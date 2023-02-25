package com.example20230223.testmysql.com.yzm.service;

import com.example20230223.testmysql.com.yzm.pojo.User;

import java.util.List;

/**
 * @Auther: yzm
 * @Date: 2023/2/25 - 02 - 25 - 10:38
 */
public interface UserService {
    List<User> findAll();
}
