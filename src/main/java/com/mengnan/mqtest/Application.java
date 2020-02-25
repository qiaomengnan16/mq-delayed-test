package com.mengnan.mqtest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author qiaomengnan
 * @ClassName: Application
 * @Description:
 * @date 2020-02-25
 */
@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private DelayProducer delayProducer;

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);

    }

    @Override
    public void run(String... strings) throws Exception {
        delayProducer.sendMsg();
    }
}
