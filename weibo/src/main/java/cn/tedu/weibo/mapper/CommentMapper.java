package cn.tedu.weibo.mapper;

import cn.tedu.weibo.pojo.entity.Comment;
import cn.tedu.weibo.pojo.vo.CommentVO;

import java.util.List;

public interface CommentMapper {
    /**
     * 向数据库插入评论的信息
     * @param comment 传入评论的信息
     */
    void insert(Comment comment);

    /**
     * 查询评论的所有信息
     * @return 返回List集合
     */
    List<CommentVO> select(int id);
}
