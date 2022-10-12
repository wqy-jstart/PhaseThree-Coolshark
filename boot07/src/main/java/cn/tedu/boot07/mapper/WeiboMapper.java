package cn.tedu.boot07.mapper;

import cn.tedu.boot07.entity.Weibo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface WeiboMapper {

    /**
     * 执行插入weibo信息到数据库
     *
     * @param weibo weibo对象
     */
    @Insert("INSERT INTO weibo VALUES(null,#{content},#{url},#{created})")
    void insert(Weibo weibo);

    /**
     * 执行查询所有的weibo数据
     *
     * @return List集合形式返回
     */
    @Select("SELECT id,content,url,created FROM weibo")
    List<Weibo> select();

    /**
     * 执行删除weibo功能
     *
     * @param id 要删除的微博id
     */
    @Delete("DELETE FROM weibo WHERE id=#{id}")
    void deleteById(int id);

    /**
     * 根据传递的微博id,查询图片信息的路径
     * @param id 微博id
     * @return id对应的图片路径
     */
    @Select("SELECT url FROM weibo WHERE id=#{id}")
    String selectUrlById(int id);
}
