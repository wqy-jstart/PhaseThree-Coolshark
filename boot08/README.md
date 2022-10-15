# boot08工程简介

### 引入:

- #### Spring Web

- #### MyBatis Framework

- #### MySQL Driver

# 延伸阅读

### 实现Mybatis框架在XML配置文件中书写SQL语句的用法

- #### 之前SQL语句是写在Mapper接口中的注解里面

  - ##### 如果SQL语句太长 存在字符串折行拼接问题 不够直观

  - ##### 一些关联查询的操作不易复用

  - ##### 对于DBA(数据库管理员)更友好,不需要去Java代码中改SQL语句而是从配置文件中进行修改

#### 步骤:

- #### 在application.properties里面添加链接数据库的信息

- #### 创建Mybatis配置类, 通过MapperScan注解 取代每个Mapper接口类中的@Mapper注解

  - ##### 在工程跟目录下创建config包,在包下面创建Mybatis配置类 MybatisConfig.java

    ```java
    package cn.tedu.boot08.config;
    import org.mybatis.spring.annotation.MapperScan;
    import org.springframework.context.annotation.Configuration;
    
    //告诉编译器此工程的所有Mapper接口都在这个包路径里面
    @Configuration
    @MapperScan("cn.tedu.boot08.mapper")
    public class MyBatisConfig {
    }
    ```

  - ##### 创建entity.Product实体类和mapper.ProductMapper

    ```java
    package cn.tedu.boot08.mapper;
    import cn.tedu.boot08.entity.Product;
    
    //此时使用了MapperScan注解并传入了mapper包路径 则不需要再写@Mapper注解
    //已经默认此项目所有mapper接口都在这个包路径里
    public interface ProductMapper {
        //此处不再写@Insert等注解,SQL语句写在XML配置文件中
        void insert(Product product);
    }
    ```

- #### ★添加Mybatis框架mapper的映射XML文件到**resources目录**(存放资源的目录)存放在mappers目录里面

- #### 之后会在mapper的XML文件中进行数据库的"增删改查"等一系列操作.

  在XML配置文件里<mapper>标签的**namespace属性中传入操作对象对应mapper接口的path路径**,以此来处理该对象与数据库之间的关联操作

  - 在<insert/delete/select,update...标签中的id传入对应的方法名,最后书写SQL语句这些操作**标签都在mapper标签中**.

    ```xml
    <mapper namespace="cn.tedu.boot08.mapper.ProductMapper">
        <!--1.插入标签-->
        <insert id="insert">
            INSERT INTO product
            VALUES (NULL, #{title}, #{price}, #{num})
        </insert>
        <!--2.删除标签-->
        <delete id="deleteById">
            DELETE
            FROM product
            WHERE id = #{id}
        </delete>
        <!--3.修改标签-->
        <update id="update">
            UPDATE product
            SET title=#{title},
                price=#{price},
                num=#{num}
            WHERE id = #{id}
        </update>
        <!--4.查询标签(Count(*)查数量)  resultType设置返回的基本类型int-->
        <select id="count" resultType="int">
            SELECT count(*)
            FROM product
        </select>
    </mapper>
    ```

  - - 查询时需要返回值返回查到的数据,在<select id="方法名" resultType属性中传入返回的类型,基本类型可直接写,但引用类型需写入该引用对象的path路径,(可选择java类右键->Copy Path...->Copy Reference复制)获得.

      ```xml
      <!--查询标签(查所有)     resultType设置结果返回的类型(此处为引用类型,需添加对象的path)-->
      <select id="select" resultType="cn.tedu.boot08.entity.Product">
          SELECT id, title, price, num
          FROM product
      </select>
      ```

- ## ★动态SQL语句

  ##### 动态根据传过来的参数类型(普通元素集合,对象集合,普通元素数组,任意数量的类型(Integer...))来进行批量操作

### 一. 批量删除Delete(根据传入的多个商品id进行批量删除操作):

#### 需要用到的标签:

1. ##### foreach循环遍历标签.

2. ##### collection的值如果是List集合则写list,如果不是List集合则写array.

3. ##### item代表遍历的集合中变量.

4. ##### separator代表分隔符.

##### 1.通过List集合传入商品id

向集合中调用add()方法添加需要删除的商品id,调用deleteByIds1()方法,可接收返回值(返回删除的商品数量)

- ```java
  int deleteByIds1(List<Integer> ids); //传List集合
  ```

  ```xml
  <!--★此处foreach遍历的是List<Integer>集合中的元素-->
      <delete id="deleteByIds1">
          DELETE FROM product
          WHERE id IN(
          <foreach collection="list" item="id" separator=",">
              #{id}
          </foreach>
          )
      </delete>
  ```

##### 2.通过Integer[]数组传入商品id:

