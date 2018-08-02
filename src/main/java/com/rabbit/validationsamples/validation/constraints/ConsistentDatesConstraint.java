package com.rabbit.validationsamples.validation.constraints;

import com.rabbit.validationsamples.validation.validators.ConsistentDatesValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Documented
@Target({ElementType.METHOD, ElementType.CONSTRUCTOR})
@Retention(RetentionPolicy.RUNTIME)
// With the @Constraint annotation, we defined the class that is going to validate our field
@Constraint(validatedBy = ConsistentDatesValidator.class)
public @interface ConsistentDatesConstraint {

	/*
		These three properties are mandatory for constraint annotations:
			. message – returns the default key for creating error messages, this enables the usage of message interpolation
			. groups – allows to specify validation groups for constraints
			. payload – can be used by clients of the Bean Validation API to assign custom payload objects to a constraint
	*/

	String message() default "End date must be after begin date and both must be in the future";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
