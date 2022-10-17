package cn.tedu.coolshark.mapper;

import cn.tedu.coolshark.pojo.entity.Category;

import java.util.List;

public interface CategoryMapper {
    /**
     * 查询分类的所有信息
     * @return 返回分类所有信息的集合
     */
    List<Category> select();

    /**
     * 删除后台分类列表中的数据
     * @param id 接收要删除的id
     */
    void deleteById(int id);

    /**
     * 添加分类数据
     * @param name 传入分类的名字
     */
    void insert(String name);

    /**
     * 接收修改后的信息,进行执行修改
     * @param category 修改后的对象信息
     */
    void update(Category category);
}
