# day02

### 选择器

1. 标签名选择器: 匹配页面中所有同名标签

   格式: 标签名{样式代码}

2. id选择器:  当需要选择页面中某一个元素时使用

   格式: #id{样式代码}

3. 类选择器: 当需要选择页面中多个不相关的元素时,给元素添加相同的class属性值

   格式:.class{样式代码}

4. 分组选择器:  可以将多个选择器合并成一个选择器   

   格式: div,#id,.class{样式代码}

5. 属性选择器: 通过元素的属性选择元素

   格式: 标签名[属性名='值']{样式代码}   

6. 任意元素选择器:  匹配页面中所有元素

   格式: *{样式代码}

7. 子孙后代选择器: 通过元素和元素之间关系 匹配某一层元素以及这一层内部的所有

   格式: body div div p{样式代码}  匹配body里面的div里面的div里面的所有p(包含后代)

8. 子元素选择器: 通过元素和元素之间关系 匹配某一层元素

   格式: body>div>div>p{样式代码}  匹配body里面的div里面的div里面的所有p子元素(不包含后代)

9. 伪类选择器:  匹配的是元素的状态, 包括: 未访问状态,访问过状态,悬停状态,点击状态



通过内部样式实现以下效果
1. 关羽绿色

2. 张飞和苹果黄色

3. 文本框和所有水果背景红色

4. p2 字体粉色

5. p2 和 p3 背景黄色

6. 腾讯官网未访问绿色,

  访问过红色,悬停黄色,点击粉色



### 颜色赋值

- 三原色: 红绿蓝,  RGB   Red Green Blue,   每个颜色的取值范围0-255    
- 五种赋值方式:
  - 颜色单词:   red/black/yellow/blue.....
  - 6位16进制赋值:    #ff0000  
  - 3位16进制赋值:    #f00
  - 3位10进制赋值:    rgb(255,0,0)
  - 4位10进制赋值:    rgba(255,0,0,0-1)     a=alpha代表透明度 值越小越透明

### 背景图片

- background-image:url("图片路径");  设置背景图片
- background-size: 宽度 高度; 设置背景图片尺寸
- background-repeat:no-repeat; 禁止重复
- background-position: 横向 纵向;  设置背景图片位置 

### 文本和字体相关的样式

- text-align:left/right/center; 设置文本水平对齐方式
- text-decoration:overline/underline/line-through/none  文本修饰
- line-height:20; 设置行高  单行可以实现垂直居中, 多行可以控制行间距
- text-shadow:颜色 x偏移值 y偏移值 浓度;   设置阴影
- font-size:20px;  设置字体大小
- font-weight: bold/normal; 设置加粗 和去掉加粗
- font-style: italic; 设置斜体
- font-family:xxx,xxx,xxx,xxx; 设置字体
- font: 20px  xxx,xxx,xxx; 设置字体大小+字体

### 文本和字体相关练习

1. 刘德华 宽度 100 高度 30 

  绿色背景红色字体
  横向和纵向居中

2. 苹果和香蕉 字体大小 25px 斜体

3. 冰箱去掉加粗 蓝色阴影
    方向是左下 浓度 3

4. 洗衣机添加下划线

5. 百度去掉下划线字体加粗
    字体大小 20px

### 元素的显示方式display

- block:块级元素的默认值, 特点: 独占一行并且可以修改宽高, 包括: h1-h6, p, div等
- inline:行内元素的默认值, 特点: 共占一行, 不能修改宽高, 包括: span,b,i,s,u,a
- inline-block:行内块元素的默认值, 特点:共占一行并可以修改宽高, 包括:img,input等
- none: 隐藏元素

### 盒子模型

- 盒子模型= content内容+margin外边距+border边框+padding内边距
- 作用: 控制元素的显示效果
  - content,包含width和height,控制元素显示尺寸
  - margin外边距:控制元素显示的位置   
  - border边框: 控制边框效果
  - padding内边距: 控制元素内容的位置

### 盒子模型之content

- 包含 width和height  通过这两个样式设置元素的宽和高
- 赋值方式:
  - 像素
  - 上级元素的百分比
