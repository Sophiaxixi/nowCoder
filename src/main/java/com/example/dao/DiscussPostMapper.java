package com.example.dao;

import com.example.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author: shlin
 * @Date: 2023/4/28 - 04 - 28 - 14:19
 * @Description: com.example.dao
 * @Version: 1.0
 */
@Mapper
public interface DiscussPostMapper {

    @Select("select * from discuss_post where( case when #{userId}!=0 then user_id = #{userId} else 1 = 1 end)" +
            "and status!=2 order by type desc, create_time desc limit #{offset}, #{limit}")
    List<DiscussPost> selectDiscussPosts(int userId, int offset, int limit);//分页展示帖子 如果userId=0说明要展示所有

    // @Param用于给参数取别名
    // 如果只有一个参数 并且在<if>里使用 则必须取别名
    @Select("select count(id) from discuss_post where( case when #{userId}!=0 then user_id = #{userId} else 1 = 1 end)" +
            "and status!=2")
    int selectDiscussPostRows(@Param("userId") int userId);

}
