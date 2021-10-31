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
			this.title = event.target.value;
			console.log("タイトル入力 : " + this.title);
			$(form).validate()
		},
		/* 入力された詳細を格納する */
		inputDetail: function(event) {
			this.detail = event.target.value;
			console.log("詳細入力 : " + this.detail);
		},
		/* 入力された備考を格納する */
		inputRemark: function(event) {
			this.remark = event.target.value;
			console.log("備考入力 : " + this.password);
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