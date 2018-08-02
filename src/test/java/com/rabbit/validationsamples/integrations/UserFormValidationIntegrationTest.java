package com.rabbit.validationsamples.integrations;

import com.rabbit.validationsamples.controllers.UserFormController;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;


public class UserFormValidationIntegrationTest {

	private MockMvc mockMvc;

	@Before
	public void setup() {

		mockMvc = MockMvcBuilders.standaloneSetup(new UserFormController()).build();
	}

	@Test
	public void testGetNewUserPage() throws Exception {

		mockMvc
				.perform(
						get("/user")
				)
				.andExpect(
						view().name("userHome")
				)
		;
	}

	@Test
	public void testNewUser_ok() throws Exception {

		mockMvc
				.perform(
						MockMvcRequestBuilders
								.post("/user")
								.accept(MediaType.TEXT_HTML)
								.param("email", "john@yahoo.com")
								.param("verifyEmail", "john@yahoo.com")
								.param("password", "pass")
								.param("verifyPassword", "pass")
				)
				.andExpect(
						model().errorCount(0)
				)
				.andExpect(
						status().isOk()
				)
		;
	}

	@Test
	public void testNewUser_error() throws Exception {

		mockMvc
				.perform(
						MockMvcRequestBuilders
								.post("/user")
								.accept(MediaType.TEXT_HTML)
								.param("email", "john@yahoo.com")
								.param("verifyEmail", "john@yahoo.commmm")
								.param("password", "pass")
								.param("verifyPassword", "passsss")
				)
				.andExpect(
						model().errorCount(2)
				)
				.andExpect(
						status().isOk()
				)
		;
	}

}
