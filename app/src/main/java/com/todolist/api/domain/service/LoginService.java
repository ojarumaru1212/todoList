package com.todolist.api.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todolist.api.domain.logic.LoginLogic;
import com.todolist.api.domain.model.LoginForm;

/**
 * ログイン サービスクラス
 *
 */
@Service
public class LoginService {
	
	private final LoginLogic logic;
	
	@Autowired
	public LoginService(LoginLogic logic) {
		this.logic = logic;
	}

	/**
	 * ログイン処理を実施するため、ロジッククラスを呼び出す
	 * 
	 * @param loginReq 入力情報
	 * @return true:ログイン成功、false:ログイン失敗
	 */
	public boolean login(LoginForm loginReq) {
		return logic.login(loginReq);
	}
}
