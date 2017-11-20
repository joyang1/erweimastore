USE `erweimastore`;

CREATE TABLE `admins` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NULL COMMENT '用户名 唯一',
  `nickname` varchar(45) NOT NULL COMMENT '昵称 可修改',
  `passwd` varchar(100) NULL DEFAULT '' COMMENT '密码',
  `type` varchar(10) NULL COMMENT '性别',
  `status` int(11) NOT NULL DEFAULT 1 COMMENT '状态 0-删除 1-正常',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8 COMMENT '管理员表';