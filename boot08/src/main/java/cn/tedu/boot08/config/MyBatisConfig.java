package cn.tedu.boot08.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

//告诉编译器此工程的所有Mapper接口都在这个包路径里面
@Configuration
@MapperScan("cn.tedu.boot08.mapper")
public class MyBatisConfig {
}
