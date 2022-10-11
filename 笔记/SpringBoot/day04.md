### 前后端分离

![image-20221011144636901](image-20221011144636901.png)

## ![image-20221011144952969](image-20221011144952969.png)

- 前后端不分离: 指在后端代码中需要写前端页面的代码, 这样的话后端程序员需要开发两套Controller,一套Controller负责给浏览器客户端响应页面+数据, 另一套Controller负责给手机端响应数据, 这样的话对于Java后端程序员工作量增加了很多
- 前后端分离: 指在后端代码中不处理页面相关不管客户端是浏览器还是手机端一视同仁只响应数据,这样的话后端只需要提供一套Controller即可, 此时浏览器客户端需要的页面需要单独发请求获取,获取完页面之后再通过异步请求的方式获取数据,然后把数据展示到页面中(这个过程称为页面的局部刷新,只能通过异步请求实现) 所以以后为了解决前后端分离的问题 则不再使用同步请求



### JSON

- JSON是一个轻量级的数据交换格式,也叫作数据封装格式.



刘德华:18&张学友:20&郭富城:30

[{"name":"刘德华","age":18},{"name":"张学友","age":20},{"name":"郭富城","age":30}]

![image-20221011163001464](image-20221011163001464.png)

- 当服务器给客户端响应的数据类型为自定义对象或List集合时, SpringMVC框架会自动将返回的数据转成JSON格式的字符串, 然后通过网络传输给客户端, 客户端接收到的数据是JSON格式的字符串,Axios框架会自动将JSON格式字符串里的数据转成JavaScript语言中的数组或对象







### 异步版本商品管理系统步骤:     晚上任务:写3遍以上 非常重要!!!


1. 创建boot061工程  打钩3个   
2. 配置连接数据库的信息 
3. 添加首页index.html   里面添加  添加商品的超链接  地址/insert.html页面

- 添加商品步骤:

1. 创建insert.html页面, 页面中三个文本框和一个按钮,  文本框和vue的data中的product对象进行双向绑定, 给按钮添加点击事件调用insert方法
2. 在insert方法中发出异步请求把data中的product对象提交到服务器,服务器返回数据后弹出"添加完成" 然后跳转到首页
3. 创建controller.ProductController 并添加insert方法处理/insert请求 返回值为void, 创建Product实体类封装接收到的参数
4. 创建mapper.ProductMapper 并提供insert方法 
5. 在ProductController 调用mapper的insert方法 把接收到的product对象传递进去,不需要给客户端响应任何数据 返回值为void

- 商品列表步骤:

1. 在首页中添加商品列表超链接 请求地址为/list.html
2. 创建list.html页面, 页面中添加表格, 并且让表格和arr数组进行绑定, 在页面中添加created方法,在方法中向/select地址发出异步请求获取所有商品的数据, 把得到的数据直接赋值给arr数组, 由于页面内容和数组进行了绑定所以页面会自动显示出查询到的数据
3. 在ProductController里面创建select方法处理/select请求, 方法中调用mapper的select方法 返回值为List集合里面装着Product对象, 把得到的集合直接响应给客户端,SpringMVC框架当发现响应的内容为自定义对象或集合时 会先转成JSON格式的字符串,然后通过网络传输给客户端,而客户端当发现传递过来的是JSON格式的字符串时Axios框架会自动将JSON格式字符串转成数组或JS对象
4. 实现mapper里面的select方法

- 删除商品步骤:

1. 在list.html页面中添加一列 每一行商品信息的后面加上删除超链接 废掉超链接的跳转功能,给超链接添加点击事件, 点击时调用del 方法 把需要删除的商品id传递过去
2. 在del方法中发出异步的get请求 请求地址为/delete?id=xxx  服务器响应后 刷新页面
3. 在ProductController中创建delete方法处理/delete请求, 方法中调用mapper的deleteById方法把接收到的id传递过去 
4. 实现mapper里面的deleteById方法

- 修改商品步骤:

1. 在list.html页面中 删除按钮的前面添加修改超链接, 请求地址为/update.html?id=xxx  
2. 创建update.html页面, 在页面中准备4个文本框和一个按钮, 让文本框和product对象进行双向绑定, 在页面中添加created方法,实现进入页面后立即向/selectById?id=xxx地址发出请求  请求到的数据为自定义的商品对象(JS对象) 把对象赋值给Vue中和页面进行双向绑定的对象,页面会自动发生改变
3. 在ProductController中添加selectById方法处理/selectById请求, 接收传递过来的id, 然后调用mapper中的selectById方法 返回值为Product对象 把对象直接响应给客户端 
4. 实现mapper里面的selectById方法 
5. 在update.html页面中,给修改按钮添加点击事件, 点击后调用update方法
6. 实现update方法在方法中向/update地址发出异步post请求 把双向绑定的product对象传递给服务器
7. 在ProductController里面添加update方法处理/update请求, 调用mapper的update方法把接收到的product对象传递过去 
8. 实现mapper里面的update方法













