package com.rabbit.validationsamples.integrations;

import com.rabbit.validationsamples.dtos.ProfileDto;
import com.rabbit.validationsamples.dtos.ProfileWrapperDto;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;


public class ProfileWrapperDtoValidationIntegrationTest {

	private static Validator validator;

	@BeforeClass
	public static void setup() {

		final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@Test
	public void validateProfileWrapper_ok() {

		final Set<ConstraintViolation<ProfileWrapperDto>> violations = validator.validate(
				ProfileWrapperDto.builder()
						.profile(
								ProfileDto.builder()
										.companyName("MB SOLID consulting")
										.build()
						)
						.build()
		);

		Assert.assertTrue(violations.isEmpty());
	}

	@Test
	public void validateProfileWrapper_error() {

		final Set<ConstraintViolation<ProfileWrapperDto>> violations = validator.validate(
				ProfileWrapperDto.builder()
						.profile(
								ProfileDto.builder()
										.companyName("")
										.build()
						)
						.build()
		);

		Assert.assertFalse(violations.isEmpty());
		Assert.assertEquals(1, violations.size());
	}

}
