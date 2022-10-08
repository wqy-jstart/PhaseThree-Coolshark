package cn.tedu.boot011.controller;

import cn.tedu.boot011.entity.User;
import cn.tedu.boot011.util.DBUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Controller
public class UserController {
    @RequestMapping("/reg")
    @ResponseBody
    public String reg(User user){
        System.out.println("user = "+user);
        try( //与数据库MySQL建立连接,将用户数据插入保存到bbsdb的user表中
                Connection connection = DBUtil.getConnection()
        ) {
            String sql = "INSERT INTO user VALUES(null,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,user.getUsername());
            ps.setString(2,user.getPassword());
            ps.setString(3,user.getNickname());
            int num = ps.executeUpdate();//该方法返回影响数据库的条数
            if (num>0){//若影响的条数大于零说明插入成功
                System.out.println("保存成功!");
            }else {
                System.out.println("保存失败!");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return "注册成功!";//将结果返回给浏览器
    }
}
