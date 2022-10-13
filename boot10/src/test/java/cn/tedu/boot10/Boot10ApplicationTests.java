package cn.tedu.boot10;

import cn.tedu.boot10.mapper.PlayerMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Boot10ApplicationTests {
    //告诉编译器,装配失败不重要
    @Autowired(required = false)
    PlayerMapper mapper;

    //测试根据球员的id,来查询球员包括其团队的所有信息
    @Test
    void contextLoads() {
        System.out.println(mapper.selectById(1));
    }
}
