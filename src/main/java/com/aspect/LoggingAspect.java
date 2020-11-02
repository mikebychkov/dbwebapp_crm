package com.aspect;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger logger = LogManager.getLogger(LoggingAspect.class);

    @Pointcut("execution(* com.control.*.*(..))")
    private void controlMethods() {
    }

    @Pointcut("execution(* com.service.*.*(..))")
    private void serviceMethods() {
    }

    @Pointcut("execution(* com.store.*.*(..))")
    private void storeMethods() {
    }

    @Before(value = "controlMethods() || serviceMethods() || storeMethods()")
    public void beforeMethod(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        logger.info("=== METHOD SIGNATURE: " + signature);
        Object[] args = joinPoint.getArgs();
        for(int i = 0; i < args.length; i++) {
            logger.info("=== METHOD ARGUMENT #" + i + " = " + args[i]);
        }
    }

    @AfterReturning(value = "controlMethods() || serviceMethods() || storeMethods()", returning = "result")
    public void afterMethodSucceed(JoinPoint joinPoint, Object result) {
        logger.info("=== METHOD SIGNATURE: " + joinPoint.getSignature());
        logger.info("=== METHOD RESULT: " + result);
    }
}
