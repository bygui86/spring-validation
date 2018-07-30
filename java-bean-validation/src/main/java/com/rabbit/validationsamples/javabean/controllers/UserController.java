package com.rabbit.validationsamples.javabean.controllers;

import com.rabbit.validationsamples.javabean.dtos.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;


@Slf4j
@Controller
@RequestMapping("/user")
public class UserController {

	/**
	 * Spring framework has simple ways of triggering the validation process by just using annotations (javax @Valid).
	 * This is mainly so that we don’t have to interact with the programmatic validation API.
	 */
	@PostMapping
	@ResponseBody
	public UserDto postUser(@RequestBody @Valid final UserDto userDto) {

		log.info("Post user {}, validated!", userDto);
		return userDto;
	}

}
