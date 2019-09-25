package aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(MyAspect.class);

    @Around("execution(* service.ProuductService.*(..))")
    public void Log(ProceedingJoinPoint joinPoint){
        LOGGER.info("Called before" + joinPoint.getSignature().getName() + "method");
        try {
            joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        LOGGER.info("Called after" + joinPoint.getSignature().getName() + "method");

    }
}
