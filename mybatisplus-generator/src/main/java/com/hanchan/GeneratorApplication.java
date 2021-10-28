package com.hanchan;


import com.hanchan.utils.MyAutoGeneratorPlusSuper;
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
