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

​    - 实现注册和登录功能

### 发布微博功能

- 创建Weibo表

  create table weibo(id int primary key auto_increment,content varchar(100),url varchar(200),created timestamp,user_id int);







### 微博项目流程

1. 创建工程准备工作
2. 实现注册登录功能
3. 首页控制登录后的显示内容(欢迎语和发微博) 
4. 实现退出登录功能
5. 实现发微博功能
6. 实现首页微博列表展示功能
7. 实现微博详情功能
8. 实现详情页面发评论功能
9. 实现详情页面评论列表展示功能