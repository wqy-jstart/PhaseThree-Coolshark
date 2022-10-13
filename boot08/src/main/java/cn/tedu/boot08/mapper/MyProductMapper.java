package cn.tedu.boot08.mapper;

import cn.tedu.boot08.entity.MyProduct;

import java.util.List;

public interface MyProductMapper {

    /**
     * 执行插入商品功能
     * @param product 接收调用者传入的MyProduct对象
     */
    void insert(MyProduct product);

    /**
     * 执行查询一个商品功能
     * @param id 接收调用者传入的商品id
     * @return 返回MyProduct对象
     */
    MyProduct selectById(int id);

    /**
     * 执行查询所有商品的功能
     * @return 返回所有商品的对象集合
     */
    List<MyProduct> select();
}
