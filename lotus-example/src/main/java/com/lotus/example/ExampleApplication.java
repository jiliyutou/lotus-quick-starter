package com.lotus.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/***
 * 程序启动入口
 *
 * @author haikuo.zhk
 */
@SpringBootApplication
public class ExampleApplication {

    private final static Logger LOG = LoggerFactory.getLogger(ExampleApplication.class);

    public static void main(String args[]) {
        LOG.info("Start [{}] Application", ExampleApplication.class.toString());
        SpringApplication.run(ExampleApplication.class, args);
    }
}