package demo.aop.test02.demoaoptest02.annotation;

import demo.aop.test02.demoaoptest02.monitor.MonitorSession;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MonitorAdvice {

    @Pointcut("execution (* demo.aop.test02.demoaoptest02.service.Speakable.*(..))")
    public void pointcut() {
    }

    @Around("pointcut()")
    public void around(ProceedingJoinPoint pjp) throws Throwable {
        MonitorSession.begin(pjp.getSignature().getName());
        pjp.proceed();
        MonitorSession.end();
    }

}
