package com.todolist.api.domain.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import lombok.Data;

/**
 * ユーザマスタ エンティティクラス
 *
 */
@Data
public class User implements Serializable {
    private Long userNo;
    private String userId;
    private String password;
    private Timestamp lastLoginDate;
    private Timestamp registedDate;
    private Timestamp updatedDate;
}
