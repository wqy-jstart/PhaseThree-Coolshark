package cn.tedu.weibo.controller;

import cn.tedu.weibo.mapper.CommentMapper;
import cn.tedu.weibo.pojo.dto.CommentDTO;
import cn.tedu.weibo.pojo.entity.Comment;
import cn.tedu.weibo.pojo.vo.CommentVO;
import cn.tedu.weibo.pojo.vo.UserVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class CommentController {

    @Autowired(required = false)
    CommentMapper mapper;

    @RequestMapping("/comment/insert")
    public int insert(@RequestBody CommentDTO comment, HttpSession session){
        //传入user判断返回session保存的对象来判断是否登录
        UserVO user = (UserVO) session.getAttribute("user");
        if (user==null){
            return 2;
        }
        System.out.println("comment = "+comment);//该comment中含有内容content和weiboId
        Comment c = new Comment();
        BeanUtils.copyProperties(comment,c);//将comment复制到对象c中
        //设置用户的id
        c.setUserId(user.getId());
        //调用mapper的insert()方法
        mapper.insert(c);
        return 1;
    }

    @RequestMapping("/comment/selectByWeiboId")
    public List<CommentVO> select(int id){
        return mapper.selectByWeiboId(id);
    }
}
