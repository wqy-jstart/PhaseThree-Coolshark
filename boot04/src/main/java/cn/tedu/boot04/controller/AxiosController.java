package cn.tedu.boot04.controller;

import cn.tedu.boot04.entity.Product;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AxiosController {
    //处理测试异步get请求
    @RequestMapping("/helloAxios")
    public String helloAxios(String name,int age){
        //在这里指定年龄的类型为int,如果不是int型,控制台会报400类型不符合的错误
        //若为同步请求,会直接在页面报400类型不符合的错误
        return "get测试成功!name="+name+"年龄="+age;
    }

    //处理异步post请求
    //如果发出的请求方式为post请求并且传递过来的是自定义JS对象接收参数时
    //需要添加@RequestBody注解  如果不加注解  接收到的参数是null
    @RequestMapping("/postAxios")
    public String postAxios(@RequestBody Product product){

        return "post测试成功!"+product.toString();
    }
}
