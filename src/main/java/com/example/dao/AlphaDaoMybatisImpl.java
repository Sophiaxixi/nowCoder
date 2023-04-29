package com.example.dao;

import org.springframework.stereotype.Repository;

/**
 * @Author: shlin
 * @Date: 2023/4/26 - 04 - 26 - 22:48
 * @Description: com.example.dao
 * @Version: 1.0
 */
@Repository("alphaMybatis")
public class AlphaDaoMybatisImpl implements AlphaDao{
    @Override
    public String select() {
        return "mybatis";
    }
}
