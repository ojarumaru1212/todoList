CREATE TABLE `mst_user` (
    `user_no` bigint NOT NULL AUTO_INCREMENT COMMENT "連番",
    `user_id` char(255) NOT NULL COMMENT "ユーザID",
    `password` char(255) NOT NULL COMMENT "パスワード",
    `last_login_date` datetime COMMENT "最終ログイン日時",
    `registed_date` datetime COMMENT "登録日時",
    `updated_date` datetime COMMENT "更新日時",
    PRIMARY KEY(user_no, user_id)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;