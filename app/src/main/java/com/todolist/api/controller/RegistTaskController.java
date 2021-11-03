package com.todolist.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	public String registTask(@RequestBody RegistTaskForm req) throws JsonProcessingException {
		boolean registSuccessFlg = service.RegistTask(req);
		
		// シリアライズ
		String json = mapper.writeValueAsString(registSuccessFlg);
		return json;
	}

}