package cn.tedu.boot08.mapper;

import cn.tedu.boot08.entity.Product;

//此时使用了MapperScan注解并传入了mapper包路径 则不需要再写@Mapper注解
//已经默认此项目所有mapper接口都在这个包路径里
public interface ProductMapper {
    //此处不再写@Insert等注解,SQL语句写在XML配置文件中
    void insert(Product product);
}
