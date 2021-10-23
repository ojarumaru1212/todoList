package com.todolist.api.domain.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.todolist.api.domain.mapper.UserMapper;
import com.todolist.api.domain.model.LoginForm;

/**
 * ログイン ロジッククラス
 *
 */
@Component
public class LoginLogic {

	private final UserMapper mapper;
	
	@Autowired
	public LoginLogic(UserMapper mapper) {
		this.mapper = mapper;
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
		int updatedCnt = mapper.findByUserIdAndPassword(loginReq.getUserName(), loginReq.getPassword());
		// 一致件数0件
		if(updatedCnt == 0) {
			return successedFlg;
		}
		
		successedFlg = true;
		return successedFlg;
	}
	
}
