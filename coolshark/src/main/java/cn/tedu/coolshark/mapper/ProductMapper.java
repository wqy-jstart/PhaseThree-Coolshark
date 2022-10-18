package cn.tedu.coolshark.mapper;

import cn.tedu.coolshark.pojo.dto.ProductDTO;
import cn.tedu.coolshark.pojo.dto.ProductUpdateDTO;
import cn.tedu.coolshark.pojo.entity.Product;
import cn.tedu.coolshark.pojo.vo.ProductAdminVO;
import cn.tedu.coolshark.pojo.vo.ProductTopVO;
import cn.tedu.coolshark.pojo.vo.ProductUpdateVO;

import java.util.List;

public interface ProductMapper {
    /**
     * 执行向数据库中插入商品数据
     * @param product 商品数据实体类
     */
    void insert(Product product);

    /**
     * 执行查询SQL中有关管理员的商品信息List集合
     * @return 返回管理员商品对象的List集合
     */
    List<ProductAdminVO> selectAdmin();

    /**
     * 根据商品id查找商品图片的url路径
     * @param id 商品id
     * @return 返回要查找的商品图片url路径
     */
    String selectUrlById(int id);

    /**
     * 执行删除商品的功能
     * @param id 要删除的商品id
     */
    void deleteById(int id);

    /**
     * 根据商品id进行查询修改前的商品信息
     * @param id 商品id
     * @return 返回修改前的商品信息VO对象
     */
    ProductUpdateVO selectByIdUpdate(int id);

    /**
     * 执行修改商品信息
     * @param product 接收修改的商品信息DTO
     */
    void update(ProductUpdateDTO product);

    /**
     * 执行查询SQL中有关排行的商品信息
     * @return 返回排行榜中商品的信息VO
     */
    List<ProductTopVO> selectTop();
}
