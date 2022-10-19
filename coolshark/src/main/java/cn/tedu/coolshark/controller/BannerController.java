package cn.tedu.coolshark.controller;

import cn.tedu.coolshark.mapper.BannerMapper;
import cn.tedu.coolshark.pojo.entity.Banner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.List;

@RestController
@RequestMapping("/banner")//在类上写该注解可以指定提交地址的父路径
public class BannerController {
    @Value("${dirPath}")//该注解会将配置文件中的变量传递到当下的全局变量中
    private String dirPath;

    @Autowired(required = false)
    BannerMapper mapper;

    /**
     * 处理向JS中返回查询的轮播图所有的信息
     * @return 返回轮播图所有信息的List集合
     */
    @RequestMapping("/select")
    public List<Banner> select(){
        return mapper.select();
    }

    /**
     * 处理要删除的轮播图
     * @param id 接收传递的id
     */
    @RequestMapping("/delete")
    public void delete(int id){
        //删文件
        String url = mapper.selectUrlById(id);
        if(new File(dirPath+url).delete()){
            System.out.println("删除成功!");
        }else {
            System.out.println("删除失败!");
        }
        //删数据
       mapper.delete(id);//向数据库中删除
    }

    /**
     *添加轮播图
     * @param url 传入添加的图片路径
     */
    @RequestMapping("/insert")
    public void insert(String url){
        mapper.insert(url);
    }

    /**
     * 修改轮播图
     * @param banner 接收修改后的对象
     */
    @RequestMapping("/update")
    public void update(@RequestBody Banner banner){
        System.out.println("banner = "+banner);
        mapper.update(banner);
    }
}
