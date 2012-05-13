package info.yalamanchili.office.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingInterceptor {
	@Before("execution(* info.yalamanchili.office..*.*(..))")
	public void logBefore(JoinPoint joinPoint) {
		// TODO add logging/trace related stuff here
		// System.out.println("****Invoking method : " +
		// joinPoint.getSignature().getName());
	}
}
