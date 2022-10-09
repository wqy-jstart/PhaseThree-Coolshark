package cn.tedu.boot03.mapper;

import cn.tedu.boot03.entity.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
//★该接口通过获取方法中的参数自动插入到数据库中(★省去手动获取信息和添加到数据库的过程)
public interface ProductMapper {
    //在Mapper接口中书写实体类和数据库中表之间的对应关系
    //Mybatis框架会通过此关系生成JDBC代码.
    //#{变量名}----从参数列表中找同名参数,如果找不到,则调用参数列表中对象的getXXX方法获取数据

    //执行插入功能,将用户输入的内容,插到表中的对应字段内,无返回值
    @Insert("INSERT INTO product VALUES(null,#{title},#{price},#{num})")
    void insert(Product product);//接口中只有方法的声明,没有方法的实现,故不能加方法体

    //查询到的数据会封装到对象里面并且把对象装进list集合,把集合作为返回值
    @Select("SELECT id,title,price,num FROM product")
    List<Product> select();

    //执行删除功能,调用者传入id,自动传入SQL语句中执行删除功能,无返回值
    @Delete("DELETE FROM product WHERE id=#{id}")
    void delete(int id);

    //执行修改功能,传入商品对象,自动寻找参数传入SQL语句中执行修改,无返回值
    @Update("UPDATE product SET title=#{title},price=#{price},num=#{num} WHERE id=#{id}")
    void update(Product product);
}
