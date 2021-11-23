package com.todolist.api.domain.logic;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.todolist.api.common.constant.SessionConstants;
import com.todolist.api.domain.mapper.TaskMapper;
import com.todolist.api.domain.model.LoginRequestForm;
import com.todolist.api.domain.model.RegistTaskRequestForm;

/**
 * タスク登録 ロジッククラス
 *
 */
@Component
public class RegistTaskLogic {

	private final TaskMapper mapper;
	private final HttpSession session;

	@Autowired
	public RegistTaskLogic(TaskMapper mapper, HttpSession session) {
		this.mapper = mapper;
		this.session = session;
	}

	/**
	 * タスクを登録する
	 * 
	 * @return true:登録件数1件、false:登録件数1件以外
	 */
	public boolean registTask(RegistTaskRequestForm form) {
		// セッションよりユーザ情報を取得
		LoginRequestForm loginForm = (LoginRequestForm) session.getAttribute(SessionConstants.LOGIN_FORM);

		int registCnt = mapper.registTask(form.getTitle(), loginForm.getUserName(), form.getDetail(), form.getRemark());

		return registCnt == 1 ? true : false;
	}

}
