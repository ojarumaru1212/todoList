package com.todolist.api.domain.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.todolist.api.domain.entity.Task;

@Mapper
public interface TaskMapper {

	/**
	 * ログインユーザのタスク一覧を取得する
	 * 
	 * @param userId ユーザID
	 * @return タスク一覧
	 */
	@Select("SELECT title, detail, remark, completed_flg, deleted_flg FROM tbl_task WHERE user_id = #{userId}")
	@Results(id = "task", value = {
			// column:selectするカラム名、property:カラムと対応付けるJavaのフォールド名
			@Result(column = "title", property = "title"), @Result(column = "remark", property = "remark"),
			@Result(column = "completed_flg", property = "completedFlg"),
			@Result(column = "deleted_flg", property = "deletedFlg") })
	List<Task> selectTask(@Param("userId") String userId);
}
