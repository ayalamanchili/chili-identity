package info.yalamanchili.office.logging;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingInterceptor {
	private static final Log log = LogFactory.getLog(LoggingInterceptor.class);

	@Before("execution(* info.yalamanchili.office..*.*(..))")
	public void logBefore(JoinPoint joinPoint) {
		if (log.isInfoEnabled()) {
			log.info("--- invoking ---:" + joinPoint.getSignature());
		}
	}

	@AfterReturning(pointcut = "execution(* info.yalamanchili.office..*.*(..))", returning = "result")
	public void logAfterReturning(JoinPoint joinPoint, Object result) {
		if (log.isInfoEnabled()) {
			log.info("--- returning ---:" + result);
		}
	}
}
