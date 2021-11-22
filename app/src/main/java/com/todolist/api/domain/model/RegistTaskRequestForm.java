package com.todolist.api.domain.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

import lombok.Data;

/**
 * タスク登録 リクエストクラス<br>
 * タスクテーブルに登録する項目も併せて定義している。
 *
 */
@Component
@Data
public class RegistTaskRequestForm {
	/**
	 * タイトル
	 */
	@NotEmpty(message = "{task.title.required}")
	@Size(min = 1, max = 100, message = "{task.title.length}")
	@Pattern(regexp = "^[a-zA-Z0-9!-/:\\[\\-@-`{-~|^\\x20-\\x7e]*", message = "{task.title.pattern}")
	private String title;

	/**
	 * 詳細<br>
	 * 値がnullの場合、チェック処理が行わない
	 */
	@Size(min = 1, max = 500, message = "{task.detail.length}")
	@Pattern(regexp = "^[a-zA-Z0-9!-/:\\[\\-@-`{-~|^\\x20-\\x7e]*", message = "{task.detail.pattern}")
	private String detail;

	/**
	 * 備考<br>
	 * 値がnullの場合、チェック処理が行わない。 
	 */
	@Size(min = 1, max = 500, message = "{task.remark.length}")
	@Pattern(regexp = "^[a-zA-Z0-9!-/:\\[\\-@-`{-~|^\\x20-\\x7e]*", message = "{task.remark.pattern}")
	private String remark;
	
	/**
	 * ユーザID
	 */
	private String userId;
	
	/**
	 * 完了フラグ
	 */
	private String completedFlg;
	
	
	/**
	 * 削除フラグ
	 */
	private String deletedFlg;
}
