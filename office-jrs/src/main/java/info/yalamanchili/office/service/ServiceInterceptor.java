package info.yalamanchili.office.service;

import info.yalamanchili.jpa.AbstractEntity;
import info.yalamanchili.office.entity.security.CUser;
import info.yalamanchili.office.service.exception.ServiceException;
import info.yalamanchili.office.service.exception.ServiceException.StatusCode;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * this interceptor will handle invocation validates the input params to process
 * the valdiation errors to aggregate them(ServiceMessages), also handle other
 * errors during invocation and captures them and delegates them to
 * corresponding exception mapper (ServiceExceptionMapper)
 * 
 */
@Aspect
@Component
@Scope("request")
public class ServiceInterceptor {

	@Autowired
	protected ServiceMessages serviceMessages;

	@Around("execution(* info.yalamanchili.office.jrs..*.*(..))")
	public Object aroundInvoke(ProceedingJoinPoint joinPoint) throws Throwable {
		Object result = null;
		/* skip validation for search methods */
		if (!joinPoint.getSignature().toShortString().contains("search")) {
			for (Object arg : joinPoint.getArgs()) {
				if (arg instanceof AbstractEntity || arg instanceof CUser) {
					validate(arg);
				}
			}
			checkForErrors();
		}
		try {
			result = joinPoint.proceed();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException(StatusCode.INTERNAL_SYSTEM_ERROR, e.getLocalizedMessage(), e.getMessage());
		}
		checkForErrors();
		return result;
	}

	protected void validate(Object entity) {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		for (ConstraintViolation<Object> violation : validator.validate(entity)) {
			serviceMessages.addError(new info.yalamanchili.office.service.types.Error(violation.getPropertyPath()
					.toString(), "INVALID_INPUT", violation.getMessage()));
		}
	}

	protected void checkForErrors() {
		if (serviceMessages.isNotEmpty()) {
			throw new ServiceException(StatusCode.INVALID_REQUEST, serviceMessages.getErrors());
		}
	}
}
