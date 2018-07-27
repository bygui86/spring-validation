package com.rabbit.validationsample.validation.validators;

import com.rabbit.validationsample.validation.constraints.ContactNumberConstraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


/**
 * Let’s create our custom validator – which checks phone numbers. The phone number must be a number with more than 8 digits but no more that 14 digits.
 * <p>
 * The validation class implements the ConstraintValidator interface and must implement the isValid method; it’s in this method that we defined our validation rules.
 * <p>
 * Naturally, we’re going with a simple validation rule here, to show how the validator works.
 * <p>
 * ConstraintValidator defines the logic to validate a given constraint for a given object. Implementations must comply with the following restriction:
 * . the object must resolve to a non-parametrized type
 * . generic parameters of the object must be unbounded wildcard types
 */
public class ContactNumberValidator implements ConstraintValidator<ContactNumberConstraint, String> {

	@Override
	public void initialize(final ContactNumberConstraint constraintAnnotation) {

		// no-op
	}

	@Override
	public boolean isValid(final String contactField, final ConstraintValidatorContext context) {

		return contactField != null
				&& contactField.matches("[0-9]+")
				&& (contactField.length() > 8)
				&& (contactField.length() < 14);
	}

}