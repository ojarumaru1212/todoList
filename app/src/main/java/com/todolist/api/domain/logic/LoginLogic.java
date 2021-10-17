package com.todolist.api.domain.logic;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.todolist.api.domain.entity.User;
import com.todolist.api.domain.model.LoginForm;
import com.todolist.api.domain.repository.UserRepository;

/**
 * ログイン ロジッククラス
 *
 */
@Component
public class LoginLogic {

	private final UserRepository repository;
	
	@Autowired
	public LoginLogic(UserRepository repository) {
		this.repository = repository;
	}
	
	/**
	 * ログイン処理を実施する
	 * 
	 * @param loginReq 入力情報
	 * @return true:ログイン成功、false:ログイン失敗
	 */
	public boolean login(LoginForm loginReq) {
		boolean successedFlg = false;
		
		// ユーザマスタより、入力されたユーザID、パスワードに一致するレコードを取得
		User user = repository.findByUserIdAndPassword(loginReq.getUserName(), loginReq.getPassword());
		// 一致件数0件
		if(Objects.isNull(user)) {
			return successedFlg;
		}
		
		successedFlg = true;
		return successedFlg;
	}
	
}
