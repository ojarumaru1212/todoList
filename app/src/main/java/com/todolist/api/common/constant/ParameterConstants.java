package com.todolist.api.common.constant;

/**
 * エンドポイント 定数クラス
 *
 */
public class ParameterConstants {
	
	/**	ログイン画面 リクエストエンドポイント */
	public static final String REQ_PARAM_LOGIN = "/login";

	/**	ログイン画面 ログイン処理実施エンドポイント */
	public static final String REQ_EXECUTE_LOGIN = "/executeLogin";
	
	/**	ホーム画面 初期処理エンドポイント */
	public static final String REQ_PARAM_HOME = "/home";

	/**	ホーム画面 完了ボタン押下処理エンドポイント */
	public static final String REQ_PARAM_COMPLETE = "/complete";

	/**	ホーム画面 削除ボタン押下処理エンドポイント */
	public static final String REQ_PARAM_DELETE = "/delete";

	/**	ホーム画面 戻すボタン押下処理エンドポイント */
	public static final String REQ_PARAM_REVERT = "/revert";

	/**	タスク登録画面 登録ボタン押下処理エンドポイント */
	public static final String REQ_PARAM_REGIST_TASK = "/registTask";

	/** ページ基底URL */
	public static final String RES_BASE = "/page";

	/** ログインページ（ログインページのみ、サーバからページを返却する） */
	public static final String RES_PARAM_LOGIN = "/login.html";
	
	/** リダイレクト */
	public static final String REDIRECT = "redirect:";
}
