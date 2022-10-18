package cn.tedu.coolshark.controller;

import cn.tedu.coolshark.pojo.dto.ProductDTO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

    /**
     * 添加商品
     */
    @RequestMapping("/insert")
    public void insert(@RequestBody ProductDTO product){
        System.out.println("product = " + product);//soudp
    }
}
