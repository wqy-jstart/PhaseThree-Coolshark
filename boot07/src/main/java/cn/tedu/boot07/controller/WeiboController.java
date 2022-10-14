package cn.tedu.boot07.controller;

import cn.tedu.boot07.entity.Weibo;
import cn.tedu.boot07.mapper.WeiboMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.Date;
import java.util.List;

@RestController
public class WeiboController {

    @Autowired//自动装配
    WeiboMapper mapper;

    /**
     * 处理插入weibo对象信息业务
     *
     * @param weibo weibo对象
     */
    @RequestMapping("/insert")
    public void insert(@RequestBody Weibo weibo) {//接收传过来的weibo信息(content,url)
        //new Date()得到当前系统时间
        weibo.setCreated(new Date());//将当前时间设置到weibo对象的created里
        System.out.println("weibo=" + weibo);
        /*create table weibo(id int primary key auto_increment,
        content varchar(100),url varchar(200),created timestamp);*/
        mapper.insert(weibo);
    }

    /**
     * 处理进入页面后响应数据的功能
     *
     * @return weibo对象信息
     */
    @RequestMapping("/select")
    public List<Weibo> select() {
        return mapper.select();
    }

    /**
     * 处理删除weibo功能
     *
     * @param id 要删除weibo的id
     */
    @RequestMapping("/delete")
    public void delete(int id) {
        //通过微博id查询得到图片的路径
        String url = mapper.selectUrlById(id);
        if(new File("G:/files"+url).delete()){//File对象的delete()方法,返回值boolean
            System.out.println("删除成功!");//将图片从文件中删除
        }else {
            System.out.println("删除失败!");
        }
        mapper.deleteById(id);//将图片从weibo表中删除
    }
}
