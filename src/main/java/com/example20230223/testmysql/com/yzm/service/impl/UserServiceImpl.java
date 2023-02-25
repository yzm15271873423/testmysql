package com.example20230223.testmysql.com.yzm.service.impl;

import com.example20230223.testmysql.com.yzm.mapper.UserMapper;
import com.example20230223.testmysql.com.yzm.pojo.User;
import com.example20230223.testmysql.com.yzm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: yzm
 * @Date: 2023/2/25 - 02 - 25 - 10:39
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findAll() {
        return userMapper.selectAll();
    }
}
