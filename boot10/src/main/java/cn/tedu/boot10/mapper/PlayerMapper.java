package cn.tedu.boot10.mapper;

import cn.tedu.boot10.pojo.vo.PlayerVO;

//该接口处理有关运动员的业务方法
public interface PlayerMapper {

    /**
     * 通过球员id查询
     * @param id 球员id
     * @return 要查询的球员信息
     */
    PlayerVO selectById(int id);
}
