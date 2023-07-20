package com.menghuan;


import com.menghuan.utils.MyAutoGeneratorPlusSuper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GeneratorApplication {

    public static void main(String[] args) {

        SpringApplication.run(GeneratorApplication.class, args);

        MyAutoGeneratorPlusSuper myAutoGeneratorPlusSuper = new MyAutoGeneratorPlusSuper();
        myAutoGeneratorPlusSuper.mainRun();
    }

}
