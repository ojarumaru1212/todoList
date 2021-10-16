var app1 = new Vue({
	el: '#app',
	data: {
		userName: null, // ユーザ名
		password: null, // パスワード
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
		login: function(event) {
			console.log(event);

			const url = "/executeLogin";
			const data = {
				userName: this.userName,
				password: this.password
			};
			
			axios.post(url, data
			).then(response => {
				this.result = response.data
			}).catch(err => {
				console.error(err)
			})
		}
	}
})