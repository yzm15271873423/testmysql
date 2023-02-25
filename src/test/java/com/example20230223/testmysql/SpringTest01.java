package com.example20230223.testmysql;

import com.example20230223.testmysql.com.yzm.mapper.UserMapper;
import com.example20230223.testmysql.com.yzm.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.internal.Classes;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sound.midi.Soundbank;
import java.util.List;

/**
 * @Auther: yzm
 * @Date: 2023/2/24 - 02 - 24 - 22:48
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SpringTest01 {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void test01() {
        List<User> users = userMapper.selectAll();
        users.forEach((user) -> {
            System.out.println("username: " + user.getName() + "  age: " + user.getAge());
        });
        System.out.println("开始test");
        log.info("test日志记录！！！");
    }
}
