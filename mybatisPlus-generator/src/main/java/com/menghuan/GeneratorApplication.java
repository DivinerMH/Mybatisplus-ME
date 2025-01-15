package com.menghuan;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.menghuan.utils.MyAutoGeneratorPlusSuper;

@SpringBootApplication
public class GeneratorApplication {

    public static void main(String[] args) {

        SpringApplication.run(GeneratorApplication.class, args);

        MyAutoGeneratorPlusSuper myAutoGeneratorPlusSuper = new MyAutoGeneratorPlusSuper();
        myAutoGeneratorPlusSuper.mainRun();
    }

}
