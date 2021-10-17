package com.todolist.api.domain.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.todolist.api.domain.entity.User;


/**
 * ユーザマスタ リポジトリークラス
 *
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	
	/**
	 * 一致するユーザIDとパスワードのレコードを取得する
	 * 
	 * @param userId ユーザID
	 * @param password パスワード
	 * @return ユーザIDと一致するレコード
	 */
	User findByUserIdAndPassword(String userId, String password);
}
