package com.todolist.api.domain.model;

import java.io.Serializable;
import java.util.List;

import lombok.Builder;
import lombok.Data;

/**
 * タスク登録 レスポンスクラス
 *
 */
//@Component
@Data
@Builder
public class RegistTaskResponseForm implements Serializable {
	private List<String> messages;
	private boolean registSuccessFlg;
}
