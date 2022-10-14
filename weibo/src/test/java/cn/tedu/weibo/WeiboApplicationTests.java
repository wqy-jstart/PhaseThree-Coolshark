package cn.tedu.weibo;

import cn.tedu.weibo.mapper.UserMapper;
import cn.tedu.weibo.mapper.WeiboMapper;
import cn.tedu.weibo.pojo.dto.UserDTO;
import cn.tedu.weibo.pojo.entity.Weibo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class WeiboApplicationTests {

    @Autowired(required = false)
    UserMapper userMapper;

    @Test
    void contextLoads() {
        UserDTO user = new UserDTO();
        user.setUsername("tom");
        user.setPassword("123456");
        user.setNickname("汤姆");
        userMapper.insert(user);
    }

    @Test
    void t1(){
        //因为UserVO对象中重写了toString()方法直接输出查询后的UserVO对象
        System.out.println(userMapper.selectByUsername("tom"));
    }

    @Autowired(required = false)
    WeiboMapper weiboMapper;

    @Test
    void t2(){
        Weibo weibo = new Weibo();
        weibo.setContent("文本内容");
        weibo.setUrl("/a58b16ce-7cf0-4e8a-b322-66ff5e31affb.jpg");
        weibo.setCreated(new Date());
        weibo.setUserId(1);
        weiboMapper.insert(weibo);
    }

}
