package cn.tedu.boot04.mapper;

import cn.tedu.boot04.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    //1.执行验证用户名是否存在的功能,查询password判断是否返回结果到User对象中
    //2.执行登录查询功能,传入用户登录的用户名,来查询密码,根据查询结果,返回到User对象中
    @Select("SELECT password FROM user WHERE username=#{username}")
    //传入用户名,根据查询的结果返回一个User对象,判断对象是否为空来确定用户名是否存在
    User selectByUsername(String username);

    //执行注册插入功能,将User对象中封装的注册信息传入SQL语句中,进而保存到数据库
    @Insert("INSERT INTO user VALUES(null,#{username},#{password},#{nickname})")
    void insert(User user);
}
