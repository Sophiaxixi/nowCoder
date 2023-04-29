package com.example;

import com.example.dao.DiscussPostMapper;
import com.example.dao.UserMapper;
import com.example.entity.DiscussPost;
import com.example.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.Date;
import java.util.List;

/**
 * @Author: shlin
 * @Date: 2023/4/28 - 04 - 28 - 11:06
 * @Description: com.example
 * @Version: 1.0
 */
@SpringBootTest
@ContextConfiguration(classes = NowCoderApplication.class) //就使用了和主类一样的配置类
public class MapperTest {

    @Autowired
    UserMapper userMapper;
    @Autowired
    DiscussPostMapper discussPostMapper;

    @Test
    public void testSelectUser(){
        User user = userMapper.selectById(101);
        System.out.println(user);

        User user2 = userMapper.selectByEmail("nowcoder101@sina.com");
        System.out.println(user2);

        User user3 = userMapper.selectByName("liubei");
        System.out.println(user3);

    }

    @Test
    public void testInsertUser(){
        User user = new User();
        user.setUsername("test2");
        user.setEmail("test.qq.com");
        user.setPassword("123456");
        user.setSalt("abc");
        user.setType(0);
        user.setStatus(1);
        user.setActivationCode("sdfwer");
        user.setCreateTime(new Date());
        user.setHeaderUrl("http://images.nowcoder.com/head/100t.png");

        int rows = userMapper.insertUser(user);
        System.out.println(rows);
        //System.out.println(userMapper.selectByName(user.getUsername()).getId());//这样可以获得自增的id
        System.out.println(user.getId());//这样输出一直是0

    }

    @Test
    public void updateUser(){
        int rows = userMapper.updateStatus(150,0);
        System.out.println(rows);

        rows = userMapper.updateHeader(150,"http://images.nowcoder.com/head/102.png");
        System.out.println(rows);

        rows = userMapper.updatePassword(150,"654321");
        System.out.println(rows);
    }

    @Test
    public void testSelectPost(){
        List<DiscussPost> list = discussPostMapper.selectDiscussPosts(0,0,10);
        for(DiscussPost post:list){
            System.out.println(post);
        }

        int rows = discussPostMapper.selectDiscussPostRows(0);
        System.out.println(rows);
    }

}
