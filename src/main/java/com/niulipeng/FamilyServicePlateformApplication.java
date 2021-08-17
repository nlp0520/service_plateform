package com.niulipeng;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan//启动报错，在当前启动类上加mapperScan或者在每个类上加mapper注解
public class FamilyServicePlateformApplication {

    public static void main(String[] args) {
        SpringApplication.run(FamilyServicePlateformApplication.class, args);
    }

}
