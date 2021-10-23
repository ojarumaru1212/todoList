package com.todolist.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.todolist.api.common.constant.ParameterConstants;
import com.todolist.api.domain.entity.Task;
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

//	/**
//	 * ログイン処理を実施する
//	 * 
//	 * @return ログイン処理結果
//	 * @throws JsonProcessingException 
//	 */
//	@PostMapping(ParameterConstants.REQ_EXECUTE_Home)
//	@ResponseBody
//	public String home(@RequestBody HomeForm HomeReq) throws JsonProcessingException {
//		// ログイン処理実施
//		boolean successedFlg = service.home(HomeReq);
//		
//		// シリアライズ
//		String json = mapper.writeValueAsString(successedFlg);
//
//		return json;
//	}
}