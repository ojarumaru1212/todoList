package com.todolist.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.todolist.api.common.constant.ParameterConstants;
import com.todolist.api.domain.model.LoginForm;
import com.todolist.api.domain.service.LoginService;

/**
 * ログイン コントローラークラス
 *
 */
@Controller
public class LoginController {
	
	private final LoginService service;
	private final ObjectMapper mapper;
	
	@Autowired
	public LoginController(LoginService service, ObjectMapper mapper) {
		this.service = service;
		this.mapper = mapper;
	}

	/**
	 * ログイン画面を表示する
	 * 
	 * @return ログイン画面 URL
	 */
	@GetMapping(ParameterConstants.REQ_PARAM_LOGIN)
	public String displayLogin() {
		return ParameterConstants.RES_BASE + ParameterConstants.RES_PARAM_LOGIN;
	}

	/**
	 * ログイン処理を実施する
	 * 
	 * @return ログイン処理結果
	 * @throws JsonProcessingException 
	 */
	@PostMapping(ParameterConstants.REQ_EXECUTE_LOGIN)
	@ResponseBody
	public String login(@RequestBody LoginForm loginReq) throws JsonProcessingException {
		// ログイン処理実施
		boolean successedFlg = service.login(loginReq);
		
		// シリアライズ
		String json = mapper.writeValueAsString(successedFlg);

		return json;
	}
}