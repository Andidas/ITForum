/*
Navicat MySQL Data Transfer

Source Server         : lwy
Source Server Version : 50525
Source Host           : localhost:3306
Source Database       : itforum

Target Server Type    : MYSQL
Target Server Version : 50525
File Encoding         : 65001

Date: 2017-12-17 18:16:16
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `follow`
-- ----------------------------
DROP TABLE IF EXISTS `follow`;
CREATE TABLE `follow` (
  `fid` int(11) NOT NULL AUTO_INCREMENT COMMENT '关注表的id',
  `uid` int(11) DEFAULT NULL COMMENT '用户id',
  `sid` int(11) DEFAULT NULL COMMENT '被关注的session',
  PRIMARY KEY (`fid`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of follow
-- ----------------------------
INSERT INTO `follow` VALUES ('18', '16', '10');
INSERT INTO `follow` VALUES ('20', '16', '11');
INSERT INTO `follow` VALUES ('21', '16', '13');
INSERT INTO `follow` VALUES ('22', '16', '15');
INSERT INTO `follow` VALUES ('23', '16', '12');
INSERT INTO `follow` VALUES ('25', '16', '9');
INSERT INTO `follow` VALUES ('27', '16', '3');

-- ----------------------------
-- Table structure for `it_admin`
-- ----------------------------
DROP TABLE IF EXISTS `it_admin`;
CREATE TABLE `it_admin` (
  `aid` int(11) NOT NULL AUTO_INCREMENT,
  `aname` varchar(255) NOT NULL,
  `apassword` varchar(255) NOT NULL,
  PRIMARY KEY (`aid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of it_admin
-- ----------------------------
INSERT INTO `it_admin` VALUES ('1', 'lwy', '123456');
INSERT INTO `it_admin` VALUES ('2', 'admin', 'admin');

-- ----------------------------
-- Table structure for `lzl_reply`
-- ----------------------------
DROP TABLE IF EXISTS `lzl_reply`;
CREATE TABLE `lzl_reply` (
  `lid` int(11) NOT NULL AUTO_INCREMENT,
  `lrid` int(11) NOT NULL,
  `luid` int(11) NOT NULL,
  `lcontent` varchar(255) NOT NULL,
  `ltime` varchar(255) NOT NULL,
  PRIMARY KEY (`lid`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lzl_reply
-- ----------------------------
INSERT INTO `lzl_reply` VALUES ('14', '1', '30', '你的回帖也太简单了吧', '12-13');
INSERT INTO `lzl_reply` VALUES ('15', '3', '16', '还不错', '2017-12-13 22:38:26');
INSERT INTO `lzl_reply` VALUES ('16', '1', '30', '你的回帖也太简单了吧', '12-13');
INSERT INTO `lzl_reply` VALUES ('17', '3', '16', '还不错', '2017-12-13 23:07:00');
INSERT INTO `lzl_reply` VALUES ('18', '3', '16', '还不错', '2017-12-13 23:08:39');
INSERT INTO `lzl_reply` VALUES ('19', '76', '16', '123132', '2017-12-14 15:40:18');
INSERT INTO `lzl_reply` VALUES ('20', '76', '16', 'esowfh', '2017-12-14 20:13:02');
INSERT INTO `lzl_reply` VALUES ('21', '76', '16', '897', '2017-12-14 20:18:46');
INSERT INTO `lzl_reply` VALUES ('22', '37', '16', '终于可以回复 了\n', '2017-12-14 20:19:45');
INSERT INTO `lzl_reply` VALUES ('23', '37', '16', '[可爱]', '2017-12-14 20:23:06');
INSERT INTO `lzl_reply` VALUES ('24', '76', '16', '[img/face/36_衰.gif]', '2017-12-14 20:52:52');
INSERT INTO `lzl_reply` VALUES ('26', '76', '16', '21654', '2017-12-14 21:30:56');
INSERT INTO `lzl_reply` VALUES ('27', '76', '16', 'hhjhuj', '2017-12-14 21:42:59');
INSERT INTO `lzl_reply` VALUES ('28', '37', '30', '11111', '2017-12-14 21:43:55');
INSERT INTO `lzl_reply` VALUES ('29', '36', '30', '很烦', '2017-12-14 21:59:53');
INSERT INTO `lzl_reply` VALUES ('31', '82', '16', '你这是什么', '2017-12-17 17:32:07');

-- ----------------------------
-- Table structure for `private_letter`
-- ----------------------------
DROP TABLE IF EXISTS `private_letter`;
CREATE TABLE `private_letter` (
  `pid` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `friend_id` int(11) NOT NULL,
  `puid` int(11) NOT NULL,
  `ptouid` int(11) NOT NULL,
  `message_type` int(11) NOT NULL DEFAULT '1',
  `ptime` varchar(255) DEFAULT NULL,
  `pcontent` varchar(255) DEFAULT NULL,
  `pstatus` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=144 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of private_letter
-- ----------------------------
INSERT INTO `private_letter` VALUES ('38', '31', '16', '31', '16', '1', '2017-11-30 20:41:10', '我也是', '2');
INSERT INTO `private_letter` VALUES ('41', '32', '16', '16', '32', '1', '2017-11-30 20:48:01', '你是？', '1');
INSERT INTO `private_letter` VALUES ('42', '31', '16', '31', '16', '1', '2017-11-30 20:48:02', '我是程序员', '2');
INSERT INTO `private_letter` VALUES ('44', '32', '16', '32', '16', '1', '2017-12-04 22:10:25', '我是一个软件工程师', '1');
INSERT INTO `private_letter` VALUES ('46', '32', '16', '32', '16', '1', '2017-12-04 22:11:15', '你呢？做什么的？', '1');
INSERT INTO `private_letter` VALUES ('49', '32', '16', '16', '32', '1', '2017-12-04 22:12:21', '好巧呀~我也是做这行的', '1');
INSERT INTO `private_letter` VALUES ('51', '31', '16', '16', '31', '1', '2017-12-04 22:13:04', '我也是', '2');
INSERT INTO `private_letter` VALUES ('53', '32', '16', '16', '32', '1', '2017-12-04 22:16:44', '你在哪里从事工作', '1');
INSERT INTO `private_letter` VALUES ('55', '32', '16', '16', '32', '1', '2017-12-04 22:17:18', '我在深圳，你呢', '1');
INSERT INTO `private_letter` VALUES ('56', '32', '16', '32', '16', '1', '2017-12-04 22:17:43', '我在福州呢', '1');
INSERT INTO `private_letter` VALUES ('58', '32', '30', '32', '30', '1', '2017-12-04 22:31:52', '您好，有事请教您', '1');
INSERT INTO `private_letter` VALUES ('59', '30', '32', '32', '30', '1', '2017-12-04 22:31:52', '您好，有事请教您', '2');
INSERT INTO `private_letter` VALUES ('60', '16', '30', '16', '30', '1', '2017-12-04 22:38:23', '您好', '2');
INSERT INTO `private_letter` VALUES ('61', '30', '16', '16', '30', '1', '2017-12-04 22:38:23', '您好', '1');
INSERT INTO `private_letter` VALUES ('62', '16', '30', '16', '30', '1', '2017-12-04 22:38:31', '您好', '2');
INSERT INTO `private_letter` VALUES ('63', '30', '16', '16', '30', '1', '2017-12-04 22:38:31', '您好', '1');
INSERT INTO `private_letter` VALUES ('65', '32', '16', '16', '32', '1', '2017-12-14 22:25:03', '这样子哦', '1');
INSERT INTO `private_letter` VALUES ('67', '32', '16', '16', '32', '1', '2017-12-14 22:27:06', '这样子哦', '1');
INSERT INTO `private_letter` VALUES ('69', '30', '16', '16', '30', '1', '2017-12-14 22:27:43', '您好，请问在吗', '1');
INSERT INTO `private_letter` VALUES ('70', '30', '32', '30', '32', '1', '2017-12-14 22:28:33', '什么事情', '2');
INSERT INTO `private_letter` VALUES ('71', '32', '30', '30', '32', '1', '2017-12-14 22:28:33', '什么事情', '1');
INSERT INTO `private_letter` VALUES ('72', '30', '32', '30', '32', '1', '2017-12-14 22:29:47', '什么事情', '2');
INSERT INTO `private_letter` VALUES ('73', '32', '30', '30', '32', '1', '2017-12-14 22:29:47', '什么事情', '1');
INSERT INTO `private_letter` VALUES ('75', '31', '16', '16', '31', '1', '2017-12-17 15:05:59', '您好', '1');
INSERT INTO `private_letter` VALUES ('77', '31', '16', '16', '31', '1', '2017-12-17 15:06:15', '请问在吗', '1');
INSERT INTO `private_letter` VALUES ('78', '16', '30', '16', '30', '1', '2017-12-17 15:06:46', '嗨咯', '2');
INSERT INTO `private_letter` VALUES ('79', '30', '16', '16', '30', '1', '2017-12-17 15:06:46', '嗨咯', '1');
INSERT INTO `private_letter` VALUES ('81', '30', '16', '16', '30', '1', '2017-12-17 15:07:54', '哈哈哈', '1');
INSERT INTO `private_letter` VALUES ('83', '30', '16', '16', '30', '1', '2017-12-17 15:08:05', '哈哈哈', '1');
INSERT INTO `private_letter` VALUES ('85', '30', '16', '16', '30', '1', '2017-12-17 15:08:12', '哈哈哈', '1');
INSERT INTO `private_letter` VALUES ('87', '30', '16', '16', '30', '1', '2017-12-17 15:08:40', '哈哈哈', '1');
INSERT INTO `private_letter` VALUES ('89', '32', '16', '16', '32', '1', '2017-12-17 15:08:53', '在吗', '1');
INSERT INTO `private_letter` VALUES ('91', '32', '16', '16', '32', '1', '2017-12-17 15:09:03', '在吗', '1');
INSERT INTO `private_letter` VALUES ('93', '32', '16', '16', '32', '1', '2017-12-17 15:09:13', '在吗', '1');
INSERT INTO `private_letter` VALUES ('95', '31', '16', '16', '31', '1', '2017-12-17 15:09:29', '宁噶', '1');
INSERT INTO `private_letter` VALUES ('97', '31', '16', '16', '31', '1', '2017-12-17 15:09:42', '132132', '1');
INSERT INTO `private_letter` VALUES ('99', '31', '16', '16', '31', '1', '2017-12-17 15:09:57', '132132', '1');
INSERT INTO `private_letter` VALUES ('101', '31', '16', '16', '31', '1', '2017-12-17 15:13:41', '132132', '1');
INSERT INTO `private_letter` VALUES ('103', '32', '16', '16', '32', '1', '2017-12-17 15:35:39', '你好', '1');
INSERT INTO `private_letter` VALUES ('104', '31', '16', '31', '16', '1', '2017-12-17 15:35:39', '我是程序员', '1');
INSERT INTO `private_letter` VALUES ('107', '31', '16', '16', '31', '1', '2017-12-17 16:02:07', '您好\r\n', '1');
INSERT INTO `private_letter` VALUES ('109', '32', '16', '16', '32', '1', '2017-12-17 16:02:21', '你在吗', '1');
INSERT INTO `private_letter` VALUES ('110', '16', '30', '16', '30', '1', '2017-12-17 16:06:39', '你好', '2');
INSERT INTO `private_letter` VALUES ('111', '30', '16', '16', '30', '1', '2017-12-17 16:06:39', '你好', '1');
INSERT INTO `private_letter` VALUES ('113', '32', '16', '16', '32', '1', '2017-12-17 16:06:48', '你好', '1');
INSERT INTO `private_letter` VALUES ('115', '31', '16', '16', '31', '1', '2017-12-17 16:06:59', '你在干嘛呢', '1');
INSERT INTO `private_letter` VALUES ('117', '31', '16', '16', '31', '1', '2017-12-17 16:07:22', '你在干嘛呢', '1');
INSERT INTO `private_letter` VALUES ('119', '31', '16', '16', '31', '1', '2017-12-17 16:08:28', '你在干嘛呢', '1');
INSERT INTO `private_letter` VALUES ('121', '31', '16', '16', '31', '1', '2017-12-17 16:33:12', '你在干嘛呢', '1');
INSERT INTO `private_letter` VALUES ('123', '31', '16', '16', '31', '1', '2017-12-17 16:33:14', '你在干嘛呢', '1');
INSERT INTO `private_letter` VALUES ('125', '31', '16', '16', '31', '1', '2017-12-17 16:33:15', '你在干嘛呢', '1');
INSERT INTO `private_letter` VALUES ('127', '31', '16', '16', '31', '1', '2017-12-17 16:33:17', '你在干嘛呢', '1');
INSERT INTO `private_letter` VALUES ('129', '31', '16', '16', '31', '1', '2017-12-17 16:33:26', '你在干嘛呢', '1');
INSERT INTO `private_letter` VALUES ('131', '31', '16', '16', '31', '1', '2017-12-17 16:33:43', '你在干嘛呢', '1');
INSERT INTO `private_letter` VALUES ('133', '31', '16', '16', '31', '1', '2017-12-17 16:33:49', '你在干嘛呢', '1');
INSERT INTO `private_letter` VALUES ('135', '31', '16', '16', '31', '1', '2017-12-17 16:34:00', '你在干嘛呢', '1');
INSERT INTO `private_letter` VALUES ('137', '31', '16', '16', '31', '1', '2017-12-17 16:34:03', '你在干嘛呢', '1');
INSERT INTO `private_letter` VALUES ('139', '31', '16', '16', '31', '1', '2017-12-17 16:34:13', '你在干嘛呢', '1');
INSERT INTO `private_letter` VALUES ('141', '31', '16', '16', '31', '1', '2017-12-17 16:34:19', '你在干嘛呢', '1');
INSERT INTO `private_letter` VALUES ('142', '16', '31', '16', '31', '1', '2017-12-17 16:59:05', '你好', '2');
INSERT INTO `private_letter` VALUES ('143', '31', '16', '16', '31', '1', '2017-12-17 16:59:05', '你好', '1');

-- ----------------------------
-- Table structure for `reply`
-- ----------------------------
DROP TABLE IF EXISTS `reply`;
CREATE TABLE `reply` (
  `rid` int(11) NOT NULL AUTO_INCREMENT COMMENT '跟贴表ID',
  `rtid` int(11) NOT NULL COMMENT '回复主贴ID,外键(引用发贴表的TID)',
  `rsid` int(11) NOT NULL COMMENT '所在版块ID,外键(引用版块表的SID)',
  `ruid` int(11) NOT NULL COMMENT '发贴人ID,外键(引用用户表的UID)',
  `rfavour` int(11) DEFAULT '0' COMMENT '点赞数',
  `rcontent` text NOT NULL COMMENT '回贴内容',
  `rtime` varchar(255) NOT NULL COMMENT '回贴时间',
  PRIMARY KEY (`rid`),
  KEY `r_t_id` (`rtid`),
  KEY `r_s_id` (`rsid`),
  KEY `r_u_id` (`ruid`),
  CONSTRAINT `r_s_id` FOREIGN KEY (`rsid`) REFERENCES `session` (`sid`),
  CONSTRAINT `r_t_id` FOREIGN KEY (`rtid`) REFERENCES `topic` (`tid`),
  CONSTRAINT `r_u_id` FOREIGN KEY (`ruid`) REFERENCES `user` (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=92 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of reply
-- ----------------------------
INSERT INTO `reply` VALUES ('3', '82', '12', '16', '0', '<p>水贴</p>', '2017-11-08 11:23:25');
INSERT INTO `reply` VALUES ('7', '68', '9', '16', '0', '<p>回个水贴</p>', '2017-11-08 16:25:34');
INSERT INTO `reply` VALUES ('8', '67', '9', '16', '0', '<p>这是什么鬼帖子</p>', '2017-11-08 16:29:05');
INSERT INTO `reply` VALUES ('9', '69', '9', '16', '0', '<p>我看得懂也</p>', '2017-11-08 16:31:15');
INSERT INTO `reply` VALUES ('32', '67', '9', '31', '0', '<p>我又来了</p>', '2017-11-09 19:23:06');
INSERT INTO `reply` VALUES ('33', '87', '11', '31', '0', '<p>怎么回事</p>', '2017-11-09 20:18:43');
INSERT INTO `reply` VALUES ('36', '89', '9', '16', '0', '<p>真是不敢相信</p>', '2017-11-09 21:13:55');
INSERT INTO `reply` VALUES ('37', '89', '9', '31', '0', '<p>妹zi哦</p>', '2017-11-09 21:15:21');
INSERT INTO `reply` VALUES ('75', '68', '9', '32', '0', '<p>今天太阳好大呀</p><p>out.print(\"yes~ not \");</p>', '2017-11-10 14:29:20');
INSERT INTO `reply` VALUES ('76', '89', '9', '30', '0', '<p>太有了</p>', '2017-11-10 15:20:46');
INSERT INTO `reply` VALUES ('77', '94', '10', '16', '0', '<p>实现了工厂类</p>', '2017-11-16 21:25:41');
INSERT INTO `reply` VALUES ('78', '98', '10', '30', '0', '<a href=\"http://blog.csdn.net/\" target=\"_blank\">点一下这个链接</a>', '2017-11-23 13:35:36');
INSERT INTO `reply` VALUES ('79', '107', '3', '16', '0', '<p>你不知道吗？是罗贯中</p>', '2017-12-17 17:17:00');
INSERT INTO `reply` VALUES ('80', '107', '3', '16', '0', '<p>真的不知道？</p>', '2017-12-17 17:17:33');
INSERT INTO `reply` VALUES ('82', '108', '4', '16', '0', '<p>回帖子咯</p>', '2017-12-17 17:19:29');
INSERT INTO `reply` VALUES ('83', '108', '4', '16', '0', '<p>嗨咯</p>', '2017-12-17 17:54:43');
INSERT INTO `reply` VALUES ('84', '108', '4', '16', '0', '<p>登录了</p><p><br></p>', '2017-12-17 18:06:02');
INSERT INTO `reply` VALUES ('85', '108', '4', '16', '0', '<p>怎么回事</p>', '2017-12-17 18:06:22');
INSERT INTO `reply` VALUES ('86', '108', '4', '16', '0', '<p>你都不懂我怎么动</p>', '2017-12-17 18:07:17');
INSERT INTO `reply` VALUES ('91', '106', '3', '16', '0', '<p>天真</p>', '2017-12-17 18:14:06');

-- ----------------------------
-- Table structure for `sensitive_word`
-- ----------------------------
DROP TABLE IF EXISTS `sensitive_word`;
CREATE TABLE `sensitive_word` (
  `wid` int(11) NOT NULL AUTO_INCREMENT,
  `word` varchar(255) NOT NULL,
  PRIMARY KEY (`wid`),
  UNIQUE KEY `u_word` (`word`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sensitive_word
-- ----------------------------
INSERT INTO `sensitive_word` VALUES ('16', 'AV');
INSERT INTO `sensitive_word` VALUES ('17', 'sex');
INSERT INTO `sensitive_word` VALUES ('15', '反中国');
INSERT INTO `sensitive_word` VALUES ('3', '反共');
INSERT INTO `sensitive_word` VALUES ('5', '国名党');
INSERT INTO `sensitive_word` VALUES ('4', '红四军');
INSERT INTO `sensitive_word` VALUES ('6', '董存润');

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
  `stopiccount` int(11) DEFAULT '0' COMMENT '发贴数',
  `sclickcount` int(11) DEFAULT '0' COMMENT '点击率',
  `spicture` varchar(255) DEFAULT NULL COMMENT '头像',
  PRIMARY KEY (`sid`),
  UNIQUE KEY `onlysname` (`sname`) USING BTREE,
  KEY `s_u_id` (`smasterid`),
  CONSTRAINT `s_u_id` FOREIGN KEY (`smasterid`) REFERENCES `user` (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of session
-- ----------------------------
INSERT INTO `session` VALUES ('1', 'html5', '16', '前端开发', 'i am html5', '0', '12', 'code_by_rasmusir-d4a4dj2.jpg');
INSERT INTO `session` VALUES ('3', 'JQuery', '16', '前端开发', '去掉复杂', '0', '49', 'code-wallpaper-18.png');
INSERT INTO `session` VALUES ('4', 'CSS3', '16', '前端开发', '有问题不防看看隔壁的 css', '0', '8', 'code-wallpaper-6.png');
INSERT INTO `session` VALUES ('5', 'JavaScript', '16', '前端开发', '永远不要小看任何人', '0', '3', 'ITForum.jpg');
INSERT INTO `session` VALUES ('6', 'Bootstrap', '16', '前端开发', null, '0', '0', null);
INSERT INTO `session` VALUES ('7', 'Font Awesome', '16', '前端开发', null, '0', '0', null);
INSERT INTO `session` VALUES ('8', 'Foundation', '16', '前端开发', '这世界并不简单。', '0', '3', 'ITForum.jpg');
INSERT INTO `session` VALUES ('9', 'JAVA', '16', '后端开发', '金钱与未来，你的选择是什么？', '13', '519', 'code-wallpaper-8.jpg');
INSERT INTO `session` VALUES ('10', 'PHP', '16', '后端开发', null, '6', '181', null);
INSERT INTO `session` VALUES ('11', 'SpringBoot', '30', '后端开发', null, '4', '75', null);
INSERT INTO `session` VALUES ('12', 'Python', '31', '后端开发', null, '3', '31', null);
INSERT INTO `session` VALUES ('13', 'C', '32', '后端开发', null, '1', '36', null);
INSERT INTO `session` VALUES ('15', 'Go', '16', '后端开发', null, '1', '19', null);
INSERT INTO `session` VALUES ('25', 'Ruby', '16', '后端开发', null, '0', '0', null);
INSERT INTO `session` VALUES ('26', 'Android', '30', '移动开发', null, '0', '0', null);
INSERT INTO `session` VALUES ('27', 'ISO', '30', '移动开发', null, '0', '0', null);
INSERT INTO `session` VALUES ('28', 'Unity3D', '30', '移动开发', null, '0', '0', null);
INSERT INTO `session` VALUES ('29', 'Cocos2D', '30', '移动开发', null, '0', '0', null);
INSERT INTO `session` VALUES ('30', 'Oracle', '30', '数据库', null, '1', '19', null);
INSERT INTO `session` VALUES ('31', 'MySQL', '16', '数据库', null, '0', '1', null);
INSERT INTO `session` VALUES ('32', 'MongoDB', '16', '数据库', null, '0', '0', null);
INSERT INTO `session` VALUES ('33', 'SQLServle', '16', '数据库', null, '0', '8', null);
INSERT INTO `session` VALUES ('34', 'Redis', '16', '数据库', null, '0', '2', null);
INSERT INTO `session` VALUES ('35', 'Eclipse', '30', '开发工具', null, '0', '0', null);
INSERT INTO `session` VALUES ('36', 'Git', '30', '开发工具', null, '0', '0', null);
INSERT INTO `session` VALUES ('37', 'Svn', '30', '开发工具', null, '0', '0', null);
INSERT INTO `session` VALUES ('38', 'HTTP', '30', '网站建设', ' ', '0', '1', null);
INSERT INTO `session` VALUES ('40', 'PhotoShop', '30', 'UI设计', null, '0', '1', null);
INSERT INTO `session` VALUES ('41', 'Linux', '30', '运维', null, '0', '0', null);
INSERT INTO `session` VALUES ('42', 'Junit', '30', '测试', null, '0', '0', null);
INSERT INTO `session` VALUES ('43', 'Hadoop', '30', '大数据', null, '0', '0', null);
INSERT INTO `session` VALUES ('44', 'DevOps', '30', '云计算', null, '0', '0', null);
INSERT INTO `session` VALUES ('46', 'Google', '16', '搜索引擎', '谷歌搜索', '0', '23', 'google.jpg');
INSERT INTO `session` VALUES ('47', 'html', '16', '前端开发', 'i am html', '0', '2', 'google.jpg');

-- ----------------------------
-- Table structure for `topic`
-- ----------------------------
DROP TABLE IF EXISTS `topic`;
CREATE TABLE `topic` (
  `tid` int(11) NOT NULL AUTO_INCREMENT COMMENT '发贴表ID',
  `tsid` int(11) NOT NULL COMMENT '所在版块,外键(引用版块表的SID)',
  `tuid` int(11) NOT NULL COMMENT '发贴人,外键(引用用户表的UID)',
  `treplycount` int(11) DEFAULT '0' COMMENT '回复数',
  `temotion` varchar(255) DEFAULT NULL COMMENT '发贴表情',
  `ttopic` varchar(255) NOT NULL COMMENT '标题',
  `tcontents` text NOT NULL COMMENT '正文',
  `ttime` varchar(255) NOT NULL COMMENT '发贴时间',
  `tclickcount` int(11) DEFAULT '0' COMMENT '点击率',
  `tflag` int(11) DEFAULT NULL COMMENT '状态',
  `tlastreplyuseid` int(11) DEFAULT NULL COMMENT '最后回复用户ID,外键(引用用户表的UID)',
  `tlastreplaytime` varchar(255) DEFAULT NULL COMMENT '最后回复时间',
  PRIMARY KEY (`tid`),
  KEY `t_s_id` (`tsid`),
  KEY `t_u_id` (`tuid`),
  KEY `t_s_lastid` (`tlastreplyuseid`),
  CONSTRAINT `t_s_id` FOREIGN KEY (`tsid`) REFERENCES `session` (`sid`),
  CONSTRAINT `t_s_lastid` FOREIGN KEY (`tlastreplyuseid`) REFERENCES `user` (`uid`),
  CONSTRAINT `t_u_id` FOREIGN KEY (`tuid`) REFERENCES `user` (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=109 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of topic
-- ----------------------------
INSERT INTO `topic` VALUES ('67', '9', '16', '2', null, '大家好', '123', '2017-11-06 17:14:33', '35', null, '31', '2017-11-09 19:23:06');
INSERT INTO `topic` VALUES ('68', '9', '16', '2', null, 'hello world', '<p>&nbsp;@Override</p><p><span style=\"white-space:pre\">	</span>public int addFollow(Follow follow) {</p><p><span style=\"white-space:pre\">		</span>int result =0;</p><p><span style=\"white-space:pre\">		</span>try {</p><p><span style=\"white-space:pre\">			</span>sqlSession = dbAccess.getSqlSession();</p><p><span style=\"white-space:pre\">			</span>result = sqlSession.insert(\"Follow.addFollow\",follow);</p><p><span style=\"white-space:pre\">			</span>sqlSession.commit();</p><p><span style=\"white-space:pre\">		</span>} catch (IOException e) {</p><p><span style=\"white-space:pre\">			</span>e.printStackTrace();</p><p><span style=\"white-space:pre\">			</span>return result;</p><p><span style=\"white-space:pre\">		</span>}</p><p><span style=\"white-space:pre\">		</span>return result;</p><p><span style=\"white-space:pre\">	</span>}</p>', '2017-11-07 09:05:55', '9', null, '32', '2017-11-10 14:29:20');
INSERT INTO `topic` VALUES ('69', '9', '16', '1', null, '一段无聊的代码', '<p>@Override</p><p><span style=\"white-space:pre\">	</span>public int deleteFollow(int fid) {</p><p><span style=\"white-space:pre\">		</span>int result =0;</p><p><span style=\"white-space:pre\">		</span>try {</p><p><span style=\"white-space:pre\">			</span>sqlSession = dbAccess.getSqlSession();</p><p><span style=\"white-space:pre\">			</span>result = sqlSession.delete(\"Follow.deleteFollow\",fid);</p><p><span style=\"white-space:pre\">			</span>sqlSession.commit();</p><p><span style=\"white-space:pre\">		</span>} catch (IOException e) {</p><p><span style=\"white-space:pre\">			</span>e.printStackTrace();</p><p><span style=\"white-space:pre\">			</span>return result;</p><p><span style=\"white-space:pre\">		</span>}</p><p><span style=\"white-space:pre\">		</span>return result;</p><p><span style=\"white-space:pre\">	</span>}</p>', '2017-11-07 09:07:08', '9', null, '16', '2017-11-08 16:31:15');
INSERT INTO `topic` VALUES ('70', '9', '16', '0', null, '大家帮我优化下这个代码，谢谢', '<p><img style=\"width: 180px;\" src=\"files/a2aef601b6cc4f01721cc429e745548a.jpg\" data-filename=\"image name\"></p><p>@Override</p><p><span style=\"white-space:pre\">	</span>public String neatenSessionContent(String uname, String ttopic,</p><p><span style=\"white-space:pre\">			</span>String tcontents) {</p><p><br></p><p><span style=\"white-space:pre\">		</span>String newContents = \"&lt;li&gt;&lt;div class=\'col-xs-2\'&gt;&lt;div class=\'thumbsUp\'&gt;&lt;p title=\'回复条数\'&gt;&lt;span class=\'activeSpan\'&gt;0&lt;/span&gt;&lt;span class=\'glyphicon glyphicon-comment\'&gt;&lt;/span&gt;&lt;/p&gt;&lt;p title=\'观看人数\'&gt;&lt;span class=\'activeSpan\'&gt;0&lt;/span&gt;&lt;span class=\'glyphicon glyphicon glyphicon glyphicon-eye-open\'&gt;&lt;/span&gt;&lt;/p&gt;&lt;/div&gt;&lt;/div&gt;&lt;div class=\'panel col-xs-10\'&gt;&lt;div class=\'panel-heading\'&gt;&lt;a href=\'javaScript:void(0)\'class=\'TopicTName\'&gt;\"</p><p><span style=\"white-space:pre\">				</span>+ ttopic</p><p><span style=\"white-space:pre\">				</span>+ \"&lt;/a&gt;&lt;/div&gt;&lt;div class=\'panel-body\'&gt;\"</p><p><span style=\"white-space:pre\">				</span>+&nbsp; neatenSessionContentInit(tcontents)</p><p><span style=\"white-space:pre\">				</span>+ \"&lt;/div&gt;&lt;div class=\'panel-footer clearfix\'&gt;&lt;div style=\'float: right\'&gt;&lt;span class=\'glyphicon glyphicon-user\'&gt;&lt;/span&gt;&lt;a href=\'user.jsp\' title=\'作者\' target=\'_blank\'&gt;\"</p><p><span style=\"white-space:pre\">				</span>+ uname</p><p><span style=\"white-space:pre\">				</span>+ \"&lt;/a&gt;&lt;/div&gt;&lt;/div&gt;&lt;/div&gt;&lt;/li&gt;\";</p><p><span style=\"white-space:pre\">				</span></p><p><span style=\"white-space:pre\">		</span></p><p><span style=\"white-space:pre\">		</span>return newContents;</p><p><span style=\"white-space:pre\">	</span>}</p>', '2017-11-07 09:10:32', '9', null, '16', '2017-11-09 10:59:03');
INSERT INTO `topic` VALUES ('77', '13', '16', '1', null, '让我来水一贴', '<p>TopicView topicView = new TopicView();</p><p><span style=\"white-space:pre\">		</span>//当前被选中的帖子</p><p><span style=\"white-space:pre\">		</span>Topic topic = topicService.queryTopicOneByTopic(topicTName);</p><p><span style=\"white-space:pre\">		</span>//版块名称</p><p><span style=\"white-space:pre\">		</span>String sessionName = sessionService.querySessionNameBySID(topic.getTsid());&nbsp;</p><p><span style=\"white-space:pre\">		</span>//用户名</p><p><span style=\"white-space:pre\">		</span>String userName = userService.queryUserNameById(topic.getTuid());</p><p><span style=\"white-space:pre\">		</span>//最后一个回复的用户</p><p><span style=\"white-space:pre\">		</span>String lastReplyUserName = userService.queryUserNameById(topic.getTlastreplyuseid());</p><p><span style=\"white-space:pre\">		</span>//相同的topic</p><p><span style=\"white-space:pre\">		</span>List&lt;Topic&gt; sameTopic = topicService.queryTopicListByTSID(topic.getTsid());</p><p><span style=\"white-space:pre\">		</span></p>', '2017-11-07 15:52:29', '5', null, '16', '10-11');
INSERT INTO `topic` VALUES ('78', '10', '30', '0', null, '我只是想来水哥贴', '<p>哈哈哈哈啊哈<img src=\"files/a2aef601b6cc4f01721cc429e745548a.jpg\" data-filename=\"image name\" style=\"width: 180px;\"></p>', '2017-11-07 20:42:34', '3', null, '30', '2017-11-09 10:59:03');
INSERT INTO `topic` VALUES ('79', '10', '30', '0', null, 'PHP好玩吗', '<p>兰兄弟</p>', '2017-11-07 21:27:16', '3', null, '30', '2017-11-09 10:59:03');
INSERT INTO `topic` VALUES ('82', '12', '16', '1', null, '水贴', '<p>123</p>', '2017-11-08 11:16:40', '9', null, '16', '2017-11-09 10:59:03');
INSERT INTO `topic` VALUES ('83', '12', '16', '0', null, 'python是什么', '<p>好用吗<img src=\"files/a2aef601b6cc4f01721cc429e745548a.jpg\" data-filename=\"image name\" style=\"width: 180px;\"></p>', '2017-11-08 11:25:22', '1', null, '16', '2017-11-09 10:59:03');
INSERT INTO `topic` VALUES ('84', '12', '16', '0', null, '起航', '<p><img src=\"files/java.jpg\" data-filename=\"image name\" style=\"width: 150px;\"><br></p>', '2017-11-08 11:33:00', '5', null, '16', '2017-11-09 10:59:03');
INSERT INTO `topic` VALUES ('86', '10', '31', '0', null, '今天是好日子', '<p>真的吗</p>', '2017-11-09 20:14:12', '3', null, '31', '2017-11-09 20:14:12');
INSERT INTO `topic` VALUES ('87', '11', '31', '1', null, '出bug了，帮我看一下', '<p>&nbsp; &nbsp; &lt;c:if test=\"${topicList.treplycount!=0}\"&gt;<br></p><p><span style=\"white-space:pre\">									</span>&lt;div style=\"float: left\"&gt;</p><p><span style=\"white-space:pre\">										</span>&lt;span class=\"glyphicon glyphicon glyphicon-comment\"&gt;&lt;/span&gt; &lt;a</p><p><span style=\"white-space:pre\">											</span>href=\"user.jsp\" title=\"最后回复人\" target=\"_blank\"&gt;${topicList.lastreplyuser}&lt;/a&gt; &lt;span</p><p><span style=\"white-space:pre\">											</span>class=\"glyphicon glyphicon-time\"&gt;&lt;/span&gt; &lt;span class=\"time\"</p><p><span style=\"white-space:pre\">											</span>title=\"最后回复时间\"&gt;${topicList.tlastreplaytime}&lt;/span&gt;</p><p><span style=\"white-space:pre\">									</span>&lt;/div&gt;</p><p><span style=\"white-space:pre\">								</span>&lt;/c:if&gt;</p>', '2017-11-09 20:18:28', '4', null, '31', '2017-11-09 20:18:43');
INSERT INTO `topic` VALUES ('89', '9', '30', '5', null, '发个正经的帖子', '<p><img src=\"files/a2aef601b6cc4f01721cc429e745548a.jpg\" data-filename=\"image name\" style=\"width: 180px;\"><img src=\"files/ITForum.jpg\" data-filename=\"image name\" style=\"width: 180px;\"><img src=\"files/java.jpg\" data-filename=\"image name\" style=\"width: 150px;\"><br></p>', '2017-11-09 21:01:46', '280', null, '30', '2017-11-10 15:20:46');
INSERT INTO `topic` VALUES ('90', '15', '30', '0', null, '沙发', '<p><img src=\"files/a2aef601b6cc4f01721cc429e745548a.jpg\" data-filename=\"image name\" style=\"width: 180px;\"></p><p>来了</p>', '2017-11-10 15:19:54', '1', null, '30', '2017-11-10 15:19:54');
INSERT INTO `topic` VALUES ('91', '11', '30', '0', null, 'test', '<p>&nbsp; &nbsp; 小测试<img style=\"width: 150px;\" src=\"files/java.jpg\" data-filename=\"image name\"><br></p>', '2017-11-10 17:08:13', '1', null, '30', '2017-11-10 17:08:13');
INSERT INTO `topic` VALUES ('92', '11', '30', '0', null, '添加帖子', '<p>/*添加帖子，界面*/</p><p><span style=\"white-space:pre\">	</span>function newTopicContent(data){</p><p><span style=\"white-space:pre\">		</span>console.log(data);</p><p><span style=\"white-space:pre\">		</span>$(\'#topicTitleText\').val(\"\");</p><p><span style=\"white-space:pre\">		</span>$(\'#topicText\').summernote(\'code\', \"\");</p><p><span style=\"white-space:pre\">		</span>$(\'#mainContent&gt;ul\').prepend(data);</p><p><span style=\"white-space:pre\">		</span>/*topic的跳转*/</p><p><span style=\"white-space:pre\">		</span>$(\'.TopicTName\').click(</p><p><span style=\"white-space:pre\">				</span>function() {</p><p><span style=\"white-space:pre\">					</span>location.href = \"Topic?op=toTopic&amp;topicTid=\"</p><p><span style=\"white-space:pre\">							</span>+ $(this).siblings(\'.topicTid\').val() + \"&amp;sessionSid=\"</p><p><span style=\"white-space:pre\">							</span>+ $(\'#sessionSid\').val();</p><p><span style=\"white-space:pre\">				</span>});</p><p><span style=\"white-space:pre\">	</span>}</p>', '2017-11-10 17:17:22', '0', null, '30', '2017-11-10 17:17:22');
INSERT INTO `topic` VALUES ('93', '9', '16', '0', null, '不开心', '<p>出bug了<img src=\"files/code-wallpaper-15.jpg\" data-filename=\"image name\" style=\"width: 576.328px;\"></p>', '2017-11-14 20:22:17', '50', null, '16', '2017-11-14 20:22:17');
INSERT INTO `topic` VALUES ('94', '10', '16', '1', null, '补充图片', '<p><img src=\"files/a2aef601b6cc4f01721cc429e745548a.jpg\" data-filename=\"image name\" style=\"width: 180px;\"><img src=\"files/java.jpg\" data-filename=\"image name\" style=\"width: 150px;\"><img src=\"files/ITForum.jpg\" data-filename=\"image name\" style=\"width: 180px;\"><img src=\"files/程序猿.jpg\" data-filename=\"image name\" style=\"width: 698px;\"><br></p>', '2017-11-16 20:06:32', '23', null, '16', '2017-11-16 21:25:41');
INSERT INTO `topic` VALUES ('98', '10', '16', '1', null, '尝试', '<p>......字符串<img src=\"files/google.jpg\" data-filename=\"image name\" style=\"width: 25%;\"></p>', '2017-11-23 13:31:55', '12', null, '30', '2017-11-23 13:35:36');
INSERT INTO `topic` VALUES ('102', '46', '16', '0', null, '我来自己发', '<p>爱你么么哒</p>', '2017-12-10 15:25:11', '4', null, '16', '2017-12-10 15:25:11');
INSERT INTO `topic` VALUES ('106', '3', '16', '6', null, '号东西好东西', '<p><font color=\"#00ff00\" style=\"background-color: rgb(0, 0, 255);\">jquery是最好的语言</font></p>', '2017-12-10 17:03:42', '68', null, '16', '2017-12-17 18:14:06');
INSERT INTO `topic` VALUES ('107', '3', '16', '2', null, '询问一个号问题', '<p>三国演义作者是谁<img src=\"files/notfound.jpg\" data-filename=\"image name\" style=\"width: 712px;\"></p>', '2017-12-17 17:08:09', '4', null, '16', '2017-12-17 17:17:33');
INSERT INTO `topic` VALUES ('108', '4', '16', '5', null, '你好呀兄弟', '<p><img src=\"files/code-wallpaper-16.jpg\" data-filename=\"image name\" style=\"width: 712px;\"><br></p>', '2017-12-17 17:18:59', '45', null, '16', '2017-12-17 18:07:17');

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
  `ustate` int(11) DEFAULT '0' COMMENT '用户状态',
  `upoint` int(11) DEFAULT '0' COMMENT '用户积分',
  `uissectioner` int(11) DEFAULT '0' COMMENT '是否版主',
  PRIMARY KEY (`uid`),
  UNIQUE KEY `onlyemail` (`uemail`),
  UNIQUE KEY `onlyuname` (`uname`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('16', '刘伟艺', '787c8ad9f686d6ae66a053497de9ae15b6b13364', '865799243@qq.com', '2017-10-27 10:22:34', '1995-02-12', '1', 'a2aef601b6cc4f01721cc429e745548a.jpg', '在平时学校生活中，做过很多兼职。例如：家教、电话访问员、酒楼服\r\n务员、派传单、问卷调查，还到工厂打过暑期工，亲身体会了各种工作的不同运作程序和处事方法，\r\n锻炼成了吃苦耐劳的精神，并从工作中体会到乐趣，尽心尽力。\r\n四年的大学生涯，让我的组织协调能力、管理能力、应变能力\r\n等大大提升，\r\n\r\n使我具备良好的心理素质，让我在竞争中拥有更大\r\n的优势，让我在人生事业中走\r\n得更高更远。获得了“优秀大学生”和“优秀毕业生”的称号。', '1', '1', '1');
INSERT INTO `user` VALUES ('30', '小鹏', '787c8ad9f686d6ae66a053497de9ae15b6b13364', '1275179864@qq.com', '2017-10-31 18:04:54', '2017-11-16', '0', 'java.jpg', '我最美', '0', '0', '0');
INSERT INTO `user` VALUES ('31', '小思', '787c8ad9f686d6ae66a053497de9ae15b6b13364', '956738834@qq.com', '2017-10-31 18:06:55', '2017-11-20', '0', 'google.jpg', '我贼强~~', '0', '0', '0');
INSERT INTO `user` VALUES ('32', '小勇', '787c8ad9f686d6ae66a053497de9ae15b6b13364', '941966176@qq.com', '2017-11-04 19:20:51', '2017-11-08', '1', 'code-wallpaper-22.jpg', '', '0', '0', '0');
INSERT INTO `user` VALUES ('36', 'test', 'test', 'test@qq.com', '2017-11-29 16:32:12', '2017-11-09', '1', null, 'I am you lover~', '0', '0', '0');
INSERT INTO `user` VALUES ('37', 'admin', '787c8ad9f686d6ae66a053497de9ae15b6b13364', '15880808647@163.com', '2017-12-05 15:27:36', null, null, null, null, '0', '0', '0');
DELIMITER ;;
CREATE TRIGGER `t_afterdelete_on_reply` BEFORE DELETE ON `reply` FOR EACH ROW begin 
			delete from lzl_reply where lrid = old.rid;
end
;;
DELIMITER ;
DELIMITER ;;
CREATE TRIGGER `t_afterdelete_on_session` BEFORE DELETE ON `session` FOR EACH ROW BEGIN
      delete from topic where tsid=old.sid;
			delete from follow where sid=old.sid;
END
;;
DELIMITER ;
DELIMITER ;;
CREATE TRIGGER `t_afterdelete_on_topic` BEFORE DELETE ON `topic` FOR EACH ROW begin 
			delete from reply where rtid = old.tid;
end
;;
DELIMITER ;
