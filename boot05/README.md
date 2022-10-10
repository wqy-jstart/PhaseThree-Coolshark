# boot05工程简介

### 引入:

- #### Spring Web

- #### MyBatis Framework

- #### MySQL Driver

# 延伸阅读

#### 1.处理异步请求的Post注册功能

- ##### 将用户名,密码,昵称通过双向绑定到user对象中,点击注册触发reg()方法,post请求,将user对象传到处理/reg的方法中,在方法中通过selectByUsername()方法返回的User对象是否为空来判断用户名是否存在,若为空则调用mapper的insert()方法,将对象传入user对象由底层通过JDBC代码保存到数据库.

- ##### 传入的user为JavaScript代码中的user,该user已被封装到entity包下的User对象中.

- ##### 在传入User对象时需要添加@RequestBody注解,否则对象中的信息会为空.

#### 2.处理异步请求的Post登录功能

- ##### 将用户输入的用户名和密码通过双向绑定到user对象中,点击登录触发login()方法,post请求,将user对象传到处理/login的方法中,在方法中通过selectByUsername()方法返回的User对象是否为空来判断用户名是否存在,若存在则比较密码是否正确,最终通过返回的int值到JS代码中分支判断并通过弹出消息框alert()来处理返回登录结果.

#### 3.为Post注册功能添加@blur="f()"光标失去焦点功能

- ##### 在用户名输入框内添加@blur="f()"来处理光标失去焦点事件,当用户输完用户名准备输入密码时触发该事件,并调用f()方法,该方法会将用户输入的用户名通过get请求传到处理/check请求地址的方法中,该方法通过selectByUsername()方法返回的User对象是否为空来判断用户名是否存在,并返回响应结果给JS,JS接收该响应并赋值给插入绑定的{{info}},当开始输入密码时,反馈用户名是否存在于用户名输入框的右侧.
