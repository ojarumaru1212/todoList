var app1 = new Vue({
	el: '#app',
	data: {
		loading: true, // ローディング表示可否フラグ（true:表示、false:非表示）
		init_url: "/home", // 初期処理の際にサーバと通信するURL
		data: null, // サーバと通信時のリクエストパラメータ
		result: null,// ログイン処理実施結果（true:成功、false:失敗）
		locationUrl: "/page/home.html", // ログイン成功時の先に先URL
	},
	mounted: function() {
		axios.get(this.init_url
		).then(response => {
			this.result = response.data;
			this.loading = false;
		}).catch(err => {
			alert(err);
		})
	},
	methods: {
		/* 入力されたユーザ名を格納する */
		inputUserName: function(event) {
			this.userName = event.target.value;
		}
	}
})