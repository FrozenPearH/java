/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50727
Source Host           : localhost:3306
Source Database       : hap_dev

Target Server Type    : MYSQL
Target Server Version : 50727
File Encoding         : 65001

Date: 2019-09-11 21:09:24
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for hap_om_order_headers
-- ----------------------------
DROP TABLE IF EXISTS `hap_om_order_headers`;
CREATE TABLE `hap_om_order_headers` (
  `HEADER_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '订单头ID',
  `ORDER_NUMBER` varchar(60) NOT NULL COMMENT '订单编号',
  `COMPANY_ID` bigint(20) NOT NULL COMMENT '公司ID',
  `ORDER_DATE` datetime NOT NULL COMMENT '订单日期',
  `ORDER_STATUS` varchar(30) NOT NULL COMMENT '订单状态',
  `CUSTOMER_ID` bigint(20) NOT NULL COMMENT '客户ID',
  `OBJECT_VERSION_NUMBER` decimal(20,0) DEFAULT '1',
  `REQUEST_ID` bigint(20) DEFAULT '-1' COMMENT '请求号',
  `PROGRAM_ID` bigint(20) DEFAULT '-1',
  `CREATION_DATE` datetime DEFAULT CURRENT_TIMESTAMP,
  `CREATED_BY` decimal(20,0) DEFAULT '-1',
  `LAST_UPDATED_BY` decimal(20,0) DEFAULT '-1',
  `LAST_UPDATE_DATE` datetime DEFAULT CURRENT_TIMESTAMP,
  `LAST_UPDATE_LOGIN` decimal(20,0) DEFAULT NULL,
  `ATTRIBUTE_CATEGORY` varchar(30) DEFAULT NULL,
  `ATTRIBUTE1` varchar(240) DEFAULT NULL,
  `ATTRIBUTE2` varchar(240) DEFAULT NULL,
  `ATTRIBUTE3` varchar(240) DEFAULT NULL,
  `ATTRIBUTE4` varchar(240) DEFAULT NULL,
  `ATTRIBUTE5` varchar(240) DEFAULT NULL,
  `ATTRIBUTE6` varchar(240) DEFAULT NULL,
  `ATTRIBUTE7` varchar(240) DEFAULT NULL,
  `ATTRIBUTE8` varchar(240) DEFAULT NULL,
  `ATTRIBUTE9` varchar(240) DEFAULT NULL,
  `ATTRIBUTE10` varchar(240) DEFAULT NULL,
  `ATTRIBUTE11` varchar(240) DEFAULT NULL,
  `ATTRIBUTE12` varchar(240) DEFAULT NULL,
  `ATTRIBUTE13` varchar(240) DEFAULT NULL,
  `ATTRIBUTE14` varchar(240) DEFAULT NULL,
  `ATTRIBUTE15` varchar(240) DEFAULT NULL,
  PRIMARY KEY (`HEADER_ID`)
) ENGINE=MyISAM AUTO_INCREMENT=1022 DEFAULT CHARSET=utf8 COMMENT='销售订单头表';

-- ----------------------------
-- Records of hap_om_order_headers
-- ----------------------------
INSERT INTO `hap_om_order_headers` VALUES ('1000', '1000', '101', '2019-09-07 00:00:00', 'NEW', '202', '15', '-1', '-1', '2019-09-07 11:20:50', '-1', '10001', '2019-09-11 20:36:02', '10001', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `hap_om_order_headers` VALUES ('1001', '1001', '104', '2019-09-09 00:00:00', 'NEW', '205', '12', '-1', '-1', '2019-09-09 10:24:20', '-1', '10001', '2019-09-11 11:56:29', '10001', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `hap_om_order_headers` VALUES ('1010', '12312', '101', '2019-09-19 00:00:00', 'NEW', '201', '20', '-1', '-1', '2019-09-10 17:16:49', '-1', '10001', '2019-09-11 16:12:08', '10001', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `hap_om_order_headers` VALUES ('1020', '1222', '101', '2019-09-17 00:00:00', 'NEW', '203', '1', '-1', '-1', '2019-09-11 20:24:21', '-1', '10001', '2019-09-11 20:24:22', '10001', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `hap_om_order_headers` VALUES ('1021', '122', '101', '2019-09-11 00:00:00', 'NEW', '204', '1', '-1', '-1', '2019-09-11 21:05:32', '-1', '10001', '2019-09-11 21:05:32', '10001', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
