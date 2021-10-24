package com.todolist.api.domain.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * ユーザマスタ マッパークラス
 *
 */
@Mapper
public interface UserMapper {
    
	/**
	 * 一致するユーザIDとパスワードのレコードの最終ログイン日時、更新日時を更新する。
	 * 
	 * @param userId ユーザID
	 * @param password パスワード
	 * @return 更新件数
	 */
	@Update("UPDATE mst_user SET last_login_date=now(), updated_date=now() where user_id = (\n"
			+ "    SELECT user_id FROM (\n"
			+ "        SELECT user_id FROM mst_user WHERE user_id = #{userId} AND password = #{password} \n"
			+ "    ) AS T1\n"
			+ ")")
    int findByUserIdAndPassword(@Param("userId") String userId, @Param("password") String password);
}
