package com.rabbit.validationsamples.dtos;

import com.rabbit.validationsamples.validation.constraints.ValidReservationConstraint;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.time.LocalDate;


@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
// @AllArgsConstructor
@Data
@Builder
@Validated
public class ReservationDto {

	String id;

	LocalDate begin;

	LocalDate end;

	@Positive
	int room;

	/**
	 * The Bean Validation API allows us to not only validate single objects but also object graphs, using the so-called cascaded validation.
	 * Hence, we can use @Valid for a cascaded validation, if we want to validate complex objects. This works for method parameters as well as for return values.
	 */
	@Valid
	PersonDto person;

	// @ConsistentDatesConstraint
	@ValidReservationConstraint
	public ReservationDto(
			final String id, final LocalDate begin, final LocalDate end,
			final int room, final PersonDto person) {

		this.id = id;
		this.begin = begin;
		this.end = end;
		this.room = room;
		this.person = person;
	}

}
