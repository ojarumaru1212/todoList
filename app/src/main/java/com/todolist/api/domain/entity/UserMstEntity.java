package com.todolist.api.domain.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.todolist.api.common.constant.DataBaseConstants;

import lombok.Data;

@Entity
@Data
@Table(name=DataBaseConstants.MST_USER)
public class UserMstEntity {
    @Id
    private Integer userNo;
    @Id
    private String userId;
    private String password;
    private String lastLoginDate;
    private String registedDate;
    private String updatedDate;
}
