package cn.tedu.boot10.mapper;

import cn.tedu.boot10.pojo.vo.TeamVO;

//处理有关球队的业务方法
public interface TeamMapper {

    TeamVO selectById(int id);
}
