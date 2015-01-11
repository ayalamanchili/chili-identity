/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
package info.yalamanchili.office.service;

import info.chili.jpa.validation.Validate;
import info.chili.service.jrs.ServiceMessages;
import info.chili.service.jrs.exception.ServiceException;
import info.chili.service.jrs.exception.ServiceException.StatusCode;
import info.yalamanchili.office.dao.security.LoginSuccessListener;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.email.MailUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.activiti.engine.ActivitiException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * this interceptor will handle invocation validates the input params to process
 * the valdiation errors to aggregate them(ServiceMessages), also handle other
 * errors during invocation and captures them and delegates them to
 * corresponding exception mapper (ServiceExceptionMapper)
 *
 */
@Aspect
@Component
@Scope("prototype")
//have to specify the order so that this is run before the transaction advice runs to handle all possible exceptions
@Order(100)
public class ServiceInterceptor {

    private static final Log log = LogFactory.getLog(ServiceInterceptor.class);
    @Autowired
    protected ServiceMessages serviceMessages;

    @Pointcut(value = "execution(* info.yalamanchili.office.jrs..*.*(..)) || execution(* info.chili.service..*.*(..))")
    public void anyPublicMethod() {
    }

    @Around("anyPublicMethod() && @annotation(validate)")
    @Transactional(readOnly = true)
    public Object process(ProceedingJoinPoint joinPoint, Validate validate) throws Throwable {
        Object result = null;
        validate(joinPoint);
        try {
            result = joinPoint.proceed();
        } catch (ServiceException se) {
            throw new ServiceException(StatusCode.INVALID_REQUEST, se.getErrors());
        } catch (Exception e) {
            MailUtils.logExceptionDetials(e);
            throw new ServiceException(StatusCode.INTERNAL_SYSTEM_ERROR, "SYSTEM", "INTERNAL_ERROR", e.getMessage());
        }
        checkForErrors();
        return result;
    }

    protected void validate(ProceedingJoinPoint joinPoint) {
        for (Object arg : joinPoint.getArgs()) {
            if (arg != null && arg instanceof java.io.Serializable) {
                validate(arg);
            }
        }
        checkForErrors();
    }

    /* 
     * This is for handling exception from non jrs methods like bpm, notification and scheduleing    */
    @AfterThrowing(pointcut = "execution(* info.yalamanchili.office..*.*(..))", throwing = "exception")
    public void catchException(JoinPoint joinPoint, Throwable exception) {
        if (exception instanceof ServiceException) {
            ServiceException se = (ServiceException) exception;
            throw new ServiceException(StatusCode.INVALID_REQUEST, se.getErrors());
        } else if (exception instanceof ActivitiException && exception.getCause() != null && exception.getCause().getCause() instanceof ServiceException) {
            ServiceException se = (ServiceException) exception.getCause().getCause();
            throw new ServiceException(StatusCode.INVALID_REQUEST, se.getErrors());

        } else {
            MailUtils.logExceptionDetials(exception);
            //TODO this is again intercepted by this same service interceptor to convert into 400 error
            throw new ServiceException(StatusCode.INTERNAL_SYSTEM_ERROR, "SYSTEM", "INTERNAL_ERROR", exception.getMessage());
        }
    }

    //TODO should have a catch all exception here?
    protected void validate(Object entity) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        for (ConstraintViolation<Object> violation : validator.validate(entity)) {
            log.error("validation error:" + violation.getPropertyPath() + ":" + violation.getMessage());
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
