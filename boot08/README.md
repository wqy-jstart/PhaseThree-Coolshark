# boot08工程简介

### 引入:

- #### Spring Web

- #### MyBatis Framework

- #### MySQL Driver

# 延伸阅读

### 实现Mybatis框架在XML配置文件中书写SQL语句的用法

- ##### 之前SQL语句是写在Mapper接口中的注解里面

  - 如果SQL语句太长 存在字符串折行拼接问题 不够直观

  - 一些关联查询的操作不易复用

  - 对于DBA(数据库管理员)更友好,不需要去Java代码中改SQL语句而是从配置文件中进行修改

#### 步骤:

- ##### 在application.properties里面添加链接数据库的信息

- ##### 创建Mybatis配置类, 通过MapperScan注解 取代每个Mapper接口类中的@Mapper注解

  - 在工程跟目录下创建config包,在包下面创建Mybatis配置类 MybatisConfig.java

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

  - 创建entity.Product实体类和mapper.ProductMapper

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

  - 添加Mybatis框架mapper的映射文件到**resources目录(存放资源的目录)**存放在mappers目录里面

    - 在XML配置文件里<mapper>标签的namespace中传入对象的mapper接口path路径

    - 在<insert/delete/delect,update...标签中的id传入对应的方法名,最后书写SQL语句.

      ```xml
      <mapper namespace="cn.tedu.boot08.mapper.ProductMapper">
      
          <insert id="insert">
              INSERT INTO product VALUES(
                                         NULL,#{title},#{price},#{num}
                                        )
          </insert>
      </mapper>
      ```

      
