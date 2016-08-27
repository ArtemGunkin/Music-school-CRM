package ru.kpfu.itis.gunkin.aspects;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggingAspect {
    private final static Logger logger = Logger.getLogger(LoggingAspect.class);

    @Before("execution(* ru.kpfu.itis.gunkin.controllers.*.*(..))")
    public void logControllers(JoinPoint joinPoint) {
        logger.info(joinPoint.getThis().getClass().getName() + ": " + joinPoint.getSignature().getName() + "called.");
    }
}
