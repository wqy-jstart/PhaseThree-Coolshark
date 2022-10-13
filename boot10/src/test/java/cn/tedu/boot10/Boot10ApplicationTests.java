package cn.tedu.boot10;

import cn.tedu.boot10.mapper.PlayerMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Boot10ApplicationTests {

    @Autowired(required = false)
    PlayerMapper mapper;

    @Test
    void contextLoads() {
        System.out.println(mapper.selectById(1));
    }

}
