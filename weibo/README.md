# 工程简介

### 引入:

- #### Spring Web

- #### MyBatis Framework

- #### MySQL Driver

# 延伸阅读

## ★完成一个小型的weibo案例,将实例对象按照DTO/Entity/VO进行划分

### 1.首先在Config中进行配置(目的是在xml中书写SQL语句)

- ##### 添加注解@Configuration

- ##### 添加注解@MapperScan("本次项目中mapper接口所在的包")

### 2.书写index.html首页,添加注册和登录超链接

- #### 处理注册业务

  - 将用户输入的注册信息封装到UserDTO对象中插入到user表中

- #### 处理登录业务

  - 将用户登录的信息封装到UserLoginDTO对象中,通过用户名查询user表,将查询的结果封装到UserVO对象中,判断结果和密码来进行反馈登录结果
  - 登录过程中使用session来保存用户的信息,调用HttpSession中的setAttribute()方法,传入用户注册时所保存的UserDTO对象的引用和根据用户名查到的UserVO的引用,并以键值对的形式进行保存,并存到缓存中

- #### 处理登录后的页面

  #### 利用v-if判断通过向session中查询的nickname是否为空来判断登录前和登录后,登录后会添加发布微博的功能,和欢迎页面,以及退出登录功能,这些显示需要跟注册登录进行v-if与v-else的显示对立关系.

  - ##### 登录后的欢迎页面

    - 使用created:function(){}方法在处理登录后的页面,将欢迎用户的页面进行插入绑定,请求的数据返回到JS的user对象中
    - 在Controller中利用getAttribute()获取session中保存的user对象以UserVO的对象类型进行返回

  - ##### 处理退出登录的功能

    - 在退出登录中添加键盘点击事件@click="logout()"进行处理
    - 在methods中处理logout()方法,采用异步get请求,在Controller中调用removeAttribute()方法删除session中保存的对象,并给JS的user对象赋成空串{}实现退出登录

  - #### 处理发送微博的功能

    - 点击发送微博,跳转到send.html页面,在该页面中引入Element组件的上传文件的代码并设置action处理地址,来实现发送图片的功能,外加一个文本输入框并与weibo对象的content进行双向绑定到JS的weibo对象中,添加发送的内容,添加发布的button按钮并与@click="send()"进行事件绑定
    - 在上传文件的过程里,使用Element组件提供的handleSuccess(response, file, fileList)事件接收服务端响应的信息
    - 创建UploadController,获取图片的唯一文件名,并准备保存图片的磁盘路径,每当添加图片,在UploadController中会返回相对唯一图片文件名赋给JS中weibo对象的url,并且利用MultipartFile的transferTo(new File(filePath))方法将该图片存放在指定的磁盘路径里
    - 在methods中处理send()发布事件方法,在方法中判断图片的url是否为空,若为空,alert()提示上传图片;若不为空,则利用异步post请求,传入JS中的weibo对象(目前对象中有content和url),在WeiboController中处理该业务
      - 利用WeiboDTO实例来接收传过来JS的weibo对象信息,再次利用获取session中保存的对象,返回给UserVO,若为空时返回2,前端提示请先登录,若不为空时,将WeiboDTO对象的内容利用BeanUtils.copyProperties(weibo,w)方法复制到Weibo对象中,并设置事件和当前的登录的id,最终将这些信息(内容,图片url,时间,当前登录的用户id)在XML文件中插入到weibo表中

  - #### 处理在登录后的页面中显示之前发送的所有微博信息

    - 在index.html中在登录后显示的v-if部分添加标签来添加每个微博的id,昵称,内容,时间,并在id前添加查看详情的超链接并传入当前微博的id为后面处理详情页面做准备
    - 将微博id,昵称,内容,时间进行插入绑定在JS中利用created:function(){}方法发送异步get请求使得进入该页面时自动请求所有发送过的微博数据,并以数组的形式接收
    - 在WeiboController中处理该业务,在处理该业务的select()方法中查询weibo表的所有信息封装到WeiboListVO对象中并返回,登录后的首页中使用v-for遍历用arr[]接收的List<WeiboListVO>集合信息,即可实现

  - #### 处理点击任意微博,进入详情页面detail.html显示对应微博信息,并传入当前微博的id

    - 进入详情页面后将要显示的对应微博的信息进行插入绑定(昵称,内容,图片路径),绑定到JS的weibo对象中
      - 使用created: function () {}方法,进入详情页面,直接通过抽象路径传入的当前微博id来查询当前微博的信息,用v.weibo来接收
      - 在WeiboController中的selectById()方法处理获取当前微博信息的业务,根据传递的当前微博id,到weibo表中查询,因为需要用户的昵称,故需要进行关联查询(weibo表和user表),并将查询到的结果封装到WeiboDetailVO对象中进行返回,JS中用weibo对象接收返回的数据并展示到详情页面

  - #### 处理发送评论的功能

    - 在每个微博的详情页面下添加评论的文本框和发表评论的button按钮,文本框与comment.content发送内容进行双向绑定,发表评论跟@click="send()"进行事件绑定,然后将发送内容与当前发送的weiboId放到JS的comment对象里
    - 在methods方法中处理发表评论的send按钮,利用异步post请求传入comment对象和当前的微博id
    - 在CommentController中的insert()方法中处理发评论业务,利用CommentDTO对象接收传入的内容和微博id,再次获取session保存的对象,用UserVO来接收,验证评论者是否登录,若已经登录,则将获取信息的CommentDTO对象利用BeanUtils.copyProperties(comment,c)复制到Comment对象中,并设置当前的用户id和当前的微博id,最后插入到comment表中

  - #### 处理显示评论的功能

    - 在detail.html页面中评论相关的后面添加存放评论信息的标签,并进行插入绑定,每到某个微博的详情页面时,自动请求该微博的评论信息
    - 在created: function () {}方法中添加异步get请求,传入当前微博的id
    - 在CommentController的select()方法传入当前微博的id向数据库中,以该id为过滤条件查询该微博id的所有评论信息,并将信息封装到CommentVO对象中以List集合的形式返回
    - JS中利用commentArr数组来接收返回的List评论集合,在存放评论信息的指定标签中v-for遍历数组,将信息进行呈现,最终实现显示评论的功能
