/*
SQLyog Ultimate v12.3.1 (64 bit)
MySQL - 5.5.51 : Database - bs
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`bs` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `bs`;

/*Table structure for table `enroll` */

DROP TABLE IF EXISTS `enroll`;

CREATE TABLE `enroll` (
  `id` varchar(32) DEFAULT NULL COMMENT '主键',
  `playerid` varchar(32) DEFAULT NULL,
  `eventsid` varchar(32) DEFAULT NULL,
  `yscore` varchar(32) DEFAULT NULL,
  `jscore` varchar(32) DEFAULT NULL,
  `breakrecord` char(32) DEFAULT '0' COMMENT '0表示没有破记录，其他值表示破的记录值'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `enroll` */

insert  into `enroll`(`id`,`playerid`,`eventsid`,`yscore`,`jscore`,`breakrecord`) values 
('8d7eac18d647496abbce52f2c08220d2','2db6bbb20418434e92990e27fa811123','fdedb8f92c79486184cae28ab013a926','00:03:25','00:03:22','00:03:22'),
('e98e766657d549e087c848d9e68b91d4','2db6bbb20418434e92990e27fa811125','0e255fc5ddde49e198aa015293995987',NULL,'00:29:00','00:29:00'),
('2db6bbb20418434e92990e27fa811126','2db6bbb20418434e92990e27fa811126','fdedb8f92c79486184cae28ab013a926','00:03:33','00:03:28','0'),
('2db6bbb20418434e92990e27fa811127','2db6bbb20418434e92990e27fa811127','fdedb8f92c79486184cae28ab013a926','00:03:29','00:03:42','0'),
('2db6bbb20418434e92990e27fa811128','2db6bbb20418434e92990e27fa811128','fdedb8f92c79486184cae28ab013a926','00:03:34','00:03:37','0'),
('2db6bbb20418434e92990e27fa811129','2db6bbb20418434e92990e27fa811129','fdedb8f92c79486184cae28ab013a926','00:03:29','00:03:33','0'),
('c06d462788d148fc902cc7bf3ae6712a','2db6bbb20418434e92990e27fa811124','0e255fc5ddde49e198aa015293995987',NULL,'00:03:22','00:03:22'),
('527a602efed34bd4ab9516234f0da8aa','2db6bbb20418434e92990e27fa811123','87610b53159748678abd0fc113acfdf6',NULL,'3','3');

/*Table structure for table `events` */

DROP TABLE IF EXISTS `events`;

CREATE TABLE `events` (
  `id` varchar(32) NOT NULL,
  `name` varchar(128) DEFAULT NULL COMMENT '项目名称',
  `sex` varchar(12) DEFAULT NULL COMMENT '性别',
  `type` varchar(32) DEFAULT NULL COMMENT '个人还是团体',
  `record` varchar(128) DEFAULT NULL COMMENT '记录',
  `rtype` varchar(32) DEFAULT NULL COMMENT '记录类型（越大0越好还是越小1越好）',
  `fenzu` varchar(32) DEFAULT '否' COMMENT '0不分组 1分组',
  `yusai` varchar(32) DEFAULT '否' COMMENT '0只有决赛 1有预赛和角色',
  `unit` varchar(32) DEFAULT NULL COMMENT '记录的单位',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `events` */

insert  into `events`(`id`,`name`,`sex`,`type`,`record`,`rtype`,`fenzu`,`yusai`,`unit`) values 
('0e255fc5ddde49e198aa015293995987','女子3000米','女','个人赛','00:03:22','1','否','否',NULL),
('87610b53159748678abd0fc113acfdf6','男子跳高','男','个人赛','3','0','否','是','秒'),
('9a9045f4cbf14a7491dff6ce7d19fb4c','男子1500米','男','个人赛','00:08:00','1','是','是',NULL),
('fdedb8f92c79486184cae28ab013a926','男子800米','男','个人赛','00:03:22','1','是','是',NULL);

/*Table structure for table `grouping` */

DROP TABLE IF EXISTS `grouping`;

CREATE TABLE `grouping` (
  `id` varchar(32) DEFAULT NULL,
  `name` varchar(32) DEFAULT NULL COMMENT '分组名称',
  `sort` varchar(32) DEFAULT NULL COMMENT '分道名称',
  `playerid` varchar(32) DEFAULT NULL,
  `eventsid` varchar(32) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `grouping` */

insert  into `grouping`(`id`,`name`,`sort`,`playerid`,`eventsid`) values 
('d41266add97b43358b7e5ac6cf88fe09','第1组','第1号','2db6bbb20418434e92990e27fa811123','fdedb8f92c79486184cae28ab013a926'),
('b3f024480ffa416eb3e300bd1f08a7ad','第1组','第2号','2db6bbb20418434e92990e27fa811126','fdedb8f92c79486184cae28ab013a926'),
('54d38c801ab44887b8bc2732efe8dd69','第1组','第3号','2db6bbb20418434e92990e27fa811129','fdedb8f92c79486184cae28ab013a926'),
('1dd81567cc674164b4b7bf0c0eb69176','第2组','第1号','2db6bbb20418434e92990e27fa811128','fdedb8f92c79486184cae28ab013a926'),
('e7b98b07667f4b1fa9c1ff9711f649be','第2组','第2号','2db6bbb20418434e92990e27fa811127','fdedb8f92c79486184cae28ab013a926');

/*Table structure for table `menu` */

DROP TABLE IF EXISTS `menu`;

CREATE TABLE `menu` (
  `menuId` varchar(32) NOT NULL COMMENT '菜单ID',
  `menuName` varchar(50) DEFAULT NULL COMMENT '名称',
  `menuUrl` varchar(100) DEFAULT NULL COMMENT '方法',
  `parentId` varchar(32) DEFAULT NULL COMMENT '父ID',
  `menuDescription` varchar(200) DEFAULT NULL COMMENT '描述',
  `state` varchar(20) DEFAULT NULL COMMENT '状态/OPEN/CLOSED',
  `iconCls` varchar(50) DEFAULT NULL COMMENT '图标',
  `seq` int(11) DEFAULT NULL COMMENT '顺序排序',
  PRIMARY KEY (`menuId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `menu` */

insert  into `menu`(`menuId`,`menuName`,`menuUrl`,`parentId`,`menuDescription`,`state`,`iconCls`,`seq`) values 
('0ae7afbd0fe44488a90292c413248601','报名管理','enroll/index.htm','6c7fbe58ec364d4494f5fcb7ee5bf2b6','3','open','icon-',3),
('1b267ed6e1404eada4dd17ca79821dc6','成绩查询','achieve/index.htm','6c7fbe58ec364d4494f5fcb7ee5bf2b6','','open','icon-',6),
('1b6ed9d5d3a94b768f1f1019d586a410','运动会管理系统','','-1','主菜单','closed','icon-home',1),
('1f9d43074b1a430f9fba7e990fdcc214','分组管理','grouping/index.htm','6c7fbe58ec364d4494f5fcb7ee5bf2b6','','open','icon-',4),
('54475f4f787b45daa3df6f2ee0b312aa','系统管理','','1b6ed9d5d3a94b768f1f1019d586a410','','closed','icon-permission',1),
('5c796c8fedf8430b8f07dfe27f4c48dd','角色管理','role/roleIndex.htm','54475f4f787b45daa3df6f2ee0b312aa','','open','icon-486',3),
('6c7fbe58ec364d4494f5fcb7ee5bf2b6','参赛报名','','1b6ed9d5d3a94b768f1f1019d586a410','','closed','icon-',3),
('83b2b01b7f2448a6bd5246e9f42df1fc','赛事项目管理','events/eventsIndex.htm','b5549eb8735647ff9e13782a015d6139','','open','icon-',1),
('922b1f2962574a9084f80ea0ceb2f0c5','菜单管理','menu/menuIndex.htm','54475f4f787b45daa3df6f2ee0b312aa','','open','icon-menuManage',4),
('9a885dd6f1a14b04bae0bad15073602c','系统公告','notice/index.htm','b5549eb8735647ff9e13782a015d6139','','open','icon-',2),
('a2853c3915b04af494a19ac8b4955dd8','运动员管理','player/playerIndex.htm','6c7fbe58ec364d4494f5fcb7ee5bf2b6','','open','icon-',2),
('b5549eb8735647ff9e13782a015d6139','运动会管理','','1b6ed9d5d3a94b768f1f1019d586a410','','closed','icon-',2),
('f1f96a0fb9664c80973cbdcdfb0b817e','个人信息','player/playerInfo.htm','6c7fbe58ec364d4494f5fcb7ee5bf2b6','','open','icon-',1),
('f6c7b05fef0d4b75a3496fcf281c2524','用户管理','user/userIndex.htm','54475f4f787b45daa3df6f2ee0b312aa','','open','icon-489',2);

/*Table structure for table `notice` */

DROP TABLE IF EXISTS `notice`;

CREATE TABLE `notice` (
  `id` varchar(122) NOT NULL,
  `title` varchar(32) DEFAULT NULL,
  `content` longtext,
  `time` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `notice` */

insert  into `notice`(`id`,`title`,`content`,`time`) values 
('632695ea29b6419ea0c10c0acb6312f2','运动会时间安排','<p><span style=\"font-family:宋体\">时间安排</span></p><table><tbody><tr class=\"firstRow\"><td width=\"189\" valign=\"top\" style=\"border-width: 1px; border-color: windowtext; padding: 0px 7px;\"><p><span style=\"font-family:宋体\">日期</span></p></td><td width=\"189\" valign=\"top\" style=\"border-top-width: 1px; border-right-width: 1px; border-bottom-width: 1px; border-top-color: windowtext; border-right-color: windowtext; border-bottom-color: windowtext; border-left: none; padding: 0px 7px;\"><p><span style=\"font-family:宋体\">时段</span></p></td><td width=\"189\" valign=\"top\" style=\"border-top-width: 1px; border-right-width: 1px; border-bottom-width: 1px; border-top-color: windowtext; border-right-color: windowtext; border-bottom-color: windowtext; border-left: none; padding: 0px 7px;\"><p><span style=\"font-family:宋体\">项目</span></p></td></tr><tr><td width=\"189\" valign=\"top\" style=\"border-right-width: 1px; border-bottom-width: 1px; border-left-width: 1px; border-right-color: windowtext; border-bottom-color: windowtext; border-left-color: windowtext; border-top: none; padding: 0px 7px;\"><p>03-01</p></td><td width=\"189\" valign=\"top\" style=\"border-top: none; border-left: none; border-bottom-width: 1px; border-bottom-color: windowtext; border-right-width: 1px; border-right-color: windowtext; padding: 0px 7px;\"><p><span style=\"font-family:宋体\">上午</span></p></td><td width=\"189\" valign=\"top\" style=\"border-top: none; border-left: none; border-bottom-width: 1px; border-bottom-color: windowtext; border-right-width: 1px; border-right-color: windowtext; padding: 0px 7px;\"><p><span style=\"font-family:宋体\">项目一</span></p></td></tr><tr><td width=\"189\" valign=\"top\" style=\"border-right-width: 1px; border-bottom-width: 1px; border-left-width: 1px; border-right-color: windowtext; border-bottom-color: windowtext; border-left-color: windowtext; border-top: none; padding: 0px 7px;\"><p>03-01</p></td><td width=\"189\" valign=\"top\" style=\"border-top: none; border-left: none; border-bottom-width: 1px; border-bottom-color: windowtext; border-right-width: 1px; border-right-color: windowtext; padding: 0px 7px;\"><p><span style=\"font-family:宋体\">下午</span></p></td><td width=\"189\" valign=\"top\" style=\"border-top: none; border-left: none; border-bottom-width: 1px; border-bottom-color: windowtext; border-right-width: 1px; border-right-color: windowtext; padding: 0px 7px;\"><p><span style=\"font-family:宋体\">项目</span>2</p></td></tr><tr><td width=\"189\" valign=\"top\" style=\"border-right-width: 1px; border-bottom-width: 1px; border-left-width: 1px; border-right-color: windowtext; border-bottom-color: windowtext; border-left-color: windowtext; border-top: none; padding: 0px 7px;\"><p>03-02</p></td><td width=\"189\" valign=\"top\" style=\"border-top: none; border-left: none; border-bottom-width: 1px; border-bottom-color: windowtext; border-right-width: 1px; border-right-color: windowtext; padding: 0px 7px;\"><p><span style=\"font-family:宋体\">上午</span></p></td><td width=\"189\" valign=\"top\" style=\"border-top: none; border-left: none; border-bottom-width: 1px; border-bottom-color: windowtext; border-right-width: 1px; border-right-color: windowtext; padding: 0px 7px;\"><p><span style=\"font-family:宋体\">项目</span>3<span style=\"font-family:宋体\">，</span>4</p></td></tr><tr><td width=\"189\" valign=\"top\" style=\"border-right-width: 1px; border-bottom-width: 1px; border-left-width: 1px; border-right-color: windowtext; border-bottom-color: windowtext; border-left-color: windowtext; border-top: none; padding: 0px 7px;\"><p>03-02</p></td><td width=\"189\" valign=\"top\" style=\"border-top: none; border-left: none; border-bottom-width: 1px; border-bottom-color: windowtext; border-right-width: 1px; border-right-color: windowtext; padding: 0px 7px;\"><p><span style=\"font-family:宋体\">下午</span></p></td><td width=\"189\" valign=\"top\" style=\"border-top: none; border-left: none; border-bottom-width: 1px; border-bottom-color: windowtext; border-right-width: 1px; border-right-color: windowtext; padding: 0px 7px;\"><p><span style=\"font-family:宋体\">项目</span>7</p></td></tr><tr><td width=\"189\" valign=\"top\" style=\"border-right-width: 1px; border-bottom-width: 1px; border-left-width: 1px; border-right-color: windowtext; border-bottom-color: windowtext; border-left-color: windowtext; border-top: none; padding: 0px 7px;\"><p>03-03</p></td><td width=\"189\" valign=\"top\" style=\"border-top: none; border-left: none; border-bottom-width: 1px; border-bottom-color: windowtext; border-right-width: 1px; border-right-color: windowtext; padding: 0px 7px;\"><p><span style=\"font-family:宋体\">上午</span></p></td><td width=\"189\" valign=\"top\" style=\"border-top: none; border-left: none; border-bottom-width: 1px; border-bottom-color: windowtext; border-right-width: 1px; border-right-color: windowtext; padding: 0px 7px;\"><p><span style=\"font-family:宋体\">闭幕</span></p></td></tr></tbody></table><p>&nbsp;</p><p><br/></p>','2018-03-06');

/*Table structure for table `operation` */

DROP TABLE IF EXISTS `operation`;

CREATE TABLE `operation` (
  `operationId` varchar(64) NOT NULL COMMENT '具体的方法',
  `operationName` varchar(100) DEFAULT NULL COMMENT '方法名',
  `menuId` varchar(32) DEFAULT NULL COMMENT '所属菜单',
  `menuName` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`operationId`),
  KEY `menuId` (`menuId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='具体的页面按钮上的方法\r\n（此自增ID至少从10000开始）';

/*Data for the table `operation` */

insert  into `operation`(`operationId`,`operationName`,`menuId`,`menuName`) values 
('05da9b23441449b88cf56a3c762b4c','授权','5c796c8fedf8430b8f07dfe27f4c48dd','角色管理'),
('2af6d42e4cd24a829baf683ebb4467','删除','9a885dd6f1a14b04bae0bad15073602c','系统公告'),
('2e2a86f7e4be41ed837e215aeebca7','删除','83b2b01b7f2448a6bd5246e9f42df1fc','赛事项目管理'),
('41114d5298e84dd6a075cec32f12c3','修改','83b2b01b7f2448a6bd5246e9f42df1fc','赛事项目管理'),
('570c269b28dc483da09f32fa75fb1c','添加','5c796c8fedf8430b8f07dfe27f4c48dd','角色管理'),
('6de09cc41d834dd3a5b66f9bcbc3a9','删除','922b1f2962574a9084f80ea0ceb2f0c5','菜单管理'),
('7581831ec7504ea592241df49441b5','删除','5c796c8fedf8430b8f07dfe27f4c48dd','角色管理'),
('78cfc2d05f394e619300c3c22ba51c','添加','922b1f2962574a9084f80ea0ceb2f0c5','菜单管理'),
('795f2fefd6ea4e4cae96ef6633ca9a','修改','5c796c8fedf8430b8f07dfe27f4c48dd','角色管理'),
('7e609bcf3b5b4313bd6bd01e1bcb36','添加','f6c7b05fef0d4b75a3496fcf281c2524','用户管理'),
('7f1f1c3bf1de4e5fbc8e95a4851871','修改','922b1f2962574a9084f80ea0ceb2f0c5','菜单管理'),
('8a5cc94bc02c4ec9a082524bc9b396','修改','f6c7b05fef0d4b75a3496fcf281c2524','用户管理'),
('8aec801cdb61401db99972710f8469','修改','9a885dd6f1a14b04bae0bad15073602c','系统公告'),
('b9d2596fb6914b8392809ec16be0cb','删除','f6c7b05fef0d4b75a3496fcf281c2524','用户管理'),
('bac48c00792240ab8fe1a6c8b007e4','添加','83b2b01b7f2448a6bd5246e9f42df1fc','赛事项目管理'),
('bcf6874ab5c442149a65b0f719fa7e','添加','9a885dd6f1a14b04bae0bad15073602c','系统公告'),
('ebf5a2f3af5f4d67ad05fd9a5691b2','按钮管理','922b1f2962574a9084f80ea0ceb2f0c5','菜单管理');

/*Table structure for table `player` */

DROP TABLE IF EXISTS `player`;

CREATE TABLE `player` (
  `id` varchar(32) NOT NULL,
  `userid` varchar(32) DEFAULT NULL COMMENT '对应的登录',
  `dept` varchar(32) DEFAULT NULL COMMENT '班级',
  `code` varchar(32) DEFAULT NULL COMMENT '学校',
  `sex` varchar(32) DEFAULT NULL COMMENT '性别',
  `disease` varchar(32) DEFAULT NULL COMMENT '疾病',
  `remarks` varchar(32) DEFAULT NULL COMMENT '备注',
  `realName` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `player` */

insert  into `player`(`id`,`userid`,`dept`,`code`,`sex`,`disease`,`remarks`,`realName`) values 
('2db6bbb20418434e92990e27fa811123','935b0fc88d2945e09c728aef35c7bc9b','2014级2班3','E2170923','男','无',NULL,'学生1'),
('2db6bbb20418434e92990e27fa811124','935b0fc88d2945e09c728aef35c7bc9c','2014级2班3','E2170123','女','无',NULL,'学生2'),
('2db6bbb20418434e92990e27fa811125','935b0fc88d2945e09c728aef35c7bc9d','2014级2班3','E2170233','女','无',NULL,'学生3'),
('2db6bbb20418434e92990e27fa811126','935b0fc88d2945e09c728aef35c7bc9e','2014级2班3','E2170131','男','无',NULL,'学生4'),
('2db6bbb20418434e92990e27fa811127','935b0fc88d2945e09c728aef35c7bc9f','2014级2班3','E2170564','男','无',NULL,'学生5'),
('2db6bbb20418434e92990e27fa811128','935b0fc88d2945e09c728aef35c7bc9g','2014级2班3','E2171923','男','无',NULL,'学生6'),
('2db6bbb20418434e92990e27fa811129','935b0fc88d2945e09c728aef35c7bc9h','2014级2班3','E2180923','男','无',NULL,'学生7');

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `roleId` varchar(32) NOT NULL COMMENT '角色ID',
  `roleName` varchar(20) DEFAULT NULL COMMENT '角色名称',
  `menuIds` longtext COMMENT '菜单IDs',
  `operationIds` longtext COMMENT '按钮IDS',
  `roleDescription` varchar(200) DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`roleId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `role` */

insert  into `role`(`roleId`,`roleName`,`menuIds`,`operationIds`,`roleDescription`) values 
('1','超级管理员','1b6ed9d5d3a94b768f1f1019d586a410,54475f4f787b45daa3df6f2ee0b312aa,f6c7b05fef0d4b75a3496fcf281c2524,5c796c8fedf8430b8f07dfe27f4c48dd,922b1f2962574a9084f80ea0ceb2f0c5,b5549eb8735647ff9e13782a015d6139,83b2b01b7f2448a6bd5246e9f42df1fc,9a885dd6f1a14b04bae0bad15073602c,6c7fbe58ec364d4494f5fcb7ee5bf2b6,a2853c3915b04af494a19ac8b4955dd8,0ae7afbd0fe44488a90292c413248601,1f9d43074b1a430f9fba7e990fdcc214,1b267ed6e1404eada4dd17ca79821dc6','7e609bcf3b5b4313bd6bd01e1bcb36,8a5cc94bc02c4ec9a082524bc9b396,b9d2596fb6914b8392809ec16be0cb,05da9b23441449b88cf56a3c762b4c,570c269b28dc483da09f32fa75fb1c,7581831ec7504ea592241df49441b5,795f2fefd6ea4e4cae96ef6633ca9a,6de09cc41d834dd3a5b66f9bcbc3a9,78cfc2d05f394e619300c3c22ba51c,7f1f1c3bf1de4e5fbc8e95a4851871,ebf5a2f3af5f4d67ad05fd9a5691b2,2e2a86f7e4be41ed837e215aeebca7,41114d5298e84dd6a075cec32f12c3,bac48c00792240ab8fe1a6c8b007e4,2af6d42e4cd24a829baf683ebb4467,8aec801cdb61401db99972710f8469,bcf6874ab5c442149a65b0f719fa7e','拥有全部权限的超级管理员角色'),
('484b5d3c23f1484daa92277ac4b3b86e','学生运动员','1b6ed9d5d3a94b768f1f1019d586a410,b5549eb8735647ff9e13782a015d6139,9a885dd6f1a14b04bae0bad15073602c,6c7fbe58ec364d4494f5fcb7ee5bf2b6,f1f96a0fb9664c80973cbdcdfb0b817e,0ae7afbd0fe44488a90292c413248601,1b267ed6e1404eada4dd17ca79821dc6','1','');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` varchar(32) NOT NULL COMMENT '用户ID',
  `name` varchar(20) DEFAULT NULL COMMENT '用户名',
  `password` varchar(20) DEFAULT NULL COMMENT '密码',
  `roleId` varchar(32) DEFAULT NULL COMMENT '角色ID',
  `description` varchar(200) DEFAULT NULL COMMENT '描述信息',
  PRIMARY KEY (`id`),
  KEY `roleId` (`roleId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`name`,`password`,`roleId`,`description`) values 
('1','admin','admin','1','1'),
('935b0fc88d2945e09c728aef35c7bc9b','s1','1','484b5d3c23f1484daa92277ac4b3b86e','学生'),
('935b0fc88d2945e09c728aef35c7bc9c','s2','1','484b5d3c23f1484daa92277ac4b3b86e',NULL),
('935b0fc88d2945e09c728aef35c7bc9d','s3','1','484b5d3c23f1484daa92277ac4b3b86e',NULL),
('935b0fc88d2945e09c728aef35c7bc9e','s4','1','484b5d3c23f1484daa92277ac4b3b86e',NULL),
('935b0fc88d2945e09c728aef35c7bc9f','s5','1','484b5d3c23f1484daa92277ac4b3b86e',NULL),
('935b0fc88d2945e09c728aef35c7bc9g','s6','1','484b5d3c23f1484daa92277ac4b3b86e',NULL),
('935b0fc88d2945e09c728aef35c7bc9h','s7','1','484b5d3c23f1484daa92277ac4b3b86e',NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
