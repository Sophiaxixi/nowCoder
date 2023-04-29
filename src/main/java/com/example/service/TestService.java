package com.example.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @Author: shlin
 * @Date: 2023/4/26 - 04 - 26 - 23:07
 * @Description: com.example.service
 * @Version: 1.0
 */
@Service
@Scope("prototype")
public class TestService {

    public TestService() {
        System.out.println("实例化了");
    }

    @PostConstruct
    public void init(){
        System.out.println("初始化了");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("销毁了");
    }
}
