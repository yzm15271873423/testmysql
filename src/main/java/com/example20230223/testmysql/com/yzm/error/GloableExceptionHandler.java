package com.example20230223.testmysql.com.yzm.error;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Auther: yzm
 * @Date: 2023/2/24 - 02 - 24 - 18:50
 */
@RestControllerAdvice
public class GloableExceptionHandler {

    private final Logger log = LoggerFactory.getLogger(GloableExceptionHandler.class);

    @ExceptionHandler(value = {Exception.class})
    public String handleException() {
        log.error("发生了异常！");
        return "发生异常！";
    }
}
