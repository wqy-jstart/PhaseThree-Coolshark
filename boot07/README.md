# boot07工程简介
### 引入:

- #### Spring Web

- #### MyBatis Framework

- #### MySQL Driver
# 延伸阅读

### 1.处理文件上传功能

- #### 流程:

  - 创建新工程boot071

  - 在application.properties配置文件中添加5行内容,其中3行数据库相关, 2行文件上传相关

  - 创建index.html首页, 添加上传页面超链接 请求地址 /upload.html

  - 创建upload.html页面(从Web->day07->helloeui.html复制粘贴而来) 从elementUI文档中找到 Upload上传组件中的 照片墙, 然后把3部分代码复制到自己的页面中,给el-upload添加 action设置请求路径为/upload 添加name为pic 添加limit设置上传文件的数量

  - 创建controller.UploadController 添加 upload方法处理/upload请求 在方法中得到**唯一文件名**,然后把文件保存到指定的文件夹中, 把/文件名 响应给客户端

  - 在upload.html页面中的el-upload组件里面添加:**on-success="handleSuccess"(这是Element组件提供的事件方法)** 并且实现handleSuccess方法,这样上传完成后 就会响应此方法,此方法中的response参数就是服务器响应的数据,把响应的图片路径显示到页面中

    - ```javascript
       handleSuccess(response, file, fileList) {//调用后可直接接收响应过来的数据
                      //response代表服务器上传成功时响应的数据,此处的response和Axios框架发出请求的到的response不同,类似于response.data
                      //file代表当前上传成功的文件
                      //fileList代表上传成功的所有文件(是一个数组)
                      v.weibo.url = response;//将响应的"唯一文件名图片路径"添加到weibo对象中
                  },
      ```

### 2.发送微博的功能

- #### 流程:

  - ##### 在entity包下实例化一个Weibo对象,封装私有的id,content,url,created(时间)属性,提供getter,setter方法,重写toString()方法

    - 在created属性上添加@JsonFormat注解,传入时间的呈现格式及时区

      ```java
       private Integer id;
          private String content;
          private String url; //微博图片路径
          //通过JsonFormat设置显示的时间格式
          // 2022年10月12号 15时23分22秒   2022-10-12 15:23:22
          // yyyy年MM月dd号 HH时mm分ss秒   yyyy-MM-dd HH:mm:ss (h为1-12时,H为1-24时)
          @JsonFormat(pattern = "yyy年MM月dd号 HH时mm分ss秒",timezone = "GMT+8")//指定时间呈现格式和时区GMT+8东八区
          private Date created; //发布微博时间
      ```

      

  - ##### 添加文本输入框,用来输入发布内容,创建一个JS的weibo对象,将其与对象中的content内容进行双向绑定,将响应的图片路径赋给weibo对象中的url属性

  - ##### 添加发布微博的按钮,添加@click="insert()"点击事件,在methods里实现insert()方法,判断用户的图片路径是否为空"",若不为空,进入分支,使用异步post请求,传入JS的weibo对象,在WeiboController中添加@RequestBody注解接收Weibo对象,并通过Date获取当前时间设置到对象中的created属性中,最后调用insert()方法传入对象,将信息插入到数据库中的weibo表中

  - ##### 添加首页的weibo历史信息的呈现功能

    - 在index.html中利用created:function(){}来实现页面自动请求weibo表中的数据
    - 利用异步get请求,不传递参数,定义请求路径,在WeiboController里处理该业务,调用select()方法,该方法会返回在数据库中查询weibo表的所有信息以List集合的形式返回,在JS中用arr[]数组来接收(List集合内部会被转换为JSON字符串数组,通过网络转换成二进制数据,再转换为JSON字符串数组经Axios框架转变为JS中的数组),最后v-for遍历数组,将数组中的属性值利用{{}}绑定到对应的标签内,图片路径用<img>属性绑定,最后展现到首页
    - 添加首页weibo记录的删除功能,在遍历数组的div标签内添加删除的超链接类型标签,通过javascript:void(0),废除链接功能,添加@click="del(weibo.id)"事件绑定,传入点击的当前weibo的id
      - 在methods中实现del()方法.接收传递的id,方法中利用BOM操作confim做确认提示框的判断,里面使用异步get请求传入要删除的weibo的id,在WeiboController里处理该删除业务在调用deleteById()根据id向数据库进行删除所有数据操作,无返回值,与此同时,创建文件,传入图片的详细路径调用File的delete()方法,对文件中的图片也进行删除

  - ##### 添加Element组件中上传图片后的删除图片功能(含垃圾桶的标签),在引入Element代码中methods里的handleRemove方法的实现里

    - 添加异步get请求传入图片的url唯一路径和提交地址/remove在UploadController里处理该业务

      - 因只有删除图片功能,所以先接收传入的图片url唯一路径,在remove方法中创建文件,传入图片的详细路径调用delete()方法进行删除.

        ```java
        @RequestMapping("/remove")
            public void remove(String url){
                if(new File("G:/files"+url).delete()){//File对象的delete()方法,返回值boolean
                    System.out.println("删除成功!");
                }else {
                    System.out.println("删除失败!");
                }
            }
        ```

        
