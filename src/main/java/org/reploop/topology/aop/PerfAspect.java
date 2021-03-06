package org.reploop.topology.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Component
@Aspect
@Slf4j
public class PerfAspect {
    @Around(argNames = "jp", value = "execution(public * org.reploop.topology.parser.LsofDriver..*(..))")
    public Object perf(ProceedingJoinPoint jp) throws Throwable {
        StopWatch watch = new StopWatch(getClass().getSimpleName());
        try {
            watch.start(jp.getSignature().getName());
            return jp.proceed();
        } finally {
            watch.stop();
            log.info("{}", watch.prettyPrint());
        }
    }
}
