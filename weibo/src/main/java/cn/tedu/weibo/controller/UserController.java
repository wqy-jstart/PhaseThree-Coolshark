package cn.tedu.weibo.controller;

import cn.tedu.weibo.mapper.UserMapper;
import cn.tedu.weibo.pojo.dto.UserDTO;
import cn.tedu.weibo.pojo.dto.UserLoginDTO;
import cn.tedu.weibo.pojo.vo.UserVO;
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
     * 处理用户注册功能
     *
     * @param user 传入用户post异步请求时发送的UserDTO对象
     * @return 返回int值(1 : 注册成功 2 : 用户名已存在)
     */
    @RequestMapping("/reg")
    public int reg(@RequestBody UserDTO user) {
        System.out.println("user = " + user);
        UserVO u = mapper.selectByUsername(user.getUsername());
        if (u != null) {
            return 2;//用户名已存在
        }
        mapper.insert(user);//用户名可用,并插到数据库
        return 1;//注册成功
    }

    /**
     * 处理用户登录功能
     * @param user 用户登录时封装登录信息的UserLoginDTO对象
     * @param session HttpSession对象,用于和用户建立回话
     * @return 返回int型(1:登陆成功 2:用户名不存在 3:密码错误)
     */
    @RequestMapping("/login")
    public int login(@RequestBody UserLoginDTO user, HttpSession session) {//HttpSession来区分登录的不用用户
        UserVO u = mapper.selectByUsername(user.getUsername());//根据UserLoginDTO中用户登录的用户名查询UserVO里面的信息
        if (u != null) { //如果不为空说明用户名存在,然后比较密码
            if (user.getPassword().equals(u.getPassword())) {//密码一致,登录成功
                //往Session对象中保存
                session.setAttribute("user", u);//类似Map,★这里的u为返回的UserVO对象的引用
                return 1;//登录成功
            }
            return 3;//密码错误
        }
        return 2;//用户名不存在
    }

    /**
     * 用户信息保存到Session对象以后,利用引用调用获取用户名并返回到首页
     * @param session HttpSession对象
     * @return 返回UserVO类型
     */
    @RequestMapping("/currentUser")
    public UserVO currentUser(HttpSession session) {
        return (UserVO) session.getAttribute("user");
    }

    /**
     * 处理退出登录,同时要删除session对象中的user用户信息
     * @param session HttpSession对象
     */
    @RequestMapping("/logout")
    public void logout(HttpSession session){
        //调用removeAttribute()方法将session中保存的user对象删除
        session.removeAttribute("user");
    }
}
