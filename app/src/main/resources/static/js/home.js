var app1 = new Vue({
	el: '#app',
	data: {
		loading: true, // ローディング表示可否フラグ（true:表示、false:非表示）
		init_url: "/home", // 初期処理の際にサーバと通信するURL
		complete_url: "/complete", // 完了ボタン押下時にサーバと通信するURL
		delete_url: "/delete", // 削除ボタン押下時にサーバと通信するURL
		revert_url: "/revert", // 戻すボタン押下時にサーバと通信するURL
		data: null, // サーバと通信時のリクエストパラメータ
		result: null,// サーバで取得したタスク一覧
		locationUrl: "/page/home.html", // ログイン成功時の先に先URL
	},
	mounted: function() {
		axios.get(this.init_url
		).then(response => {
			this.result = response.data;
			console.log(this.result);
			this.loading = false;
		}).catch(err => {
			alert(err);
		})
	},
	methods: {
		/* 完了ボタン押下時の処理 */
		completeTask: function(taskNo) {
			this.data = {
				taskNo: taskNo
			};

			// ローディング開始
			this.loading = true;

			// タスクテーブルの完了フラグを「"1":完了」に更新
			axios.post(this.complete_url, this.data
			).then(response => {
				this.result = response.data;
				this.loading = false;
			}).catch(err => {
				alert(err);
			})
		},
		/* 削除ボタン押下時の処理 */
		deleteTask: function(taskNo) {
			const confResult = confirm('削除しますか');
			// キャンセルボタンが押下された場合
			if(!confResult){
				return;
			}
			this.data = {
				taskNo: taskNo
			};

			// ローディング開始
			this.loading = true;

			// タスクテーブルの削除フラグを「"1":削除済」に更新
			axios.post(this.delete_url, this.data
			).then(response => {
				this.result = response.data;
				this.loading = false;
			}).catch(err => {
				alert(err);
			})
		},
		/* 戻すボタン押下時の処理 */
		revertTask: function(taskNo) {
			this.data = {
				taskNo: taskNo
			};

			// ローディング開始
			this.loading = true;

			// タスクテーブルの完了フラグを「"0":未完了」に更新
			axios.post(this.revert_url, this.data
			).then(response => {
				this.result = response.data;
				this.loading = false;
			}).catch(err => {
				alert(err);
			})
		}
	}
})