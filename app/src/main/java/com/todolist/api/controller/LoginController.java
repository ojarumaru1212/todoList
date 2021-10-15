package com.todolist.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.todolist.api.common.constant.ParameterConst;

/**
 * ログイン コントローラー
 *
 */
@Controller
public class LoginController {

	/**
	 * @return ログイン画面 URL
	 */
	@GetMapping(ParameterConst.REQ_PARAM_LOGIN)
	public String login() {
		return ParameterConst.RES_BASE + ParameterConst.RES_PARAM_LOGIN;
	}
}