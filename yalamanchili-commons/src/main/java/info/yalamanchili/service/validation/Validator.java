package info.yalamanchili.service.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author ayalamanchili 
 * Annotated the getter method any service bean property
 * to perform any validations implemented by the GenericValdiator
 */
//TODO can we use custom hibernate validator.?
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Validator {
	Class<?> value();
}
