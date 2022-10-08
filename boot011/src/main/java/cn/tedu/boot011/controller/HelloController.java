package cn.tedu.boot011.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
public class HelloController {
//    @RequestMapping("/hello")
//    public void hello(HttpServletResponse response) throws IOException {
//        //设置响应头
//        response.setContentType("text/html;charset=utf-8");
//        //获取输出对象
//        PrintWriter pw = response.getWriter();
//        //输出数据
//        pw.println("服务器接收到了响应!");
//        //关闭资源
//        pw.close();
//    }
    @RequestMapping("/hello")
    @ResponseBody //此注解的作用是,可以通过返回值的方式给客户端响应数据
    public String hello(){
        return "服务器接收到了响应!";
    }
}
