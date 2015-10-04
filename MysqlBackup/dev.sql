/*
Navicat MySQL Data Transfer

Source Server         : 96.44.168.50
Source Server Version : 50542
Source Host           : 96.44.168.50:3306
Source Database       : dev

Target Server Type    : MYSQL
Target Server Version : 50542
File Encoding         : 65001

Date: 2015-10-02 10:39:24
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `addFund`
-- ----------------------------
DROP TABLE IF EXISTS `addFund`;
CREATE TABLE `addFund` (
  `orderKey` varchar(32) NOT NULL DEFAULT '',
  `orderTitle` varchar(255) DEFAULT NULL,
  `orderMoney` float(64,0) DEFAULT NULL,
  `orderDate` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`orderKey`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of addFund
-- ----------------------------
INSERT INTO `addFund` VALUES ('K6NMhfNAxNtxgISB', '', '0', '');
INSERT INTO `addFund` VALUES ('cvyRb6V8dDzup3tU', '', '0', '15-10-01');
INSERT INTO `addFund` VALUES ('wWjhYHK7yxX5IwRy', '', '0', '15-10-01');
INSERT INTO `addFund` VALUES ('KjZWZnXh1sIgMvAh', '', '0', '15-10-01');
INSERT INTO `addFund` VALUES ('uVpmF66aPNxFThtF', '', '0', '15-10-01');
INSERT INTO `addFund` VALUES ('95oqMjYAVRsrd57C', '', '0', '15-10-01');
INSERT INTO `addFund` VALUES ('kmAEak6W80ShCGxh', '', '0', '15-10-01');
INSERT INTO `addFund` VALUES ('mVvtoiNKnKBt0mAcS4gofjEv5POpgIL7', '', '0', '15-10-01');
INSERT INTO `addFund` VALUES ('sFzBusL9eFOAoWuc3ppz7YzL8r5DytZ3', '', '0', '15-10-01');
INSERT INTO `addFund` VALUES ('TvIye7PTG1epyy1rqHt4btlUkmKiqbqh', '', '0', '15-10-01');
INSERT INTO `addFund` VALUES ('yP8Bk4Q30kzsS2J2aVeF8Yg9GBPoKfAZ', '', '0', '15-10-01');
INSERT INTO `addFund` VALUES ('lVuPTSDCPJHsuNOeh8SBhTpwP3Uas4QY', '', '0', '15-10-01');
INSERT INTO `addFund` VALUES ('9Ot0qCbzlmztICrVOxSgm0T00RL6XToE', '', '0', '15-10-02');
INSERT INTO `addFund` VALUES ('Xr5mpjcpTsdNkYb1X1Ir587XZ0wjdDwi', '', '0', '15-10-02');
INSERT INTO `addFund` VALUES ('7KnN3plfzE3N1R242wnrtVgSiIyuQSPa', '', '0', '15-10-02');
INSERT INTO `addFund` VALUES ('4Jiz0AaQAM9EXiDNjELNSWMARjoNN59F', '', '0', '15-10-02');
INSERT INTO `addFund` VALUES ('2NYoiaOWt3YF0u682HOVBCmxed9AMvCy', '', '0', '15-10-02');
INSERT INTO `addFund` VALUES ('szYBIKNZDg7RDSHETls1ODUV4poMin6O', '', '0', '15-10-02');

-- ----------------------------
-- Table structure for `userInfo`
-- ----------------------------
DROP TABLE IF EXISTS `userInfo`;
CREATE TABLE `userInfo` (
  `ID` int(255) NOT NULL AUTO_INCREMENT,
  `userName` varchar(255) NOT NULL,
  `passWord` varchar(255) NOT NULL,
  `group` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=259 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of userInfo
-- ----------------------------
INSERT INTO `userInfo` VALUES ('1', '啊实打实的', 'ec02c59dee6faaca3189bace969c22d3', 'normal');
INSERT INTO `userInfo` VALUES ('2', '中文测试', 'd0e37ec62193e3c3b7bb1c1641fd1e2f', 'normal');
INSERT INTO `userInfo` VALUES ('3', '4米无语', '6c39359443a551cdeceeca14750f0835', 'normal');
INSERT INTO `userInfo` VALUES ('4', '共和新路', '71ecdf86e2b14ada2f0818436eec5d08', 'normal');
INSERT INTO `userInfo` VALUES ('5', '46495959', '90fed2dd11ba88ac4ee1184fde643faf', 'normal');
INSERT INTO `userInfo` VALUES ('6', '154546454', '5cda813b4c898d7a2d2db84997f82ed3', 'normal');
INSERT INTO `userInfo` VALUES ('7', 'hojxjyl', 'b574d02f121ad2ab0ff17eec372f367e', 'normal');
INSERT INTO `userInfo` VALUES ('8', 'hojxjyl', 'b574d02f121ad2ab0ff17eec372f367e', 'normal');
INSERT INTO `userInfo` VALUES ('9', 'dhcncncnf', '37eb0b9dd1010459906fec121730e488', 'normal');
INSERT INTO `userInfo` VALUES ('10', 'djxjnffn', '047eed890b5477b6cf338d180465d050', 'normal');
INSERT INTO `userInfo` VALUES ('11', 'cjfbfbc', '62be471c2cefd40d70d7d031db6aecba', 'normal');
INSERT INTO `userInfo` VALUES ('12', '6797981', '5b36158c8eb2fe88b02bd676821132a8', 'normal');
INSERT INTO `userInfo` VALUES ('13', '6797981', '5b36158c8eb2fe88b02bd676821132a8', 'normal');
INSERT INTO `userInfo` VALUES ('14', '6797981', '5b36158c8eb2fe88b02bd676821132a8', 'normal');
INSERT INTO `userInfo` VALUES ('15', '6797981', '5b36158c8eb2fe88b02bd676821132a8', 'normal');
INSERT INTO `userInfo` VALUES ('16', '6797981', '5b36158c8eb2fe88b02bd676821132a8', 'normal');
INSERT INTO `userInfo` VALUES ('17', '6797981', '5b36158c8eb2fe88b02bd676821132a8', 'normal');
INSERT INTO `userInfo` VALUES ('18', '6797981', '5b36158c8eb2fe88b02bd676821132a8', 'normal');
INSERT INTO `userInfo` VALUES ('19', '6797981', '5b36158c8eb2fe88b02bd676821132a8', 'normal');
INSERT INTO `userInfo` VALUES ('20', '6797981', '5b36158c8eb2fe88b02bd676821132a8', 'normal');
INSERT INTO `userInfo` VALUES ('21', '1231231', 'd6a2e3c51e2434ed72ca2e8ecfe9a34c', 'normal');
INSERT INTO `userInfo` VALUES ('22', '23131232', 'bbcb4d16cc6d8535d2dba67fbb671165', 'normal');
INSERT INTO `userInfo` VALUES ('23', '23131232', 'bbcb4d16cc6d8535d2dba67fbb671165', 'normal');
INSERT INTO `userInfo` VALUES ('24', '23131232', 'bbcb4d16cc6d8535d2dba67fbb671165', 'normal');
INSERT INTO `userInfo` VALUES ('25', '23131232', 'bbcb4d16cc6d8535d2dba67fbb671165', 'normal');
INSERT INTO `userInfo` VALUES ('26', '23131232', 'bbcb4d16cc6d8535d2dba67fbb671165', 'normal');
INSERT INTO `userInfo` VALUES ('27', '23131232', 'bbcb4d16cc6d8535d2dba67fbb671165', 'normal');
INSERT INTO `userInfo` VALUES ('28', '23131232', 'bbcb4d16cc6d8535d2dba67fbb671165', 'normal');
INSERT INTO `userInfo` VALUES ('29', '23131232', 'bbcb4d16cc6d8535d2dba67fbb671165', 'normal');
INSERT INTO `userInfo` VALUES ('30', '23131232', 'bbcb4d16cc6d8535d2dba67fbb671165', 'normal');
INSERT INTO `userInfo` VALUES ('31', '23131232', 'bbcb4d16cc6d8535d2dba67fbb671165', 'normal');
INSERT INTO `userInfo` VALUES ('32', '23131232', 'bbcb4d16cc6d8535d2dba67fbb671165', 'normal');
INSERT INTO `userInfo` VALUES ('33', '23131232', 'bbcb4d16cc6d8535d2dba67fbb671165', 'normal');
INSERT INTO `userInfo` VALUES ('34', '23131232', 'bbcb4d16cc6d8535d2dba67fbb671165', 'normal');
INSERT INTO `userInfo` VALUES ('35', '23131232', 'bbcb4d16cc6d8535d2dba67fbb671165', 'normal');
INSERT INTO `userInfo` VALUES ('36', '23131232', 'bbcb4d16cc6d8535d2dba67fbb671165', 'normal');
INSERT INTO `userInfo` VALUES ('37', '23131232', 'bbcb4d16cc6d8535d2dba67fbb671165', 'normal');
INSERT INTO `userInfo` VALUES ('38', '23131232', 'bbcb4d16cc6d8535d2dba67fbb671165', 'normal');
INSERT INTO `userInfo` VALUES ('39', '23131232', 'bbcb4d16cc6d8535d2dba67fbb671165', 'normal');
INSERT INTO `userInfo` VALUES ('40', '23131232', 'bbcb4d16cc6d8535d2dba67fbb671165', 'normal');
INSERT INTO `userInfo` VALUES ('41', '23131232', 'bbcb4d16cc6d8535d2dba67fbb671165', 'normal');
INSERT INTO `userInfo` VALUES ('42', '23131232', 'bbcb4d16cc6d8535d2dba67fbb671165', 'normal');
INSERT INTO `userInfo` VALUES ('43', 'djdjfjfjf', '9676f07f1bc17ff668f37b30c56d925b', 'normal');
INSERT INTO `userInfo` VALUES ('44', 'djdjfjfjf', '9676f07f1bc17ff668f37b30c56d925b', 'normal');
INSERT INTO `userInfo` VALUES ('45', 'djdjfjfjf', '9676f07f1bc17ff668f37b30c56d925b', 'normal');
INSERT INTO `userInfo` VALUES ('46', 'djdjfjfjf', '9676f07f1bc17ff668f37b30c56d925b', 'normal');
INSERT INTO `userInfo` VALUES ('47', 'djdjfjfjf', '9676f07f1bc17ff668f37b30c56d925b', 'normal');
INSERT INTO `userInfo` VALUES ('48', 'djdjfjfjf', '9676f07f1bc17ff668f37b30c56d925b', 'normal');
INSERT INTO `userInfo` VALUES ('49', 'djdjfjfjf', '9676f07f1bc17ff668f37b30c56d925b', 'normal');
INSERT INTO `userInfo` VALUES ('50', 'djdjfjfjf', '9676f07f1bc17ff668f37b30c56d925b', 'normal');
INSERT INTO `userInfo` VALUES ('51', 'djdjfjfjf', '9676f07f1bc17ff668f37b30c56d925b', 'normal');
INSERT INTO `userInfo` VALUES ('52', 'djdjfjfjf', '9676f07f1bc17ff668f37b30c56d925b', 'normal');
INSERT INTO `userInfo` VALUES ('53', 'djdjfjfjf', '9676f07f1bc17ff668f37b30c56d925b', 'normal');
INSERT INTO `userInfo` VALUES ('54', 'djdjfjfjf', '9676f07f1bc17ff668f37b30c56d925b', 'normal');
INSERT INTO `userInfo` VALUES ('55', 'djdjfjfjf', '9676f07f1bc17ff668f37b30c56d925b', 'normal');
INSERT INTO `userInfo` VALUES ('56', 'djdjfjfjf', '9676f07f1bc17ff668f37b30c56d925b', 'normal');
INSERT INTO `userInfo` VALUES ('57', 'djdjfjfjf', '9676f07f1bc17ff668f37b30c56d925b', 'normal');
INSERT INTO `userInfo` VALUES ('58', 'djdjfjfjf', '9676f07f1bc17ff668f37b30c56d925b', 'normal');
INSERT INTO `userInfo` VALUES ('59', 'xndncncn', 'ec929757f01bfa69e3b141dec1c4e84c', 'normal');
INSERT INTO `userInfo` VALUES ('60', 'xndncncn', 'ec929757f01bfa69e3b141dec1c4e84c', 'normal');
INSERT INTO `userInfo` VALUES ('61', 'asdasd', 'ec02c59dee6faaca3189bace969c22d3', 'normal');
INSERT INTO `userInfo` VALUES ('62', 'xndncncn', 'ec929757f01bfa69e3b141dec1c4e84c', 'normal');
INSERT INTO `userInfo` VALUES ('63', 'xndncncn', 'ec929757f01bfa69e3b141dec1c4e84c', 'normal');
INSERT INTO `userInfo` VALUES ('64', 'xndncncn', 'ec929757f01bfa69e3b141dec1c4e84c', 'normal');
INSERT INTO `userInfo` VALUES ('65', 'xndncncn', 'ec929757f01bfa69e3b141dec1c4e84c', 'normal');
INSERT INTO `userInfo` VALUES ('66', 'xndncncn', 'ec929757f01bfa69e3b141dec1c4e84c', 'normal');
INSERT INTO `userInfo` VALUES ('67', 'xndncncn', 'ec929757f01bfa69e3b141dec1c4e84c', 'normal');
INSERT INTO `userInfo` VALUES ('68', 'jddjfnfk', '97146d4716d3710f8c2128490464b23e', 'normal');
INSERT INTO `userInfo` VALUES ('69', 'jddjfnfk', '97146d4716d3710f8c2128490464b23e', 'normal');
INSERT INTO `userInfo` VALUES ('70', 'jddjfnfk', '97146d4716d3710f8c2128490464b23e', 'normal');
INSERT INTO `userInfo` VALUES ('71', 'jddjfnfk', '97146d4716d3710f8c2128490464b23e', 'normal');
INSERT INTO `userInfo` VALUES ('72', 'jddjfnfk', '97146d4716d3710f8c2128490464b23e', 'normal');
INSERT INTO `userInfo` VALUES ('73', 'jddjfnfk', '97146d4716d3710f8c2128490464b23e', 'normal');
INSERT INTO `userInfo` VALUES ('74', 'jddjfnfk', '97146d4716d3710f8c2128490464b23e', 'normal');
INSERT INTO `userInfo` VALUES ('75', 'jddjfnfk', '97146d4716d3710f8c2128490464b23e', 'normal');
INSERT INTO `userInfo` VALUES ('76', 'jddjfnfk', '97146d4716d3710f8c2128490464b23e', 'normal');
INSERT INTO `userInfo` VALUES ('77', 'jdjdjdjfj', '1693cdcabdd426ba76776205f5bc05fc', 'normal');
INSERT INTO `userInfo` VALUES ('78', 'rjfnfngng', '13c7b91dbd1e80166db7fdbb24840154', 'normal');
INSERT INTO `userInfo` VALUES ('79', 'djdjdjjf', 'f28e0042da5c0c54f830c1ca98e91338', 'normal');
INSERT INTO `userInfo` VALUES ('80', 'dujdfjjf', '413d5d4843ef8b715e956f330672792f', 'normal');
INSERT INTO `userInfo` VALUES ('81', 'fjcncncmc', 'a866d9b0ccde88906c8e91935793a67e', 'normal');
INSERT INTO `userInfo` VALUES ('82', '', 'd41d8cd98f00b204e9800998ecf8427e', 'normal');
INSERT INTO `userInfo` VALUES ('83', 'test', 'e10adc3949ba59abbe56e057f20f883e', 'normal');
INSERT INTO `userInfo` VALUES ('84', 'test', 'e10adc3949ba59abbe56e057f20f883e', 'normal');
INSERT INTO `userInfo` VALUES ('85', 'test', 'e10adc3949ba59abbe56e057f20f883e', 'normal');
INSERT INTO `userInfo` VALUES ('86', 'test', 'e10adc3949ba59abbe56e057f20f883e', 'normal');
INSERT INTO `userInfo` VALUES ('87', 'test', 'e10adc3949ba59abbe56e057f20f883e', 'normal');
INSERT INTO `userInfo` VALUES ('88', 'test', 'e10adc3949ba59abbe56e057f20f883e', 'normal');
INSERT INTO `userInfo` VALUES ('89', 'test', 'e10adc3949ba59abbe56e057f20f883e', 'normal');
INSERT INTO `userInfo` VALUES ('90', 'test', 'e10adc3949ba59abbe56e057f20f883e', 'normal');
INSERT INTO `userInfo` VALUES ('91', 'test', 'e10adc3949ba59abbe56e057f20f883e', 'normal');
INSERT INTO `userInfo` VALUES ('92', 'test', 'e10adc3949ba59abbe56e057f20f883e', 'normal');
INSERT INTO `userInfo` VALUES ('93', 'test', 'e10adc3949ba59abbe56e057f20f883e', 'normal');
INSERT INTO `userInfo` VALUES ('94', 'test', 'e10adc3949ba59abbe56e057f20f883e', 'normal');
INSERT INTO `userInfo` VALUES ('95', 'test', 'e10adc3949ba59abbe56e057f20f883e', 'normal');
INSERT INTO `userInfo` VALUES ('96', 'test', 'e10adc3949ba59abbe56e057f20f883e', 'normal');
INSERT INTO `userInfo` VALUES ('97', 'test', 'e10adc3949ba59abbe56e057f20f883e', 'normal');
INSERT INTO `userInfo` VALUES ('98', 'test', 'e10adc3949ba59abbe56e057f20f883e', 'normal');
INSERT INTO `userInfo` VALUES ('99', 'test', 'e10adc3949ba59abbe56e057f20f883e', 'normal');
INSERT INTO `userInfo` VALUES ('100', 'test', 'e10adc3949ba59abbe56e057f20f883e', 'normal');
INSERT INTO `userInfo` VALUES ('101', 'test', 'e10adc3949ba59abbe56e057f20f883e', 'normal');
INSERT INTO `userInfo` VALUES ('102', 'test', 'e10adc3949ba59abbe56e057f20f883e', 'normal');
INSERT INTO `userInfo` VALUES ('103', 'test', 'e10adc3949ba59abbe56e057f20f883e', 'normal');
INSERT INTO `userInfo` VALUES ('104', 'test', 'e10adc3949ba59abbe56e057f20f883e', 'normal');
INSERT INTO `userInfo` VALUES ('105', 'test', 'e10adc3949ba59abbe56e057f20f883e', 'normal');
INSERT INTO `userInfo` VALUES ('106', 'test', 'e10adc3949ba59abbe56e057f20f883e', 'normal');
INSERT INTO `userInfo` VALUES ('107', 'jddjfjfj', 'a9208ba091bbd5682c5a22b4d4a20c7f', 'normal');
INSERT INTO `userInfo` VALUES ('108', 'jddjfjfj', 'a9208ba091bbd5682c5a22b4d4a20c7f', 'normal');
INSERT INTO `userInfo` VALUES ('109', 'jddjfjfj', 'a9208ba091bbd5682c5a22b4d4a20c7f', 'normal');
INSERT INTO `userInfo` VALUES ('110', 'jddjfjfj', 'a9208ba091bbd5682c5a22b4d4a20c7f', 'normal');
INSERT INTO `userInfo` VALUES ('111', 'jddjfjfj', 'a9208ba091bbd5682c5a22b4d4a20c7f', 'normal');
INSERT INTO `userInfo` VALUES ('112', 'jddjfjfj', 'a9208ba091bbd5682c5a22b4d4a20c7f', 'normal');
INSERT INTO `userInfo` VALUES ('113', 'jddjfjfj', 'a9208ba091bbd5682c5a22b4d4a20c7f', 'normal');
INSERT INTO `userInfo` VALUES ('114', 'jddjfjfj', 'a9208ba091bbd5682c5a22b4d4a20c7f', 'normal');
INSERT INTO `userInfo` VALUES ('115', 'jddjfjfj', 'a9208ba091bbd5682c5a22b4d4a20c7f', 'normal');
INSERT INTO `userInfo` VALUES ('116', 'jddjfjfj', 'a9208ba091bbd5682c5a22b4d4a20c7f', 'normal');
INSERT INTO `userInfo` VALUES ('117', 'jddjfjfj', 'a9208ba091bbd5682c5a22b4d4a20c7f', 'normal');
INSERT INTO `userInfo` VALUES ('118', 'jddjfjfj', 'a9208ba091bbd5682c5a22b4d4a20c7f', 'normal');
INSERT INTO `userInfo` VALUES ('119', 'jddjfjfj', 'a9208ba091bbd5682c5a22b4d4a20c7f', 'normal');
INSERT INTO `userInfo` VALUES ('120', 'jddjfjfj', 'a9208ba091bbd5682c5a22b4d4a20c7f', 'normal');
INSERT INTO `userInfo` VALUES ('121', 'jddjfjfj', 'a9208ba091bbd5682c5a22b4d4a20c7f', 'normal');
INSERT INTO `userInfo` VALUES ('122', 'jddjfjfj', 'a9208ba091bbd5682c5a22b4d4a20c7f', 'normal');
INSERT INTO `userInfo` VALUES ('123', 'jddjfjfj', 'a9208ba091bbd5682c5a22b4d4a20c7f', 'normal');
INSERT INTO `userInfo` VALUES ('124', 'jddjfjfj', 'a9208ba091bbd5682c5a22b4d4a20c7f', 'normal');
INSERT INTO `userInfo` VALUES ('125', 'jddjfjfj', 'a9208ba091bbd5682c5a22b4d4a20c7f', 'normal');
INSERT INTO `userInfo` VALUES ('126', 'jddjfjfj', 'a9208ba091bbd5682c5a22b4d4a20c7f', 'normal');
INSERT INTO `userInfo` VALUES ('127', 'jddjfjfj', 'a9208ba091bbd5682c5a22b4d4a20c7f', 'normal');
INSERT INTO `userInfo` VALUES ('128', 'jddjfjfj', 'a9208ba091bbd5682c5a22b4d4a20c7f', 'normal');
INSERT INTO `userInfo` VALUES ('129', 'jddjfjfj', 'a9208ba091bbd5682c5a22b4d4a20c7f', 'normal');
INSERT INTO `userInfo` VALUES ('130', 'jddjfjfj', 'a9208ba091bbd5682c5a22b4d4a20c7f', 'normal');
INSERT INTO `userInfo` VALUES ('131', 'jddjfjfj', 'a9208ba091bbd5682c5a22b4d4a20c7f', 'normal');
INSERT INTO `userInfo` VALUES ('132', 'jddjfjfj', 'a9208ba091bbd5682c5a22b4d4a20c7f', 'normal');
INSERT INTO `userInfo` VALUES ('133', 'jddjfjfj', 'a9208ba091bbd5682c5a22b4d4a20c7f', 'normal');
INSERT INTO `userInfo` VALUES ('134', 'jddjfjfj', 'a9208ba091bbd5682c5a22b4d4a20c7f', 'normal');
INSERT INTO `userInfo` VALUES ('135', 'jddjfjfj', 'a9208ba091bbd5682c5a22b4d4a20c7f', 'normal');
INSERT INTO `userInfo` VALUES ('136', 'jddjfjfj', 'a9208ba091bbd5682c5a22b4d4a20c7f', 'normal');
INSERT INTO `userInfo` VALUES ('137', 'test', 'e10adc3949ba59abbe56e057f20f883e', 'normal');
INSERT INTO `userInfo` VALUES ('138', 'test', 'e10adc3949ba59abbe56e057f20f883e', 'normal');
INSERT INTO `userInfo` VALUES ('139', 'test', 'e10adc3949ba59abbe56e057f20f883e', 'normal');
INSERT INTO `userInfo` VALUES ('140', 'test', 'e10adc3949ba59abbe56e057f20f883e', 'normal');
INSERT INTO `userInfo` VALUES ('141', 'test', 'e10adc3949ba59abbe56e057f20f883e', 'normal');
INSERT INTO `userInfo` VALUES ('142', 'hsdjfnnf', 'f14e5f825ad9986296fd3f89df7933db', 'normal');
INSERT INTO `userInfo` VALUES ('143', 'asdasdasddsfasd', 'a3dcb4d229de6fde0db5686dee47145d', 'normal');
INSERT INTO `userInfo` VALUES ('144', 'asdasdasddsfasd', 'a3dcb4d229de6fde0db5686dee47145d', 'normal');
INSERT INTO `userInfo` VALUES ('145', 'asdasd', 'a8f5f167f44f4964e6c998dee827110c', 'normal');
INSERT INTO `userInfo` VALUES ('146', 'sdasdasd', 'a3dcb4d229de6fde0db5686dee47145d', 'normal');
INSERT INTO `userInfo` VALUES ('147', 'sdasdasd', 'a3dcb4d229de6fde0db5686dee47145d', 'normal');
INSERT INTO `userInfo` VALUES ('148', 'sdasdasd', 'a3dcb4d229de6fde0db5686dee47145d', 'normal');
INSERT INTO `userInfo` VALUES ('149', 'sdasdasd', 'a3dcb4d229de6fde0db5686dee47145d', 'normal');
INSERT INTO `userInfo` VALUES ('150', 'sdasdasd', 'a3dcb4d229de6fde0db5686dee47145d', 'normal');
INSERT INTO `userInfo` VALUES ('151', 'sdasdasd', 'a3dcb4d229de6fde0db5686dee47145d', 'normal');
INSERT INTO `userInfo` VALUES ('152', 'sdasdasd', 'a3dcb4d229de6fde0db5686dee47145d', 'normal');
INSERT INTO `userInfo` VALUES ('153', 'sdasdasd', 'a3dcb4d229de6fde0db5686dee47145d', 'normal');
INSERT INTO `userInfo` VALUES ('154', 'sdasdasd', 'a3dcb4d229de6fde0db5686dee47145d', 'normal');
INSERT INTO `userInfo` VALUES ('155', 'sdasdasd', 'a3dcb4d229de6fde0db5686dee47145d', 'normal');
INSERT INTO `userInfo` VALUES ('156', 'sdasdasd', 'a3dcb4d229de6fde0db5686dee47145d', 'normal');
INSERT INTO `userInfo` VALUES ('157', 'sdasdasd', 'a3dcb4d229de6fde0db5686dee47145d', 'normal');
INSERT INTO `userInfo` VALUES ('158', 'sdasdasd', 'a3dcb4d229de6fde0db5686dee47145d', 'normal');
INSERT INTO `userInfo` VALUES ('159', 'sdasdasd', 'a3dcb4d229de6fde0db5686dee47145d', 'normal');
INSERT INTO `userInfo` VALUES ('160', 'sdasdasd', 'a3dcb4d229de6fde0db5686dee47145d', 'normal');
INSERT INTO `userInfo` VALUES ('161', 'sdasdasd', 'a3dcb4d229de6fde0db5686dee47145d', 'normal');
INSERT INTO `userInfo` VALUES ('162', 'sdasdasd', 'a3dcb4d229de6fde0db5686dee47145d', 'normal');
INSERT INTO `userInfo` VALUES ('163', 'sdasdasd', 'a3dcb4d229de6fde0db5686dee47145d', 'normal');
INSERT INTO `userInfo` VALUES ('164', 'sdasdasd', 'a3dcb4d229de6fde0db5686dee47145d', 'normal');
INSERT INTO `userInfo` VALUES ('165', 'qweqweq', 'a38933e6379e64d2fdbad595cec0b8c9', 'normal');
INSERT INTO `userInfo` VALUES ('166', '', 'd41d8cd98f00b204e9800998ecf8427e', 'normal');
INSERT INTO `userInfo` VALUES ('167', 'asdasdasd', 'a8f5f167f44f4964e6c998dee827110c', 'normal');
INSERT INTO `userInfo` VALUES ('168', 'dsadasd', '71f6ac3385ce284152a64208521c592b', 'normal');
INSERT INTO `userInfo` VALUES ('169', 'dsadasd', '71f6ac3385ce284152a64208521c592b', 'normal');
INSERT INTO `userInfo` VALUES ('170', 'dsadasd', '71f6ac3385ce284152a64208521c592b', 'normal');
INSERT INTO `userInfo` VALUES ('171', 'dsadasd', '71f6ac3385ce284152a64208521c592b', 'normal');
INSERT INTO `userInfo` VALUES ('172', 'dsadasd', '71f6ac3385ce284152a64208521c592b', 'normal');
INSERT INTO `userInfo` VALUES ('173', 'dsadasd', '71f6ac3385ce284152a64208521c592b', 'normal');
INSERT INTO `userInfo` VALUES ('174', 'dsadasd', '71f6ac3385ce284152a64208521c592b', 'normal');
INSERT INTO `userInfo` VALUES ('175', 'dsadasd', '71f6ac3385ce284152a64208521c592b', 'normal');
INSERT INTO `userInfo` VALUES ('176', 'dsadasd', '71f6ac3385ce284152a64208521c592b', 'normal');
INSERT INTO `userInfo` VALUES ('177', 'dsadasd', '71f6ac3385ce284152a64208521c592b', 'normal');
INSERT INTO `userInfo` VALUES ('178', 'dsadasd', '71f6ac3385ce284152a64208521c592b', 'normal');
INSERT INTO `userInfo` VALUES ('179', 'sdasdasdBA', 'a8f5f167f44f4964e6c998dee827110c', 'normal');
INSERT INTO `userInfo` VALUES ('180', 'asdasdasd', 'a8f5f167f44f4964e6c998dee827110c', 'normal');
INSERT INTO `userInfo` VALUES ('181', 'sdasd', '67117df1e2ca460c52084ca261aa85e8', 'normal');
INSERT INTO `userInfo` VALUES ('182', 'sdasd', '67117df1e2ca460c52084ca261aa85e8', 'normal');
INSERT INTO `userInfo` VALUES ('183', 'sdasd', '67117df1e2ca460c52084ca261aa85e8', 'normal');
INSERT INTO `userInfo` VALUES ('184', 'sdasdsadwdasd', '67117df1e2ca460c52084ca261aa85e8', 'normal');
INSERT INTO `userInfo` VALUES ('185', 'adasdasd', '714592cf6b5b5feb1876e70254b2c658', 'normal');
INSERT INTO `userInfo` VALUES ('186', 'adasdasd', '714592cf6b5b5feb1876e70254b2c658', 'normal');
INSERT INTO `userInfo` VALUES ('187', 'adasdasd', '714592cf6b5b5feb1876e70254b2c658', 'normal');
INSERT INTO `userInfo` VALUES ('188', 'adasdasd', '714592cf6b5b5feb1876e70254b2c658', 'normal');
INSERT INTO `userInfo` VALUES ('189', 'r', '342f9c9485be86cb1fa1f18e7aa98b13', 'normal');
INSERT INTO `userInfo` VALUES ('190', 'sdad', 'a008e2a837deb8d0b5a61be1d269ae15', 'normal');
INSERT INTO `userInfo` VALUES ('191', 'sdad', 'a008e2a837deb8d0b5a61be1d269ae15', 'normal');
INSERT INTO `userInfo` VALUES ('192', 'qweqweq', '9f0483c5b5d88722ed180d5656c5798f', 'normal');
INSERT INTO `userInfo` VALUES ('193', 'qweqweqadasd', '9f0483c5b5d88722ed180d5656c5798f', 'normal');
INSERT INTO `userInfo` VALUES ('194', 'sdasd', 'fa1b865d9280d4a488afa30fd60216e7', 'normal');
INSERT INTO `userInfo` VALUES ('195', 'sdasd', 'fa1b865d9280d4a488afa30fd60216e7', 'normal');
INSERT INTO `userInfo` VALUES ('196', 'sdasd', 'fa1b865d9280d4a488afa30fd60216e7', 'normal');
INSERT INTO `userInfo` VALUES ('197', 'sdasda', 'a8f5f167f44f4964e6c998dee827110c', 'normal');
INSERT INTO `userInfo` VALUES ('198', 'sdasda', 'a8f5f167f44f4964e6c998dee827110c', 'normal');
INSERT INTO `userInfo` VALUES ('199', 'sdasda', 'a8f5f167f44f4964e6c998dee827110c', 'normal');
INSERT INTO `userInfo` VALUES ('200', 'asdasdasd', 'a8f5f167f44f4964e6c998dee827110c', 'normal');
INSERT INTO `userInfo` VALUES ('201', '', 'd41d8cd98f00b204e9800998ecf8427e', 'normal');
INSERT INTO `userInfo` VALUES ('202', '', 'd41d8cd98f00b204e9800998ecf8427e', 'normal');
INSERT INTO `userInfo` VALUES ('203', '', 'd41d8cd98f00b204e9800998ecf8427e', 'normal');
INSERT INTO `userInfo` VALUES ('204', '', 'd41d8cd98f00b204e9800998ecf8427e', 'normal');
INSERT INTO `userInfo` VALUES ('205', '', 'd41d8cd98f00b204e9800998ecf8427e', 'normal');
INSERT INTO `userInfo` VALUES ('206', '', 'd41d8cd98f00b204e9800998ecf8427e', 'normal');
INSERT INTO `userInfo` VALUES ('207', 'qweqweqwe', 'bd57f88e2521f7e662c572444c4573d9', 'normal');
INSERT INTO `userInfo` VALUES ('208', 'qweqwe', '023299564b0db47d5f3e476a254d0c21', 'normal');
INSERT INTO `userInfo` VALUES ('209', 'sdasdasd', 'f67c2bcbfcfa30fccb36f72dca22a817', 'normal');
INSERT INTO `userInfo` VALUES ('210', 'adasd', 'a3dcb4d229de6fde0db5686dee47145d', 'normal');
INSERT INTO `userInfo` VALUES ('211', 'asdasdasd', 'a3dcb4d229de6fde0db5686dee47145d', 'normal');
INSERT INTO `userInfo` VALUES ('212', 'asdasdasd', 'a3dcb4d229de6fde0db5686dee47145d', 'normal');
INSERT INTO `userInfo` VALUES ('213', 'qweaweasd', 'a3dcb4d229de6fde0db5686dee47145d', 'normal');
INSERT INTO `userInfo` VALUES ('214', 'asdasdas', '4d62bffac8405b34fd7255d6b3d5f7c6', 'normal');
INSERT INTO `userInfo` VALUES ('215', 'asdasdasd', '07b388be01a34ce7193b130baca74bc1', 'normal');
INSERT INTO `userInfo` VALUES ('216', '中文测试', 'a3dcb4d229de6fde0db5686dee47145d', 'normal');
INSERT INTO `userInfo` VALUES ('217', '中文测试', 'a3dcb4d229de6fde0db5686dee47145d', 'normal');
INSERT INTO `userInfo` VALUES ('218', 'rjfnfnf', 'd32d5d7dd09a13127b74dae6be15d7b6', 'normal');
INSERT INTO `userInfo` VALUES ('219', '', 'd41d8cd98f00b204e9800998ecf8427e', 'normal');
INSERT INTO `userInfo` VALUES ('220', 'hxnxnf', '7d9a339be40eea072db3826445db1156', 'normal');
INSERT INTO `userInfo` VALUES ('221', 'jdjdndnd', 'ae6ed7ca55890075b270a0615f7e6bb9', 'normal');
INSERT INTO `userInfo` VALUES ('222', 'o9', 'e85e07f6fe79b13a70065ea679fe37d5', 'normal');
INSERT INTO `userInfo` VALUES ('223', '', 'd41d8cd98f00b204e9800998ecf8427e', 'normal');
INSERT INTO `userInfo` VALUES ('224', 'test', 'e10adc3949ba59abbe56e057f20f883e', 'normal');
INSERT INTO `userInfo` VALUES ('225', 'test', 'e10adc3949ba59abbe56e057f20f883e', 'normal');
INSERT INTO `userInfo` VALUES ('226', 'djdjdn', 'eff6948a94115f7125fcc5f3cd40a96e', 'normal');
INSERT INTO `userInfo` VALUES ('227', 'ggg', '5bc39f86da9cc55654690646a0a06561', 'normal');
INSERT INTO `userInfo` VALUES ('228', 'asdasd', 'a3dcb4d229de6fde0db5686dee47145d', 'normal');
INSERT INTO `userInfo` VALUES ('229', 'asdasd', 'a3dcb4d229de6fde0db5686dee47145d', 'normal');
INSERT INTO `userInfo` VALUES ('230', '不错不错', 'd41d8cd98f00b204e9800998ecf8427e', 'normal');
INSERT INTO `userInfo` VALUES ('231', 'baidu', 'bfe279945c6109d067bcd295b5189d86', 'normal');
INSERT INTO `userInfo` VALUES ('232', 'test', 'e10adc3949ba59abbe56e057f20f883e', 'normal');
INSERT INTO `userInfo` VALUES ('233', '1', 'c4ca4238a0b923820dcc509a6f75849b', 'normal');
INSERT INTO `userInfo` VALUES ('234', '1', 'c4ca4238a0b923820dcc509a6f75849b', 'normal');
INSERT INTO `userInfo` VALUES ('235', '1', 'c4ca4238a0b923820dcc509a6f75849b', 'normal');
INSERT INTO `userInfo` VALUES ('236', '1', 'c4ca4238a0b923820dcc509a6f75849b', 'normal');
INSERT INTO `userInfo` VALUES ('237', '1', 'c4ca4238a0b923820dcc509a6f75849b', 'normal');
INSERT INTO `userInfo` VALUES ('238', '1', 'c4ca4238a0b923820dcc509a6f75849b', 'normal');
INSERT INTO `userInfo` VALUES ('239', '', 'd41d8cd98f00b204e9800998ecf8427e', 'normal');
INSERT INTO `userInfo` VALUES ('240', '', 'd41d8cd98f00b204e9800998ecf8427e', 'normal');
INSERT INTO `userInfo` VALUES ('241', 'ydfgd', '9b24679ee2abc8ca012ca4b07223739f', 'normal');
INSERT INTO `userInfo` VALUES ('242', 'asdasd111111111111', '922ec9531b1f94add983a8ce2ebdc97b', 'normal');
INSERT INTO `userInfo` VALUES ('243', '123123', 'a3dcb4d229de6fde0db5686dee47145d', 'normal');
INSERT INTO `userInfo` VALUES ('244', '123123', 'a3dcb4d229de6fde0db5686dee47145d', 'normal');
INSERT INTO `userInfo` VALUES ('245', '123123', '202cb962ac59075b964b07152d234b70', 'normal');
INSERT INTO `userInfo` VALUES ('246', '123123', '202cb962ac59075b964b07152d234b70', 'normal');
INSERT INTO `userInfo` VALUES ('247', 'popo', '202cb962ac59075b964b07152d234b70', 'normal');
INSERT INTO `userInfo` VALUES ('248', 'acb', '5ff832d9bca8241d653279756f3ccd11', 'normal');
INSERT INTO `userInfo` VALUES ('249', 'acb', '5ff832d9bca8241d653279756f3ccd11', 'normal');
INSERT INTO `userInfo` VALUES ('250', '20150923', 'e10adc3949ba59abbe56e057f20f883e', 'normal');
INSERT INTO `userInfo` VALUES ('251', '20150923', 'e10adc3949ba59abbe56e057f20f883e', 'normal');
INSERT INTO `userInfo` VALUES ('252', 'hyg', 'f8d98d3b397811f73e5869ec5e34707b', 'normal');
INSERT INTO `userInfo` VALUES ('253', 'yugung', 'dbfec8efa3b0a992253d8eaea068bcbd', 'normal');
INSERT INTO `userInfo` VALUES ('254', 'hu', '18bd9197cb1d833bc352f47535c00320', 'normal');
INSERT INTO `userInfo` VALUES ('255', '123', '202cb962ac59075b964b07152d234b70', 'normal');
INSERT INTO `userInfo` VALUES ('256', 'hua', 'a4fdbfbe6a68f0a0088c2d98c6447311', 'normal');
INSERT INTO `userInfo` VALUES ('257', '777', 'f1c1592588411002af340cbaedd6fc33', 'normal');
INSERT INTO `userInfo` VALUES ('258', '', 'd41d8cd98f00b204e9800998ecf8427e', 'normal');
