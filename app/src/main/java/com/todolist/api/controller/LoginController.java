package com.todolist.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todolist.api.common.constant.ParameterConst;

@RestController
public class LoginController {

	@GetMapping(ParameterConst.PARAM_LOGIN)
	public String greeting() {
//		return new Greeting(counter.incrementAndGet(), String.format(template, name));
		return "test";
	}
}