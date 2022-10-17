package cn.tedu.coolshark.controller;

import cn.tedu.coolshark.mapper.UserMapper;
import cn.tedu.coolshark.pojo.dto.UserDTO;
import cn.tedu.coolshark.pojo.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class UserController {
    @Autowired(required = false)
    UserMapper mapper;

    /**
     * 该方法用于处理用户登录
     * @param user UserDTO用户登录的信息
     * @param session 建立一次会话,保存用户登录的信息
     * @return 返回int值,对应登录结果
     */
    @RequestMapping("/login")
    public int login(@RequestBody UserDTO user, HttpSession session){
        System.out.println("user="+user);
        UserVo u = mapper.selectByUsername(user.getUsername());
        if (u!=null) {
            if (user.getPassword().equals(u.getPassword())) {
                session.setAttribute("user",u);
                return 1;
            }
            return 3;
        }
        return 2;
    }
}
