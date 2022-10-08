package cn.tedu.boot011.controller;

import cn.tedu.boot011.entity.Emp;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ParamController {
    @RequestMapping("/param1")
    @ResponseBody
    public String param1(HttpServletRequest request){
        //从Request对象中获取参数(该种方法只能传字符串,之后做转换)
        String info = request.getParameter("info");
        return "接收到了:"+info;
        //提交后浏览器路径信息:http://localhost:8080/param1?info=xxx
    }

    @RequestMapping("/param2")
    @ResponseBody
    //SpringMVC框架提供的方式,直接在参数列表中传入表单中的信息,如果传入参数类型有误,报400错误
    public String param2(String name,int age){//变量名应当与表单上的name值一致
        return name+":"+age;
        //提交后浏览器路径信息:http://localhost:8080/param2?name=xxx&age=xxx
    }

    @RequestMapping("/param3")
    @ResponseBody
    public String param3(Emp emp){//将表单中的信息封装到对象中,在参数列表中传递该对象即可!
        return emp.toString();
        //提交后浏览器路径信息:http://localhost:8080/param3?name=xxx&salary=xxx&job=xxx
    }
}
