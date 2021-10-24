package com.todolist.api.domain.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import lombok.Data;

/**
 * タスクテーブル エンティティクラス
 *
 */
@Data
public class Task implements Serializable {
    private Long taskNo;
    private String title;
    private String UserId;
    private String detail;
    private String remark;
    private String completedFlg;
    private String deletedFlg;
    private Timestamp registedDate;
    private Timestamp updatedDate;
}
