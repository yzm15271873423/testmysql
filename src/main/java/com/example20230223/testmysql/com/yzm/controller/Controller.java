package com.example20230223.testmysql.com.yzm.controller;

import com.example20230223.testmysql.com.yzm.log.WebLog;
import com.example20230223.testmysql.com.yzm.mapper.UserMapper;
import com.example20230223.testmysql.com.yzm.pojo.User;
import com.example20230223.testmysql.com.yzm.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Auther: yzm
 * @Date: 2023/2/23 - 02 - 23 - 16:38
 */
@org.springframework.stereotype.Controller
public class Controller {
    private final Logger logger =  LoggerFactory.getLogger(Controller.class);

    @Autowired
    private UserService userService;

    @RequestMapping("/test")
    @ResponseBody
    @WebLog(desc = "这是请求了controller的 /test 接口")
    public List<User> test(@RequestParam("id") int id) {
        int sum = 3 / id;
        System.out.println("sum: " + sum);
        logger.debug("这是logger日志，dug级别的日志================");

        List<User> users = userService.findAll();
        users.stream().map(user -> user.getName()).forEach(name -> {
            System.out.println(name);
        });

        return users;
    }
}
