package com.example.service;

import com.example.dao.UserMapper;
import com.example.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: shlin
 * @Date: 2023/4/28 - 04 - 28 - 14:57
 * @Description: com.example.service
 * @Version: 1.0
 */
@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    public User findUserById(int id){
        return userMapper.selectById(id);
    }
}
