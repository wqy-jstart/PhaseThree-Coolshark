package cn.tedu.boot011.controller;

import cn.tedu.boot011.entity.User;
import cn.tedu.boot011.util.DBUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Controller
public class UserController {
    @RequestMapping("/reg")
    @ResponseBody
    public String reg(User user) {
        System.out.println("user = " + user);
        try ( //与数据库MySQL建立连接,将用户数据插入保存到bbsdb的user表中
              Connection connection = DBUtil.getConnection()//通过DBUtil来获取数据库连接
        ) {
            //1.先判断注册的用户是否存在
            String sql = "SELECT 1 FROM user WHERE username=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            //设置第一个?为用户名,通过用户名判断该用户是否存在
            ps.setString(1, user.getUsername());
            ResultSet rs = ps.executeQuery();//该方法返回查询的结果集
            if (rs.next()) {
                return "该用户已存在!";
            }
            //2.在用户不存在的情况下向user表中保存新的用户信息(用户名,密码,昵称)
            String sql1 = "INSERT INTO user VALUES(null,?,?,?)";//定义SQL语句
            ps = connection.prepareStatement(sql1);//使用预编译传入SQL语句生成执行方法
            //使用PreparedStatement类的set方法设置需要传入的值
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getNickname());
            int num = ps.executeUpdate();//该方法返回影响数据库的条数
            if (num > 0) {//若影响的条数大于零说明插入成功
                System.out.println("保存成功!");
            } else {
                System.out.println("保存失败!");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return "注册成功!";//将结果返回给浏览器
    }

    @RequestMapping("/login")
    @ResponseBody
    public String login(String username, String password) {
        System.out.println("用户名:" + username + ",密码:" + password);
        try (
                Connection connection = DBUtil.getConnection()
        ) {
            String sql = "SELECT username,password " +
                    "FROM user " +
                    "WHERE username=? " +
                    "AND password=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,username);
            ps.setString(2,password);
            ResultSet rs = ps.executeQuery();//获取查询的结果集
            if (rs.next()) {//返回true说明查询到了结果
                System.out.println("登陆成功!");
            } else {
                System.out.println("登录失败!");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return "正在处理登录!";
    }
}
