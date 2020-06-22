/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50729
Source Host           : localhost:3306
Source Database       : shopping

Target Server Type    : MYSQL
Target Server Version : 50729
File Encoding         : 65001

Date: 2020-06-22 22:41:07
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for address
-- ----------------------------
DROP TABLE IF EXISTS `address`;
CREATE TABLE `address` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `receiver_name` varchar(50) DEFAULT NULL,
  `receiver_phone` varchar(50) DEFAULT NULL,
  `receiver_mobile` varchar(11) DEFAULT NULL,
  `receiver_province` varchar(50) DEFAULT NULL,
  `receiver_city` varchar(50) DEFAULT NULL,
  `receiver_district` varchar(50) DEFAULT NULL,
  `receiver_address` varchar(255) DEFAULT NULL,
  `receiver_zip` varchar(50) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of address
-- ----------------------------

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `parent_id` int(11) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('1', '0', '服装', '1', '2020-06-22 11:22:32', '2020-06-22 11:22:32');
INSERT INTO `category` VALUES ('2', '0', '电子', '1', '2020-06-22 11:24:50', '2020-06-22 11:24:50');
INSERT INTO `category` VALUES ('3', '0', '家电', '1', '2020-06-22 11:24:50', '2020-06-22 11:24:50');
INSERT INTO `category` VALUES ('4', '0', '运动', '1', '2020-06-22 11:24:50', '2020-06-22 11:24:50');
INSERT INTO `category` VALUES ('5', '0', '学习', '1', '2020-06-22 11:24:50', '2020-06-22 11:24:50');
INSERT INTO `category` VALUES ('6', '0', '首饰', '1', '2020-06-22 11:24:50', '2020-06-22 11:24:50');
INSERT INTO `category` VALUES ('7', '0', '家具', '1', '2020-06-22 11:24:50', '2020-06-22 11:24:50');
INSERT INTO `category` VALUES ('8', '1', '男装', '1', '2020-06-22 11:25:50', '2020-06-22 11:25:50');
INSERT INTO `category` VALUES ('9', '1', '女装', '1', '2020-06-22 11:25:50', '2020-06-22 11:25:50');
INSERT INTO `category` VALUES ('10', '1', '童装', '1', '2020-06-22 11:25:50', '2020-06-22 11:25:50');
INSERT INTO `category` VALUES ('11', '5', '文具', '1', '2020-06-22 11:27:21', '2020-06-22 11:27:21');
INSERT INTO `category` VALUES ('12', '5', '书籍', '1', '2020-06-22 11:27:21', '2020-06-22 11:27:21');
INSERT INTO `category` VALUES ('13', '12', '课本', '1', '2020-06-22 11:28:31', '2020-06-22 11:28:31');
INSERT INTO `category` VALUES ('14', '12', '练习册', '1', '2020-06-22 11:28:31', '2020-06-22 11:28:31');
INSERT INTO `category` VALUES ('15', '12', '课外读物', '1', '2020-06-22 11:28:31', '2020-06-22 11:28:31');
INSERT INTO `category` VALUES ('23', '2', '电脑', '1', '2020-06-22 14:17:37', '2020-06-22 14:17:37');
INSERT INTO `category` VALUES ('28', '2', '电子手表', '1', '2020-06-22 15:02:21', '2020-06-22 15:02:34');
INSERT INTO `category` VALUES ('29', '1', '汉服', '1', '2020-06-22 15:05:48', '2020-06-22 15:06:01');
INSERT INTO `category` VALUES ('30', '4', '球类', '1', '2020-06-22 15:08:39', '2020-06-22 15:09:08');
INSERT INTO `category` VALUES ('31', '1', '洛丽塔', '1', '2020-06-22 15:11:49', '2020-06-22 15:12:00');
INSERT INTO `category` VALUES ('32', '3', '洗衣机', '1', '2020-06-22 15:12:46', '2020-06-22 15:15:44');
INSERT INTO `category` VALUES ('33', '8', '未命名', '0', '2020-06-22 15:17:34', '2020-06-22 15:26:55');
INSERT INTO `category` VALUES ('34', '7', '衣柜', '1', '2020-06-22 15:22:53', '2020-06-22 15:23:15');
INSERT INTO `category` VALUES ('35', '6', '项链', '1', '2020-06-22 15:28:20', '2020-06-22 15:28:32');
INSERT INTO `category` VALUES ('36', '6', '戒指', '1', '2020-06-22 15:28:35', '2020-06-22 15:28:42');
INSERT INTO `category` VALUES ('37', '35', '未命名', '0', '2020-06-22 15:50:47', '2020-06-22 16:17:48');
INSERT INTO `category` VALUES ('38', '36', '未命名', '0', '2020-06-22 15:50:51', '2020-06-22 16:45:09');
INSERT INTO `category` VALUES ('39', '38', '未命名', '0', '2020-06-22 16:26:15', '2020-06-22 16:27:22');
INSERT INTO `category` VALUES ('40', '38', '未命', '0', '2020-06-22 16:44:51', '2020-06-22 16:45:06');

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `category_id` int(11) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `subtitle` varchar(50) DEFAULT NULL,
  `main_image` varchar(255) DEFAULT NULL,
  `sub_image` varchar(255) DEFAULT NULL,
  `detail` varchar(255) DEFAULT NULL,
  `price` decimal(20,2) DEFAULT NULL,
  `stock` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods
