/*
 Navicat Premium Data Transfer

 Source Server         : test_89
 Source Server Type    : MySQL
 Source Server Version : 50721
 Source Host           : 61.14.254.71
 Source Database       : app_put

 Target Server Type    : MySQL
 Target Server Version : 50721
 File Encoding         : utf-8

 Date: 06/02/2018 17:28:57 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

CREATE TABLE `dish_brand` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(40) DEFAULT NULL,
  `code` varchar(20) DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8


CREATE TABLE `dish_shop` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `brand_dish_id` bigint(20) DEFAULT NULL,
  `name` varchar(40) DEFAULT NULL,
  `code` varchar(20) DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_brand_dish_id` (`brand_dish_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8

-- ----------------------------
--  Table structure for `put_comment`
-- ----------------------------
DROP TABLE IF EXISTS `put_comment`;
CREATE TABLE `put_comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键Id',
  `user_id` int(11) NOT NULL COMMENT 'put_user id',
  `parent_id` int(11) DEFAULT NULL COMMENT '父级Id(评论回复Id)',
  `logo` varchar(80) DEFAULT NULL COMMENT '用户头像(url地址)',
  `nickname` varchar(80) DEFAULT NULL COMMENT '昵称',
  `type` tinyint(2) NOT NULL DEFAULT '0' COMMENT '类型 0 点赞 1 评论',
  `content` varchar(255) DEFAULT NULL COMMENT '评论内容',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=297 DEFAULT CHARSET=utf8 COMMENT='彩票用户评论(IOS上架用)';

-- ----------------------------
--  Table structure for `put_media`
-- ----------------------------
DROP TABLE IF EXISTS `put_media`;
CREATE TABLE `put_media` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `comment_id` int(11) NOT NULL COMMENT 'put_comment id',
  `file_name` varchar(80) DEFAULT NULL COMMENT '文件名',
  `file_size` int(10) DEFAULT NULL COMMENT '问价大小',
  `file_url` varchar(120) NOT NULL COMMENT '文件访问路径',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=105 DEFAULT CHARSET=utf8 COMMENT='图片';

-- ----------------------------
--  Table structure for `put_user`
-- ----------------------------
DROP TABLE IF EXISTS `put_user`;
CREATE TABLE `put_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `username` varchar(40) NOT NULL COMMENT '用户名',
  `password` varchar(32) NOT NULL COMMENT '密码',
  `salt` varchar(20) NOT NULL COMMENT '盐',
  `nickname` varchar(80) DEFAULT NULL COMMENT '昵称',
  `cellphone` varchar(15) DEFAULT NULL COMMENT '手机号',
  `logo` varchar(80) DEFAULT NULL COMMENT '用户头像(url地址)',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='用户注册表(IOS上架用)';

SET FOREIGN_KEY_CHECKS = 1;
