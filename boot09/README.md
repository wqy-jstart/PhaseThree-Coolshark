# boot09工程简介

### 引入:

- #### Spring Web

- #### MyBatis Framework

- #### MySQL Driver

# 延伸阅读

## Mybatis框架在XML配置文件中书写SQL语句的用法:

- ### 在boot08工程的基础上进行练习员工emp表

  - ##### 插入员工信息

    - 将要插入的信息封装到对象中

  - ##### 删除员工信息

    - 传递某个员工id为过滤条件进行删除

  - ##### 修改员工信息

    - 将修改的信息添加到emp对象中

  - ##### 查询员工信息

    - ##### 查询一个

      - 根据id来查询一个商品信息,以对象形式返回

    - ##### 查询对个

      - 不加过滤条件查询所有商品信息,以List集合形式返回

    - ##### 统计数量

      - 使用sql语句中SELECT COUNT(*)来查询数量,返回int(数量的值)

  #### 动态SQL练习:

  - ##### 批量删除员工信息

    - 将对个需要删除的商品id封装到List集合/array数组/...任意数量中,在sql语句中id过滤条件进行<foreach标签遍历传过来的多个id,collection属性传入遍历的类型(集合填list/数组以及其他填array),item属性传入遍历元素的名字(例:p),separator属性传入要删除的多余","

  - ##### 批量添加员工信息

    - 将需要插入的多个员工信息进行NEW,最后一List集合的形式指定对象的泛型,到xml文件的sql语句中<foreach遍历

  - ##### 动态修改员工信息

    - 将要修改的员工信息装到emp对象中,利用<set标签,在标签中<if test="判断条件" 在不为null的情况下进行修改

  - ##### 映射查询员工信息

    - 当查询的员工信息与对象中的名字不一致时例如:表中manager_id->对象中managerId,使用<resultMap标签进行关联映射,在映射中Type类型中指定输出的结果的Path路径,在<result标签中的column**与**property属性中对应映射的关系
