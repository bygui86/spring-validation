package com.rabbit.validationsamples.controllers;

import com.rabbit.validationsamples.dtos.ContactDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;


/**
 * We defined this simple controller that have a single JSP page, and use the submitForm method to enforce the validation of our phone number.
 */
@Slf4j
@Controller("contactController")
public class ContactController {

	@GetMapping("/validatePhone")
	public String loadFormPage(final Model model) {

		log.info("get validate phone page...");

		model.addAttribute("contactDto", new ContactDto());

		return "phoneHome";
	}

	/**
	 * /@Valid forces the recursive validation of all properties.
	 * <p>
	 * We can use @Valid at two places:
	 * . On a input parameter: it triggers the validation of the object, when the method is called
	 * . If there is a nested object (e.g Reservation.person), we also have to add a @Valid on the object-attribute: thereby, it triggers the validation of the
	 * nested property
	 *
	 * @param contactDto
	 * @param bindingResult
	 * @param model
	 */
	@PostMapping("/validatePhone")
	public String submitForm(
			@Valid final ContactDto contactDto,
			final BindingResult bindingResult,
			final Model model) {

		log.info("post phone to be validated: {}", contactDto.toString());

		if (bindingResult.hasErrors()) {
			log.error("Phone number not valid!");
			return "phoneHome";
		}

		model.addAttribute("message", "Successfully saved phone: " + contactDto.toString());

		return "phoneHome";
	}
}
