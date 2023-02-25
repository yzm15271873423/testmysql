package com.example20230223.testmysql.com.yzm.log;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @Auther: yzm
 * @Date: 2023/2/25 - 02 - 25 - 10:06
 */
@Component
@Aspect
@Slf4j
public class LogAspect {

    @Pointcut("@annotation(com.example20230223.testmysql.com.yzm.log.WebLog)")
    public void webLog() {};

    @Around("webLog()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();

        log.info("进入Around方法，执行handle方法前执行！");
        Object proceed = proceedingJoinPoint.proceed();
        // 打印出参
        log.info("响应返回数据  : {}", JSON.toJSONString(proceed));

        log.info("打印日志描述信息： {}", getAspectLogDescription(proceedingJoinPoint));

        // 执行耗时
        log.info("处理器方法执行耗时 : {} ms", System.currentTimeMillis() - startTime);
        return proceed;
    }

    /**
     * 获取切面注解的描述
     *
     * @param joinPoint 切点
     * @return 描述信息
     * @throws Exception
     */
    public String getAspectLogDescription(JoinPoint joinPoint)
            throws Exception {
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        StringBuilder description = new StringBuilder("");
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                Class[] clazzs = method.getParameterTypes();
                if (clazzs.length == arguments.length) {
                    description.append(method.getAnnotation(WebLog.class).desc());
                    break;
                }
            }
        }
        return description.toString();
    }
}