- 行内元素width和height无效,如果一定要改宽高需要将元素显示方式改成block或inline-block这两种方式

### 盒子模型之外边距

- 元素距上级元素或相邻兄弟元素的距离称为外边距   
- 赋值方式:
  - margin-left/right/top/bottom:20px;  单独某一个方向赋值
  - margin:20px; 四个方向赋值
  - margin:10px 20px; 上下10 左右20     ,左右auto代表居中
  - margin:10px 20px 30px 40px; 上右下左 顺时针赋值
- 行内元素上下外边距无效
- 上下相邻彼此添加外边距取最大值, 左右相邻两者相加 
- 粘连问题: 当元素的上边缘和上级元素的上边缘重叠时,给元素添加上外边距,会出现粘连问题,给上级元素添加overflow:hidden解决此问题. 

### 盒子模型之border边框

- 赋值方式:
  - border-left/right/top/bottom: 粗细 样式 颜色;    单独某个方向添加边框
  - border:粗细 样式 颜色;    四个方向添加边框
- 设置圆角:   border-radius:20px;   值 越大 越圆  

### 盒子模型之padding内边距

- 作用: 控制元素内容的位置, 元素边缘距内容的距离称为内边距
- 赋值方式:  和外边距类似
  - padding-left/top/bottom:20px; 单独某个方向赋值
  - padding:20px; 四个方向赋值
  - padding:10px 20px; 上下和左右赋值
  - padding:10px 20px 30px 40px; 上右下左顺时针赋值
- 给元素添加内边距会影响元素的宽高, 给元素添加box-sizing:border-box; 样式后不再影响

### CSS三大特性

- 继承性: 元素可以继承上级元素文本和字体相关的样式, 部分标签自带的效果不受继承影响





### 表设计面试题    

2021年过年时小明在这些天都收到了许多亲戚\朋友还有同事的红包,也发出了一些红包,有的是微信,有的是支付宝也有现金,请参考下面的题目帮小明设计表格保存红包的信息

1. 设计表 (至少包含一张流水表) 

   - 先列出需要保存的数据有哪些

     人物关系,红包类型,时间,金额,性别,名字

   - 将需要保存的数据进行拆分,用不同的表去保存数据, 需要考虑数据冗余的问题

     - 流水表: id,红包金额,红包类型,时间,人物id

       create database webday02 charset=utf8;

       use webday02;

       create table trade(id int primary key auto_increment,money int,type varchar(20), time date,p_id int);

     - 人物表: id,名字,性别,关系

       create table person(id int primary key auto_increment,name varchar(20),gender char(1),rel varchar(10));

     - 准备数据:

       往人物表中插入以下数据:     刘德华,男,亲戚     杨幂,女,亲戚       马云,男,同事         

       特朗普,男,朋友               貂蝉,女,朋友

       insert into person values(null,'刘德华','男','亲戚'),(null,'杨幂','女','亲戚'),(null,'马云','男','同事'),(null,'特朗普','男','朋友'),(null,'貂蝉','女','朋友');

       ```
           刘德华 微信 收1000 2021-03-20   
           杨幂 现金 收500 发50 2021-04-14    
           马云 支付宝 收20000 发5 2021-03-11    
           特朗普 微信 收2000  2021-05-18    
           貂蝉 微信 发20000 2021-07-22
       ```

       insert into trade values(null,1000,'微信',"2021-03-20",1),

       (null,500,'现金',"2021-04-14",2),(null,-50,'现金',"2021-04-14",2),

       (null,20000,'支付宝',"2021-03-11",3),(null,-5,'支付宝',"2021-03-11",3),

       (null,2000,'微信',"2021-05-18",4),

       (null,-20000,'微信',"2021-07-22",5);

2. 统计2021年3月15号到现在的所有红包收益

   select sum(money) from trade where time>="2021-3-15";

3. 查询2021年2月15号到现在 金额大于100 所有女性亲戚的名字和金额 

   select name,money

   from trade t join person p on t.p_id=p.id

   where time>="2021-2-15" and abs(money)>100 and gender='女' and rel='亲戚';

4. 查询三个平台(微信,支付宝,现金)分别收入的红包金额  

   select type,sum(money) from trade where money>0 group by type;














