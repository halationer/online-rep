/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50729
Source Host           : localhost:3306
Source Database       : shopping

Target Server Type    : MYSQL
Target Server Version : 50729
File Encoding         : 65001

Date: 2020-06-18 16:00:30
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------

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
-- Table structure for order_detial
-- ----------------------------
DROP TABLE IF EXISTS `order_detial`;
CREATE TABLE `order_detial` (
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
-- Records of order_detial
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
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_table
-- ----------------------------
INSERT INTO `user_table` VALUES ('1', '张三', '123456', '15485699999', '1256221875@qq.com', '0', '我是谁', '皮卡丘', '2020-06-15 12:48:30', '2020-06-15 12:48:59');
INSERT INTO `user_table` VALUES ('5', '李四', '85255695', '15548562658', '654654fa@163.com', '1', '我是谁', '杰尼龟', '2020-06-17 23:57:31', '2020-06-17 23:57:36');
INSERT INTO `user_table` VALUES ('8', '王麻子', 'fljfsoifj', '18956254447', 'foafje@qq.com', '1', '我是谁', '小鬼', '2020-06-10 23:58:37', '2020-06-18 23:58:41');
INSERT INTO `user_table` VALUES ('9', '张大', 'kkkel', '13985687456', '651fsaf5@163.com', '1', null, null, '2020-06-10 10:47:33', '2020-06-27 10:47:39');
INSERT INTO `user_table` VALUES ('10', 'Mike', 'lkfjaslk', null, null, '1', null, null, null, null);
INSERT INTO `user_table` VALUES ('11', 'eiei', 'lsaef3223', null, null, '1', null, null, null, null);
INSERT INTO `user_table` VALUES ('12', 'peipei', 'aldfj', null, null, '1', null, null, null, null);
INSERT INTO `user_table` VALUES ('13', '佩奇', 'afj654654/../.', null, null, '1', null, null, null, null);
INSERT INTO `user_table` VALUES ('14', '李黑', 'jafl85335&&^^', null, null, '1', null, null, null, null);
INSERT INTO `user_table` VALUES ('15', '2938j3roijeflk', '654654654\'\'\'', null, null, '1', null, null, null, null);
INSERT INTO `user_table` VALUES ('16', 'i飞机', 'eofjeof', null, null, '1', null, null, null, null);
INSERT INTO `user_table` VALUES ('17', '老罗', '55569898', null, null, '1', null, null, '2020-06-18 12:05:22', '2020-06-18 12:05:22');
