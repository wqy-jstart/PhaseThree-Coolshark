package cn.tedu.coolshark.controller;

import cn.tedu.coolshark.mapper.ProductMapper;
import cn.tedu.coolshark.pojo.dto.ProductDTO;
import cn.tedu.coolshark.pojo.dto.ProductUpdateDTO;
import cn.tedu.coolshark.pojo.entity.Product;
import cn.tedu.coolshark.pojo.vo.ProductAdminVO;
import cn.tedu.coolshark.pojo.vo.ProductUpdateVO;
import cn.tedu.coolshark.pojo.vo.ProductTopVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired(required = false)
    ProductMapper mapper;

    /**
     * 该方法用来添加商品信息
     *
     * @param product 接收传入要添加的商品信息DTO对象
     */
    @RequestMapping("/insert")
    public void insert(@RequestBody ProductDTO product) {
        System.out.println("product = " + product);//soudp
        Product p = new Product();
        //把DTO里面的属性复制到p实体类中
        BeanUtils.copyProperties(product, p);
        //给属性复制
        p.setCreated(new Date());
        //浏览量
        p.setViewCount(0);
        mapper.insert(p);
    }

    /**
     * 处理查询管理员相关的所有商品信息
     *
     * @return 返回有关管理员的信息对象List集合
     */
    @RequestMapping("/select/admin")
    public List<ProductAdminVO> selectAdmin() {
        return mapper.selectAdmin();
    }

    /**
     * 删除商品
     *
     * @param id 要删除的商品id
     */
    @RequestMapping("/delete")
    public void delete(int id) {
        //根据id去商品表中找url路径
        String url = mapper.selectUrlById(id);
        //删文件
        if (new File("G:/files" + url).delete()) {
            System.out.println("删除成功!");
        } else {
            System.out.println("删除失败!");
        }
        //删数据
        mapper.deleteById(id);
    }

    /**
     * 处理修改前需要查询的商品信息
     *
     * @param id 商品id
     * @return 返回查询前的商品信息VO对象
     */
    @RequestMapping("/delectById/update")
    public ProductUpdateVO selectByIdUpdate(int id) {
        return mapper.selectByIdUpdate(id);
    }

    /**
     * 处理修改商品信息
     * @param product 接收修改后的商品信息DTO对象
     */
    @RequestMapping("/update")
    public void update(@RequestBody ProductUpdateDTO product) {
        System.out.println("product = " + product);
        mapper.update(product);
    }

    @RequestMapping("/select/top")
    public List<ProductTopVO> selectTop(){
        return mapper.selectTop();
    }
}
