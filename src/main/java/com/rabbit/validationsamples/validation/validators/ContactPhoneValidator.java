package com.rabbit.validationsamples.validation.validators;

import com.rabbit.validationsamples.validation.constraints.ContactPhoneConstraint;

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
public class ContactPhoneValidator implements ConstraintValidator<ContactPhoneConstraint, String> {

	@Override
	public void initialize(final ContactPhoneConstraint constraintAnnotation) {

		// no-op
	}

	/**
	 * This method contains the actual validation logic.
	 *
	 * @param contactPhone
	 * @param context
	 */
	@Override
	public boolean isValid(final String contactPhone, final ConstraintValidatorContext context) {

		return contactPhone != null
				&& contactPhone.matches("[0-9]+")
				&& (contactPhone.length() > 8)
				&& (contactPhone.length() < 14);
	}

}