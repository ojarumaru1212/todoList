package com.todolist.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.todolist.api.common.constant.ParameterConstants;
import com.todolist.api.domain.model.RegistTaskForm;
import com.todolist.api.domain.service.RegistTaskService;

/**
 * タスク登録 コントローラークラス
 *
 */
@Controller
public class RegistTaskController {

	private final RegistTaskService service;
	private final ObjectMapper mapper;

	@Autowired
	public RegistTaskController(RegistTaskService service, ObjectMapper mapper) {
		this.service = service;
		this.mapper = mapper;
	}

	/**
	 * タスクを登録する
	 * 
	 * @return true:登録件数1件、false:登録件数1件以外
	 * @throws JsonProcessingException
	 */
	@PostMapping(ParameterConstants.REQ_PARAM_REGIST_TASK)
	@ResponseBody
	public String registTask(@RequestBody @Valid RegistTaskForm req, BindingResult bindingResult)
			throws JsonProcessingException {
		
		boolean registSuccessFlg = false;
		String json = null;
		
		// 入力チェック
		if (bindingResult.hasErrors()) {
			// TODO エラーメッセージを画面に返却し、画面にメッセージを表示する。
//			for (ObjectError error : bindingResult.getAllErrors()) {
//				System.out.println(error.getDefaultMessage());
//			}
			// シリアライズ
			json = mapper.writeValueAsString(registSuccessFlg);
			return json;
		}

		// タスク登録
		registSuccessFlg = service.RegistTask(req);

		// シリアライズ
		json = mapper.writeValueAsString(registSuccessFlg);
		return json;
	}

}