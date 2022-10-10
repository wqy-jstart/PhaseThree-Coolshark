package cn.tedu.boot05.mapper;

import cn.tedu.boot05.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    //处理查询业务
    //1.查询是否存在   2.查询密码返回登录结果
    @Select("SELECT password FROM user WHERE username=#{username}")
    User selectByUsername(String name);

    //处理注册,将用户注册的内容插入到user表中
    @Insert("INSERT INTO user VALUE(null,#{username},#{password},#{nickname})")
    void insert(User user);
}
