package com.todolist.api.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.todolist.api.common.constant.ParameterConstants;
import com.todolist.api.domain.model.RegistTaskRequestForm;
import com.todolist.api.domain.model.RegistTaskResponseForm;
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
	public String registTask(@RequestBody @Valid RegistTaskRequestForm req, BindingResult bindingResult)
			throws JsonProcessingException {

		boolean registSuccessFlg = false;
		List<String> messageList = new ArrayList<>();
		String json = null;

		// 入力チェック
		if (bindingResult.hasErrors()) {
			// エラーメッセージをリストに格納
			for (ObjectError error : bindingResult.getAllErrors()) {
				messageList.add(error.getDefaultMessage());
			}

			RegistTaskResponseForm regTaskResForm = RegistTaskResponseForm.builder().messages(messageList)
					.registSuccessFlg(registSuccessFlg).build();
			// シリアライズ
			json = mapper.writeValueAsString(regTaskResForm);
			return json;
		}

		// タスク登録
		registSuccessFlg = service.RegistTask(req);

		RegistTaskResponseForm regTaskResForm = RegistTaskResponseForm.builder().registSuccessFlg(registSuccessFlg)
				.build();

		// シリアライズ
		json = mapper.writeValueAsString(regTaskResForm);
		return json;
	}

}