package lab.seq.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class LabAspect {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Before("execution(* lab.seq.service.*.*(..))")
    public void before(JoinPoint joinPoint){
        logger.info("Before");
    }

    @Around("execution(* lab.seq.service.*.*(..))")
    public void around(ProceedingJoinPoint proceedingJoinPoint){

        long startTime = System.currentTimeMillis();

        try {
            proceedingJoinPoint.proceed();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
        long endTime = System.currentTimeMillis();

        logger.info("Take {} " , endTime - startTime);
    }

    @Pointcut("lab.seq.aop.CommonAspect")
    public void pointCut(ProceedingJoinPoint proceedingJoinPoint){

        long startTime = System.currentTimeMillis();

        try {
            proceedingJoinPoint.proceed();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
        long endTime = System.currentTimeMillis();

        logger.info("Take {} milliseconds " , endTime - startTime);
    }

    @AfterReturning(value = "execution(* lab.seq.service.*.*(..))", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result){

    }


}
