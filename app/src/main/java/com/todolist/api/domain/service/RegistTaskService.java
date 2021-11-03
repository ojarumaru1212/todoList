package com.todolist.api.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todolist.api.domain.logic.RegistTaskLogic;
import com.todolist.api.domain.model.RegistTaskForm;

/**
 * タスク登録 サービスクラス
 *
 */
@Service
public class RegistTaskService {

	private final RegistTaskLogic logic;

	@Autowired
	public RegistTaskService(RegistTaskLogic logic) {
		this.logic = logic;
	}

	/**
	 * タスクを登録するため、ロジッククラスを呼び出す
	 * 
	 * @param RegistTaskForm タスク情報
	 * @return true:登録件数1件、false:登録件数1件以外
	 */
	public boolean RegistTask(RegistTaskForm form) {
		return logic.registTask(form);
	}
}
