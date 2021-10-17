var app1 = new Vue({
	el: '#app',
	data: {
		userName: null, // ユーザ名
		password: null, // パスワード
		url: "/executeLogin", // ログイン処理の際にサーバと通信するURL
		data: null, // サーバと通信時のリクエストパラメータ
		result: null,// ログイン処理実施結果（true:成功、false:失敗）
		locationUrl: "/page/home.html", // ログイン成功時の先に先URL
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
		login: async function(event) {
			console.log(event);

			this.data = {
				userName: this.userName,
				password: this.password
			};

			/*this.result = await loginExecute(this);*/
			/*await axios.post(this.url, this.data
				).then(response => {
					this.result = response.data;
					if (this.result === true) {
						location.href = this.locationUrl;
					}
				}).catch(err => {
					alert(err);
				})*/
			const response = await axios.post(this.url, this.data);
			this.result = response.data;
			if (this.result === true) {
				location.href = this.locationUrl;
			}


		}
	}
})

const loginExecute = async (vueThis) => {
	return await axios.post(vueThis.url, vueThis.data
	).then(response => {
		return response.data;

	}).catch(err => {
		alert(err);
	})
};