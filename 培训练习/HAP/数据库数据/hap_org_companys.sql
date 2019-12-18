/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50727
Source Host           : localhost:3306
Source Database       : hap_dev

Target Server Type    : MYSQL
Target Server Version : 50727
File Encoding         : 65001

Date: 2019-09-11 20:37:02
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for hap_org_companys
-- ----------------------------
DROP TABLE IF EXISTS `hap_org_companys`;
CREATE TABLE `hap_org_companys` (
  `COMPANY_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '公司ID',
  `COMPANY_NUMBER` varchar(60) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '公司编号',
  `COMPANY_NAME` varchar(240) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '公司名称',
  `ENABLED_FLAG` varchar(1) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT 'Y' COMMENT '启用标识',
  `CREATION_DATE` datetime DEFAULT CURRENT_TIMESTAMP,
  `CREATED_BY` bigint(20) DEFAULT '-1',
  `LAST_UPDATED_BY` bigint(20) DEFAULT '-1',
  `LAST_UPDATE_DATE` datetime DEFAULT CURRENT_TIMESTAMP,
  `LAST_UPDATE_LOGIN` bigint(20) DEFAULT '-1',
  `OBJECT_VERSION_NUMBER` decimal(20,0) DEFAULT '1' COMMENT '行版本号，用来处理锁',
  `REQUEST_ID` bigint(20) DEFAULT '-1' COMMENT '请求号',
  `PROGRAM_ID` bigint(20) DEFAULT '-1',
  PRIMARY KEY (`COMPANY_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=106 DEFAULT CHARSET=utf8 COMMENT='公司主数据';

-- ----------------------------
-- Records of hap_org_companys
-- ----------------------------
INSERT INTO `hap_org_companys` VALUES ('101', 'HAND001', '汉得信息', 'Y', '2016-08-24 16:48:17', '-1', '-1', '2016-08-24 16:48:17', '-1', '1', '-1', '-1');
INSERT INTO `hap_org_companys` VALUES ('102', 'HAND002', '汉得教育', 'Y', '2016-08-24 16:48:17', '-1', '-1', '2016-08-24 16:48:17', '-1', '1', '-1', '-1');
INSERT INTO `hap_org_companys` VALUES ('103', 'HAND003', '汉得保理', 'Y', '2016-08-24 16:48:17', '-1', '-1', '2016-08-24 16:48:17', '-1', '1', '-1', '-1');
INSERT INTO `hap_org_companys` VALUES ('104', 'HAND004', '随身科技', 'Y', '2016-08-24 16:48:17', '-1', '-1', '2016-08-24 16:48:17', '-1', '1', '-1', '-1');
INSERT INTO `hap_org_companys` VALUES ('105', 'HAND005', '夏尔科技', 'N', '2016-08-24 16:48:17', '-1', '-1', '2016-08-24 16:48:17', '-1', '1', '-1', '-1');
