package com.rabbit.validationsamples.services;

import com.rabbit.validationsamples.dtos.PersonDto;
import com.rabbit.validationsamples.dtos.ReservationDto;
import com.rabbit.validationsamples.validation.constraints.ConsistentDatesConstraint;
import com.rabbit.validationsamples.validation.constraints.ValidReservationConstraint;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


@Slf4j
@Service("reservationService")
@Validated
public class ReservationService {

	/**
	 * Single Parameter Constraints
	 * Defining constraints on single parameters is straightforward. We simply have to add annotations to each parameter as required.
	 *
	 * @param date
	 * @param duration
	 * @param personDto
	 *
	 * @throws InterruptedException
	 */
	public void createSingleDayReservation(
			@NotNull @Future final LocalDate date,
			@Min(1) final int duration,
			@NotNull @Valid final PersonDto personDto) throws InterruptedException {

		log.info("Person {} creating a new daily reservation for {}", personDto, date);
		TimeUnit.SECONDS.sleep(duration);
		log.info("Reservation created!");
	}

	/**
	 * Cross-Parameter Constraints
	 *
	 * @param beginDate
	 * @param endDate
	 *
	 * @throws InterruptedException
	 */
	@ConsistentDatesConstraint
	public void createMultipleDaysReservation(
			final LocalDate beginDate,
			final LocalDate endDate) throws InterruptedException {

		log.info("Person DEFAULT creating a new reservation from {} to {}", beginDate, endDate);
		TimeUnit.SECONDS.sleep(1);
		log.info("Reservation created!");
	}

	/**
	 * Cross-Parameter Constraints together with Single Parameter Constraints
	 *
	 * @param beginDate
	 * @param endDate
	 *
	 * @throws InterruptedException
	 */
	@ConsistentDatesConstraint
	public void createMultipleDaysReservation(
			final LocalDate beginDate,
			final LocalDate endDate,
			@Min(1) final int duration,
			@NotNull @Valid final PersonDto personDto) throws InterruptedException {

		log.info("Person {} creating a new reservation from {} to {}", personDto, beginDate, endDate);
		TimeUnit.SECONDS.sleep(duration);
		log.info("Reservation created!");
	}

	/**
	 * Return Value Constraints - OK
	 */
	@NotNull
	@Size(min = 1)
	public List<@NotNull PersonDto> getAllPersons_ok() {

		final List<PersonDto> persons = new ArrayList<>();
		persons.add(createPerson("Matteo", "Baiguini"));
		persons.add(createPerson("Martin", "Fowler"));
		persons.add(createPerson("Robert", "Martin"));
		return persons;
	}

	protected PersonDto createPerson(final String first, final String last) {

		return PersonDto.builder()
				.firstName(first)
				.lastName(last)
				.build();
	}

	/**
	 * Return Value Constraints - ERROR
	 */
	@NotNull
	@Size(min = 1)
	public List<@NotNull PersonDto> getAllPersons_error() {

		return null;
	}

	/**
	 * Return Value Custom Constraints - OK
	 * In this example, a returned Reservation object must satisfy the constraints defined by @ValidReservationConstraint.
	 *
	 * @param id
	 */
	@ValidReservationConstraint
	// @Valid
	public ReservationDto getReservationById_ok(final String id) {

		return ReservationDto.builder()
				.id("001")
				.begin(LocalDate.now().plusDays(1))
				.end(LocalDate.now().plusDays(2))
				.room(1)
				.person(
						PersonDto.builder()
								.firstName("Matteo")
								.lastName("Baiguini")
								.build()
				)
				.build();
	}

	/**
	 * Return Value Custom Constraints - ERROR - NULL
	 * In this example, a returned Reservation object must satisfy the constraints defined by @ValidReservationConstraint.
	 *
	 * @param id
	 */
	@ValidReservationConstraint
	// PLEASE NOTE: Seems that @Valid works just for parameters and not for returning objects
	public ReservationDto getReservationById_error_null(final String id) {

		return null;
	}

	/**
	 * Return Value Custom Constraints - ERROR - WRONG DTO
	 * In this example, a returned Reservation object must satisfy the constraints defined by @ValidReservationConstraint.
	 *
	 * @param id
	 */
	@ValidReservationConstraint
	public ReservationDto getReservationById_error_wrong(final String id) {

		return ReservationDto.builder()
				.id("001")
				.begin(LocalDate.now().plusDays(2))
				.end(LocalDate.now().plusDays(1))
				.room(1)
				.person(
						PersonDto.builder()
								.firstName("Matteo")
								.lastName("Baiguini")
								.build()
				)
				.build();
	}

}
