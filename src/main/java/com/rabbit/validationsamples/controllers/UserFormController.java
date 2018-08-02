package com.rabbit.validationsamples.controllers;

import com.rabbit.validationsamples.dtos.UserFormDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;


@Slf4j
@Controller("userFormController")
public class UserFormController {

	@GetMapping("/user")
	public String loadFormPage(final Model model) {

		log.info("get user form page...");

		model.addAttribute("userForm", new UserFormDto());

		return "userHome";
	}

	// TODO missing error message in jsp (missing field in BindingResult.x.y.z)
	@PostMapping("/user")
	public String submitForm(@Valid final UserFormDto userFormDto, final BindingResult bindingResult, final Model model) {

		log.info("post user form to be validated: {}", userFormDto.toString());

		if (bindingResult.hasErrors()) {
			log.error("User form has errors!");
			return "userHome";
		}

		model.addAttribute("message", "Valid form");

		return "userHome";
	}
}