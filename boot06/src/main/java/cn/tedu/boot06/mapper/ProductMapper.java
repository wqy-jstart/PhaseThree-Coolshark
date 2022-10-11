package cn.tedu.boot06.mapper;

import cn.tedu.boot06.entity.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
//该注解是一个接口类型,在接口中书写实体类和数据库中表之间的对应关系,MyBatis框架会自动通过此关系生成JDBC代码
public interface ProductMapper {

    /**
     * 执行插入功能
     * @param product 对象
     */
    @Insert("INSERT INTO product VALUES(null,#{title},#{price},#{num})")
    void insert(Product product);//负责接收调用者传入的商品对象在通过@Insert(String sql)插入到数据库中

    /**
     * 执行查询商品所有信息的功能
     * @return List商品集合
     */
    @Select("SELECT id,title,price,num FROM product")
    List<Product> select();//调用者会直接获得一个查询后包含商品所有信息的List集合

    /**
     * 执行删除商品的功能
     * @param id 传入商品id
     */
    @Delete("DELETE FROM product WHERE id=#{id}")
    void deleteById(int id);//通过调用者传入的商品id执行删除操作

    /**
     * 执行返回修改前商品的对象
     * @param id 传入商品的id
     * @return 返回Product商品对象(包含修改前商品的所有信息)
     */
    @Select("SELECT id,title,price,num FROM product WHERE id=#{id}")
    Product selectById(int id);//调用者通过传入商品id得到该id对应修改前的商品对象

    /**
     * 执行商品的修改功能
     * @param product Product对象(包含修改后的商品所有信息)
     */
    @Update("UPDATE product SET title=#{title},price=#{price},num=#{num} WHERE id=#{id}")
    void update(Product product);//通过调用者传入修改后的商品对象执行修改操作
}
