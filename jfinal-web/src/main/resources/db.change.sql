DROP TABLE IF EXISTS `sales`;
CREATE TABLE `sales` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `saller` varchar(255) DEFAULT NULL,
  `amount` int(11) DEFAULT NULL,
  `month` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sales
-- ----------------------------
INSERT INTO `sales` VALUES ('1', '张三', '10', '1');
INSERT INTO `sales` VALUES ('2', '李四', '20', '1');
INSERT INTO `sales` VALUES ('3', '王五', '30', '1');
INSERT INTO `sales` VALUES ('4', '赵六', '40', '1');
INSERT INTO `sales` VALUES ('5', '韩七', '50', '1');
