/*
Navicat MySQL Data Transfer

Source Server         : lwy
Source Server Version : 50525
Source Host           : localhost:3306
Source Database       : itforum

Target Server Type    : MYSQL
Target Server Version : 50525
File Encoding         : 65001

Date: 2017-10-13 17:17:03
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `reply`
-- ----------------------------
DROP TABLE IF EXISTS `reply`;
CREATE TABLE `reply` (
  `rid` int(11) NOT NULL AUTO_INCREMENT COMMENT '跟贴表ID',
  `rtid` int(11) NOT NULL COMMENT '回复主贴ID,外键(引用发贴表的TID)',
  `rsid` int(11) NOT NULL COMMENT '所在版块ID,外键(引用版块表的SID)',
  `ruid` int(11) NOT NULL COMMENT '发贴人ID,外键(引用用户表的UID)',
  `temotion` varchar(255) DEFAULT NULL COMMENT '发贴表情',
  `rcontent` varchar(255) NOT NULL COMMENT '回贴内容',
  `rtime` varchar(255) NOT NULL COMMENT '回贴时间',
  PRIMARY KEY (`rid`),
  KEY `r_t_id` (`rtid`),
  KEY `r_s_id` (`rsid`),
  KEY `r_u_id` (`ruid`),
  CONSTRAINT `r_u_id` FOREIGN KEY (`ruid`) REFERENCES `user` (`uid`),
  CONSTRAINT `r_s_id` FOREIGN KEY (`rsid`) REFERENCES `session` (`sid`),
  CONSTRAINT `r_t_id` FOREIGN KEY (`rtid`) REFERENCES `topic` (`tid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of reply
-- ----------------------------

-- ----------------------------
-- Table structure for `session`
-- ----------------------------
DROP TABLE IF EXISTS `session`;
CREATE TABLE `session` (
  `sid` int(11) NOT NULL AUTO_INCREMENT COMMENT '版块ID',
  `sname` varchar(255) NOT NULL COMMENT '版块名称,唯一',
  `smasterid` int(11) NOT NULL COMMENT '版主ID,外键(引用用户表的UID)',
  `sprofile` varchar(255) DEFAULT NULL COMMENT '版块主题',
  `sstatement` varchar(255) DEFAULT NULL COMMENT '本版留言',
  `stopiccount` int(11) DEFAULT NULL COMMENT '发贴数',
  `sclickcount` int(11) DEFAULT NULL COMMENT '点击率',
  PRIMARY KEY (`sid`),
  UNIQUE KEY `onlysname` (`sname`) USING BTREE,
  KEY `s_u_id` (`smasterid`),
  CONSTRAINT `s_u_id` FOREIGN KEY (`smasterid`) REFERENCES `user` (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of session
-- ----------------------------

-- ----------------------------
-- Table structure for `topic`
-- ----------------------------
DROP TABLE IF EXISTS `topic`;
CREATE TABLE `topic` (
  `tid` int(11) NOT NULL AUTO_INCREMENT COMMENT '发贴表ID',
  `tsid` int(11) NOT NULL COMMENT '所在版块,外键(引用版块表的SID)',
  `tuid` int(11) NOT NULL COMMENT '发贴人,外键(引用用户表的UID)',
  `treplycount` int(11) DEFAULT NULL COMMENT '回复数',
  `temotion` varchar(255) DEFAULT NULL COMMENT '发贴表情',
  `ttopic` varchar(255) NOT NULL COMMENT '标题',
  `tcontents` varchar(255) NOT NULL COMMENT '正文',
  `ttime` varchar(255) NOT NULL COMMENT '发贴时间',
  `tclickcount` int(11) DEFAULT NULL COMMENT '点击率',
  `tflag` int(11) DEFAULT NULL COMMENT '状态',
  `tlastreplyuseid` int(11) DEFAULT NULL COMMENT '最后回复用户ID,外键(引用用户表的UID)',
  `tlastreplaytime` varchar(0) DEFAULT NULL COMMENT '最后回复时间',
  PRIMARY KEY (`tid`),
  KEY `t_s_id` (`tsid`),
  KEY `t_u_id` (`tuid`),
  KEY `t_s_lastid` (`tlastreplyuseid`),
  CONSTRAINT `t_s_lastid` FOREIGN KEY (`tlastreplyuseid`) REFERENCES `user` (`uid`),
  CONSTRAINT `t_s_id` FOREIGN KEY (`tsid`) REFERENCES `session` (`sid`),
  CONSTRAINT `t_u_id` FOREIGN KEY (`tuid`) REFERENCES `user` (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of topic
-- ----------------------------

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uid` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `uname` varchar(255) NOT NULL COMMENT '用户昵称,唯一',
  `upassword` varchar(255) NOT NULL COMMENT '密码',
  `uemail` varchar(255) NOT NULL COMMENT '电子邮件,唯一',
  `uregdate` varchar(255) NOT NULL COMMENT '注册日期',
  `ubirthady` varchar(255) DEFAULT NULL COMMENT '生日',
  `usex` int(11) DEFAULT NULL COMMENT '性别',
  `uhead` varchar(255) DEFAULT NULL COMMENT '用户头像',
  `usatement` varchar(255) DEFAULT NULL COMMENT '用户备注',
  `ustate` int(11) DEFAULT NULL COMMENT '用户状态',
  `upoint` int(11) DEFAULT NULL COMMENT '用户积分',
  `uissectioner` int(11) DEFAULT NULL COMMENT '是否版主',
  PRIMARY KEY (`uid`),
  UNIQUE KEY `onlyemail` (`uemail`),
  UNIQUE KEY `onlyuname` (`uname`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('10', 'aaa', 'sss', '1233@qq.com', '9-12', 'ddd', '1', 'fff', 'ggg', '1', '1', '1');
