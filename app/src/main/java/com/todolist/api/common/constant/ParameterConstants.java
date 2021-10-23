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

	/** ページ基底URL */
	public static final String RES_BASE = "/page";

	/** ログインページ（ログインページのみ、サーバからページを返却する） */
	public static final String RES_PARAM_LOGIN = "/login.html";
}
