package com.rabbit.validationsamples.javabean;

import com.rabbit.validationsamples.javabean.dtos.UserDto;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;


public class UserDtoValidationIntegrationTest {

	private static Validator validator;

	@BeforeClass
	public static void setup() {

		final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@Test
	public void validateUser_ok() {

		final Set<ConstraintViolation<UserDto>> violations =
				validator.validate(
						UserDto.builder()
								.name("john doe")
								.working(true)
								.aboutMe("i'm still fighting for a place in this world")
								.age(42)
								.email("john@doe.org")
								.build()
				);
		Assert.assertTrue(violations.isEmpty());
	}

	@Test
	public void validateUser_noNameError() {

		final Set<ConstraintViolation<UserDto>> violations =
				validator.validate(
						UserDto.builder()
								.working(true)
								.aboutMe("i'm still fighting for a place in this world")
								.age(42)
								.email("john@doe.org")
								.build()
				);
		Assert.assertFalse(violations.isEmpty());
		Assert.assertEquals(1, violations.size());
		Assert.assertEquals(
				"Name cannot be null",
				violations.iterator().next().getMessage());
	}

	@Test
	public void validateUser_emailError() {

		final Set<ConstraintViolation<UserDto>> violations =
				validator.validate(
						UserDto.builder()
								.name("john doe")
								.working(true)
								.aboutMe("i'm still fighting for a place in this world")
								.age(42)
								.email("johndoe.org")
								.build()
				);
		Assert.assertFalse(violations.isEmpty());
		Assert.assertEquals(1, violations.size());
		Assert.assertEquals(
				"Email must be valid",
				violations.iterator().next().getMessage());
	}

	@Test
	public void validateUser_ageError() {

		final Set<ConstraintViolation<UserDto>> violations =
				validator.validate(
						UserDto.builder()
								.name("john doe")
								.working(true)
								.aboutMe("i'm still fighting for a place in this world")
								.age(17)
								.email("john@doe.org")
								.build()
				);
		Assert.assertFalse(violations.isEmpty());
		Assert.assertEquals(1, violations.size());
		Assert.assertEquals(
				"Age should not be less than 18",
				violations.iterator().next().getMessage());
	}

	@Test
	public void validateUser_aboutMeError() {

		final Set<ConstraintViolation<UserDto>> violations =
				validator.validate(
						UserDto.builder()
								.name("john doe")
								.working(true)
								.aboutMe("i'm john")
								.age(42)
								.email("john@doe.org")
								.build()
				);
		Assert.assertFalse(violations.isEmpty());
		Assert.assertEquals(1, violations.size());
		Assert.assertEquals(
				"About Me must be between 10 and 200 characters",
				violations.iterator().next().getMessage());
	}

	@Test
	public void validateUser_mutipleErrors() {

		final Set<ConstraintViolation<UserDto>> violations =
				validator.validate(
						UserDto.builder()
								.name("john doe")
								.working(false)
								.aboutMe("i'm john")
								.age(17)
								.email("johndoe.org")
								.build()
				);
		Assert.assertFalse(violations.isEmpty());
		Assert.assertEquals(4, violations.size());
	}

}
