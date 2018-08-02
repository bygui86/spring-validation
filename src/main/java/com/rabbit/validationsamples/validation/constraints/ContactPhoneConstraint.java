package com.rabbit.validationsamples.validation.constraints;

import com.rabbit.validationsamples.validation.validators.ContactPhoneValidator;

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
// With the @Constraint annotation, we defined the class that is going to validate our field
@Constraint(validatedBy = ContactPhoneValidator.class)
public @interface ContactPhoneConstraint {

	/*
		These three properties are mandatory for constraint annotations:
			. message – returns the default key for creating error messages, this enables the usage of message interpolation
			. groups – allows to specify validation groups for constraints
			. payload – can be used by clients of the Bean Validation API to assign custom payload objects to a constraint
	*/

	String message() default "Invalid phone number";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
