# boot10工程简介

### 引入:

- #### Spring Web

- #### MyBatis Framework

- #### MySQL Driver

# 延伸阅读

### ★关联查询

- #### 准备工作:

  - 创建boot10工程 ,在application.properties配置文件中添加配置信息

  - 创建球队和球员表

    create table team(id int primary key auto_increment,name varchar(20),loc varchar(20));

    create table player(id int primary key auto_increment,name varchar(20),team_id int);

    insert into team values(null,'公牛队','芝加哥'),(null,'火箭队','休斯顿');

    insert into player values(null,'乔丹',1),(null,'皮蓬',1),(null,'姚明',2),(null,'麦迪',2);

- #### 引入PoJo

  - ##### pojo指简单的Java对象 是实体类Entity和 值对象VO 还有DTO数据传输对象的统称

  - ##### Entity实体类,通常和对应的表字段的数量是一致的

  - ##### DTO数据传输对象, 当客户端给服务器传递参数时,参数的数量可能比实体类中的数量要少,比如实体类中有10个参数 但是客户端只传递过来的3个参数,此时通过DTO接收传递过来的参数,如果使用实体类接收也可以但是会存在很多的null值,使用DTO好处是只要发现null值就能判断出传输出错了

  - ##### VO值对象, 从数据库中的某个表查询数据,有多种场景,有的需要查全部,而有的查询只需要查一部分数据,如果只查一部分数据查询回来的数据直接用Entity接收封装的话,则Entity中会存在大量的null值, 这些null值传输给客户端也会占用流量,浪费资源,使用VO则可以解决此问题

- #### 根据要查询的内容来选择查询方式,当查询的内容一张表不能满足时需要关联查询

  - ##### 关联查询时,建议给查询的内容设置别名,添加关联条件和过滤条件

  - ##### 若别名与对象中的属性名不同时,采取人工映射,<resultMap id="映射关系" type="结果类型实例的Path路径"

  - ##### 映射时,若存在主键(通常id是主键类型),对应映射关系时使用<id标签,其他的采用<result标签,以column和property属性进行对应,如:

    - ```xml
      <id column="pid" property="id"></id>
              <result column="pname" property="name"></result>
      ```

  - ##### 若指定的查询类型type对象中含有对象的引用类型,需要在下方添加<association property="该对象的引用" javaType="该对象的Path路径",然后在里面写对应关系,规则跟上面一样

```xml
<mapper namespace="cn.tedu.boot10.mapper.PlayerMapper">    
    <select id="selectById" resultMap="playerRM">
        SELECT p.id pid, p.name pname, t.id tid, t.name tname,loc
        FROM player p
                 JOIN team t
                      ON p.team_id = t.id
        WHERE p.id = #{id}
    </select>
    <resultMap id="playerRM" type="cn.tedu.boot10.pojo.vo.PlayerVO">
        <id column="pid" property="id"></id>
        <result column="pname" property="name"></result>
        <!--关联team并传入该表的path完全路径,并将表中与该Team对象的属性名不同的进行人工映射操作
        association标签用于关联对象-->
        <association property="team" javaType="cn.tedu.boot10.pojo.entity.Team">
            <id column="tid" property="id"></id>
            <result column="tname" property="name"></result>
            <result column="loc" property="loc"></result>
        </association>
    </resultMap>
</mapper>
```

