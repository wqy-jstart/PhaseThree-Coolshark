package cn.tedu.boot06.controller;

import cn.tedu.boot06.entity.Product;
import cn.tedu.boot06.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Autowired//自动装配
    ProductMapper mapper;

    /**
     * 处理添加商品业务
     *
     * @param product JS传入的商品对象
     */
    @RequestMapping("/insert")
    public void insert(@RequestBody Product product) { //异步请求接收JS传入的商品对象
        System.out.println("product = " + product);
        //使用mapper引用调用ProductMapper接口中的insert方法,传入Product商品对象通过@Insert插入到数据库
        mapper.insert(product);//调用insert()方法将商品对象传入,由@Insert(String sql)保存到数据库
    }

    /**
     * 处理返回商品信息功能
     *
     * @return List集合(商品对象的集合)
     */
    @RequestMapping("/select")
    public List<Product> select() {//不接收任何信息,直接查询商品表格中所有数据,响应给JS
        return mapper.select();//将查询后的商品信息List集合返回给JS
    }

    /**
     * 处理删除商品的功能
     *
     * @param id 要删除的商品id
     */
    @RequestMapping("/delete")
    public void delete(int id) {//接收JS传入的商品id
        mapper.deleteById(id);//调用接口中的delete()方法将id对应的商品删除,无需返回值
    }

    /**
     * 处理返回修改前的商品对象信息
     *
     * @param id 传入要修改的商品id
     * @return 通过id获取的Product对象
     */
    @RequestMapping("/selectById")
    public Product selectById(int id) {//接收JS传入的商品id
        return mapper.selectById(id);//通过商品id获取商品对象到JS中呈现该商品的修改页面
    }

    /**
     * 处理商品的修改功能
     *
     * @param product JS传入的修改后的商品对象(包含修改后的信息)
     */
    @RequestMapping("/update")
    public void update(@RequestBody Product product) {//异步请求接收JS传递修改后的商品对象
        mapper.update(product);//根据传入修改后的商品对象,调用update执行修改功能,无返回值
    }
}
