package cn.tedu.boot08;

import cn.tedu.boot08.entity.MyProduct;
import cn.tedu.boot08.entity.Product;
import cn.tedu.boot08.mapper.MyProductMapper;
import cn.tedu.boot08.mapper.ProductMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest
class Boot08ApplicationTests {
    //告诉编译器这个mapper不重要,以防IDEA因装配不成功而提示错误
    @Autowired(required = false)
    ProductMapper mapper;

    //测试插入
    @Test
    void contextLoads() {
        Product p = new Product();
        p.setTitle("xml标题");
        p.setPrice(111.0);
        p.setNum(333);
        mapper.insert(p);//将添加完信息的对象传入执行插入到SQL
    }

    //测试删除
    @Test
    void t1(){
        mapper.deleteById(42);
    }

    //测试修改
    @Test
    void t2(){
        Product p = new Product();
        p.setId(41);
        p.setTitle("笔记本");
        p.setPrice(7.0);
        p.setNum(9999);
        mapper.update(p);
    }

    //测试查询
    @Test
    void t3(){
        //单个商品对象信息
        System.out.println(mapper.selectById(18));
        //所有商品对象信息集合
        System.out.println(mapper.select());
    }

    //测试查询数量
    @Test
    void t4(){
        System.out.println(mapper.count()+"件商品");
    }

    //测试批量删除
    @Test
    void t5(){
        //1.测试以List集合的方式添加商品id,批量删除
        ArrayList<Integer> list = new ArrayList<>();
        //添加集合中要删除的商品id
        list.add(44);
        list.add(45);
        //调用deleteByIds1(List<Integer> list)方法,传入集合list,执行批量删除
        System.out.println(mapper.deleteByIds1(list));//输出返回的删除记录数量
        //2.测试以数组的方式添加商品id,批量删除
        Integer[] ids = {46,47};
        System.out.println(mapper.deleteByIds2(ids));
        //3.测试传入任意数量的id来批量删除商品
        System.out.println(mapper.deleteByIds3(48,49));
    }

    //测试批量插入
    @Test
    void t6(){
        //创建对象,设置属性
        Product p1 = new Product(null,"a",1.0,1);
        Product p2 = new Product(null,"b",2.0,2);
        Product p3 = new Product(null,"c",3.0,3);
        //创建集合,将对象添加进去
        ArrayList<Product> list = new ArrayList<>();
        list.add(p1);
        list.add(p2);
        list.add(p3);
        //调用insertProducts(List<Product> list),传入对象集合list,执行批量插入
        System.out.println("插入了"+mapper.insertProducts(list)+"件商品数量");//输出返回插入的商品数量
    }

    //测试动态选择性插入
    @Test
    void t7(){
        Product p = new Product();
        p.setTitle("手机");//设置对象的title属性
        int num = mapper.dynamicInsert(p);//调用dynamicInsert()方法,传入对象,返回插入的数量
        System.out.println("插入了"+num+"件商品数量");
    }

    //测试动态选择性修改
    @Test
    void t8(){
        Product p =new Product();
        p.setId(52);
        p.setPrice(200.0);
        mapper.dynamicUpdate(p);
    }

    //告诉编译器这个mapper不重要,以防IDEA因装配不成功而提示错误
    @Autowired(required = false)
    MyProductMapper myMapper;

    //测试插入
    @Test
    void t9(){
        MyProduct mp = new MyProduct();
        mp.setTitle("美式咖啡5");
        mp.setSaleCount(500);
        mp.setViewCount(50);
        myMapper.insert(mp);
    }

    //测试查询一条商品
    @Test
    void t10(){
        MyProduct mp = myMapper.selectById(1);
        System.out.println(mp);//重写了toString()方法
    }

    //测试查询所有商品
    @Test
    void t11(){
        System.out.println(myMapper.select());//集合重写了toString()方法
    }
}
