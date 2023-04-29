package com.example.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

/**
 * @Author: shlin
 * @Date: 2023/4/26 - 04 - 26 - 22:47
 * @Description: com.example.dao
 * @Version: 1.0
 */
@Repository
@Primary
public class AlphaDaoHibernateImpl implements AlphaDao{
    @Override
    public String select() {
        return "Hibernate";
    }
}
