package cn.tedu.boot02.controller;

import cn.tedu.boot02.entity.User;
import cn.tedu.boot02.util.DBUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Controller
public class UserController {
    @RequestMapping("/login")
    @ResponseBody
    public String login(User user){
        System.out.println("user = "+user);
        try(
                Connection connection = DBUtil.getConnection()
        ) {
            String sql = "SELECT password " +
                    "FROM user " +
                    "WHERE username=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,user.getUsername());
            ResultSet rs = ps.executeQuery();//返回查询的结果集
            if (rs.next()){//判断是否有一条记录,如果能查到,则比较密码是否正确
                //getString(int columnIndex)方法获取此ResultSet对象的当前行中指定列的值。(以上面字符串中的SQL语句为准)
                String pw = rs.getString(1);//得到查询到的密码
                if (pw.equals(user.getPassword())){
                    //若查询到的密码和用户输入密码属性值相同,则登陆成功
                    return "登录成功!";
                } //否则登录失败
                return "密码错误!";
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        //查不到说明用户名不存在!
        return "用户名不存在!";
    }
}
