package cn.tedu.boot05.controller;

import cn.tedu.boot05.entity.User;
import cn.tedu.boot05.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserMapper mapper;

    //处理注册
    @RequestMapping("/reg")
    public int reg(@RequestBody User user){//将返回的结果改为int,提高网络传输效率
        System.out.println("user = "+user);
        //调用selectByUsername()方法返回查询后的User对象结果
        User u = mapper.selectByUsername(user.getUsername());
        if (u==null){//说明用户不存在,可以创建
            mapper.insert(user);//调用insert()方法插入到数据库user表中
            return 1;//返回1代表成功
        }
        return 2;//返回2代表用户名已经存在
    }

    //处理登录
    @RequestMapping("/login")
    public int login(@RequestBody User user){//这里的user为post传递的user,该user已被封装到entity包下的User类中
        System.out.println("用户输入的用户名:"+user.getUsername());
        //调用selectByUsername()方法返回查询后的User对象结果
        User u = mapper.selectByUsername(user.getUsername());
        if (u==null){ //如果返回的User对象为null,说明没有查到该用户
            return 2;//返回2说明,用户名不存在
        }else { //用户名存在,比对密码
            if (user.getPassword().equals(u.getPassword())){
                return 1;//返回1说明密码正确,登录成功
            }else {
                return 3;//返回3说明密码错误,登录失败
            }
        }
    }

    //处理注册中添加的光标失去焦点事件
    @RequestMapping("/check")
    public String check(String username){ //传的是用户输入的用户名
        System.out.println("username = "+username);
        //调用selectByUsername()方法,通过输入的用户名向数据库中查询
        //并返回结果用User对象接收,若返回的对象为null说明数据库中没有该用户,可以注册
        User u = mapper.selectByUsername(username);//查询用户是否存在
        return u==null?"用户名可用!":"用户名已存在!";//三目运算
    }
}
