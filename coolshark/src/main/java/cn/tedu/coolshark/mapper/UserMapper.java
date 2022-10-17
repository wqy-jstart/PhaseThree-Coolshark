package cn.tedu.coolshark.mapper;

import cn.tedu.coolshark.pojo.vo.UserVo;

public interface UserMapper {

    UserVo selectByUsername(String username);

}
