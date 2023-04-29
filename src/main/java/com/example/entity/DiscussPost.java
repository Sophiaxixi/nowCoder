package com.example.entity;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * @Author: shlin
 * @Date: 2023/4/28 - 04 - 28 - 14:15
 * @Description: com.example.entity
 * @Version: 1.0
 */
@Data
@ToString
public class DiscussPost {
    private int id;
    private int userId;
    private String title;
    private String content;
    private int type;
    private int status;
    private Date createTime;
    private int commentCount;
    private int score;


}
