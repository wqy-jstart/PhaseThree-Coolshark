# boot04工程简介

### 引入:

- #### Spring Web

- #### MyBatis Framework

- #### MySQL Driver

# 延伸阅读

#### 1.利用SpingMVC和Mybatis框架处理了用户注册和登录的操作,并存储到数据库中.

#### 2.在java script语言中引入axios与vue框架的文件.

- ##### axios:https://cdn.bootcdn.net/ajax/libs/axios/0.21.1/axios.min.js

- ##### vue:https://cdn.staticfile.org/vue/2.2.2/vue.min.js

#### 3.引入上述JavaScript框架文件后,测试处理异步get/post请求.

#### 4.BMI练习(异步请求版本)

- ##### 用户向文本框输入身高和体重,在BMIController中用BMI接收(体重/高*高)的值.

- ##### 进入分支进行判断,返回不同的结果,在页面中接收返回的结果并利用插值{{变量}}进行绑定.

#### 5.异步注册测试(未调用insert插入到数据库)

- ##### 在输入用户名中加入@blur("f()")光标失去焦点事件,效果是当用户名输入结束准备输入密码时,该事件触发,执行f(),该方法会将输入的用户名通过get请求传到/check请求地址中,处理该请求的方法会将调用selectByUsername方法返回数据库中的结果,与之比对,最终在{{info}}中(用户名输入框右侧)响应比对结果

- ##### 该测试没有启动注册事件绑定,故未插入到数据库
