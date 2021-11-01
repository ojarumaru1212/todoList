var app1 = new Vue({
	el: '#app',
	data: {
		loading: true, // ローディング表示可否フラグ（true:表示、false:非表示）
		title: null, // タイトル
		detail: null, // 詳細
		remark: null, // 備考
		url: "/executeLogin", // ログイン処理の際にサーバと通信するURL
		data: null, // サーバと通信時のリクエストパラメータ
		result: null,// ログイン処理実施結果（true:成功、false:失敗）
		locationUrl: "/page/home.html", // ログイン成功時の先に先URL
	},
	mounted: function() {
		this.loading = false;
	},
	methods: {
		/* 入力されたタイトルを格納する */
		inputTitle: function(event) {
			const validChk = validExecute(event.target.value, true, 1, 100);
			if (!validChk) return;

			this.title = event.target.value;
			console.log("タイトル入力 : " + this.title);
		},
		/* 入力された詳細を格納する */
		inputDetail: function(event) {
			const validChk = validExecute(event.target.value, false, 1, 500);
			if (!validChk) return;

			this.detail = event.target.value;
			console.log("詳細入力 : " + this.detail);
		},
		/* 入力された備考を格納する */
		inputRemark: function(event) {
			const validChk = validExecute(event.target.value, false, 1, 500);
			if (!validChk) return;

			this.remark = event.target.value;
			console.log("備考入力 : " + this.remark);
		},
		/* タスクを登録するため、サーバと通信する */
		registTask: function(event) {
			console.log(event);

			/*			this.data = {
							userName: this.userName,
							password: this.password
						};
			
						// ローディング開始
						this.loading = true;
			
						axios.post(this.url, this.data
						).then(response => {
							this.result = response.data;
							if (this.result === true) {
								location.href = this.locationUrl;
							}
						}).catch(err => {
							alert(err);
						})*/

		}
	}
})

/**
* 入力チェックを実施する。
* @param value チェック対象の値
* @param requiredFlg 必須フラグ（true:必須、false:任意）
* @param minLength 最小桁数
* @param maxLength 最大桁数
* @return true:チェックOK、false:チェックNG
*/
const validExecute = (value, requiredFlg, minLength, maxLength) => {
	// 必須チェック
	if (!isRequired(value)) {
		// 任意項目の場合、必須エラーとしない。
		return requiredFlg === true ? false : true;
	}

	// 桁チェック
	if (!isLength(value, minLength, maxLength)) return false;

	// 型チェック
	if (!isFormat(value)) return false;

	return true;
}