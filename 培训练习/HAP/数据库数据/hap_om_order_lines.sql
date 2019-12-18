/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50727
Source Host           : localhost:3306
Source Database       : hap_dev

Target Server Type    : MYSQL
Target Server Version : 50727
File Encoding         : 65001

Date: 2019-09-11 21:09:30
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for hap_om_order_lines
-- ----------------------------
DROP TABLE IF EXISTS `hap_om_order_lines`;
CREATE TABLE `hap_om_order_lines` (
  `LINE_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '订单行ID',
  `HEADER_ID` bigint(20) NOT NULL COMMENT '订单头ID',
  `LINE_NUMBER` bigint(20) NOT NULL COMMENT '行号',
  `INVENTORY_ITEM_ID` bigint(20) NOT NULL COMMENT '产品ID',
  `ORDERD_QUANTITY` bigint(20) NOT NULL COMMENT '数量',
  `ORDER_QUANTITY_UOM` varchar(30) NOT NULL COMMENT '产品单位',
  `UNIT_SELLING_PRICE` bigint(20) NOT NULL COMMENT '销售单价',
  `DESCRIPTION` varchar(240) NOT NULL COMMENT '备注',
  `COMPANY_ID` bigint(20) NOT NULL COMMENT '公司ID',
  `ADDITION1` varchar(150) DEFAULT NULL COMMENT '附加信息1',
  `ADDITION2` varchar(150) DEFAULT NULL COMMENT '附加信息2',
  `ADDITION3` varchar(150) DEFAULT NULL COMMENT '附加信息3',
  `ADDITION4` varchar(150) DEFAULT NULL COMMENT '附加信息4',
  `ADDITION5` varchar(150) DEFAULT NULL COMMENT '附加信息5',
  `OBJECT_VERSION_NUMBER` decimal(20,0) DEFAULT '1' COMMENT '行版本号，用来处理锁',
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
  PRIMARY KEY (`LINE_ID`),
  KEY `HAP_OM_ORDER_LINES _N1` (`HEADER_ID`),
  KEY `HAP_OM_ORDER_LINES _N2` (`INVENTORY_ITEM_ID`)
) ENGINE=MyISAM AUTO_INCREMENT=1039 DEFAULT CHARSET=utf8 COMMENT='销售订单行表';

-- ----------------------------
-- Records of hap_om_order_lines
-- ----------------------------
INSERT INTO `hap_om_order_lines` VALUES ('1000', '1000', '1', '1001', '100', 'EA', '20000', 'aaa', '101', null, null, null, null, null, '9', '-1', '-1', '2019-09-07 11:24:34', '-1', '10001', '2019-09-11 19:37:29', '10001', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `hap_om_order_lines` VALUES ('1001', '1000', '2', '1002', '23', 'EA', '200', 'bbb', '101', null, null, null, null, null, '3', '-1', '-1', '2019-09-07 11:27:42', '-1', '10001', '2019-09-10 19:09:41', '10001', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `hap_om_order_lines` VALUES ('1002', '1001', '1', '1002', '200', 'EA', '300', 'cccc', '104', null, null, null, null, null, '8', '-1', '-1', '2019-09-09 10:28:10', '-1', '10001', '2019-09-11 11:56:29', '10001', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `hap_om_order_lines` VALUES ('1003', '1001', '2', '1002', '200', 'EA', '300', 'dddd', '104', null, null, null, null, null, '1', '-1', '-1', '2019-09-09 19:44:56', '10001', '10001', '2019-09-09 19:44:56', '10001', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `hap_om_order_lines` VALUES ('1014', '1010', '1', '1002', '111', 'EA', '11', '111', '101', null, null, null, null, null, '2', '-1', '-1', '2019-09-10 17:16:49', '10001', '10001', '2019-09-10 17:16:55', '10001', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `hap_om_order_lines` VALUES ('1016', '1010', '2', '1001', '111', 'EA', '111', '222', '101', null, null, null, null, null, '1', '-1', '-1', '2019-09-11 09:30:18', '10001', '10001', '2019-09-11 09:30:18', '10001', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `hap_om_order_lines` VALUES ('1036', '1020', '1', '1002', '123', 'EA', '123', '333', '101', null, null, null, null, null, '1', '-1', '-1', '2019-09-11 20:24:22', '10001', '10001', '2019-09-11 20:24:22', '10001', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `hap_om_order_lines` VALUES ('1037', '1000', '3', '1003', '222', 'EA', '222', '222', '101', null, null, null, null, null, '1', '-1', '-1', '2019-09-11 20:36:02', '10001', '10001', '2019-09-11 20:36:02', '10001', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `hap_om_order_lines` VALUES ('1038', '1021', '1', '1003', '123', 'EA', '123', '123', '101', null, null, null, null, null, '1', '-1', '-1', '2019-09-11 21:05:32', '10001', '10001', '2019-09-11 21:05:32', '10001', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
