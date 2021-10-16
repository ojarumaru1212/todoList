package com.todolist.api.domain.entity;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class LoginRequest {
	private String userName;
	private String password;
}
