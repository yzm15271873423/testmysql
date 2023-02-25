package com.example20230223.testmysql.com.yzm.mapper;

import com.example20230223.testmysql.com.yzm.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Auther: yzm
 * @Date: 2023/2/23 - 02 - 23 - 17:07
 */
@Mapper
public interface UserMapper {
    List<User> selectAll();
}