定义数组的同时,传入若干需要删除的商品id,调用deleteById2()方法,可接收返回值(返回删除的商品数量)

- ```java
  int deleteByIds2(Integer[] ids); //传Integer数组
  ```

  ```xml
  <!--★此处foreach遍历的是Integer[]数组中的元素-->
      <delete id="deleteByIds2">
          DELETE FROM product
          WHERE id IN(
          <foreach collection="array" item="id" separator=",">
              #{id}
          </foreach>
          )
      </delete>
  ```

##### 3.通过Integer...任意数量Integer类型传入商品id

直接在调用deleteById3()方法的同时,传入若干需要删除的商品id,可接收返回值(返回删除的商品数量)

- ```java
  int deleteByIds3(Integer... ids); //传任意数量的Integer
  ```

```xml
<delete id="deleteByIds3">
        DELETE FROM product
        WHERE id IN(
        <foreach collection="array" item="id" separator=",">
            #{id}
        </foreach>
        )
    </delete>
```

### 二. 批量插入Insert(根据传入的List集合,包含多个商品对象,进行批量插入操作):

##### 向List集合中添加add()要插入的商品对象,每一个对象利用全参构造器,为属性赋值

- int insertProducts(List<Product> list);

```xml
<insert id="insertProducts">
        INSERT INTO product
        VALUES
        <!--遍历插入的集合中对象的属性-->
        <foreach collection="list" item="p" separator=",">
            (
            NULL,#{p.title},#{p.price},#{p.num}
            )
        </foreach>
    </insert>
```

### 三. 动态插入Insert

##### 在XML文件中进行DML插入操作,设定插入的字段名,根据传递的参数或对象中的参数进行插入,未进行插入的字段默认NULL值

#### 需要用到的标签:

1. ##### trim标签:用于去除sql中多余关键字,添加前缀等选择性插入、更新、删除或者条件查询的操作。

2. ##### prefix属性用于给sql语句拼接的前缀

3. ##### suffix属性用于给sql语句拼接的后缀

4. ##### suffixOverrides属性用户去除sql语句后面多余的","

5. ##### if标签用户在test属性中写判断条件

```xml
<insert id="dynamicInsert">
        INSERT INTO product
        <trim prefix="(" suffix=")" suffixOverrides=",">
            <if test="title!=null">title,</if>
            <if test="price!=null">price,</if>
            <if test="num!=null">num</if>
        </trim>
        VALUES
        <trim prefix="(" suffix=")" suffixOverrides=",">
            <if test="title!=null">#{title},</if>
            <if test="price!=null">#{price},</if>
            <if test="num!=null">#{num}</if>
        </trim>
    </insert>
```

### 四. 动态修改Update

##### 根据某个过滤条件来修改表中的数据,set标签会自动去掉后面多余的逗号,#{变量名}会自动用getter获取参数列表对象中的参数来对字段进行修改,未修改的字段会保留原来的值

```xml
<update id="dynamicUpdate">
        UPDATE product
        <set>
            <if test="title!=null">title=#{title},</if>
            <if test="price!=null">price=#{price},</if>
            <if test="num!=null">num=#{num}</if>
        </set>
        WHERE id=#{id}
    </update>
```

### 五.查询的补充:

- #### 查询时会遇到表中字段名与对象实例中的属性值不一致的情况,此时需要进行对查询结果"手动映射"

  - ##### 映射时使用<resultMap标签进行关联,在映射中指定结果的类型(一个对象实例的Path路径)

  - ##### 映射时使用<result column="表中字段" property="对象中的属性" 来实现

  - ##### 映射的内容必须在其对应的表或对象中存在,否则会报错

  ```xml
  <!--查询标签(查一条数据)   这里就不用指定返回值类型,在结果映射中已经指定了类型-->
      <select id="selectById" resultMap="productRM">
          SELECT id, title, sale_Count, view_Count
          FROM my_product
          WHERE id = #{id}
      </select>
      <!--结果的映射   当属性值与字段名不同时使用该标签进行对应-->
      <resultMap id="productRM" type="cn.tedu.boot08.entity.MyProduct">
          <!--指定一下属性值与字段名之间的对应关系-->
          <result column="sale_count" property="saleCount"></result>
          <result column="view_count" property="viewCount"></result>
      </resultMap>
  ```

- #### 定义需要复用的SQL语句

  - ##### 使用<sql  id="query" 标签,在标签中写复用的SQL语句,例如:

    ```xml
    <!--定义复用的SQL语句-->
        <sql id="query">
            SELECT id, title, sale_Count, view_Count
            FROM my_product
        </sql>
    ```

  - ##### 使用时利用<include refid="query" 标签来引入复用的sql语句,例如:

    ```xml
    <select id="selectById" resultMap="productRM">
            <include refid="query"></include>
            WHERE id = #{id}
        </select>
    ```

