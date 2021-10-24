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

	/**
	 * タスクテーブルの完了フラグを「"1":完了」に更新するため、ロジッククラスを呼び出す
	 * 
	 * @return タスク一覧
	 */
	public int updateCompletedFlg(int taskNo) {
		return logic.updateCompletedFlg(taskNo);
	}

	/**
	 * タスクテーブルの完了フラグを「"0":未完了」に更新するため、ロジッククラスを呼び出す
	 * 
	 * @return タスク一覧
	 */
	public int revertCompletedFlg(int taskNo) {
		return logic.revertCompletedFlg(taskNo);
	}

	/**
	 * タスクテーブルの削除フラグを「"1":削除済」に更新するため、ロジッククラスを呼び出す
	 * 
	 * @return タスク一覧
	 */
	public int updateDeletedFlg(int taskNo) {
		return logic.updateDeletedFlg(taskNo);
	}
}
