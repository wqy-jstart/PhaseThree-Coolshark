package cn.tedu.boot09;

import cn.tedu.boot09.entity.Emp;
import cn.tedu.boot09.mapper.EmpMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest
class Boot09ApplicationTests {

    @Autowired(required = false)
    EmpMapper mapper;

    //插入数据(表中id无法插入,因为是主键且自增,但是可以查询)
    @Test
    void contextLoads() {
        Emp e = new Emp();
        e.setName("张三");
        e.setSalary(2000.0);
        e.setJob("工地");
        e.setManagerId(1);
        mapper.insert(e);
    }

    //批量插入
    @Test
    void t1(){
        ArrayList<Emp> list = new ArrayList<>();
        list.add(new Emp(null,"张三",1000.0,"销售",2));
        list.add(new Emp(null,"李四",2000.0,"程序员",3));
        list.add(new Emp(null,"王五",4000.0,"养猪",2));
        int num = mapper.insert1(list);
        System.out.println("添加了"+num+"位员工");
    }

    //删除一条指定id下的数据
    @Test
    void t2(){
        mapper.deleteById1(7);
    }

    //批量删除数据
    @Test
    void t3(){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(6);
        list.add(7);
        int num = mapper.deleteById2(list);
        System.out.println("删除了"+num+"位员工");
    }

    //动态修改数据(根据表名进行修改)
    @Test
    void t4(){
        Emp e = new Emp();
        e.setId(1);
        e.setName("武清源");
        e.setJob("老板");
        mapper.dynamicUpdate(e);
    }

    //单个查询
    @Test
    void t5(){
        System.out.println(mapper.selectById1(1));
    }

    //查询所有
    @Test
    void t6(){
        System.out.println(mapper.selectById2());
    }

    //查询员工数量
    @Test
    void t7(){
        System.out.println("一共有"+mapper.count()+"位员工");
    }
}
