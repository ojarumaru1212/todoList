package com.todolist.api.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todolist.api.domain.entity.Task;
import com.todolist.api.domain.logic.HomeLogic;

/**
 * ホーム サービスクラス
 *
 */
@Service
public class HomeService {
	
	private final HomeLogic logic;
	
	@Autowired
	public HomeService(HomeLogic logic) {
		this.logic = logic;
	}

	/**
	 * ホーム画面の初期処理を実施するため、ロジッククラスを呼び出す
	 * 
	 * @return タスク一覧
	 */
	public List<Task> getTask() {
		return logic.getTask();
	}
}
