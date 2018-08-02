package com.rabbit.validationsamples.validation.validators;

import com.rabbit.validationsamples.validation.constraints.ConsistentDatesConstraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.constraintvalidation.SupportedValidationTarget;
import javax.validation.constraintvalidation.ValidationTarget;
import java.time.LocalDate;


/**
 * It’s important to notice that the @SupportedValidationTarget(ValidationTarget.PARAMETERS) annotation on the ConsistentDateParameterValidator class is
 * REQUIRED. The reason for this is because @ConsistentDateParameter is set on method-level, but the constraints shall be applied to the method parameters
 * (and not to the return value of the method).
 * <p>
 * PLEASE NOTE:
 * Here we are not using LocalDate as ConstraintValidator type, because the annotation @ConsistentDatesConstraint is used on multiple methods with different
 * type of parameters
 */
@SupportedValidationTarget(ValidationTarget.PARAMETERS)
public class ConsistentDatesValidator implements ConstraintValidator<ConsistentDatesConstraint, Object[]> {

	@Override
	public void initialize(final ConsistentDatesConstraint constraintAnnotation) {

		// no-op
	}

	/**
	 * This method contains the actual validation logic.
	 *
	 * @param values
	 * @param context
	 */
	@Override
	public boolean isValid(final Object[] values, final ConstraintValidatorContext context) {

		if (values[0] == null || values[1] == null) {
			return true;
		}

		if (!(values[0] instanceof LocalDate)
				|| !(values[1] instanceof LocalDate)) {
			throw new IllegalArgumentException("Illegal method signature, expected two parameters of type LocalDate.");
		}

		return ((LocalDate) values[0]).isAfter(LocalDate.now())
				&& ((LocalDate) values[0]).isBefore((LocalDate) values[1]);
	}

}