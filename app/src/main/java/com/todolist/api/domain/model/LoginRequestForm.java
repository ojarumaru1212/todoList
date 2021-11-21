package com.todolist.api.domain.model;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class LoginRequestForm {
	private String userName;
	private String password;
}
