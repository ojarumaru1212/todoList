package com.todolist.api.domain.entity;

import java.io.Serializable;

import lombok.Data;

/**
 * ユーザマスタの主キー用 Entity
 */
@Data
public class UserKey implements Serializable {
    
	private Long userNo;
    private String userId;
}
