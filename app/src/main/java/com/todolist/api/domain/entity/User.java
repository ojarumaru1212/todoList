package com.todolist.api.domain.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.todolist.api.common.constant.DataBaseConstants;

import lombok.Data;

/**
 * ユーザマスタ エンティティクラス
 *
 */
@Entity
@Data
@Table(name=DataBaseConstants.MST_USER)
@IdClass(value=UserKey.class)
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long userNo;
    @Id
    private String userId;
    private String password;
    private Timestamp lastLoginDate;
    private Timestamp registedDate;
    private Timestamp updatedDate;
}
