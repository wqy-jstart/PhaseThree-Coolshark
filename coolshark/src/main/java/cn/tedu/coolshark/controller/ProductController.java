package cn.tedu.coolshark.controller;

import cn.tedu.coolshark.mapper.ProductMapper;
import cn.tedu.coolshark.pojo.dto.ProductDTO;
import cn.tedu.coolshark.pojo.dto.ProductUpdateDTO;
import cn.tedu.coolshark.pojo.entity.Product;
import cn.tedu.coolshark.pojo.vo.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Value("${dirPath}")//该注解会将配置文件中的变量传递到当下的全局变量中
    private String dirPath;

    @Autowired(required = false)
    ProductMapper mapper;

    /**
     * 该方法用来添加商品信息
     *
     * @param product 接收传入要添加的商品信息DTO对象
     */
    @RequestMapping("/insert")
    public void insert(@RequestBody ProductDTO product) {
        System.out.println("product = " + product);//soudp
        Product p = new Product();
        //把DTO里面的属性复制到p实体类中
        BeanUtils.copyProperties(product, p);
        //给属性复制
        p.setCreated(new Date());
        //浏览量
        p.setViewCount(0);
        mapper.insert(p);
    }

    /**
     * 处理查询管理员相关的所有商品信息
     *
     * @return 返回有关管理员的信息对象List集合
     */
    @RequestMapping("/select/admin")
    public List<ProductAdminVO> selectAdmin() {
        return mapper.selectAdmin();
    }

    /**
     * 删除商品
     *
     * @param id 要删除的商品id
     */
    @RequestMapping("/delete")
    public void delete(int id) {
        //根据id去商品表中找url路径
        String url = mapper.selectUrlById(id);
        //删文件
        if (new File(dirPath+ url).delete()) {
            System.out.println("删除成功!");
        } else {
            System.out.println("删除失败!");
        }
        //删数据
        mapper.deleteById(id);
    }

    /**
     * 处理修改前需要查询的商品信息
     *
     * @param id 商品id
     * @return 返回查询前的商品信息VO对象
     */
    @RequestMapping("/delectById/update")
    public ProductUpdateVO selectByIdUpdate(int id) {
        return mapper.selectByIdUpdate(id);
    }

    /**
     * 处理修改商品信息
     * @param product 接收修改后的商品信息DTO对象
     */
    @RequestMapping("/update")
    public void update(@RequestBody ProductUpdateDTO product) {
        System.out.println("product = " + product);
        mapper.update(product);
    }


    /**
     * 处理查询商品排行的业务
     * @return 返回查询到排序后的商品VO对象
     */
    @RequestMapping("/select/top")
    public List<ProductTopVO> selectTop(){
        return mapper.selectTop();
    }

    /**
     * 处理Index主页商品的所有信息
     * @return 返回主页所有商品信息的List集合
     */
    @RequestMapping("/select/index")
    public List<ProductIndexVO> selectIndex(){
        return mapper.selectIndex();
    }

    /**
     * 处理商品详情信息
     * @param id 接收传入的商品id
     * @return 返回该id下的商品详情信息VO对象
     */
    @RequestMapping("/selectById/detail")
    public ProductDetailVO selectByIdDetail(int id, HttpSession session){
        //从会话对象中获取和当前商品id相关的信息,第一次是获取不到的
        String info = (String) session.getAttribute("view"+id);
        if (info==null){//如果info值为null说明是第一次浏览
            //让浏览量+1
            mapper.updateViewCount(id);//通过该方法让该id下的商品浏览量+1
            //把当前商品id相关信息保存到Session中,之后再次查询此商品时,此条件则不会再满足,因为值不为null
            session.setAttribute("view"+id,"isVisited");
        }
        return mapper.selectByIdDetail(id);
    }

    /**
     * 根据分类id查询该id下的所有商品信息
     * @param id 接收传递的分类id
     * @return 返回该分类id下的所有商品信息VO对象的List集合
     */
    @RequestMapping("/selectByCid")
    public List<ProductIndexVO> selectByCid(int id){
        return mapper.selectByCid(id);
    }

    /**
     * 处理根据搜索框中搜索的内容来返回搜索结果
     * @param wd 接收搜索框输入的内容
     * @return 返回搜索的商品结果
     */
    @RequestMapping("/selectByWd")
    public List<ProductIndexVO> selectWd(String wd){
        return mapper.selectByWd(wd);
    }
}
