package com.todolist.api.domain.logic;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.todolist.api.common.constant.SessionConstants;
import com.todolist.api.domain.entity.Task;
import com.todolist.api.domain.mapper.TaskMapper;
import com.todolist.api.domain.model.LoginForm;

/**
 * ホーム ロジッククラス
 *
 */
@Component
public class HomeLogic {

	private final TaskMapper mapper;
	private final HttpSession session;  
	
	@Autowired
	public HomeLogic(TaskMapper mapper, HttpSession session) {
		this.mapper = mapper;
		this.session = session;
	}
	
	/**
	 * ユーザのタスク一覧を取得する
	 * 
	 * @return タスク一覧
	 */
	public List<Task> getTask() {
		// セッションよりユーザ情報を取得
		LoginForm loginForm = (LoginForm)session.getAttribute(SessionConstants.LOGIN_FORM);
		
		return mapper.selectTask(loginForm.getUserName());
	}
	
}
