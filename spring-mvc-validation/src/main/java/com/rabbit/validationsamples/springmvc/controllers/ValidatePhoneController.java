package com.rabbit.validationsamples.springmvc.controllers;

import com.rabbit.validationsamples.springmvc.dtos.ValidatedPhone;
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
@Controller("validatePhoneController")
public class ValidatePhoneController {

	@GetMapping("/validatePhone")
	public String loadFormPage(final Model model) {

		log.info("get validate phone page...");

		model.addAttribute("validatedPhone", new ValidatedPhone());

		return "phoneHome";
	}

	@PostMapping("/addValidatePhone")
	public String submitForm(@Valid final ValidatedPhone validatedPhone, final BindingResult bindingResult, final Model model) {

		log.info("post phone to be validated: {}", validatedPhone.toString());

		if (bindingResult.hasErrors()) {
			log.error("Phone number not valid!");
			return "phoneHome";
		}

		model.addAttribute("message", "Successfully saved phone: " + validatedPhone.toString());

		return "phoneHome";
	}
}
