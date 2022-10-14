### 微博综合练习

1. 准备工作

   - 创建weibo工程, 把之前工程配置文件内容复制到新工程

   - 把配置文件中的bbsdb改成weibo

   - 创建weibo数据库和用户表

     create database weibo charset=utf8;

     use weibo;

     create table user(id int primary key auto_increment,username varchar(50),password varchar(50),nickname varchar(50));

   - 创建MybatisConfig

   - 创建mappers文件夹

​     