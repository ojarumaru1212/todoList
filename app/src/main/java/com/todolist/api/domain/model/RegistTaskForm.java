package com.todolist.api.domain.model;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class RegistTaskForm {
    private String title;
    private String userId;
    private String detail;
    private String remark;
    private String completedFlg;
    private String deletedFlg;
}
