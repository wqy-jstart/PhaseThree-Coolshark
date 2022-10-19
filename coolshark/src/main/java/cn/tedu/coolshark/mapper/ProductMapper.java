package cn.tedu.coolshark.mapper;

import cn.tedu.coolshark.pojo.dto.ProductDTO;
import cn.tedu.coolshark.pojo.dto.ProductUpdateDTO;
import cn.tedu.coolshark.pojo.entity.Product;
import cn.tedu.coolshark.pojo.vo.*;

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

    /**
     * 执行查询主页所有商品信息的功能
     * @return 返回所有商品信息VO对象的List集合
     */
    List<ProductIndexVO> selectIndex();

    /**
     * 执行查询商品详情的功能
     * @param id 接收传入的商品id
     * @return 返回该id下的商品详情信息VO对象
     */
    ProductDetailVO selectByIdDetail(int id);

    /**
     * 根据传入的商品id让该商品浏览量+1
     * @param id 商品id
     */
    void updateViewCount(int id);

    /**
     * 查询指定分类下的商品信息
     * @param id 分类id
     * @return 返回首页商品信息对象的List集合
     */
    List<ProductIndexVO> selectByCid(int id);

    /**
     * 执行根据搜索内容到数据库中查询对应商品的结果信息
     * @param wd 接收搜索框中搜索的内容
     * @return 返回搜索结果的商品信息VO对象List集合
     */
    List<ProductIndexVO> selectByWd(String wd);
}
