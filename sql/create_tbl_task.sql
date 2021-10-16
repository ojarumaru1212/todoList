CREATE TABLE `tbl_task` (
    `task_no` bigint NOT NULL AUTO_INCREMENT COMMENT "連番",
    `title` char(255) NOT NULL COMMENT "タイトル",
    `detail` varchar(500) COMMENT "詳細",
    `remark` varchar(500) COMMENT "備考",
    `completed_flg` char(1) DEFAULT '0' COMMENT "完了フラグ",
    `deleted_flg` char(1) DEFAULT '0' COMMENT "削除フラグ",
    `registed_date` datetime COMMENT "登録日時",
    `updated_date` datetime COMMENT "更新日時",
    PRIMARY KEY(task_no, title)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;