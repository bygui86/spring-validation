package com.rabbit.validationsamples.dtos;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@NoArgsConstructor
// @AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@Builder
public class PersonDto {

	@Size(min = 5, max = 200)
	String firstName;

	@Size(min = 5, max = 200)
	String lastName;

	/**
	 * Single Parameter Constraints
	 * Defining constraints on single parameters is straightforward. We simply have to add annotations to each parameter as required.
	 *
	 * @param firstName
	 * @param lastName
	 */
	public PersonDto(
			@Size(min = 5, max = 200) @NotNull final String firstName,
			@Size(min = 5, max = 200) @NotNull final String lastName) {

		this.firstName = firstName;
		this.lastName = lastName;
	}

}
