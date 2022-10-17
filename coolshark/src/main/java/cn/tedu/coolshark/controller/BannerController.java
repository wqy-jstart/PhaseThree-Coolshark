package cn.tedu.coolshark.controller;

import cn.tedu.coolshark.mapper.BannerMapper;
import cn.tedu.coolshark.pojo.entity.Banner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.List;

@RestController
public class BannerController {

    @Autowired(required = false)
    BannerMapper mapper;

    /**
     * 处理向JS中返回查询的轮播图所有的信息
     * @return 返回轮播图所有信息的List集合
     */
    @RequestMapping("/banner/select")
    public List<Banner> select(){
        return mapper.select();
    }

    /**
     * 处理要删除的轮播图
     * @param id 接收传递的id
     */
    @RequestMapping("/banner/delete")
    public void delete(int id){
       mapper.delete(id);
    }

    @RequestMapping("/banner/insert")
    public void insert(String url){
        mapper.insert(url);
    }
}
