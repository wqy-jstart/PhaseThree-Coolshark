package cn.tedu.boot03.controller;

import cn.tedu.boot03.entity.Product;
import cn.tedu.boot03.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController//使用RestController相当于在每一个方法上都添加了@ResponseBody注解(该注解通过返回值方式向浏览器响应数据)
public class ProductController {
    /*自动装配 此框架添加之后,Mybatis和Spring框架会生成
    ProductMapper的实现类,并且实例化该实现类(实现类里面会实现ProductMapper中的
    抽象方法,实现的方法里面写的就是JDBC代码),并且把实例化好的对象赋值给了mapper变量*/
    @Autowired
    ProductMapper mapper;

    //执行添加业务
    @RequestMapping("/insert")
    public String insert(Product product) {
        System.out.println("product = " + product);
        //调用接口中insert()方法,传入商品对象
        //在ProductMapper接口中写在@insert中的SQL语句会自动调用参数列表中对象的getXXX方法获取数据
        mapper.insert(product);
        return "添加完成!<a href='/'>返回首页</a>";
    }

    //执行商品列表任务
    @RequestMapping("/select")
    public String select() {
        List<Product> list = mapper.select();
//        return list.toString();//将集合中的内容转成字符串输出
        //书写HTML页面表格,将List集合中封装的所有对象信息呈现到该表格对应的<td>标签中,最终返回页面
        String html = "<body background=\"a.jpg\">";
        html += "<table border='1' align='center'>";
        html += "<caption><b>商品列表<b></caption>";
        html += "<tr><th>id</th><th>商品标题</th><th>价格</th><th>库存</th><th>操作</th></tr>";
        for (Product p : list) {
            html += "<tr>";
            html += "<td>" + p.getId() + "</td>";
            html += "<td>" + p.getTitle() + "</td>";
            html += "<td>" + p.getPrice() + "</td>";
            html += "<td>" + p.getNum() + "</td>";
            //添加删除字段,传入需要删除的商品ID,"?"左边是处理该业务的请求地址,提供ID进行处理
            html += "<td><a href='/delete?id=" + p.getId() + "'>删除</a></td>";
            html += "</tr>";
        }
        html += "</table>";
        html += "</body>";
//        return list.toString();//输出该集合[{},{},{}...]
        return html;//返回HTML页面
    }

    //执行删除任务
    @RequestMapping("/delete")
    public String delete(int id) {
        mapper.delete(id);
        return "删除完成!<a href='/select'>返回列表页面</a>";
    }

    //执行修改任务
    @RequestMapping("/update")
    public String update(Product product) {
        System.out.println("product = " + product);
        mapper.update(product);
        return "修改完成!<a href='/select'>返回列表页面</a>";
    }
}
