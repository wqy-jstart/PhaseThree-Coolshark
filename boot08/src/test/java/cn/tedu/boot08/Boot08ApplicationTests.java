package cn.tedu.boot08;

import cn.tedu.boot08.entity.Product;
import cn.tedu.boot08.mapper.ProductMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Boot08ApplicationTests {
    //告诉编译器这个mapper不重要,以防IDEA提示错误
    @Autowired(required = false)
    ProductMapper mapper;

    @Test
    void contextLoads() {
        Product p = new Product();
        p.setTitle("xml标题");
        p.setPrice(111.0);
        p.setNum(222);
        mapper.insert(p);//将添加完信息的对象传入执行插入到SQL
    }
}
