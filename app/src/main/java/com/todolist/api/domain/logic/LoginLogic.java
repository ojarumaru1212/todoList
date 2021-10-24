package com.todolist.api.domain.logic;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.todolist.api.common.constant.SessionConstants;
import com.todolist.api.domain.mapper.UserMapper;
import com.todolist.api.domain.model.LoginForm;

/**
 * ログイン ロジッククラス
 *
 */
@Component
public class LoginLogic {

	private final UserMapper mapper;
	private final HttpSession session;  
	
	@Autowired
	public LoginLogic(UserMapper mapper, HttpSession session) {
		this.mapper = mapper;
		this.session = session;
	}
	
	/**
	 * ログイン処理を実施する
	 * 
	 * @param loginReq 入力情報
	 * @return true:ログイン成功、false:ログイン失敗
	 */
	@Transactional(rollbackFor=Exception.class)
	public boolean login(LoginForm loginReq) {
		boolean successedFlg = false;
		
		// ユーザマスタより、入力されたユーザID、パスワードに一致するレコードを取得
		int updatedCnt = mapper.findByUserIdAndPassword(loginReq.getUserName(), loginReq.getPassword());
		// 一致件数0件
		if(updatedCnt == 0) {
			return successedFlg;
		}
		
		// ユーザ情報をセッションに格納
		session.setAttribute(SessionConstants.LOGIN_FORM, loginReq);
		
		successedFlg = true;
		return successedFlg;
	}
	
}
