### 酷鲨商城项目

- 准备工作:

  - 创建coolshark项目 , 3个打钩, 在application.properties里面添加配置信息,把连接数据库url中的数据库名称改成cs

  - 创建数据库和表

    create database cs charset=utf8;

    use cs;

    create table user(id int primary key auto_increment,username varchar(50),password varchar(50),nickname varchar(50));

    insert into user values(null,'admin','123456','管理员');

  - 把Web前端中开发好的页面复制到新工程中 

- 登录步骤:

  1. 在 login.html 中给登录按钮添加点击事件 点击时调用 login 方法,并且在 data 里面声明一个 user 对象让页面中的文本框和密码框和 user 对象里面的用户名和密码进行双向绑定,实现 login 方法在方法中向/login 发出请求,根据响应的 123 控制显示的内容,如果是 1 代表成功 跳转到首页
  2. 创建 User 实体类,创建 UserMapper 在 mapper 中提供一个 selectByUsername 方法
  3. 创建 UserController 添加 login 方法处理/login 请求, 调用 mapper 里面的方法 给客户端响 应 1,2,3

- 首页分类展示步骤:

  1. 建表并准备数据

     create table category(id int primary key auto_increment,name varchar(20));

     insert into category values(null,'精彩活动'),(null,'当季女装'),(null,'品牌男装'),(null,'环球美食'),(null,'医药健康'),(null,'啦啦啦');

  2. 创建Category实体类, 创建CategoryMapper 添加select方法 查询所有

  3. 创建CategoryController 添加select方法处理/category/select请求

  4. 在index.html页面让分类展示部分的代码和categoryArr数组进行绑定, 在created方法中向/category/select地址发出请求获取所有分类数据 把得到的数据赋值给categoryArr 

- 首页展示轮播图步骤:

  1. 建表和准备数据

     create table banner(id int primary key auto_increment,url varchar(200));

     insert into banner values(null,'/imgs/b1.jpg'),(null,'/imgs/b2.jpg'),(null,'/imgs/b3.jpg'),(null,'/imgs/b4.jpg');

  2. 创建Banner实体类有id和url两个属性

  3. 创建BannerMapper 里面创建一个select方法

  4. 在index.html首页中的created方法里面向/banner/select地址发出请求获取数据把得到的数据赋值给bannerArr数组, 让页面中的轮播图和bannerArr数组进行绑定

  5. 创建BannerController 添加select方法处理/banner/select请求,调用mapper里面的select方法获取到所有轮播图的数据响应给客户端

### 后台分类展示功能

1. 登录成功时跳转的页面改成 /admin.html
2. 进入页面后向/category/select发请求,把获取到的数据赋值给categoryArr数组,页面已经和数组进行了绑定 得到数据后页面会自动改变

- 删除分类功能
  - 给删除按钮添加点击事件, 调用categoryDelete方法,在方法中发出删除请求
  - 在CategoryController中处理请求 并调用mapper中的deleteById方法
  - 实现Mapper中的deleteById方法
- 添加分类功能
  - 点击添加分类时弹出文本框 获取用户输入的分类, 然后发出添加分类的请求
  - 在CategoryController中处理请求 并调用mapper中的insert方法
  - 实现Mapper中的insert方法
- 修改分类名称
  - 在删除分类的前面添加修改按钮,点击按钮时弹出文本输入框获取输入的新的分类名称,然后发出修改请求,把分类对象传递过去
  - 在CategoryController中处理请求,并调用mapper的update方法
  - 实现mapper中的update方法

### 后台轮播图管理

- 轮播图列表展示
  - 进入后台管理页面后 发出请求获取所有轮播图数据赋值给bannerArr数组

- 删除步骤参照删除分类

- 添加轮播图:

  - 在admin.html点击添加轮播图超链接时 跳转到/insertBanner.html页面
  - 创建/insertBanner.html页面,在页面中添加页头和 上传组件, 参考微博练习中的上传图片步骤

  

