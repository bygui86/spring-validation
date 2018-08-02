package com.rabbit.validationsamples.dtos;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


// TODO more complex validation with expression language (javax-el)
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserDto {

	@NotNull(message = "Name cannot be null")
	String name;

	@AssertTrue
	boolean working;

	@Size(min = 10, max = 200, message = "About Me must be between 10 and 200 characters")
	String aboutMe;

	@Min(value = 18, message = "Age should not be less than 18")
	@Max(value = 99, message = "Age should not be greater than 99")
	int age;

	@Email(message = "Email must be valid")
	String email;

}
