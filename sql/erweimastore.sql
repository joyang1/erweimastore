USE `erweimastore`;

CREATE TABLE `admins` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NULL COMMENT '用户名 唯一',
  `nickname` varchar(45) NOT NULL COMMENT '昵称 可修改',
  `passwd` varchar(100) NOT NULL COMMENT '密码',
  `sex` varchar(10) NOT NULL DEFAULT '' COMMENT '性别 0-男 1-女',
  `type` varchar(10)  NOT NULL DEFAULT '0' COMMENT '管理员等级',
  `status` int(11) NOT NULL DEFAULT 1 COMMENT '状态 0-删除 1-正常',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8 COMMENT '管理员表';

INSERT INTO admins (id, name, nickname, passwd, sex) VALUES (1, 'admin', 'testadmin', '123456', '0');

CREATE TABLE `stores` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL COMMENT '店铺名 唯一',
  `url` varchar(45) NOT NULL DEFAULT ''COMMENT '店铺url',
  `qrCodePath` varchar(100) NOT NULL DEFAULT '' COMMENT '店铺二维码路径',
  PRIMARY KEY (`id`),
  UNIQUE (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8 COMMENT '店铺表';

CREATE TABLE `products` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL COMMENT '商品名 唯一',
  `picturePath` varchar(500) NOT NULL COMMENT '商品图片路径',
  `price` FLOAT NOT NULL COMMENT '商品价格',
  `percent` FLOAT NOT NULL COMMENT '商品折扣',
  `status` int(11) NOT NULL DEFAULT 1 COMMENT '状态 0-删除 1-正常',
  `storeName` varchar(100) NOT NULL COMMENT '所属店铺',
  PRIMARY KEY (`id`),
  UNIQUE (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8 COMMENT '商品表';