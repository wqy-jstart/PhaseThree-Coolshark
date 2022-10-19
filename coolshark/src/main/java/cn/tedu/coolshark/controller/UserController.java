package cn.tedu.coolshark.controller;

import cn.tedu.coolshark.mapper.UserMapper;
import cn.tedu.coolshark.pojo.dto.UserDTO;
import cn.tedu.coolshark.pojo.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@RestController
public class UserController {
    @Autowired(required = false)
    UserMapper mapper;

    /**
     * 该方法用于处理用户登录
     * @param user UserDTO用户登录的信息
     * @param response 建立一次会话,保存用户登录的信息
     * @return 返回int值,对应登录结果
     */
    @RequestMapping("/login")
    public int login(@RequestBody UserDTO user, HttpServletResponse response){
        System.out.println("user="+user);
        UserVo u = mapper.selectByUsername(user.getUsername());
        if (u!=null) {
            if (user.getPassword().equals(u.getPassword())) {//如果密码正确
                if (user.getRem()){//如果勾选了记住用户名密码
                    //创建Cookie,将用户名和密码进行保存,设置保存最大时间
                    Cookie c1 = new Cookie("username", user.getUsername());//将用户名保存到username中
                    Cookie c2 = new Cookie("password", user.getPassword());//将密码保存到password中
                    //设置保存最大时间
                    c1.setMaxAge(60*60*24);
                    c2.setMaxAge(60*60*24);
                    //将获取的用户名密码下发给页面
                    response.addCookie(c1);
                    response.addCookie(c2);
                }
                return 1;
            }
            return 3;
        }
        return 2;
    }
}
