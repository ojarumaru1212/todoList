package com.todolist.api.domain.model;

import lombok.Data;

/**
 * ホーム画面 完了、削除、戻すボタン押下処理 リクエストクラス
 *
 */
@Data
public class HomeRequestForm {
	private int taskNo;
}
