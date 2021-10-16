package com.todolist.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.todolist.api.common.constant.ParameterConstants;
import com.todolist.api.domain.entity.LoginRequest;

/**
 * ログイン コントローラー
 *
 */
@Controller
public class LoginController {

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
	 */
	@PostMapping(ParameterConstants.REQ_EXECUTE_LOGIN)
	@ResponseBody
	public String login(@RequestBody LoginRequest loginReq) {
		return "ok";
//		return ParameterConstants.RES_BASE + ParameterConstants.RES_PARAM_LOGIN;
	}
}