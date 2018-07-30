package com.rabbit.validationsamples.javabean.dtos;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Setter
@ToString
@EqualsAndHashCode
@Builder
public class CustomerDto {

	@Getter
	List<@NotBlank String> addresses;

	// PLEASE NOTE: if dateOfBirth is null, then the Optional value is not validated
	LocalDate dateOfBirth;

	public Optional<@Past LocalDate> getDateOfBirth() {

		return Optional.ofNullable(dateOfBirth);
	}

}
