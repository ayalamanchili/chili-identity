package info.yalamanchili.office.service;

import info.chili.service.jrs.ServiceMessages;
import info.chili.service.jrs.exception.ServiceException;
import info.chili.service.jrs.exception.ServiceException.ReasonCode;
import info.chili.service.jrs.exception.ServiceException.StatusCode;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.core.annotation.Order;
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
//have to specify the order so that this is run before the transaction advice runs to handle all possible exceptions
@Order(100)
public class ServiceInterceptor {

    @Autowired
    protected ServiceMessages serviceMessages;

    @Around("execution(* info.yalamanchili.office.jrs..*.*(..)) || execution(* info.yalamanchili.office.dao..*.*(..))")
    public Object aroundInvoke(ProceedingJoinPoint joinPoint) throws Throwable {
        Object result = null;
        //TODO make the excluded methods configurable
        /* skip validation for search and login methods */
        if (!joinPoint.getSignature().toShortString().contains("search") && !joinPoint.getSignature().toShortString().contains("login")) {
            for (Object arg : joinPoint.getArgs()) {
                if (arg != null && arg instanceof java.io.Serializable) {
                    validate(arg);
                }
            }
            checkForErrors();
        }
        try {
            result = joinPoint.proceed();
        } catch (ServiceException se) {
            throw new ServiceException(StatusCode.INVALID_REQUEST, se.getErrors());
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServiceException(StatusCode.INTERNAL_SYSTEM_ERROR, "SYSTEM", "INTERNAL_ERROR", e.getMessage());
        }
        checkForErrors();
        return result;
    }

//    @AfterThrowing(pointcut = "execution(* info.yalamanchili.office.jrs..*.*(..))", throwing = "exception")
//    public void catchException(JoinPoint joinPoint, Throwable exception) {
//        System.out.print("ddddddd");
//    }
    protected void validate(Object entity) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        for (ConstraintViolation<Object> violation : validator.validate(entity)) {
            serviceMessages.addError(new info.chili.service.jrs.types.Error(violation.getPropertyPath()
                    .toString(), "INVALID_INPUT", violation.getMessage()));
        }
    }

    protected void checkForErrors() {
        if (serviceMessages.isNotEmpty()) {
            throw new ServiceException(StatusCode.INVALID_REQUEST, serviceMessages.getErrors());
        }
    }
}
