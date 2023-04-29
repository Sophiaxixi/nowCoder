package com.example;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

/**
 * @Author: shlin
 * @Date: 2023/4/28 - 04 - 28 - 21:46
 * @Description: com.example
 * @Version: 1.0
 */
@SpringBootTest
@ContextConfiguration(classes = NowCoderApplication.class) //就使用了和主类一样的配置类
public class LoggerTests {

    private static final Logger logger = LoggerFactory.getLogger(LoggerTests.class);//不同的工作用不同的logger

    @Test
    public void testLogger(){
        System.out.println(logger.getName());

        logger.debug("debug log");
        logger.info("info");
        logger.warn("warn");//比较少用
        logger.error("error");
    }
}
