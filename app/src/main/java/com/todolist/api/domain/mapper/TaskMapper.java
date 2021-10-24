package com.todolist.api.domain.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.todolist.api.domain.entity.Task;

/**
 * タスクテーブル マッパークラス
 *
 */
@Mapper
public interface TaskMapper {

	/**
	 * ログインユーザのタスク一覧を取得する
	 * 
	 * @param userId ユーザID
	 * @return タスク一覧
	 */
	@Select("SELECT task_no, title, detail, remark, completed_flg, deleted_flg FROM tbl_task WHERE user_id = #{userId}")
	@Results(id = "task", value = {
			// column:selectするカラム名、property:カラムと対応付けるJavaのフォールド名
			@Result(column = "task_no", property = "taskNo"), @Result(column = "title", property = "title"),
			@Result(column = "remark", property = "remark"),
			@Result(column = "completed_flg", property = "completedFlg"),
			@Result(column = "deleted_flg", property = "deletedFlg") })
	List<Task> selectTask(@Param("userId") String userId);

	/**
	 * 完了フラグを「"1":完了」に更新する
	 * 
	 * @param taskNo タスク番号
	 * @return 更新件数
	 */
	@Update("UPDATE tbl_task SET completed_flg = '1', updated_date = now() where task_no = #{taskNo}")
	int updateCompletedFlg(@Param("taskNo") int taskNo);

	/**
	 * 完了フラグを「"0":未完了」に更新する
	 * 
	 * @param taskNo タスク番号
	 * @return 更新件数
	 */
	@Update("UPDATE tbl_task SET completed_flg = '0', updated_date = now() where task_no = #{taskNo}")
	int revertCompletedFlg(@Param("taskNo") int taskNo);

	/**
	 * 削除フラグを「"1":削除済」に更新する
	 * 
	 * @param taskNo タスク番号
	 * @return 更新件数
	 */
	@Update("UPDATE tbl_task SET deleted_flg = '1', updated_date = now() where task_no = #{taskNo}")
	int updateDeletedFlg(@Param("taskNo") int taskNo);
}
