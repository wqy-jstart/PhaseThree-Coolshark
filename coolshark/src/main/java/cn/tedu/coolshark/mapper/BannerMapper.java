package cn.tedu.coolshark.mapper;

import cn.tedu.coolshark.pojo.entity.Banner;

import java.util.List;

/**
 * 该接口用于关联XML中的SQL语句
 */
public interface BannerMapper {

    /**
     * 该方法用来查询所有的轮播图信息
     * @return 返回轮播图信息的List集合
     */
    List<Banner> select();

    /**
     * 该方法用来删除轮播图信息
     * @param id 要删除的轮播图id
     */
    void delete(int id);

    /**
     * 执行插入轮播图图片功能
     */
    void insert(String url);
}