-- ----------------------------

-- ----------------------------
-- Table structure for order_detail
-- ----------------------------
DROP TABLE IF EXISTS `order_detail`;
CREATE TABLE `order_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_no` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  `product_name` varchar(50) DEFAULT NULL,
  `product_image` varchar(255) DEFAULT NULL,
  `current_unit_price` decimal(20,2) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `total_price` decimal(20,2) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `order_no` (`order_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_detail
-- ----------------------------

-- ----------------------------
-- Table structure for order_table
-- ----------------------------
DROP TABLE IF EXISTS `order_table`;
CREATE TABLE `order_table` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_no` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `shipping_id` int(11) DEFAULT NULL,
  `payment` decimal(20,2) DEFAULT NULL,
  `payment_type` int(11) DEFAULT NULL,
  `postage` decimal(20,2) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `payment_time` datetime DEFAULT NULL,
  `send_time` datetime DEFAULT NULL,
  `end_time` datetime DEFAULT NULL,
  `close_time` datetime DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `order_no` (`order_no`) USING BTREE,
  KEY `user_id` (`order_no`,`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_table
-- ----------------------------

-- ----------------------------
-- Table structure for pay
-- ----------------------------
DROP TABLE IF EXISTS `pay`;
CREATE TABLE `pay` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `order_no` int(11) DEFAULT NULL,
  `pay_platform` int(11) DEFAULT NULL,
  `platform_number` varchar(255) DEFAULT NULL,
  `platform_status` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pay
-- ----------------------------

-- ----------------------------
-- Table structure for shopping_cart
-- ----------------------------
DROP TABLE IF EXISTS `shopping_cart`;
CREATE TABLE `shopping_cart` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  `quantity` int(11) DEFAULT NULL,
  `checked` tinyint(1) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shopping_cart
-- ----------------------------

-- ----------------------------
-- Table structure for user_table
-- ----------------------------
DROP TABLE IF EXISTS `user_table`;
CREATE TABLE `user_table` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone` varchar(11) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `role` int(11) DEFAULT NULL,
  `question` varchar(50) DEFAULT NULL,
  `answer` varchar(50) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_table
-- ----------------------------
INSERT INTO `user_table` VALUES ('1', '张三', '123456', '15485699999', '1256221875@qq.com', '0', '我是谁', '皮卡丘', '2020-06-15 12:48:30', '2020-06-15 12:48:59');
INSERT INTO `user_table` VALUES ('5', '李四', '85255695', '15548562658', '654654fa@163.com', '1', '我是谁', '杰尼龟', '2020-06-17 23:57:31', '2020-06-17 23:57:36');
INSERT INTO `user_table` VALUES ('8', '王麻子', 'fljfsoifj', '18956254447', 'foafje@qq.com', '1', '我是谁', '小鬼', '2020-06-10 23:58:37', '2020-06-18 23:58:41');
INSERT INTO `user_table` VALUES ('9', '张大', 'kkkel', '13985687456', '651fsaf5@163.com', '1', null, null, '2020-06-10 10:47:33', '2020-06-27 10:47:39');
INSERT INTO `user_table` VALUES ('10', 'Mike', 'lkfjaslk', null, null, '1', null, null, null, null);
INSERT INTO `user_table` VALUES ('12', 'peipei', 'aldfj', null, null, '1', null, null, null, null);
INSERT INTO `user_table` VALUES ('13', '佩奇', 'afj654654/../.', null, null, '1', null, null, null, null);
INSERT INTO `user_table` VALUES ('14', '李黑', 'jafl85335&&^^', null, null, '1', null, null, null, null);
INSERT INTO `user_table` VALUES ('15', '2938j3roijeflk', '654654654\'\'\'', null, null, '1', null, null, null, null);
INSERT INTO `user_table` VALUES ('16', 'i飞机', 'eofjeof', null, null, '1', null, null, null, null);
INSERT INTO `user_table` VALUES ('17', '老罗', '55569898', null, null, '1', null, null, '2020-06-18 12:05:22', '2020-06-18 12:05:22');
INSERT INTO `user_table` VALUES ('18', 'abc', '123456', null, null, '1', null, null, null, null);
INSERT INTO `user_table` VALUES ('19', 'test001', '123456', '1234567809', '123456@qq.com', '0', '你印象最深刻的老师是谁？', 'test001', null, null);
INSERT INTO `user_table` VALUES ('20', 'test002', '123456', '15169563670', '3474339885@qq.com', '0', '你印象最深刻的老师是谁？', 'test002', null, null);
INSERT INTO `user_table` VALUES ('21', '喻言', '111', '13393346124', '287624073@qq.com', '0', '你印象最深刻的老师是谁？', '蔡徐坤', null, null);
INSERT INTO `user_table` VALUES ('22', '刘罗锅', '123456', '18596548752', '1568526489@163.com', '1', '你印象最深刻的老师是谁？', '嘿嘿', '2020-06-19 11:07:12', '2020-06-19 11:07:12');
INSERT INTO `user_table` VALUES ('23', 'z罗', '654654654', '18596464644', '15688585@163.com', '1', '你印象最深刻的老师是谁？', 'hahfei', '2020-06-19 12:52:13', '2020-06-19 12:52:13');
INSERT INTO `user_table` VALUES ('24', 'z罗Luo', 'fefeewfowi3j330fjii', '18569554444', 'fe3333@qq.com', '1', '你印象最深刻的老师是谁？', '很饿', '2020-06-19 12:54:48', '2020-06-19 12:54:48');
INSERT INTO `user_table` VALUES ('25', '不列', '3213265', '18596489845', '1568526fff@163.com', '1', '你印象最深刻的老师是谁？', 'nana', '2020-06-19 13:02:10', '2020-06-19 13:02:10');
INSERT INTO `user_table` VALUES ('26', '刘罗锅aa', 'ffsdfsdf', '', '', '1', '你印象最深刻的老师是谁？', '', '2020-06-19 13:04:29', '2020-06-19 13:04:29');
INSERT INTO `user_table` VALUES ('27', 'z罗kk', '654654', '18589448752', '1ffse6489@163.com', '1', '你印象最深刻的老师是谁？', '嘿嘿f', '2020-06-19 13:32:37', '2020-06-19 13:32:37');
