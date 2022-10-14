package cn.tedu.weibo.mapper;

import cn.tedu.weibo.pojo.dto.UserDTO;
import cn.tedu.weibo.pojo.vo.UserVO;

public interface UserMapper {

    /**
     * 向UserDTO对象中插入用户输入的信息
     * @param user UserDTO对象
     */
    void insert(UserDTO user);

    /**
     * 根据用户名查询UserVO里面的信息
     * @param username 用户名
     * @return 返回UserVO对象
     */
    UserVO selectByUsername(String username);
}
