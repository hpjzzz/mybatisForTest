package com.example.mongoandmybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.mongoandmybatis.mapper")
public class MongoandmybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(MongoandmybatisApplication.class, args);
    }

}
