### 同步请求和异步请求

- 同步: 指单线程依次做几件事
- 异步: 多线程同时做几件事
- 同步请求: 指客户端只有一个主线程,主线程负责页面渲染和监听操作,如果需要主线程发出请求时,会停止页面渲染(清空页面) 只负责发请求,当服务器响应了数据之后,主线程再次恢复渲染的职责,把服务器响应的数据显示到页面中,这个过程是将页面内容进行了整体的改变,称为整体刷新,同步请求只能实现页面的整体刷新无法实现局部刷新.
- 异步请求: 指客户端的主线程负责页面渲染和监听操作,由子线程发出请求获取数据,获取到数据后将数据展示到原有页面, 这种就叫做页面的局部刷新, 只有通过异步请求才可以实现.

### 客户端如何发出异步请求? 

- 通过Axios框架发出异步请求

- Axios是一个js框架文件, 在html页面中引入此文件即可. 

  <https://cdn.bootcdn.net/ajax/libs/axios/0.21.1/axios.min.js>



### GET和POST

- GET: 请求参数写在请求地址的后面, 由于参数在地址栏中可见所以不能传递带有敏感信息的参数, 参数大小有限制只能传递几k的数据

  应用场景: 一般的查询请求都是用Get, 删除数据一般也使用get

- POST:请求参数在请求体里面,在请求体里面的参数是不可见的所以可以传递带有敏感信息的参数, 请求参数的大小也没有限制  

  应用场景: 有敏感信息的请求, 上传请求, 参数较多时使用

### BMI练习(异步版本)

1. 在首页中添加BMI测试超链接,请求地址为/bmi.html
2. 创建bmi.html页面,页面中两个文本框一个按钮, 和一个显示结果的h2标签, 给按钮添加点击事件,点击时向/bmi发出异步get请求,把两个文本框中的身高和体重传递过去,把服务器响应回来的数据显示到h2标签里面
3. 创建BMIController 添加bmi方法处理/bmi请求,接收传递过来的身高和体重, 根据之前的计算公式得到bmi的值, 根据不同的取值范围给客户端响应不同的文本信息  

