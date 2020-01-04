package com.example.mongoandmybatis.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class AspectTest {

    @Pointcut("execution(public * com.example.mongoandmybatis.controller.PersonController.findOne(Integer))")
    public void verify() {
    }

    @Before("verify()")
    public void doVerify(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        Signature signature = (MethodSignature)joinPoint.getSignature();
        RequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = ((ServletRequestAttributes) attributes).getRequest();
        System.out.println(request.getMethod());


        for (Object arg : args) {
            System.out.println(arg);
        }
        System.out.println("ddddddddddddddddddddddddd");
    }

    @AfterReturning(value = "verify()", returning = "keys")
    public void returnVerify(JoinPoint joinPoint, Object keys) {
        RequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = ((ServletRequestAttributes) attributes).getRequest();
        System.out.println(request.getMethod());
        System.out.println("这是后置通知");
        System.out.println(keys);
    }
}
