package cn.tedu.boot04.controller;

import cn.tedu.boot04.entity.User;
import cn.tedu.boot04.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController//使用RestController相当于在每一个方法上都添加了@ResponseBody注解
public class UserController {

    @Autowired//自动装配,此框架添加之后会自动生成UserMapper的实现类,并且实例化实现类
    UserMapper mapper;//把实例化好的对象赋值给了mapper变量

    //处理用户注册
    @RequestMapping("/reg")
    public String reg(User user) {
        System.out.println("user = " + user);
        //利用mapper调用selectByUsername()方法传入用户注册的用户名,通过@Select注解进行查询,查询结果用User对象来接收
        User u = mapper.selectByUsername(user.getUsername());
        if (u != null) {//如果该对象不为空,说明用户名已经存在
            return "用户名已存在!请<a href='/reg.html'>重新注册</a>";
        }
        //利用mapper调用insert()方法根据用户输入的封装在User对象中所有信息,通过@Insert注解插入到数据库中
        mapper.insert(user);
        return "注册成功!<a href='/'>返回首页</a>";
    }

    //处理用户登录
    @RequestMapping("/login")
    public String login(User user) {
        //利用mapper调用selectByUsername()方法传入用户注册的用户名,通过@Select注解进行查询,查询结果用User对象来接收
        User u = mapper.selectByUsername(user.getUsername());
        if (u != null) {//说明查到了,用户名存在,然后比较密码(★前者为用户输入的密码,后者为查询结果中的密码)
            if (user.getPassword().equals(u.getPassword())) {
                return "登录成功!<a href='/'>返回首页</a>";
            } else {
                return "密码错误!请<a href='/login.html'>重新登录</a>";
            }
        }
        return "用户名不存在!请<a href='/login.html'>重新登录</a>";
    }

    //处理光标失去焦点事件
    @RequestMapping("/check")
    public String check(String username){
        System.out.println("username = "+username);
        //调用selectByUsername()方法,通过输入的用户名向数据库中查询
        //并返回结果用User对象接收,若返回的对象为null说明数据库中没有该用户,可以注册
        User u = mapper.selectByUsername(username);//查询用户是否存在
        return u==null?"用户名可用!":"用户名已存在!";//使用三目运算
    }
}
