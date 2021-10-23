var app1 = new Vue({
	el: '#app',
	data: {
		loading: true, // ローディング表示可否フラグ（true:表示、false:非表示）
		userName: null, // ユーザ名
		password: null, // パスワード
		url: "/executeLogin", // ログイン処理の際にサーバと通信するURL
		data: null, // サーバと通信時のリクエストパラメータ
		result: null,// ログイン処理実施結果（true:成功、false:失敗）
		locationUrl: "/page/home.html", // ログイン成功時の先に先URL
	},
	mounted: function() {
		this.loading = false;
	},
	methods: {
		/* 入力されたユーザ名を格納する */
		inputUserName: function(event) {
			this.userName = event.target.value;
			console.log("ユーザ名入力 : " + this.userName);
		},
		/* 入力されたパスワードを格納する */
		inputPassword: function(event) {
			this.password = event.target.value;
			console.log("パスワード入力 : " + this.password);
		},
		/* ログイン処理をするため、サーバと通信する */
		loginStart: function(event) {
			console.log(event);

			this.data = {
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
			})

		}
	}
})