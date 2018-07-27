package com.rabbit.validationsample.validation.constraints;

import com.rabbit.validationsample.validation.validators.FieldsValueMatchValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * This annotation will have two parameters field and fieldMatch that represent the names of the fields to compare.
 * <p>
 * This also contains a List sub-interface for defining multiple FieldsValueMatch annotations on a class.
 */
@Documented
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = FieldsValueMatchValidator.class)
public @interface FieldsValueMatch {

	String message() default "Fields values don't match!";

	String field();

	String fieldMatch();

	@Target({ElementType.TYPE})
	@Retention(RetentionPolicy.RUNTIME)
	@interface List {

		FieldsValueMatch[] value();
	}

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
