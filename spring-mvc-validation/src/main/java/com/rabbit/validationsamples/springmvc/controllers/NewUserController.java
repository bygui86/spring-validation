package com.rabbit.validationsamples.springmvc.controllers;

import com.rabbit.validationsamples.springmvc.dtos.NewUserForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;


@Slf4j
@Controller
public class NewUserController {

	@GetMapping("/user")
	public String loadFormPage(final Model model) {

		log.info("get new user page...");

		model.addAttribute("newUserForm", new NewUserForm());

		return "userHome";
	}

	// TODO missing error message in jsp (missing field in BindingResult.x.y.z)
	@PostMapping("/user")
	public String submitForm(@Valid final NewUserForm newUserForm, final BindingResult bindingResult, final Model model) {

		log.info("post user to be validated: {}", newUserForm.toString());

		if (bindingResult.hasErrors()) {
			log.error("New user has errors!");
			return "userHome";
		}

		model.addAttribute("message", "Valid form");

		return "userHome";
	}
}