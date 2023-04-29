package com.example.dao;

import com.example.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

/**
 * @Author: shlin
 * @Date: 2023/4/27 - 04 - 27 - 21:45
 * @Description: com.example.dao
 * @Version: 1.0
 */

@Mapper //用@Repository也是可以的
public interface UserMapper {
//    @Results({
//            @Result(column = "id", property = "id"),
//            @Result(column = "username", property = "username"),
//            @Result(column = "password", property = "password"),
//            @Result(column = "salt", property = "salt"),
//            @Result(column = "email", property = "email"),
//            @Result(column = "type", property = "type"),
//            @Result(column = "status", property = "status"),
//            @Result(column = "activate_code", property = "activateCode"),
//            @Result(column = "head_url", property = "headUrl"),
//            @Result(column = "create_time", property = "createTime"),
//
//    })
    @Select("select * from user where id = #{id}")
    User selectById(int id);

    @Select("select * from user where username = #{username}")
    User selectByName(String username);

    @Select("select * from user where email = #{email}")
    User selectByEmail(String email);

    @Insert("insert into user" +
            "(username,password,salt,email,type,status,activation_code,header_url,create_time" +
            ") values" + "(#{username},#{password},#{salt},#{email}," +
            "#{type},#{status},#{activationCode},#{headerUrl},#{createTime}) ")//id自增，插不插入id都可以 这里不能用#{user.username}
    int insertUser(User user);

    @Update("update user set status = #{status} where id = #{id}")
    int updateStatus(int id, int status);

    @Update("update user set header_url = #{headerUrl} where id = #{id}") //记得查询语句内是数据库字段，#{}内是类属性
    int updateHeader(int id, String headerUrl);

    @Update("update user set password = #{password} where id = #{id}")
    int updatePassword(int id, String password);
}
