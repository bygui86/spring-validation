package com.rabbit.validationsamples.validation.constraints;

import com.rabbit.validationsamples.validation.validators.ValidReservationValidator;

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
@Constraint(validatedBy = ValidReservationValidator.class)
public @interface ValidReservationConstraint {

	String message() default "End date must be after begin date and both must be in the future, room number must be bigger than 0";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
