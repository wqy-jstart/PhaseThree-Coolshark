# boot03工程简介

### 引入:

- #### Spring Web

- #### MyBatis Framework

- #### MySQL Driver

# 延伸阅读

### 1.使用SpringMVC和MyBatis框架完成商品的"增删改查"四种操作

- #### @RestController

  - ##### 与@Controller注解相似,不同的是使用@RestController相当于在每一个方法上都添加了@ResponseBody注解(该注解通过返回值方式向浏览器响应数据)

- #### @Mapper注解

  - ##### 该注解是一个接口类型,在接口中书写实体类和数据库中表之间的对应关系,Mybatis框架会自动通过此关系生成JDBC代码

- #### @Insert/Select/Delete/Update()

  - ##### 该注解方法用来写SQL语句,配合抽象方法传入的参数完成与数据库的相关操作(增删改查...)

- #### @Autowired注解

  - ##### 自动装配 此框架添加之后,Mybatis和Spring框架会生成ProductMapper的实现类

  - ##### 并且实例化该实现类(实现类里面会实现ProductMapper中的抽象方法,实现的方法里面写的就是JDBC代码),并且把实例化好的对象赋值给了mapper变量
