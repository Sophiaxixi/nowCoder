package com.example.entity;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * @Author: shlin
 * @Date: 2023/4/27 - 04 - 27 - 21:41
 * @Description: com.example.entity
 * @Version: 1.0
 */
@Data
@ToString //为了打印数据的时候方便
public class User {
    private int id;
    private String username;
    private String password;
    private String salt; //在密码之后拼的一个随机字符串 拼在密码之后再加密更安全
    private String email;
    private int type; //0 普通用户 1 管理员 2 房主
    private int status; //0 表示没激活 1 表示激活
    private String activationCode;
    private String headerUrl; //头像的访问路径
    private Date createTime;
}
