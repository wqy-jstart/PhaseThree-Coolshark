package cn.tedu.boot08.mapper;

import cn.tedu.boot08.entity.Product;

import java.util.List;

//此时使用了MapperScan注解并传入了mapper包路径 则不需要再写@Mapper注解
//已经默认此项目所有mapper接口都在这个包路径里
public interface ProductMapper {
    //此处不再写@Insert等注解,SQL语句写在XML配置文件中

    /**
     * 插入数据
     * @param product 接收调用者传入的商品对象
     */
    void insert(Product product);

    /**
     * 删除数据
     * @param id 接收调用者传入的商品id
     */
    void deleteById(int id);

    /**
     * 修改数据
     * @param product 接收调用者传入的商品对象
     */
    void update(Product product);

    /**
     * 查询所有商品信息
     * @return 返回List集合
     */
    List<Product> select();

    /**
     * 查询单个商品信息
     * @param id 接收调用者传入的商品id
     * @return Product商品对象
     */
    Product selectById(int id);

    /**
     * 查询商品数量
     * @return int型商品数量
     */
    int count();

    // 1,3,5,6,7   DELETE FROM product WHERE id IN(1,3,5)
    /**
     * 批量删除数据
     * @param ids 接收调用者传入的集合或数组,(集合或数组中添加要删除的商品id)
     * @return int返回值 返回的是生效的行数(删除了多少条)
     */
    int deleteByIds1(List<Integer> ids); //传List集合
    int deleteByIds2(Integer[] ids); //传Integer数组
    int deleteByIds3(Integer... ids); //传任意数量的Integer

    //INSERT INTO product VALUES(null,'',100,30),(null,'',100,30)...
    /**
     * 批量插入数据
     * @param list ★接收调用者传入的List集合(要插入的是包含对象的List集合)
     * @return int返回值 返回插入的数量
     */
    int insertProducts(List<Product> list);

    /**
     * 动态插入数据,自动识别对象属性是否有值
     * @param product 接收调用者传入设置后的商品对象
     * @return int返回值 返回插入的数量
     */
    int dynamicInsert(Product product);

    /**
     * 动态修改数据
     * @param p 接收调用者传入修改后的商品对象
     */
    void dynamicUpdate(Product p);
}
