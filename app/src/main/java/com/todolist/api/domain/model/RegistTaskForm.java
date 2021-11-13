package com.todolist.api.domain.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class RegistTaskForm {
	@NotEmpty(message = "{task.title.required}")
	@Size(min = 1, max = 100, message = "{task.title.length}")
	@Pattern(regexp = "^[a-zA-Z0-9!-/:\\[\\-@-`{-~|^\\x20-\\x7e]*", message = "{task.title.pattern}")
	private String title;

	@Size(min = 1, max = 500, message = "{task.detail.length}")
	@Pattern(regexp = "^[a-zA-Z0-9!-/:\\[\\-@-`{-~|^\\x20-\\x7e]*", message = "{task.detail.pattern}")
	private String detail;

	@Size(min = 1, max = 500, message = "{task.remark.length}")
	@Pattern(regexp = "^[a-zA-Z0-9!-/:\\[\\-@-`{-~|^\\x20-\\x7e]*", message = "{task.remark.pattern}")
	private String userId;

	private String remark;
	private String completedFlg;
	private String deletedFlg;
}
