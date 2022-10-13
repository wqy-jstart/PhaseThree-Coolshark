package cn.tedu.boot10.mapper;

import cn.tedu.boot10.pojo.vo.PlayerVO;

public interface PlayerMapper {

    /**
     * 通过球员id查询
     * @param id 球员id
     * @return 球员信息
     */
    PlayerVO selectById(int id);
}
