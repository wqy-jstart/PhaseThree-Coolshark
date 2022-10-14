package cn.tedu.weibo.mapper;

import cn.tedu.weibo.pojo.entity.Weibo;
import cn.tedu.weibo.pojo.vo.WeiboDetailVO;
import cn.tedu.weibo.pojo.vo.WeiboListVO;

import java.util.List;

public interface WeiboMapper {

    /**
     * 插入用户发布的weibo信息
     * @param weibo
     */
    void insert(Weibo weibo);

    /**
     * 查询所有微博信息
     * @return List集合
     */
    List<WeiboListVO> select();

    /**
     * 根据id查询一条weibo信息
     * @param id 微博的id
     * @return 返回WeiboDetailVO对象
     */
    WeiboDetailVO selectById(int id);
}
