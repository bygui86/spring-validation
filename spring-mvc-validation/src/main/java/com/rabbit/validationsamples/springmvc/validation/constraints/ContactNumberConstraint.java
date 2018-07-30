package com.rabbit.validationsamples.springmvc.validation.constraints;

import com.rabbit.validationsamples.springmvc.validation.validators.ContactNumberValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * Let’s create our custom validator – which checks phone numbers. The phone number must be a number with more than 8 digits but no more that 14 digits.
 */
@Documented
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
// With the @Constraint annotation, we defined the class that is going to validate our field, ..
@Constraint(validatedBy = ContactNumberValidator.class)
public @interface ContactNumberConstraint {

	// .. the message() is the error message that is showed in the user interface ..
	String message() default "Invalid phone number";

	// .. and the additional code is most boilerplate code to conforms to the Spring standards
	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
