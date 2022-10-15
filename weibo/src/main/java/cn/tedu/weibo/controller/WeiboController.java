package cn.tedu.weibo.controller;

import cn.tedu.weibo.mapper.WeiboMapper;
import cn.tedu.weibo.pojo.dto.WeiboDTO;
import cn.tedu.weibo.pojo.entity.Weibo;
import cn.tedu.weibo.pojo.vo.UserVO;
import cn.tedu.weibo.pojo.vo.WeiboDetailVO;
import cn.tedu.weibo.pojo.vo.WeiboListVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@RestController
public class WeiboController {
    //自动装配
    @Autowired(required = false)
    WeiboMapper mapper;

    /**
     * 处理发布功能,将用户传入的信息插到数据库中
     * @param weibo WeiboDTO对象(该对象封装了用户发送weibo所"请求"的信息)
     * @param session session用于保存用户
     * @return int
     */
    @RequestMapping("/weibo/insert")
    public int insert(@RequestBody WeiboDTO weibo, HttpSession session){
        UserVO user = (UserVO) session.getAttribute("user");//根据传入的user来查询session中是否有该对象
        if(user==null){
            return 2;
        }

        //创建微博实体类,并且把DTO里面的数据装进实体类,最终插到数据库里
        Weibo w = new Weibo();
        BeanUtils.copyProperties(weibo,w);//将weibo复制到w中
        System.out.println(w);
        //设置当前时间
        w.setCreated(new Date());
        //设置当前登录用户的id
        w.setUserId(user.getId());
        mapper.insert(w);
        return 1;
    }

    /**
     * 查询所有的WeiboListVO中的信息
     * @return 返回包含WeiboListVO对象的所有信息
     */
    @RequestMapping("/weibo/select")
    public List<WeiboListVO> select(){
        return mapper.select();
    }

    /**
     * 根据weibo的id来查询该weibo的信息
     * @param id 传入要查看的weibo的id
     * @return 返回WeiboDetailVO对象的信息
     */
    @RequestMapping("/weibo/selectById")
    public WeiboDetailVO selectById(int id){
        return mapper.selectById(id);
    }
}
