package com.example.controller;

import com.example.dao.DiscussPostMapper;
import com.example.dao.UserMapper;
import com.example.entity.DiscussPost;
import com.example.entity.Page;
import com.example.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.jws.WebParam;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: shlin
 * @Date: 2023/4/28 - 04 - 28 - 15:07
 * @Description: com.example.controller
 * @Version: 1.0
 */
@Controller
public class HomeController {

    @Autowired
    private DiscussPostMapper discussPostMapper;
    @Autowired
    private UserMapper userMapper;

    @RequestMapping(path="/index",method = RequestMethod.GET)
    public String getIndexPage(Model model, Page page){
        //调用方法前，springMVC会自动实例化Model和page,并将page注入model
        //所以在thymeleaf中可以直接访问page对象中的数据
        page.setRows(discussPostMapper.selectDiscussPostRows(0));
        page.setPath("index");
        List<DiscussPost> list = discussPostMapper.selectDiscussPosts(0,page.getOffset(),page.getLimit());

        List<Map<String,Object>> discussPosts = new ArrayList<>();
        if(list!=null){
            for(DiscussPost post:list){
                Map<String,Object> map = new HashMap<>();
                map.put("post",post);
                User user = userMapper.selectById(post.getUserId());
                map.put("user",user);
                discussPosts.add(map);
            }
        }

        model.addAttribute("discussPosts",discussPosts);
        return "index";//在templates文件夹下 //不要再加/
    }
}
