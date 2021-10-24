package com.todolist.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.todolist.api.common.constant.ParameterConstants;
import com.todolist.api.domain.entity.Task;
import com.todolist.api.domain.model.HomeForm;
import com.todolist.api.domain.service.HomeService;

/**
 * ホーム コントローラークラス
 *
 */
@Controller
public class HomeController {

	private final HomeService service;
	private final ObjectMapper mapper;

	@Autowired
	public HomeController(HomeService service, ObjectMapper mapper) {
		this.service = service;
		this.mapper = mapper;
	}

	/**
	 * ホーム画面の初期処理を実施する
	 * 
	 * @return タスク一覧
	 * @throws JsonProcessingException
	 */
	@GetMapping(ParameterConstants.REQ_PARAM_HOME)
	@ResponseBody
	public String displayHome() throws JsonProcessingException {
		List<Task> taskList = service.getTask();

		// シリアライズ
		String json = mapper.writeValueAsString(taskList);

		return json;
	}

	/**
	 * 完了ボタン押下時の処理<br>
	 * タスクテーブルの完了フラグを「"1":完了」に更新する
	 * 
	 * @return タスク一覧
	 * @throws JsonProcessingException
	 */
	@PostMapping(ParameterConstants.REQ_PARAM_COMPLETE)
	public String complete(@RequestBody HomeForm form) throws JsonProcessingException {
		int updateCnt = service.updateCompletedFlg(form.getTaskNo());

		// ホーム画面の初期処理にリダイレクトし、タスク一覧を取得する
		return ParameterConstants.REDIRECT + ParameterConstants.REQ_PARAM_HOME;
	}

	/**
	 * 削除ボタン押下時の処理<br>
	 * タスクテーブルの削除フラグを「"1":削除済」に更新する
	 * 
	 * @return タスク一覧
	 * @throws JsonProcessingException
	 */
	@PostMapping(ParameterConstants.REQ_PARAM_DELETE)
	public String delete(@RequestBody HomeForm form) throws JsonProcessingException {
		int updateCnt = service.updateDeletedFlg(form.getTaskNo());

		// ホーム画面の初期処理にリダイレクトし、タスク一覧を取得する
		return ParameterConstants.REDIRECT + ParameterConstants.REQ_PARAM_HOME;
	}

	/**
	 * 戻すボタン押下時の処理<br>
	 * タスクテーブルの完了フラグを「"0":未完了」に更新する
	 * 
	 * @return タスク一覧
	 * @throws JsonProcessingException
	 */
	@PostMapping(ParameterConstants.REQ_PARAM_REVERT)
	public String revert(@RequestBody HomeForm form) throws JsonProcessingException {
		int updateCnt = service.revertCompletedFlg(form.getTaskNo());

		// ホーム画面の初期処理にリダイレクトし、タスク一覧を取得する
		return ParameterConstants.REDIRECT + ParameterConstants.REQ_PARAM_HOME;
	}
}