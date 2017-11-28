/*
Navicat MySQL Data Transfer

Source Server         : lwy
Source Server Version : 50525
Source Host           : localhost:3306
Source Database       : itforum

Target Server Type    : MYSQL
Target Server Version : 50525
File Encoding         : 65001

Date: 2017-11-28 21:00:06
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
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of follow
-- ----------------------------
INSERT INTO `follow` VALUES ('18', '16', '10');
INSERT INTO `follow` VALUES ('20', '16', '11');
INSERT INTO `follow` VALUES ('21', '16', '13');
INSERT INTO `follow` VALUES ('22', '16', '15');
INSERT INTO `follow` VALUES ('23', '16', '12');
INSERT INTO `follow` VALUES ('24', '16', '9');

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
-- Table structure for `private_letter`
-- ----------------------------
DROP TABLE IF EXISTS `private_letter`;
CREATE TABLE `private_letter` (
  `pid` int(11) NOT NULL AUTO_INCREMENT,
  `puid` int(11) NOT NULL,
  `ptouid` int(11) NOT NULL,
  `ptime` varchar(255) DEFAULT NULL,
  `pcontent` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of private_letter
-- ----------------------------
INSERT INTO `private_letter` VALUES ('1', '16', '30', '11-12', 'hi');
INSERT INTO `private_letter` VALUES ('3', '16', '30', '2017-11-28 16:10:35', 'NIHAO');
INSERT INTO `private_letter` VALUES ('4', '16', '30', '2017-11-28 16:14:09', 'NIHAO');
INSERT INTO `private_letter` VALUES ('5', '30', '16', '2017-11-28 16:14:09', 'you too');

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
) ENGINE=InnoDB AUTO_INCREMENT=79 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of reply
-- ----------------------------
INSERT INTO `reply` VALUES ('1', '77', '13', '30', '0', '简单回个帖', '2017-11-07 21:36:58');
INSERT INTO `reply` VALUES ('3', '82', '12', '16', '0', '<p>水贴</p>', '2017-11-08 11:23:25');
INSERT INTO `reply` VALUES ('4', '74', '9', '16', '0', '<p>可以回帖了吧</p>', '2017-11-08 16:04:46');
INSERT INTO `reply` VALUES ('5', '74', '9', '16', '0', '<p>做沙发</p>', '2017-11-08 16:08:23');
INSERT INTO `reply` VALUES ('7', '68', '9', '16', '0', '<p>回个水贴</p>', '2017-11-08 16:25:34');
INSERT INTO `reply` VALUES ('8', '67', '9', '16', '0', '<p>这是什么鬼帖子</p>', '2017-11-08 16:29:05');
INSERT INTO `reply` VALUES ('9', '69', '9', '16', '0', '<p>我看得懂也</p>', '2017-11-08 16:31:15');
INSERT INTO `reply` VALUES ('10', '75', '9', '30', '0', '沙发', '2017-11-09 10:59:03');
INSERT INTO `reply` VALUES ('11', '76', '9', '30', '0', '<p>你开心我就开心</p>', '2017-11-09 10:59:21');
INSERT INTO `reply` VALUES ('12', '74', '9', '30', '0', '<p>在回一个</p>', '2017-11-09 11:31:18');
INSERT INTO `reply` VALUES ('13', '76', '9', '31', '0', '<p>测测啦</p>', '2017-11-09 12:40:06');
INSERT INTO `reply` VALUES ('14', '74', '9', '31', '0', '<p>楼上是来搞笑的</p>', '2017-11-09 12:41:53');
INSERT INTO `reply` VALUES ('15', '74', '9', '31', '0', '1', '2017-11-09 12:42:18');
INSERT INTO `reply` VALUES ('16', '74', '9', '31', '0', '2', '2017-11-09 12:42:21');
INSERT INTO `reply` VALUES ('17', '74', '9', '31', '0', '3', '2017-11-09 12:42:22');
INSERT INTO `reply` VALUES ('18', '74', '9', '31', '0', '4', '2017-11-09 12:42:28');
INSERT INTO `reply` VALUES ('19', '74', '9', '31', '0', '分页测试', '2017-11-09 12:42:33');
INSERT INTO `reply` VALUES ('20', '74', '9', '32', '0', '<p>哈哈啊哈</p>', '2017-11-09 13:09:38');
INSERT INTO `reply` VALUES ('21', '74', '9', '16', '0', '好像分页成功了', '2017-11-09 15:29:07');
INSERT INTO `reply` VALUES ('22', '74', '9', '16', '0', '<p>你记住我了吗</p>', '2017-11-09 15:55:35');
INSERT INTO `reply` VALUES ('23', '76', '9', '30', '0', '<p>水哥沙发</p>', '2017-11-09 15:59:36');
INSERT INTO `reply` VALUES ('24', '76', '9', '30', '0', '<p>我不信</p>', '2017-11-09 16:00:34');
INSERT INTO `reply` VALUES ('25', '76', '9', '30', '0', '[{\"rfavour\":0,\"rtime\":\"2017-11-09 10:59:21\",\"uissectioner\":0,\"uname\":\"小鹏\",\"rcontent\":\"&lt;p&gt;你开心我就开心&lt;\\/p&gt;\",\"rid\":11,\"ustate\":0,\"upoint\":0},{\"rfavour\":0,\"rtime\":\"2017-11-09 12:40:06\",\"uissectioner\":0,\"uname\":\"小思\",\"rcontent\":\"&lt;p&gt;测测啦&lt;\\/p&gt;\",\"rid\":13,\"ustate\":0,\"upoint\":0},{\"rfavour\":0,\"rtime\":\"2017-11-09 15:59:36\",\"uissectioner\":0,\"uname\":\"小鹏\",\"rcontent\":\"&lt;p&gt;水哥沙发&lt;\\/p&gt;\",\"rid\":23,\"ustate\":0,\"upoint\":0},{\"rfavour\":0,\"rtime\":\"2017-11-09 16:00:34\",\"uissectioner\":0,\"uname\":\"小鹏\",\"rcontent\":\"&lt;p&gt;我不信&lt;\\/p&gt;\",\"rid\":24,\"ustate\":0,\"upoint\":0}]', '2017-11-09 16:00:50');
INSERT INTO `reply` VALUES ('26', '76', '9', '30', '0', '<div>$(\'#summernoteReply\').summernote(</div><div><span style=\"white-space:pre\">				</span>{</div><div><span style=\"white-space:pre\">					</span>height : 200,</div><div><span style=\"white-space:pre\">					</span>tabsize : 2,</div><div><span style=\"white-space:pre\">					</span>lang : \'zh-CN\',</div><div><span style=\"white-space:pre\">					</span>toolbar : [&nbsp;</div><div><span style=\"white-space:pre\">							</span>[ \'font\', [ \'bold\', \'underline\', \'clear\' ] ],</div><div><span style=\"white-space:pre\">							</span>[ \'color\', [ \'color\' ] ],</div><div><span style=\"white-space:pre\">							</span>[ \'insert\', [ \'link\' ] ],</div><div><span style=\"white-space:pre\">							</span>[ \'view\', [ \'fullscreen\'] ] ]</div><div><span style=\"white-space:pre\">		</span>});</div>', '2017-11-09 16:01:23');
INSERT INTO `reply` VALUES ('27', '76', '9', '30', '0', '<p>真的吗</p>', '2017-11-09 16:03:23');
INSERT INTO `reply` VALUES ('28', '76', '9', '31', '0', '<p>见证奇迹的时刻</p>', '2017-11-09 16:28:15');
INSERT INTO `reply` VALUES ('29', '76', '9', '31', '0', '好厉害', '2017-11-09 16:28:30');
INSERT INTO `reply` VALUES ('30', '76', '9', '31', '0', '牛逼了，兄弟', '2017-11-09 16:29:23');
INSERT INTO `reply` VALUES ('31', '76', '9', '31', '0', '可以滴三页', '2017-11-09 16:29:40');
INSERT INTO `reply` VALUES ('32', '67', '9', '31', '0', '<p>我又来了</p>', '2017-11-09 19:23:06');
INSERT INTO `reply` VALUES ('33', '87', '11', '31', '0', '<p>怎么回事</p>', '2017-11-09 20:18:43');
INSERT INTO `reply` VALUES ('34', '89', '9', '16', '0', '沙发沙发', '2017-11-09 21:11:18');
INSERT INTO `reply` VALUES ('35', '89', '9', '16', '0', '<p>会报错</p>', '2017-11-09 21:11:54');
INSERT INTO `reply` VALUES ('36', '89', '9', '16', '0', '<p>真是不敢相信</p>', '2017-11-09 21:13:55');
INSERT INTO `reply` VALUES ('37', '89', '9', '31', '0', '<p>操你妹哦</p>', '2017-11-09 21:15:21');
INSERT INTO `reply` VALUES ('74', '71', '9', '16', '0', '<p>组有沙发</p>', '2017-11-08 16:19:14');
INSERT INTO `reply` VALUES ('75', '68', '9', '32', '0', '<p>今天太阳好大呀</p><p>out.print(\"yes~ not \");</p>', '2017-11-10 14:29:20');
INSERT INTO `reply` VALUES ('76', '89', '9', '30', '0', '<p>太有了</p>', '2017-11-10 15:20:46');
INSERT INTO `reply` VALUES ('77', '94', '10', '16', '0', '<p>实现了工厂类</p>', '2017-11-16 21:25:41');
INSERT INTO `reply` VALUES ('78', '98', '10', '30', '0', '<a href=\"http://blog.csdn.net/\" target=\"_blank\">点一下这个链接</a>', '2017-11-23 13:35:36');

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
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of session
-- ----------------------------
INSERT INTO `session` VALUES ('1', 'HTML', '16', '前端开发', null, '0', '1', null);
INSERT INTO `session` VALUES ('3', 'JQuery', '16', '前端开发', null, '0', '0', null);
INSERT INTO `session` VALUES ('4', 'CSS', '16', '前端开发', null, '0', '0', null);
INSERT INTO `session` VALUES ('5', 'JavaScript', '16', '前端开发', null, '0', '0', null);
INSERT INTO `session` VALUES ('6', 'Bootstrap', '16', '前端开发', null, '0', '0', null);
INSERT INTO `session` VALUES ('7', 'Font Awesome', '16', '前端开发', null, '0', '0', null);
INSERT INTO `session` VALUES ('8', 'Foundation', '16', '前端开发', null, '0', '1', null);
INSERT INTO `session` VALUES ('9', 'JAVA', '16', '后端开发', '金钱与未来，你的选择是什么？', '13', '500', null);
INSERT INTO `session` VALUES ('10', 'PHP', '16', '后端开发', null, '6', '157', null);
INSERT INTO `session` VALUES ('11', 'SpringBoot', '30', '后端开发', null, '4', '72', null);
INSERT INTO `session` VALUES ('12', 'Python', '31', '后端开发', null, '3', '31', null);
INSERT INTO `session` VALUES ('13', 'C', '32', '后端开发', null, '1', '36', null);
INSERT INTO `session` VALUES ('15', 'Go', '16', '后端开发', null, '1', '19', null);
INSERT INTO `session` VALUES ('25', 'Ruby', '16', '后端开发', null, '0', '0', null);
INSERT INTO `session` VALUES ('26', 'Android', '30', '移动开发', null, '0', '0', null);
INSERT INTO `session` VALUES ('27', 'ISO', '30', '移动开发', null, '0', '0', null);
INSERT INTO `session` VALUES ('28', 'Unity3D', '30', '移动开发', null, '0', '0', null);
INSERT INTO `session` VALUES ('29', 'Cocos2D', '30', '移动开发', null, '0', '0', null);
INSERT INTO `session` VALUES ('30', 'Oracle', '30', '数据库', null, '1', '17', null);
INSERT INTO `session` VALUES ('31', 'MySQL', '16', '数据库', null, '0', '0', null);
INSERT INTO `session` VALUES ('32', 'MongoDB', '16', '数据库', null, '0', '0', null);
INSERT INTO `session` VALUES ('33', 'SQLServle', '16', '数据库', null, '0', '8', null);
INSERT INTO `session` VALUES ('34', 'Redis', '16', '数据库', null, '0', '2', null);
INSERT INTO `session` VALUES ('35', 'Eclipse', '30', '开发工具', null, '0', '0', null);
INSERT INTO `session` VALUES ('36', 'Git', '30', '开发工具', null, '0', '0', null);
INSERT INTO `session` VALUES ('37', 'Svn', '30', '开发工具', null, '0', '0', null);
INSERT INTO `session` VALUES ('38', 'HTTP', '30', '网站建设', null, '0', '1', null);
INSERT INTO `session` VALUES ('40', 'PhotoShop', '30', 'UI设计', null, '0', '1', null);
INSERT INTO `session` VALUES ('41', 'Linux', '30', '运维', null, '0', '0', null);
INSERT INTO `session` VALUES ('42', 'Junit', '30', '测试', null, '0', '0', null);
INSERT INTO `session` VALUES ('43', 'Hadoop', '30', '大数据', null, '0', '0', null);
INSERT INTO `session` VALUES ('44', 'DevOps', '30', '云计算', null, '0', '0', null);
INSERT INTO `session` VALUES ('46', 'Google', '16', '搜索引擎', '谷歌搜索', '0', '20', 'google.jpg');

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
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of topic
-- ----------------------------
INSERT INTO `topic` VALUES ('67', '9', '16', '2', null, '大家好', '123', '2017-11-06 17:14:33', '35', null, '31', '2017-11-09 19:23:06');
INSERT INTO `topic` VALUES ('68', '9', '16', '2', null, 'hello world', '<p>&nbsp;@Override</p><p><span style=\"white-space:pre\">	</span>public int addFollow(Follow follow) {</p><p><span style=\"white-space:pre\">		</span>int result =0;</p><p><span style=\"white-space:pre\">		</span>try {</p><p><span style=\"white-space:pre\">			</span>sqlSession = dbAccess.getSqlSession();</p><p><span style=\"white-space:pre\">			</span>result = sqlSession.insert(\"Follow.addFollow\",follow);</p><p><span style=\"white-space:pre\">			</span>sqlSession.commit();</p><p><span style=\"white-space:pre\">		</span>} catch (IOException e) {</p><p><span style=\"white-space:pre\">			</span>e.printStackTrace();</p><p><span style=\"white-space:pre\">			</span>return result;</p><p><span style=\"white-space:pre\">		</span>}</p><p><span style=\"white-space:pre\">		</span>return result;</p><p><span style=\"white-space:pre\">	</span>}</p>', '2017-11-07 09:05:55', '9', null, '32', '2017-11-10 14:29:20');
INSERT INTO `topic` VALUES ('69', '9', '16', '1', null, '一段无聊的代码', '<p>@Override</p><p><span style=\"white-space:pre\">	</span>public int deleteFollow(int fid) {</p><p><span style=\"white-space:pre\">		</span>int result =0;</p><p><span style=\"white-space:pre\">		</span>try {</p><p><span style=\"white-space:pre\">			</span>sqlSession = dbAccess.getSqlSession();</p><p><span style=\"white-space:pre\">			</span>result = sqlSession.delete(\"Follow.deleteFollow\",fid);</p><p><span style=\"white-space:pre\">			</span>sqlSession.commit();</p><p><span style=\"white-space:pre\">		</span>} catch (IOException e) {</p><p><span style=\"white-space:pre\">			</span>e.printStackTrace();</p><p><span style=\"white-space:pre\">			</span>return result;</p><p><span style=\"white-space:pre\">		</span>}</p><p><span style=\"white-space:pre\">		</span>return result;</p><p><span style=\"white-space:pre\">	</span>}</p>', '2017-11-07 09:07:08', '9', null, '16', '2017-11-08 16:31:15');
INSERT INTO `topic` VALUES ('70', '9', '16', '0', null, '大家帮我优化下这个代码，谢谢', '<p><img style=\"width: 180px;\" src=\"files/a2aef601b6cc4f01721cc429e745548a.jpg\" data-filename=\"image name\"></p><p>@Override</p><p><span style=\"white-space:pre\">	</span>public String neatenSessionContent(String uname, String ttopic,</p><p><span style=\"white-space:pre\">			</span>String tcontents) {</p><p><br></p><p><span style=\"white-space:pre\">		</span>String newContents = \"&lt;li&gt;&lt;div class=\'col-xs-2\'&gt;&lt;div class=\'thumbsUp\'&gt;&lt;p title=\'回复条数\'&gt;&lt;span class=\'activeSpan\'&gt;0&lt;/span&gt;&lt;span class=\'glyphicon glyphicon-comment\'&gt;&lt;/span&gt;&lt;/p&gt;&lt;p title=\'观看人数\'&gt;&lt;span class=\'activeSpan\'&gt;0&lt;/span&gt;&lt;span class=\'glyphicon glyphicon glyphicon glyphicon-eye-open\'&gt;&lt;/span&gt;&lt;/p&gt;&lt;/div&gt;&lt;/div&gt;&lt;div class=\'panel col-xs-10\'&gt;&lt;div class=\'panel-heading\'&gt;&lt;a href=\'javaScript:void(0)\'class=\'TopicTName\'&gt;\"</p><p><span style=\"white-space:pre\">				</span>+ ttopic</p><p><span style=\"white-space:pre\">				</span>+ \"&lt;/a&gt;&lt;/div&gt;&lt;div class=\'panel-body\'&gt;\"</p><p><span style=\"white-space:pre\">				</span>+&nbsp; neatenSessionContentInit(tcontents)</p><p><span style=\"white-space:pre\">				</span>+ \"&lt;/div&gt;&lt;div class=\'panel-footer clearfix\'&gt;&lt;div style=\'float: right\'&gt;&lt;span class=\'glyphicon glyphicon-user\'&gt;&lt;/span&gt;&lt;a href=\'user.jsp\' title=\'作者\' target=\'_blank\'&gt;\"</p><p><span style=\"white-space:pre\">				</span>+ uname</p><p><span style=\"white-space:pre\">				</span>+ \"&lt;/a&gt;&lt;/div&gt;&lt;/div&gt;&lt;/div&gt;&lt;/li&gt;\";</p><p><span style=\"white-space:pre\">				</span></p><p><span style=\"white-space:pre\">		</span></p><p><span style=\"white-space:pre\">		</span>return newContents;</p><p><span style=\"white-space:pre\">	</span>}</p>', '2017-11-07 09:10:32', '9', null, '16', '2017-11-09 10:59:03');
INSERT INTO `topic` VALUES ('71', '9', '16', '1', null, '我也不懂得，求帮助', '<p>&lt;script type=\"text/javascript\"&gt;</p><p><span style=\"white-space: pre;\">	</span>$(function(){</p><p><span style=\"white-space: pre;\">		</span>/*session的跳转*/</p><p><span style=\"white-space: pre;\">		</span>$(\'.sessionName\').click(function(){</p><p><span style=\"white-space: pre;\">			</span>location.href=\"Session?op=toSession&amp;sessionName=\"+$(this).html();</p><p><span style=\"white-space: pre;\">		</span>});//end sessionName.click</p><p><span style=\"white-space: pre;\">		</span>/*topic的跳转*/</p><p><span style=\"white-space: pre;\">		</span>$(\'.TopicTName\').click(function(){</p><p><span style=\"white-space: pre;\">			</span>location.href=\"Topic?op=toTopic&amp;TopicTName=\"+$(this).html();</p><p><span style=\"white-space: pre;\">		</span>});</p><p><span style=\"white-space: pre;\">	</span>});</p><p><span style=\"white-space: pre;\">	</span>$(document).ready(function() {</p><p><span style=\"white-space: pre;\">		</span>/*关注*/</p><p><span style=\"white-space: pre;\">		</span>$(\"#follow\").click(function() {</p><p><span style=\"white-space: pre;\">			</span>if($(\'#nowUserName\').html()==undefined){</p><p><span style=\"white-space: pre;\">				</span>alert(\'请登录\');</p><p><span style=\"white-space: pre;\">			</span>}else{</p><p><span style=\"white-space: pre;\">				</span>var param = {</p><p><span style=\"white-space: pre;\">						</span>\"op\":\"follow\",</p><p><span style=\"white-space: pre;\">						</span>\"sessionName\":$(\'#sessionName\').html(),</p><p><span style=\"white-space: pre;\">						</span>\"userName\" : $(\'#nowUserName\').html()</p><p><span style=\"white-space: pre;\">					</span>}</p><p><span style=\"white-space: pre;\">				</span>$.post(\"FollowAndUnfollow\",param,function(data){</p><p><span style=\"white-space: pre;\">					</span>if(data==\"true\"){</p><p><span style=\"white-space: pre;\">						</span>$(\"#follow\").hide();</p><p><span style=\"white-space: pre;\">						</span>$(\"#unfollow\").show();</p><p><span style=\"white-space: pre;\">					</span>}else{</p><p><span style=\"white-space: pre;\">						</span>alert(\"关注失败，服务器错误！\");</p><p><span style=\"white-space: pre;\">					</span>}<span style=\"white-space: pre;\">					</span></p><p><span style=\"white-space: pre;\">				</span>});//end post</p><p><span style=\"white-space: pre;\">			</span>}</p><p><span style=\"white-space: pre;\">		</span>});//end click function</p><p><span style=\"white-space: pre;\">		</span>/*取消关注*/</p><p><span style=\"white-space: pre;\">		</span>$(\"#unfollow\").click(function() {</p><p><span style=\"white-space: pre;\">			</span>if($(\'#nowUserName\').html()==undefined){</p><p><span style=\"white-space: pre;\">				</span>alert(\'请登录\');</p><p><span style=\"white-space: pre;\">			</span>}else{</p><p><span style=\"white-space: pre;\">				</span>var param = {</p><p><span style=\"white-space: pre;\">						</span>\"op\" :\"unfollow\",</p><p><span style=\"white-space: pre;\">						</span>\"sessionName\":$(\'#sessionName\').html(),</p><p><span style=\"white-space: pre;\">						</span>\"userName\" : $(\'#nowUserName\').html()</p><p><span style=\"white-space: pre;\">					</span>}</p><p><span style=\"white-space: pre;\">				</span>$.post(\"FollowAndUnfollow\",param,function(data){</p><p><span style=\"white-space: pre;\">					</span>if(data==\"true\"){</p><p><span style=\"white-space: pre;\">						</span>$(\"#unfollow\").hide();</p><p><span style=\"white-space: pre;\">						</span>$(\"#follow\").show();</p><p><span style=\"white-space: pre;\">					</span>}else{</p><p><span style=\"white-space: pre;\">						</span>alert(\"取消关注失败，服务器错误！\");</p><p><span style=\"white-space: pre;\">					</span>}<span style=\"white-space: pre;\">									</span></p><p><span style=\"white-space: pre;\">				</span>});//end post</p><p><span style=\"white-space: pre;\">			</span>}</p><p><span style=\"white-space: pre;\">		</span>});</p><p><span style=\"white-space: pre;\">	</span>});//end ready function</p><p>&lt;/script&gt;</p><p>&lt;/html&gt;<img src=\"http://localhost:8080/ITForum/files/%E7%A8%8B%E5%BA%8F%E7%8C%BF.jpg\" data-filename=\"image name\" style=\"width: 576.328px;\"></p>', '2017-11-07 09:13:30', '12', null, '16', '2017-11-08 16:19:14');
INSERT INTO `topic` VALUES ('74', '9', '16', '12', null, '我叫成家境', '<p>这到吗错了，</p><p>else if (myField.selectionStart || myField.selectionStart == \"0\") {</p><p>&nbsp; &nbsp; &nbsp; &nbsp; var startPos = myField.selectionStart;</p><p>&nbsp; &nbsp; &nbsp; &nbsp; var endPos = myField.selectionEnd;</p><p>&nbsp; &nbsp; &nbsp; &nbsp; var restoreTop = myField.scrollTop;</p><p>&nbsp; &nbsp; &nbsp; &nbsp; myField.value = myField.value.substring(0, startPos) + myValue + myField.value.substring(endPos, myField.value.length);</p><p>&nbsp; &nbsp; &nbsp; &nbsp; if (restoreTop &gt; 0) {</p><p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; myField.scrollTop = restoreTop;</p><p>&nbsp; &nbsp; &nbsp; &nbsp; }</p><p>&nbsp; &nbsp; &nbsp; &nbsp; myField.focus();</p><p>&nbsp; &nbsp; &nbsp; &nbsp; myField.selectionStart = startPos + myValue.length;</p><p>&nbsp; &nbsp; &nbsp; &nbsp; myField.selectionEnd = startPos + myValue.length;</p><p>&nbsp; &nbsp; } else {</p><p>&nbsp; &nbsp; &nbsp; &nbsp; myField.value += myValue;</p><p>&nbsp; &nbsp; &nbsp; &nbsp; myField.focus();</p><p>&nbsp; &nbsp; }<img src=\"files/程序猿.jpg\" data-filename=\"image name\" style=\"width: 576.328px;\"></p>', '2017-11-07 09:48:08', '166', null, '16', '2017-11-09 15:55:35');
INSERT INTO `topic` VALUES ('75', '9', '16', '1', null, '123', '<p>撒旦<b>法士大夫</b><u><a href=\"http://www.baidu.com\" target=\"_blank\">sd</a></u></p><p><u><br></u></p><p><u><br></u></p><p><img src=\"files/程序猿.jpg\" data-filename=\"image name\" style=\"width: 576.328px;\"><u><br></u></p>', '2017-11-07 09:50:20', '16', null, '30', '2017-11-09 10:59:03');
INSERT INTO `topic` VALUES ('76', '9', '16', '11', null, 'img', '<p><img src=\"files/java.jpg\" data-filename=\"image name\" style=\"width: 150px;\"><img src=\"files/ITForum.jpg\" data-filename=\"image name\" style=\"width: 180px;\"><img src=\"files/程序猿.jpg\" data-filename=\"image name\" style=\"width: 576.328px;\"><br></p>', '2017-11-07 09:54:45', '106', null, '31', '2017-11-09 16:29:40');
INSERT INTO `topic` VALUES ('77', '13', '16', '1', null, '让我来水一贴', '<p>TopicView topicView = new TopicView();</p><p><span style=\"white-space:pre\">		</span>//当前被选中的帖子</p><p><span style=\"white-space:pre\">		</span>Topic topic = topicService.queryTopicOneByTopic(topicTName);</p><p><span style=\"white-space:pre\">		</span>//版块名称</p><p><span style=\"white-space:pre\">		</span>String sessionName = sessionService.querySessionNameBySID(topic.getTsid());&nbsp;</p><p><span style=\"white-space:pre\">		</span>//用户名</p><p><span style=\"white-space:pre\">		</span>String userName = userService.queryUserNameById(topic.getTuid());</p><p><span style=\"white-space:pre\">		</span>//最后一个回复的用户</p><p><span style=\"white-space:pre\">		</span>String lastReplyUserName = userService.queryUserNameById(topic.getTlastreplyuseid());</p><p><span style=\"white-space:pre\">		</span>//相同的topic</p><p><span style=\"white-space:pre\">		</span>List&lt;Topic&gt; sameTopic = topicService.queryTopicListByTSID(topic.getTsid());</p><p><span style=\"white-space:pre\">		</span></p>', '2017-11-07 15:52:29', '5', null, '16', '10-11');
INSERT INTO `topic` VALUES ('78', '10', '30', '0', null, '我只是想来水哥贴', '<p>哈哈哈哈啊哈<img src=\"files/a2aef601b6cc4f01721cc429e745548a.jpg\" data-filename=\"image name\" style=\"width: 180px;\"></p>', '2017-11-07 20:42:34', '3', null, '30', '2017-11-09 10:59:03');
INSERT INTO `topic` VALUES ('79', '10', '30', '0', null, 'PHP好玩吗', '<p>兰兄弟</p>', '2017-11-07 21:27:16', '2', null, '30', '2017-11-09 10:59:03');
INSERT INTO `topic` VALUES ('81', '10', '16', '0', null, 'lai', '<p>zai shuiyitiao&nbsp;</p>', '2017-11-07 21:36:58', '8', null, '16', '2017-11-09 10:59:03');
INSERT INTO `topic` VALUES ('82', '12', '16', '1', null, '水贴', '<p>123</p>', '2017-11-08 11:16:40', '9', null, '16', '2017-11-09 10:59:03');
INSERT INTO `topic` VALUES ('83', '12', '16', '0', null, 'python是什么', '<p>好用吗<img src=\"files/a2aef601b6cc4f01721cc429e745548a.jpg\" data-filename=\"image name\" style=\"width: 180px;\"></p>', '2017-11-08 11:25:22', '1', null, '16', '2017-11-09 10:59:03');
INSERT INTO `topic` VALUES ('84', '12', '16', '0', null, '起航', '<p><img src=\"files/java.jpg\" data-filename=\"image name\" style=\"width: 150px;\"><br></p>', '2017-11-08 11:33:00', '5', null, '16', '2017-11-09 10:59:03');
INSERT INTO `topic` VALUES ('85', '11', '30', '0', null, '强个沙发', '<p><img src=\"files/a2aef601b6cc4f01721cc429e745548a.jpg\" data-filename=\"image name\" style=\"width: 180px;\"></p><p>哇哈哈<img src=\"files/imgs.png\" data-filename=\"image name\" style=\"width: 24px;\"></p>', '2017-11-09 19:31:24', '1', null, '30', '2017-11-09 10:59:03');
INSERT INTO `topic` VALUES ('86', '10', '31', '0', null, '今天是好日子', '<p>真的吗</p>', '2017-11-09 20:14:12', '2', null, '31', '2017-11-09 20:14:12');
INSERT INTO `topic` VALUES ('87', '11', '31', '1', null, '出bug了，帮我看一下', '<p>&nbsp; &nbsp; &lt;c:if test=\"${topicList.treplycount!=0}\"&gt;<br></p><p><span style=\"white-space:pre\">									</span>&lt;div style=\"float: left\"&gt;</p><p><span style=\"white-space:pre\">										</span>&lt;span class=\"glyphicon glyphicon glyphicon-comment\"&gt;&lt;/span&gt; &lt;a</p><p><span style=\"white-space:pre\">											</span>href=\"user.jsp\" title=\"最后回复人\" target=\"_blank\"&gt;${topicList.lastreplyuser}&lt;/a&gt; &lt;span</p><p><span style=\"white-space:pre\">											</span>class=\"glyphicon glyphicon-time\"&gt;&lt;/span&gt; &lt;span class=\"time\"</p><p><span style=\"white-space:pre\">											</span>title=\"最后回复时间\"&gt;${topicList.tlastreplaytime}&lt;/span&gt;</p><p><span style=\"white-space:pre\">									</span>&lt;/div&gt;</p><p><span style=\"white-space:pre\">								</span>&lt;/c:if&gt;</p>', '2017-11-09 20:18:28', '4', null, '31', '2017-11-09 20:18:43');
INSERT INTO `topic` VALUES ('88', '9', '31', '0', null, '你服不服', '<p><img src=\"files/4_得意.gif\" data-filename=\"image name\" style=\"width: 24px;\"><br></p>', '2017-11-09 20:22:59', '22', null, '31', '2017-11-09 20:22:59');
INSERT INTO `topic` VALUES ('89', '9', '30', '5', null, '发个正经的帖子', '<p><img src=\"files/a2aef601b6cc4f01721cc429e745548a.jpg\" data-filename=\"image name\" style=\"width: 180px;\"><img src=\"files/ITForum.jpg\" data-filename=\"image name\" style=\"width: 180px;\"><img src=\"files/java.jpg\" data-filename=\"image name\" style=\"width: 150px;\"><br></p>', '2017-11-09 21:01:46', '68', null, '30', '2017-11-10 15:20:46');
INSERT INTO `topic` VALUES ('90', '15', '30', '0', null, '沙发', '<p><img src=\"files/a2aef601b6cc4f01721cc429e745548a.jpg\" data-filename=\"image name\" style=\"width: 180px;\"></p><p>来了</p>', '2017-11-10 15:19:54', '1', null, '30', '2017-11-10 15:19:54');
INSERT INTO `topic` VALUES ('91', '11', '30', '0', null, 'test', '<p>&nbsp; &nbsp; 小测试<img style=\"width: 150px;\" src=\"files/java.jpg\" data-filename=\"image name\"><br></p>', '2017-11-10 17:08:13', '1', null, '30', '2017-11-10 17:08:13');
INSERT INTO `topic` VALUES ('92', '11', '30', '0', null, '添加帖子', '<p>/*添加帖子，界面*/</p><p><span style=\"white-space:pre\">	</span>function newTopicContent(data){</p><p><span style=\"white-space:pre\">		</span>console.log(data);</p><p><span style=\"white-space:pre\">		</span>$(\'#topicTitleText\').val(\"\");</p><p><span style=\"white-space:pre\">		</span>$(\'#topicText\').summernote(\'code\', \"\");</p><p><span style=\"white-space:pre\">		</span>$(\'#mainContent&gt;ul\').prepend(data);</p><p><span style=\"white-space:pre\">		</span>/*topic的跳转*/</p><p><span style=\"white-space:pre\">		</span>$(\'.TopicTName\').click(</p><p><span style=\"white-space:pre\">				</span>function() {</p><p><span style=\"white-space:pre\">					</span>location.href = \"Topic?op=toTopic&amp;topicTid=\"</p><p><span style=\"white-space:pre\">							</span>+ $(this).siblings(\'.topicTid\').val() + \"&amp;sessionSid=\"</p><p><span style=\"white-space:pre\">							</span>+ $(\'#sessionSid\').val();</p><p><span style=\"white-space:pre\">				</span>});</p><p><span style=\"white-space:pre\">	</span>}</p>', '2017-11-10 17:17:22', '0', null, '30', '2017-11-10 17:17:22');
INSERT INTO `topic` VALUES ('93', '9', '16', '0', null, '不开心', '<p>出bug了<img src=\"files/code-wallpaper-15.jpg\" data-filename=\"image name\" style=\"width: 576.328px;\"></p>', '2017-11-14 20:22:17', '47', null, '16', '2017-11-14 20:22:17');
INSERT INTO `topic` VALUES ('94', '10', '16', '1', null, '补充图片', '<p><img src=\"files/a2aef601b6cc4f01721cc429e745548a.jpg\" data-filename=\"image name\" style=\"width: 180px;\"><img src=\"files/java.jpg\" data-filename=\"image name\" style=\"width: 150px;\"><img src=\"files/ITForum.jpg\" data-filename=\"image name\" style=\"width: 180px;\"><img src=\"files/程序猿.jpg\" data-filename=\"image name\" style=\"width: 698px;\"><br></p>', '2017-11-16 20:06:32', '7', null, '16', '2017-11-16 21:25:41');
INSERT INTO `topic` VALUES ('95', '9', '16', '0', null, '旗鼓', '<p><img src=\"files/code-wallpaper-15.jpg\" data-filename=\"image name\" style=\"width: 698px;\"><br></p>', '2017-11-16 20:07:28', '5', null, '16', '2017-11-16 20:07:28');
INSERT INTO `topic` VALUES ('96', '9', '16', '0', null, '哈哈哈', '<p><img style=\"width: 698px;\" src=\"files/code-wallpaper-15.jpg\" data-filename=\"image name\"><img style=\"width: 24px;\" src=\"files/4_得意.gif\" data-filename=\"image name\"><br></p>', '2017-11-16 20:08:19', '54', null, '16', '2017-11-16 20:08:19');
INSERT INTO `topic` VALUES ('97', '30', '16', '0', null, '真么棒的吗', '<p>&nbsp;select * from user</p><p>&nbsp; &nbsp; sequer</p><p><img src=\"files/code_by_rasmusir-d4a4dj2.jpg\" data-filename=\"image name\" style=\"width: 698px;\"><br></p>', '2017-11-21 22:05:37', '3', null, '16', '2017-11-21 22:05:37');
INSERT INTO `topic` VALUES ('98', '10', '16', '1', null, '尝试', '<p>......字符串<img src=\"files/google.jpg\" data-filename=\"image name\" style=\"width: 25%;\"></p>', '2017-11-23 13:31:55', '10', null, '30', '2017-11-23 13:35:36');
INSERT INTO `topic` VALUES ('99', '10', '30', '0', null, '试一试', '<p><img src=\"files/code-wallpaper-16.jpg\" data-filename=\"image name\" style=\"width: 100%;\"><img src=\"files/maxresdefault.jpg\" data-filename=\"image name\" style=\"width: 25%;\">是打发士大夫</p>', '2017-11-23 13:40:19', '13', null, '30', '2017-11-23 13:40:19');

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
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'dada', 'dada', '824@qq.com', '10-12', '10-12', '0', 'img.jpg', null, '0', '0', '0');
INSERT INTO `user` VALUES ('2', 'zzm', 'aaa', '213@sd', '12-2', null, null, null, null, '0', '0', '0');
INSERT INTO `user` VALUES ('10', 'aaa', 'sss', '1233@qq.com', '9-12', 'ddd', '1', 'fff', 'ggg', '1', '1', '1');
INSERT INTO `user` VALUES ('15', 'lwy1', '123', '123@qq.com', '9-12', null, null, null, null, '0', '0', '0');
INSERT INTO `user` VALUES ('16', '刘伟艺', '***', '865799243@qq.com', '2017-10-27 10:22:34', '1995-02-12', '1', 'a2aef601b6cc4f01721cc429e745548a.jpg', '在平时学校生活中，做过很多兼职。例如：家教、电话访问员、酒楼服\r\n务员、派传单、问卷调查，还到工厂打过暑期工，亲身体会了各种工作的不同运作程序和处事方法，\r\n锻炼成了吃苦耐劳的精神，并从工作中体会到乐趣，尽心尽力。\r\n四年的大学生涯，让我的组织协调能力、管理能力、应变能力\r\n等大大提升，\r\n\r\n使我具备良好的心理素质，让我在竞争中拥有更大\r\n的优势，让我在人生事业中走\r\n得更高更远。获得了“优秀大学生”和“优秀毕业生”的称号。', '1', '1', '1');
INSERT INTO `user` VALUES ('17', 'andi', '123', '123@123', '2017-10-27 10:28:24', null, null, null, null, '0', '0', '0');
INSERT INTO `user` VALUES ('18', '你猜', '123', 'nicai@163.com', '2017-10-27 13:53:00', null, null, null, null, '0', '0', '0');
INSERT INTO `user` VALUES ('19', 'andidas', '123', '321@321', '2017-10-27 19:08:54', null, null, null, null, '0', '0', '0');
INSERT INTO `user` VALUES ('23', 'cjf', 'a123123', '123@11.c', '2017-10-27 21:08:39', null, null, null, null, '0', '0', '0');
INSERT INTO `user` VALUES ('24', '请问', 'a123123', '123@123.123', '2017-10-30 10:02:03', null, null, null, null, '0', '0', '0');
INSERT INTO `user` VALUES ('30', '小鹏', 'a123123', '1275179864@qq.com', '2017-10-31 18:04:54', null, null, null, null, '0', '0', '0');
INSERT INTO `user` VALUES ('31', '小思', 'a123123', '956738834@qq.com', '2017-10-31 18:06:55', null, null, null, null, '0', '0', '0');
INSERT INTO `user` VALUES ('32', '小勇', 'a123123', '941966176@qq.com', '2017-11-04 19:20:51', '2017-11-08', '1', 'a2aef601b6cc4f01721cc429e745548a.jpg', null, '0', '0', '0');
