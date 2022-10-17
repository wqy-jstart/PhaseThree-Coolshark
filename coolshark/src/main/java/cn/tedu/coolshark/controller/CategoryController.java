package cn.tedu.coolshark.controller;

import cn.tedu.coolshark.mapper.CategoryMapper;
import cn.tedu.coolshark.pojo.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {
    @Autowired(required = false)
    CategoryMapper mapper;

    /**
     * 该方法用于返回分类的所有信息
     * @return 分类信息的集合
     */
    @RequestMapping("/category/select")
    public List<Category> select(){
        return mapper.select();
    }

    /**
     * 删除后台分类列表中的数据
     * @param id 要删除的id
     */
    @RequestMapping("/category/delete")
    public void delete(int id){
        mapper.deleteById(id);
    }

    /**
     * 处理添加分类,先根据传递的名字,插到数据库,然后再将数据List集合查回来
     * @return 返回查询的List分类信息的集合
     */
    @RequestMapping("/category/insert")
    public List<Category> insert(String name){//接收JS文本框输入的商品name
        mapper.insert(name);//向数据库中插入文本框中输入的商品name
        return mapper.select();//直接向数据库中查询所有信息(达到一个插入后刷新的效果)
    }

    /**
     * 修改商品分类信息
     * @param category 接收修改后的商品信息(id,name)
     */
    @RequestMapping("/category/update")
    public void update(@RequestBody Category category){//用Category对象来接收传过来修改后的对象c
        mapper.update(category);//传入category对象,执行数据库的修改操作
    }
}
