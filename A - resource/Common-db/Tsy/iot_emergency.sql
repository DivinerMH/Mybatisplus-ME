/*
Navicat MySQL Data Transfer

Source Server         : 192.168.1.175:3306 - IOT 测试
Source Server Version : 50731
Source Host           : 192.168.1.175:3306
Source Database       : iot_emergency

Target Server Type    : MYSQL
Target Server Version : 50731
File Encoding         : 65001

Date: 2021-01-14 16:27:03
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `danger_node`
-- ----------------------------
DROP TABLE IF EXISTS `danger_node`;
CREATE TABLE `danger_node` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键/自增/唯一',
  `inspection_id` int(11) DEFAULT NULL COMMENT '巡检计划id',
  `node_name` varchar(500) DEFAULT NULL COMMENT '节点名称',
  `structure_id` int(11) DEFAULT '0' COMMENT '资产结构id',
  `addr` varchar(500) DEFAULT NULL COMMENT '详细地址',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  `status` char(1) DEFAULT '0' COMMENT '状态：0-未巡检 1-已巡检',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `del_flag` char(1) DEFAULT '0' COMMENT '逻辑删除(0=正常,1=删除)',
  `principal_id` int(10) DEFAULT '0' COMMENT '负责人id',
  `duty_id` int(10) DEFAULT '0' COMMENT '值班人员id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=118 DEFAULT CHARSET=utf8 COMMENT='巡检节点';

-- ----------------------------
-- Records of danger_node
-- ----------------------------
INSERT INTO `danger_node` VALUES ('29', '21', '武汉万通置业有限公司（万通工业园）', '0', '汉阳区玫瑰园东路特8号', null, '0', '2021-01-06 17:03:59', null, '0', '24', '25');
INSERT INTO `danger_node` VALUES ('30', '21', '武汉京膳坊酒店管理有限公司', '0', '武汉市汉阳区彭家岭366号万通工业园第4栋2层', null, '0', '2021-01-06 17:08:04', null, '0', '24', '26');
INSERT INTO `danger_node` VALUES ('31', '21', '武汉恒信雷克萨斯汽车销售服务有限公司', '0', '武汉市汉阳区孟家铺172号', null, '0', '2021-01-06 17:09:19', null, '0', '24', '29');
INSERT INTO `danger_node` VALUES ('32', '21', '武汉恒信中意汽车销售服务有限公司', '0', '武汉市汉阳区孟家铺172号第二层02室', null, '0', '2021-01-06 17:17:10', null, '0', '24', '31');
INSERT INTO `danger_node` VALUES ('33', '21', '武汉恒信悦宝汽车销售服务有限公司', '0', '武汉市汉阳区孟家铺172号第二层03室', null, '0', '2021-01-06 17:17:43', null, '0', '24', '32');
INSERT INTO `danger_node` VALUES ('34', '21', '武汉信一科技发展有限公司', '0', '汉阳区汉阳大道彭家岭378号', null, '0', '2021-01-06 17:18:16', null, '0', '24', '34');
INSERT INTO `danger_node` VALUES ('35', '21', '武汉未来集团（未来工业园）', '0', '武汉市汉阳区彭家岭398号', null, '0', '2021-01-06 17:18:47', null, '0', '24', '27');
INSERT INTO `danger_node` VALUES ('36', '21', '武汉盟盛人新能源汽车产业园发展股份有限公司 ', '0', '汉阳区永安堂172号', null, '0', '2021-01-06 17:19:22', null, '1', '0', '0');
INSERT INTO `danger_node` VALUES ('37', '22', '武汉万通置业有限公司（万通工业园）', '0', '汉阳区玫瑰园东路特8号', null, '0', '2021-01-07 09:42:46', null, '0', '24', '25');
INSERT INTO `danger_node` VALUES ('38', '22', '武汉未来集团', '0', '武汉市汉阳区彭家岭398号', null, '0', '2021-01-07 09:48:04', null, '0', '24', '134');
INSERT INTO `danger_node` VALUES ('39', '22', '武汉恒信雷克萨斯汽车销售服务有限公司', '0', '武汉市汉阳区孟家铺172号', null, '0', '2021-01-07 09:48:59', null, '0', '24', '29');
INSERT INTO `danger_node` VALUES ('40', '22', '武汉恒信中意汽车销售服务有限公司', '0', '武汉市汉阳区孟家铺172号第二层02室', null, '0', '2021-01-07 09:50:09', null, '0', '24', '31');
INSERT INTO `danger_node` VALUES ('41', '22', '武汉恒信悦宝汽车销售服务有限公司', '0', '武汉市汉阳区孟家铺172号第二层03室', null, '0', '2021-01-07 09:52:51', null, '0', '24', '32');
INSERT INTO `danger_node` VALUES ('42', '22', '武汉信一科技发展有限公司', '0', '武汉市汉阳区汉阳大道彭家岭378号', null, '0', '2021-01-07 09:53:48', null, '0', '24', '135');
INSERT INTO `danger_node` VALUES ('43', '21', '武汉盟盛人新能源汽车产业园发展股份有限公司', '0', '武汉市汉阳区永安堂172号', null, '0', '2021-01-07 09:54:38', null, '0', '24', '36');
INSERT INTO `danger_node` VALUES ('44', '22', '武汉和平风机有限责任公司', '0', '武汉市汉阳区琴断口街黄金口三村270号', null, '0', '2021-01-07 09:58:11', null, '0', '28', '37');
INSERT INTO `danger_node` VALUES ('45', '22', '武汉优耐特科技有限公司', '0', '武汉市汉阳区琴断口街黄金口三村270号', null, '0', '2021-01-07 09:58:56', null, '0', '28', '136');
INSERT INTO `danger_node` VALUES ('46', '22', '武汉显捷电子有限公司', '0', '武汉市汉阳区永丰街彭家岭366号（万通工业园5-2-3号）', null, '0', '2021-01-07 09:59:30', null, '0', '28', '137');
INSERT INTO `danger_node` VALUES ('47', '22', '湖北捷武实业开发有限公司', '0', '武汉市汉阳区黄金口三村270号3栋1层', null, '0', '2021-01-07 10:00:48', null, '0', '28', '138');
INSERT INTO `danger_node` VALUES ('48', '22', '武汉欣建桥橡胶科技有限公司', '0', '武汉市汉阳区琴断口街黄金口三村270号黄金口科技企业孵化基地西区特1号', null, '0', '2021-01-07 10:01:36', null, '0', '28', '44');
INSERT INTO `danger_node` VALUES ('49', '22', '武汉阿迪克电子股份有限公司', '0', '武汉市汉阳区琴断口街黄金口三村270号', null, '0', '2021-01-07 10:02:46', null, '0', '28', '45');
INSERT INTO `danger_node` VALUES ('50', '22', '武汉宝特龙信息科技有限公司', '0', '武汉市汉阳区琴断口街黄金口三村270号', null, '0', '2021-01-07 10:03:53', null, '0', '28', '139');
INSERT INTO `danger_node` VALUES ('51', '22', '武汉日和汽车零部件有限公司', '0', '武汉市汉阳区仙山社区周湾303号', null, '0', '2021-01-07 10:04:41', null, '0', '28', '48');
INSERT INTO `danger_node` VALUES ('52', '22', '武汉福运隆科技企业孵化器管理有限公司(福运隆工业园)', '0', '武汉市汉阳区黄金口工业园金花路18号3号楼', null, '0', '2021-01-07 10:06:16', null, '0', '28', '141');
INSERT INTO `danger_node` VALUES ('53', '22', '武汉市宏昌炉料有限公司', '0', '武汉市汉阳区黄金口五村特1号', null, '0', '2021-01-07 10:06:52', null, '0', '28', '142');
INSERT INTO `danger_node` VALUES ('54', '22', '武汉力安商贸有限公司（工业园）', '0', '武汉市汉阳区黄金口三村270号饲料添加剂生产基地综合楼1-2层', null, '0', '2021-01-07 10:07:22', null, '0', '28', '143');
INSERT INTO `danger_node` VALUES ('55', '22', '武汉黄金口科技产业开发有限公司（金科创业大厦）', '0', '武汉市汉阳区琴断口街黄金口三村270号', null, '0', '2021-01-07 10:08:03', null, '0', '30', '52');
INSERT INTO `danger_node` VALUES ('56', '21', '武汉和平风机有限责任公司（工业园）', '0', '武汉市汉阳区琴断口街黄金口三村270号', null, '0', '2021-01-07 10:10:46', null, '0', '28', '37');
INSERT INTO `danger_node` VALUES ('57', '22', '百威（武汉）啤酒有限公司', '0', '武汉市汉阳区琴断口上首', null, '0', '2021-01-07 10:12:21', null, '0', '30', '144');
INSERT INTO `danger_node` VALUES ('58', '21', '武汉优耐特科技有限公司', '0', '武汉市汉阳区琴断口街黄金口三村270号', null, '0', '2021-01-07 10:12:25', null, '0', '28', '38');
INSERT INTO `danger_node` VALUES ('59', '22', '武汉市汉桥船舶制造有限公司', '0', '武汉市汉阳区金福路18号', null, '0', '2021-01-07 10:13:29', null, '0', '30', '145');
INSERT INTO `danger_node` VALUES ('60', '21', '武汉显捷电子有限公司', '0', '汉阳区永丰街彭家岭366号（万通工业园5-2-3号）', null, '0', '2021-01-07 10:13:35', null, '0', '28', '40');
INSERT INTO `danger_node` VALUES ('61', '21', '湖北捷武实业开发有限公司 （工业园）', '0', '武汉市汉阳区黄金口三村270号3栋1层', null, '0', '2021-01-07 10:14:18', null, '0', '28', '42');
INSERT INTO `danger_node` VALUES ('62', '21', '武汉欣建桥橡胶科技有限公司', '0', '武汉市汉阳区琴断口街黄金口三村270号黄金口科技企业孵化基地西区特1号', null, '0', '2021-01-07 10:14:59', null, '0', '28', '44');
INSERT INTO `danger_node` VALUES ('63', '22', '武汉新塔医疗科技有限公司', '0', '武汉市汉阳区黄金口工业园百威路18号', null, '0', '2021-01-07 10:15:50', null, '0', '30', '57');
INSERT INTO `danger_node` VALUES ('64', '21', '武汉阿迪克电子有限公司', '0', '武汉市汉阳区琴断口街黄金口三村270号', null, '0', '2021-01-07 10:15:53', null, '0', '28', '45');
INSERT INTO `danger_node` VALUES ('65', '21', '武汉宝特龙信息科技有限公司', '0', '汉阳区琴断口街黄金口三村270号', null, '0', '2021-01-07 10:16:20', null, '0', '28', '47');
INSERT INTO `danger_node` VALUES ('66', '22', '武汉理想新世纪工贸发展有限公司', '0', '武汉市汉阳区黄金口工业园金花路1号1栋', null, '0', '2021-01-07 10:16:54', null, '0', '30', '146');
INSERT INTO `danger_node` VALUES ('67', '22', '武汉中鹏油脂工业有限公司', '0', '武汉市汉阳区永丰街黄金口工业园金福路16号', null, '0', '2021-01-07 10:17:26', null, '0', '30', '59');
INSERT INTO `danger_node` VALUES ('68', '22', '武汉仓管家置业有限公司', '0', '武汉市汉阳区黄金口五村特1号5栋', null, '0', '2021-01-07 10:18:22', null, '0', '30', '147');
INSERT INTO `danger_node` VALUES ('69', '22', '武汉西高电器有限公司', '0', '武汉市汉阳区黄金口都市工业园百威路10号', null, '0', '2021-01-07 10:18:52', null, '0', '30', '148');
INSERT INTO `danger_node` VALUES ('70', '22', '武汉罗莎食品有限公司', '0', '湖北省武汉市汉阳区金色环路琴台大道米粮公交站西100米', null, '0', '2021-01-07 10:20:54', null, '0', '33', '149');
INSERT INTO `danger_node` VALUES ('71', '21', '武汉日和汽车零部件有限公司', '0', '武汉市汉阳区仙山社区周湾303号', null, '0', '2021-01-07 10:22:10', null, '0', '28', '48');
INSERT INTO `danger_node` VALUES ('72', '21', '武汉福运隆科技企业孵化器管理有限公司(福运隆工业园)', '0', '武汉市汉阳区黄金口工业园金花路18号3号楼', null, '0', '2021-01-07 10:22:37', null, '0', '28', '49');
INSERT INTO `danger_node` VALUES ('73', '22', '武汉苏泊尔炊具有限公司', '0', '武汉市汉阳区彭家岭368号', null, '0', '2021-01-07 10:22:42', null, '0', '33', '150');
INSERT INTO `danger_node` VALUES ('74', '21', '武汉市宏昌炉料有限公司', '0', '武汉市汉阳区黄金口五村特1号', null, '0', '2021-01-07 10:23:14', null, '0', '28', '50');
INSERT INTO `danger_node` VALUES ('75', '22', '味好美（武汉）食品有限公司', '0', '武汉市汉阳区金色二路8号', null, '0', '2021-01-07 10:23:52', null, '0', '33', '151');
INSERT INTO `danger_node` VALUES ('76', '22', '武汉建银华盛集团股份有限公司', '0', '武汉市汉阳区金色环路18号第5栋', null, '0', '2021-01-07 10:24:29', null, '0', '33', '152');
INSERT INTO `danger_node` VALUES ('77', '22', '武汉吉远汽车有限责任公司', '0', '武汉市汉阳区黄金口工业园金色环路16号', null, '0', '2021-01-07 10:25:08', null, '0', '33', '153');
INSERT INTO `danger_node` VALUES ('78', '22', '武汉天鸣服饰有限公司（工业园）及天鸣二期', '0', '武汉市汉阳区天鸣工业园2号楼1楼2号铺位', null, '0', '2021-01-07 10:26:19', null, '0', '33', '69');
INSERT INTO `danger_node` VALUES ('79', '21', '武汉力安商贸有限公司（工业园）', '0', '武汉市汉阳区黄金口三村270号饲料添加剂生产基地综合楼1-2层', null, '0', '2021-01-07 10:28:20', null, '0', '28', '51');
INSERT INTO `danger_node` VALUES ('80', '21', '武汉黄金口科技产业开发有限公司（金科创业大厦）无食堂', '0', '汉阳区琴断口街黄金口三村270号', null, '0', '2021-01-07 10:28:50', null, '0', '28', '52');
INSERT INTO `danger_node` VALUES ('81', '22', '武汉金牛经济发展有限公司', '0', '武汉市汉阳区黄金口工业园金福路8号', null, '0', '2021-01-07 10:30:48', null, '0', '33', '154');
INSERT INTO `danger_node` VALUES ('82', '22', '湖北巨森钢化玻璃有限公司', '0', '武汉市汉阳区百威路9号', null, '0', '2021-01-07 10:31:13', null, '0', '33', '155');
INSERT INTO `danger_node` VALUES ('83', '22', '武汉正安物业管理有限公司（仓储物流园）', '0', '孟家铺路与金色一路交叉口西150米', null, '0', '2021-01-07 10:32:40', null, '0', '35', '156');
INSERT INTO `danger_node` VALUES ('84', '22', '武汉福达坊食用油有限公司', '0', '汉阳区黄金口工业园金色环路9号', null, '0', '2021-01-07 10:33:20', null, '0', '35', '157');
INSERT INTO `danger_node` VALUES ('85', '22', '武汉嘉盛包装有限公司', '0', '武汉市汉阳区永丰乡黄金口五村特1号', null, '0', '2021-01-07 10:33:52', null, '0', '35', '74');
INSERT INTO `danger_node` VALUES ('86', '22', '联东U谷项目工地', '0', '汉阳区百威路与金花路交汇处', null, '0', '2021-01-07 10:34:19', null, '0', '35', '158');
INSERT INTO `danger_node` VALUES ('87', '22', '湖北烟草民意纸业有限公司及民意纸业二期', '0', '武汉市汉阳区黄金口工业园金砖路8号', null, '0', '2021-01-07 10:39:16', null, '0', '35', '76');
INSERT INTO `danger_node` VALUES ('88', '22', '武汉加华科技园（其他拟建、在建项目工地施工安全）', '0', '武汉市汉阳区彭家岭398号第3栋3楼303室', null, '0', '2021-01-07 10:39:47', null, '0', '35', '77');
INSERT INTO `danger_node` VALUES ('89', '22', '武汉黄金口新城经贸集团有限公司（园区房屋拆迁安全、拆违、控违安全）', '0', '武汉市汉阳区永丰街黄金口村1号', null, '0', '2021-01-07 10:40:26', null, '0', '35', '159');
INSERT INTO `danger_node` VALUES ('90', '22', '黄金口园区消防安全及烟花爆竹燃放安全', '0', '黄金口园区', null, '0', '2021-01-07 10:42:18', null, '0', '161', '160');
INSERT INTO `danger_node` VALUES ('91', '21', '百威（武汉）啤酒有限公司', '0', '武汉市汉阳区琴断口上首', null, '0', '2021-01-07 10:58:12', null, '0', '30', '53');
INSERT INTO `danger_node` VALUES ('92', '21', '武汉市汉桥船舶制造有限公司（智能制造产业园）', '0', '武汉市汉阳区金福路18号', null, '0', '2021-01-07 10:59:04', null, '0', '30', '55');
INSERT INTO `danger_node` VALUES ('93', '21', '武汉得月阁餐饮管理有限公司', '0', '武汉市汉阳区黄金口什湖大道以东C1栋5号至9号', null, '0', '2021-01-07 10:59:53', null, '0', '30', '56');
INSERT INTO `danger_node` VALUES ('94', '21', '武汉新塔医疗科技有限公司 （工业园）', '0', '武汉市汉阳区黄金口工业园百威路18号', null, '0', '2021-01-07 11:00:19', null, '0', '30', '57');
INSERT INTO `danger_node` VALUES ('95', '21', '武汉理想新世纪工贸发展有限公司（理想工业园）', '0', '武汉市汉阳区黄金口工业园金花路1号1栋', null, '0', '2021-01-07 11:00:43', null, '0', '30', '58');
INSERT INTO `danger_node` VALUES ('96', '21', '武汉中鹏油脂工业有限公司', '0', '武汉市汉阳区永丰街黄金口工业园金福路16号', null, '0', '2021-01-07 11:01:09', null, '0', '30', '59');
INSERT INTO `danger_node` VALUES ('97', '21', '武汉仓管家置业有限公司（汉正街物流园）', '0', '武汉市汉阳区黄金口五村特1号5栋', null, '0', '2021-01-07 11:01:35', null, '0', '30', '60');
INSERT INTO `danger_node` VALUES ('98', '21', '武汉西高电器有限公司（包含西高酒店）', '0', '汉阳区黄金口都市工业园百威路10号', null, '0', '2021-01-07 11:02:00', null, '0', '30', '61');
INSERT INTO `danger_node` VALUES ('99', '21', '武汉罗莎食品有限公司（食品加工园）', '0', '湖北省武汉市汉阳区金色环路琴台大道米粮公交站西100米', null, '0', '2021-01-07 11:02:30', null, '0', '33', '62');
INSERT INTO `danger_node` VALUES ('100', '21', '首夏食品有限公司（罗莎内）', '0', '武汉市汉阳区金色环路6号2号厂房3楼', null, '0', '2021-01-07 11:02:59', null, '0', '33', '63');
INSERT INTO `danger_node` VALUES ('101', '21', '武汉苏泊尔炊具有限公司', '0', '武汉市汉阳区彭家岭368号', null, '0', '2021-01-07 11:03:48', null, '0', '33', '64');
INSERT INTO `danger_node` VALUES ('102', '21', '味好美（武汉）食品有限公司', '0', '武汉市汉阳区金色二路8号', null, '0', '2021-01-07 11:04:23', null, '0', '33', '65');
INSERT INTO `danger_node` VALUES ('103', '21', '武汉建银华盛集团股份有限公司（建银4S店及建银5S大厦）', '0', '武汉市汉阳区金色环路18号第5栋', null, '0', '2021-01-07 11:04:49', null, '0', '33', '67');
INSERT INTO `danger_node` VALUES ('104', '21', '武汉吉远汽车有限责任公司', '0', '武汉市汉阳区黄金口工业园金色环路16号', null, '0', '2021-01-07 11:05:10', null, '0', '33', '68');
INSERT INTO `danger_node` VALUES ('105', '21', '武汉天鸣服饰有限公司（工业园）', '0', '武汉市汉阳区黄金口都市工业园金福路6号', null, '0', '2021-01-07 11:05:49', null, '0', '33', '69');
INSERT INTO `danger_node` VALUES ('106', '21', '武汉金牛经济发展有限公司', '0', '汉阳区黄金口工业园金福路8号', null, '0', '2021-01-07 11:06:12', null, '0', '33', '70');
INSERT INTO `danger_node` VALUES ('107', '21', '湖北巨森钢化玻璃有限公司', '0', '武汉市汉阳区百威路9号', null, '0', '2021-01-07 11:06:36', null, '0', '33', '71');
INSERT INTO `danger_node` VALUES ('108', '21', '武汉正安物业管理有限公司（仓储物流园）', '0', '孟家铺路与金色一路交叉口西150米', null, '0', '2021-01-07 11:07:05', null, '0', '35', '72');
INSERT INTO `danger_node` VALUES ('109', '21', '武汉福达坊食用油有限公司（福达万品批发城）及福鱼堂', '0', '汉阳区黄金口工业园金色环路9号', null, '0', '2021-01-07 11:11:06', null, '0', '35', '73');
INSERT INTO `danger_node` VALUES ('110', '21', '武汉嘉盛包装有限公司（5.5智能产业园）无食堂', '0', '武汉市汉阳区永丰乡黄金口五村特1号', null, '0', '2021-01-07 11:11:31', null, '0', '35', '74');
INSERT INTO `danger_node` VALUES ('111', '21', '湖北烟草民意纸业有限公司及民意纸业二期', '0', '武汉市汉阳区黄金口工业园金砖路8号', null, '0', '2021-01-07 11:12:13', null, '0', '35', '76');
INSERT INTO `danger_node` VALUES ('112', '21', '武汉加华科技园 （无食堂）', '0', '武汉市汉阳区彭家岭398号第3栋3楼303室', null, '0', '2021-01-07 11:12:43', null, '0', '35', '77');
INSERT INTO `danger_node` VALUES ('113', '21', 'test', '0', '1231231', null, '0', '2021-01-07 15:40:26', null, '1', '24', '25');
INSERT INTO `danger_node` VALUES ('114', '22', '武汉盟盛人新能源汽车产业园发展股份有限公司（盟盛汽车市场内4S店）', '0', '汉阳区永安堂172号', null, '0', '2021-01-07 18:00:41', null, '0', '24', '140');
INSERT INTO `danger_node` VALUES ('115', '21', '联东U谷项目工地', '0', '武汉市汉阳区百威路与金花路交叉路口东南侧(黄金口汽配城东侧约100米)', null, '0', '2021-01-08 11:22:54', null, '0', '35', '75');
INSERT INTO `danger_node` VALUES ('116', '21', '龙欣物流码头', '0', '武汉市汉阳区永丰乡仙山村707', null, '0', '2021-01-08 11:24:24', null, '0', '35', '78');
INSERT INTO `danger_node` VALUES ('117', '21', '武汉黄金口新城经贸集团有限公司(黄金口汽配城)', '0', '汉阳区永丰街黄金口村1号', null, '0', '2021-01-08 11:25:08', null, '0', '35', '79');

-- ----------------------------
-- Table structure for `dangerous_sources`
-- ----------------------------
DROP TABLE IF EXISTS `dangerous_sources`;
CREATE TABLE `dangerous_sources` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `type_id` int(11) DEFAULT NULL COMMENT '危险源分类id',
  `name` varchar(255) DEFAULT NULL COMMENT '危险源名称',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `del_flag` char(1) DEFAULT '0' COMMENT '逻辑删除(0=正常,1=删除)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8 COMMENT='危险源表';

-- ----------------------------
-- Records of dangerous_sources
-- ----------------------------
INSERT INTO `dangerous_sources` VALUES ('27', '8', '氨', '2021-01-06 15:04:14', null, '0');
INSERT INTO `dangerous_sources` VALUES ('28', '8', '氯', '2021-01-06 15:04:32', null, '0');
INSERT INTO `dangerous_sources` VALUES ('29', '10', '粉尘', '2021-01-06 15:04:49', null, '0');
INSERT INTO `dangerous_sources` VALUES ('30', '19', '噪音', '2021-01-06 15:06:11', null, '0');
INSERT INTO `dangerous_sources` VALUES ('31', '7', '特种设备', '2021-01-06 15:06:26', null, '0');
INSERT INTO `dangerous_sources` VALUES ('32', '10', '天然气锅炉', '2021-01-06 15:06:46', null, '0');
INSERT INTO `dangerous_sources` VALUES ('33', '10', '储油库', '2021-01-06 15:07:05', null, '0');
INSERT INTO `dangerous_sources` VALUES ('34', '10', '压力容器', '2021-01-06 15:07:30', null, '0');
INSERT INTO `dangerous_sources` VALUES ('35', '8', '硫酸、亚硝酸', '2021-01-06 15:08:27', null, '0');
INSERT INTO `dangerous_sources` VALUES ('36', '6', '地下水道', '2021-01-06 15:08:45', null, '0');
INSERT INTO `dangerous_sources` VALUES ('37', '6', '集体宿舍', '2021-01-06 15:09:08', '2021-01-06 15:09:21', '0');
INSERT INTO `dangerous_sources` VALUES ('38', '19', '二氧化碳', '2021-01-06 15:10:11', null, '0');
INSERT INTO `dangerous_sources` VALUES ('39', '19', '氩', '2021-01-06 15:10:40', null, '0');
INSERT INTO `dangerous_sources` VALUES ('40', '19', '氦', '2021-01-06 15:10:59', null, '0');
INSERT INTO `dangerous_sources` VALUES ('41', '9', '消防', '2021-01-06 15:11:15', null, '0');
INSERT INTO `dangerous_sources` VALUES ('42', '11', '电', '2021-01-06 15:11:34', null, '0');
INSERT INTO `dangerous_sources` VALUES ('43', '19', '高温', '2021-01-06 15:11:45', null, '0');
INSERT INTO `dangerous_sources` VALUES ('44', '6', '污水池', '2021-01-06 15:12:04', null, '0');
INSERT INTO `dangerous_sources` VALUES ('45', '19', '乙醇', '2021-01-06 15:12:41', null, '0');
INSERT INTO `dangerous_sources` VALUES ('46', '19', '棉尘', '2021-01-06 15:14:12', null, '0');
INSERT INTO `dangerous_sources` VALUES ('47', '6', '地下仓库', '2021-01-06 15:14:30', null, '0');
INSERT INTO `dangerous_sources` VALUES ('48', '19', '地下工程', '2021-01-06 15:14:41', null, '0');
INSERT INTO `dangerous_sources` VALUES ('49', '19', '丁苯橡胶', '2021-01-06 15:15:29', null, '0');

-- ----------------------------
-- Table structure for `dangerous_sources_type`
-- ----------------------------
DROP TABLE IF EXISTS `dangerous_sources_type`;
CREATE TABLE `dangerous_sources_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键/自增/唯一',
  `type_name` varchar(200) DEFAULT NULL COMMENT '危险源分类名称(特种设备、危化品....)',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `del_flag` char(1) DEFAULT '0' COMMENT '逻辑删除(0=正常,1=删除)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='危险源分类表';

-- ----------------------------
-- Records of dangerous_sources_type
-- ----------------------------
INSERT INTO `dangerous_sources_type` VALUES ('1', '社会安全', '2020-10-22 15:43:23', '2020-10-22 15:48:49', '0');
INSERT INTO `dangerous_sources_type` VALUES ('2', '自然灾害-水灾', '2020-10-22 15:45:03', '2020-10-22 15:45:03', '0');
INSERT INTO `dangerous_sources_type` VALUES ('3', '自然灾害-火灾', '2020-10-22 16:10:58', '2020-10-22 16:10:58', '1');
INSERT INTO `dangerous_sources_type` VALUES ('4', '自然灾害-地震', '2020-10-22 16:12:17', '2020-10-22 16:15:57', '0');
INSERT INTO `dangerous_sources_type` VALUES ('5', '自然灾害-台风', '2020-10-22 16:20:26', '2020-10-22 16:20:31', '0');
INSERT INTO `dangerous_sources_type` VALUES ('6', '公共卫生', '2020-10-26 14:49:28', '2020-11-02 16:27:49', '0');
INSERT INTO `dangerous_sources_type` VALUES ('7', '特种设备', '2020-10-27 16:07:54', '2020-10-27 16:07:54', '0');
INSERT INTO `dangerous_sources_type` VALUES ('8', '危化品', '2020-10-27 16:08:05', '2020-10-27 16:08:05', '0');
INSERT INTO `dangerous_sources_type` VALUES ('9', '消防设备', '2020-10-27 16:08:13', '2020-10-27 16:08:13', '0');
INSERT INTO `dangerous_sources_type` VALUES ('10', '易燃易爆', '2020-10-27 16:08:22', '2020-10-27 16:08:22', '0');
INSERT INTO `dangerous_sources_type` VALUES ('11', '用电防控', '2020-10-27 16:08:32', '2020-10-27 16:08:32', '0');
INSERT INTO `dangerous_sources_type` VALUES ('17', '放射性', '2020-11-20 10:31:23', '2020-11-20 10:37:04', '1');
INSERT INTO `dangerous_sources_type` VALUES ('19', '职业危害', '2021-01-06 15:06:04', '2021-01-06 15:06:04', '0');
INSERT INTO `dangerous_sources_type` VALUES ('20', '食品安全', '2021-01-06 16:47:39', '2021-01-06 16:47:39', '0');
INSERT INTO `dangerous_sources_type` VALUES ('21', '安全生产', '2021-01-06 17:20:59', '2021-01-06 17:20:59', '0');
INSERT INTO `dangerous_sources_type` VALUES ('22', '自然灾害-病毒', '2021-01-07 11:18:50', '2021-01-07 11:18:50', '0');

-- ----------------------------
-- Table structure for `event`
-- ----------------------------
DROP TABLE IF EXISTS `event`;
CREATE TABLE `event` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键/自增/唯一',
  `event_name` varchar(255) DEFAULT NULL COMMENT '事件标题（报警规则标题、人为录入事件标题）',
  `model_id` int(11) DEFAULT NULL COMMENT '模板id（报警规则）',
  `product_id` int(11) DEFAULT NULL COMMENT '产品id（报警规则-设备边界）',
  `equipment_id` varchar(255) DEFAULT NULL COMMENT '设备id（报警规则）',
  `equipment_name` varchar(255) DEFAULT NULL COMMENT '设备名称（报警规则）',
  `structure_id` int(11) DEFAULT NULL COMMENT '资产结构id（报警规则）',
  `structure_name` varchar(255) DEFAULT NULL COMMENT '资产结构名称/事故发生地址（报警规则或人为录入）',
  `picture` varchar(500) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '资源图片信息（数组）',
  `context` longtext COMMENT '事件描述（人为录入），富文本内容包含文字、图片、视频、音频等',
  `type` char(1) DEFAULT NULL COMMENT '事件类型：0-报警事件 1-人为上报事件',
  `tenant_id` int(11) DEFAULT NULL COMMENT '租户id',
  `user_id` int(11) DEFAULT NULL COMMENT '小程序当前登录用户ID (小程序专业字段)',
  `reporting_name` varchar(255) DEFAULT NULL COMMENT '上报人姓名（人为录入）',
  `reporting_phone` varchar(255) DEFAULT NULL COMMENT '上报人手机号（人为录入）',
  `status` char(1) DEFAULT '0' COMMENT '应急事件状态： 0-未处理 1-已处理',
  `report_status` char(1) DEFAULT '0' COMMENT '应急报告状态：0-无 1-有',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `del_flag` char(1) DEFAULT '0' COMMENT '逻辑删除(0=正常,1=删除)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=180 DEFAULT CHARSET=utf8 COMMENT='应急事件表';

-- ----------------------------
-- Records of event
-- ----------------------------
INSERT INTO `event` VALUES ('178', '用电隐患', '17', null, null, null, null, '管委会一楼', null, '一楼插座负载过大，电线老化', '1', null, '1', '刘琳', '15007128688', '1', '1', '2021-01-07 15:47:31', '2021-01-07 15:51:35', '0');
INSERT INTO `event` VALUES ('179', '使用功率过大电器', '17', null, null, null, null, '部门办公室', null, '部分办公室使用功率过大电器，如2000W电取暖器', '1', null, '1', '刘琳', '15007128688', '0', '0', '2021-01-07 15:51:15', '2021-01-07 15:51:15', '0');

-- ----------------------------
-- Table structure for `event_message_config`
-- ----------------------------
DROP TABLE IF EXISTS `event_message_config`;
CREATE TABLE `event_message_config` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `message_id` int(11) DEFAULT NULL COMMENT '消息主键',
  `message_code` varchar(100) DEFAULT NULL COMMENT '消息编码',
  `description` varchar(255) DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COMMENT='应急事件消息推送配置表';

-- ----------------------------
-- Records of event_message_config
-- ----------------------------
INSERT INTO `event_message_config` VALUES ('3', '164', 'emergency_send_msg', null);

-- ----------------------------
-- Table structure for `event_model`
-- ----------------------------
DROP TABLE IF EXISTS `event_model`;
CREATE TABLE `event_model` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键/自增/唯一',
  `dangerous_sources_type_id` int(11) DEFAULT NULL COMMENT '危险源分类id（报警规则）',
  `user_id` int(11) DEFAULT NULL COMMENT '事件模板负责人id',
  `plan_id` int(11) DEFAULT NULL COMMENT '预案模板id',
  `model_name` varchar(255) DEFAULT NULL COMMENT '事件模板名称',
  `alarm_id` int(11) DEFAULT NULL COMMENT '报警规则id',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `del_flag` char(1) DEFAULT '0' COMMENT '逻辑删除(0=正常,1=删除)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COMMENT='事件模板表';

-- ----------------------------
-- Records of event_model
-- ----------------------------
INSERT INTO `event_model` VALUES ('15', '2', '80', '26', '防汛', '209', '2021-01-07 14:56:39', '2021-01-07 15:22:27', '0');
INSERT INTO `event_model` VALUES ('16', '22', '133', '25', '防疫', '210', '2021-01-07 14:59:13', '2021-01-07 15:22:22', '0');
INSERT INTO `event_model` VALUES ('17', '11', '28', '28', '用电安全', '207', '2021-01-07 15:36:17', '2021-01-07 15:36:17', '0');
INSERT INTO `event_model` VALUES ('18', '10', '24', '29', '火灾监测', '211', '2021-01-08 09:52:36', '2021-01-08 09:52:36', '0');

-- ----------------------------
-- Table structure for `goods`
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键/自增/唯一',
  `tenant_id` int(11) DEFAULT '1' COMMENT '租户id',
  `goods_name` varchar(255) DEFAULT NULL COMMENT '物资名称',
  `number` int(11) DEFAULT NULL COMMENT '物资数量',
  `address` varchar(255) DEFAULT NULL COMMENT '物资存放地址',
  `admin_name` varchar(255) DEFAULT NULL COMMENT '物资仓库管理员姓名',
  `admin_phone` varchar(255) DEFAULT NULL COMMENT '物资仓库管理员电话',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `del_flag` char(1) DEFAULT '0' COMMENT '逻辑删除(0=正常,1=删除)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8 COMMENT='应急物资表';

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('21', '1', '医用外科口罩', '20000', '仓库', '邓敏', '18602724065', '2021-01-07 11:21:15', null, '0');
INSERT INTO `goods` VALUES ('22', '1', '医用护目镜', '200', '仓库', '邓敏', '18602724065', '2021-01-07 11:56:07', null, '0');
INSERT INTO `goods` VALUES ('23', '1', '救生圈', '1000', '仓库', '邓敏', '18602724065', '2021-01-07 11:56:25', null, '0');
INSERT INTO `goods` VALUES ('24', '1', '医用防护手套', '600', '仓库', '邓敏', '18602724065', '2021-01-07 11:56:42', null, '0');
INSERT INTO `goods` VALUES ('25', '1', '救生衣', '1000', '仓库', '邓敏', '18602724065', '2021-01-07 11:57:06', null, '0');
INSERT INTO `goods` VALUES ('26', '1', '红外式体温枪', '50', '仓库', '邓敏', '18602724065', '2021-01-07 11:57:19', null, '0');
INSERT INTO `goods` VALUES ('27', '1', '消毒液', '100', '仓库', '邓敏', '18602724065', '2021-01-07 11:57:45', null, '0');
INSERT INTO `goods` VALUES ('28', '1', '防汛袋', '5000', '仓库', ' 邓敏', '18602724065', '2021-01-07 11:57:56', null, '0');
INSERT INTO `goods` VALUES ('29', '1', '75%酒精', '50', '仓库', '邓敏', '18602724065', '2021-01-07 11:58:15', null, '0');
INSERT INTO `goods` VALUES ('30', '1', '洗手液', '200', '仓库', '邓敏', '18602724065', '2021-01-07 14:05:04', null, '0');
INSERT INTO `goods` VALUES ('31', '1', '消毒柜', '2', '食堂', '邓敏', '18602724065', '2021-01-07 14:05:27', null, '0');
INSERT INTO `goods` VALUES ('32', '1', '手持喷雾', '100', '仓库', '邓敏', '18602724065', '2021-01-07 14:06:15', null, '0');
INSERT INTO `goods` VALUES ('33', '1', '防护服', '100', '仓库', '邓敏', '18602724065', '2021-01-07 14:06:46', null, '0');
INSERT INTO `goods` VALUES ('34', '1', '装载机', '10', '仓库', '邓敏', '18602724065', '2021-01-07 14:34:51', null, '0');

-- ----------------------------
-- Table structure for `goods_dangerous_sources_type`
-- ----------------------------
DROP TABLE IF EXISTS `goods_dangerous_sources_type`;
CREATE TABLE `goods_dangerous_sources_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键/自增/唯一',
  `goods_id` int(11) DEFAULT NULL COMMENT '物资id',
  `type_id` int(11) DEFAULT NULL COMMENT '危险源分类id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=103 DEFAULT CHARSET=utf8 COMMENT='应急物资与危险源分类关联表';

-- ----------------------------
-- Records of goods_dangerous_sources_type
-- ----------------------------
INSERT INTO `goods_dangerous_sources_type` VALUES ('88', '21', '22');
INSERT INTO `goods_dangerous_sources_type` VALUES ('89', '22', '22');
INSERT INTO `goods_dangerous_sources_type` VALUES ('90', '23', '2');
INSERT INTO `goods_dangerous_sources_type` VALUES ('91', '23', '1');
INSERT INTO `goods_dangerous_sources_type` VALUES ('92', '24', '22');
INSERT INTO `goods_dangerous_sources_type` VALUES ('93', '25', '2');
INSERT INTO `goods_dangerous_sources_type` VALUES ('94', '26', '22');
INSERT INTO `goods_dangerous_sources_type` VALUES ('95', '27', '22');
INSERT INTO `goods_dangerous_sources_type` VALUES ('96', '28', '2');
INSERT INTO `goods_dangerous_sources_type` VALUES ('97', '29', '22');
INSERT INTO `goods_dangerous_sources_type` VALUES ('98', '30', '22');
INSERT INTO `goods_dangerous_sources_type` VALUES ('99', '31', '22');
INSERT INTO `goods_dangerous_sources_type` VALUES ('100', '32', '22');
INSERT INTO `goods_dangerous_sources_type` VALUES ('101', '33', '22');
INSERT INTO `goods_dangerous_sources_type` VALUES ('102', '34', '2');

-- ----------------------------
-- Table structure for `hidden_danger`
-- ----------------------------
DROP TABLE IF EXISTS `hidden_danger`;
CREATE TABLE `hidden_danger` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键/自增/唯一',
  `dangerous_type_id` int(64) DEFAULT NULL COMMENT '危险源分类',
  `danger_name` varchar(255) DEFAULT NULL COMMENT '隐患标题',
  `danger_content` longtext COMMENT '隐患内容 ',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `del_flag` char(1) DEFAULT '0' COMMENT '逻辑删除(0=正常,1=删除)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='重大隐患表';

-- ----------------------------
-- Records of hidden_danger
-- ----------------------------
INSERT INTO `hidden_danger` VALUES ('10', '20', '汉阳经济开发区关于成立食品安全工作领导小组', '开发区各部门、辖区各企业：\n为认真贯彻落实习近平总书记坚持以人民为中心的发展思想和关于加强食品安全工作的重要指示批示精神，进一步加强食品安全监管工作，强化职责，落实任务，构建开发区食品安全监管体系，经研究，决定成立开发区食品安全领导小组，统筹安排食品安全日常工作。', '2021-01-06 16:49:57', null, '0');
INSERT INTO `hidden_danger` VALUES ('11', '21', '汉阳经济开发区关于调整安全生产工作领导小组', '开发区各部门、辖区各企业：\n为进一步加强安全生产工作，夯实安全生产监管责任，促进安全生产工作落实到位，确保不发生安全事故，按照“管行业必须管安全、管业务必须管安全、管生产经营必须管安全”、“谁主管、谁负责”、“党政同责、一岗双责”的原则，结合开发区实际，经研究，决定调整汉阳经济开发区管委会安全生产领导小组成员及分工，明确党政安全负责人为安全生产第一责任人，班子其他成员对分管范围内的安全生产工作负领导责任', '2021-01-06 17:22:13', null, '0');

-- ----------------------------
-- Table structure for `inspection_feedback`
-- ----------------------------
DROP TABLE IF EXISTS `inspection_feedback`;
CREATE TABLE `inspection_feedback` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键/自增/唯一',
  `inspection_plan_id` int(11) DEFAULT NULL COMMENT '巡检计划id',
  `node_id` int(11) DEFAULT NULL COMMENT '节点id',
  `feedback` varchar(255) DEFAULT NULL COMMENT '巡检反馈描述',
  `person_name` varchar(255) DEFAULT NULL COMMENT '巡检人员姓名',
  `person_phone` varchar(255) DEFAULT NULL COMMENT '巡检人员联系方式',
  `photos` varchar(500) DEFAULT NULL COMMENT '巡检反馈照片集合',
  `status` char(1) NOT NULL DEFAULT '0' COMMENT '状态0-合格 1-不合格',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `del_flag` char(1) DEFAULT '0' COMMENT '逻辑删除(0=正常,1=删除)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8 COMMENT='巡检反馈表';

-- ----------------------------
-- Records of inspection_feedback
-- ----------------------------

-- ----------------------------
-- Table structure for `inspection_plan`
-- ----------------------------
DROP TABLE IF EXISTS `inspection_plan`;
CREATE TABLE `inspection_plan` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键/自增/唯一',
  `danger_id` int(11) DEFAULT NULL COMMENT '隐患id',
  `tenant_id` int(11) DEFAULT NULL COMMENT '企业id',
  `plan_name` varchar(255) DEFAULT NULL COMMENT '计划名称',
  `danger_content` varchar(255) DEFAULT NULL COMMENT '巡检计划内容',
  `expert_name` varchar(255) DEFAULT NULL COMMENT '专家名称',
  `expert_phone` varchar(255) DEFAULT NULL COMMENT '专家号码',
  `addr` varchar(255) DEFAULT NULL COMMENT '详细地址',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `del_flag` char(1) DEFAULT '0' COMMENT '逻辑删除(0=正常,1=删除)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8 COMMENT='巡检计划表';

-- ----------------------------
-- Records of inspection_plan
-- ----------------------------
INSERT INTO `inspection_plan` VALUES ('21', '10', '59', '汉阳经济开发区食品安全检查', '成立开发区食品安全领导小组，统筹安排食品安全日常工作', '23', '13349903067', '武汉万通置业有限公司（万通工业园）无食堂', '2021-01-06 16:54:20', null, '0');
INSERT INTO `inspection_plan` VALUES ('22', '11', '58', '汉阳经济开发区安全生产检查', '为进一步加强安全生产工作，夯实安全生产监管责任，促进安全生产工作落实到位，确保不发生安全事故，按照“管行业必须管安全、管业务必须管安全、管生产经营必须管安全”、“谁主管、谁负责”、“党政同责、一岗双责”的原则，结合开发区实际，经研究，决定调整汉阳经济开发区管委会安全生产领导小组成员及分工，明确党政安全负责人为安全生产第一责任人，班子其他成员对分管范围内的安全生产工作负领导责任', '23', '13349903067', '多企业', '2021-01-06 17:27:25', null, '0');

-- ----------------------------
-- Table structure for `person`
-- ----------------------------
DROP TABLE IF EXISTS `person`;
CREATE TABLE `person` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键/自增/唯一',
  `name` varchar(255) DEFAULT NULL COMMENT '姓名',
  `sex` varchar(255) DEFAULT NULL COMMENT '性别：0-男 - 1-女',
  `type_id` int(11) DEFAULT NULL COMMENT '应急人员类型id',
  `phone` varchar(255) DEFAULT NULL COMMENT '联系方式',
  `email` varchar(255) DEFAULT NULL COMMENT '邮箱',
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL DEFAULT 'menghuan.png' COMMENT '头像(提供默认头像)',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `del_flag` char(1) DEFAULT '0' COMMENT '逻辑删除(0=正常,1=删除)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=162 DEFAULT CHARSET=utf8 COMMENT='应急人员';

-- ----------------------------
-- Records of person
-- ----------------------------
INSERT INTO `person` VALUES ('23', '董传胜', '0', '1', '13349903067', '', '', '2021-01-06 16:30:58', '2021-01-06 16:51:50', '0');
INSERT INTO `person` VALUES ('24', '王伟', '0', '3', '13995660477', '', '', '2021-01-06 16:32:10', '2021-01-07 15:00:28', '0');
INSERT INTO `person` VALUES ('25', '吴斌', '0', '4', '13871393588', '', '', '2021-01-06 16:42:32', null, '0');
INSERT INTO `person` VALUES ('26', '徐康', '0', '4', '15727000765', '', '', '2021-01-06 16:43:01', null, '0');
INSERT INTO `person` VALUES ('27', '黄文明', '0', '4', '13995631296', '', '', '2021-01-06 16:43:12', null, '0');
INSERT INTO `person` VALUES ('28', '罗诚', '0', '3', '13971619826', '', '', '2021-01-06 16:43:14', null, '0');
INSERT INTO `person` VALUES ('29', '姚林林', '0', '4', '15827540961', '', '', '2021-01-06 16:43:27', null, '0');
INSERT INTO `person` VALUES ('30', '杨锦逾', '0', '3', '13349878387', '', '', '2021-01-06 16:43:40', null, '0');
INSERT INTO `person` VALUES ('31', '刘晓晖', '0', '4', '13871505965', '', '', '2021-01-06 16:43:41', null, '0');
INSERT INTO `person` VALUES ('32', '张纯', '1', '4', '13476024760', '', '', '2021-01-06 16:43:57', null, '0');
INSERT INTO `person` VALUES ('33', '黄勇明', '0', '3', '15342347740', '', '', '2021-01-06 16:44:07', null, '0');
INSERT INTO `person` VALUES ('34', '洪旭', '0', '4', '13707111743', '', '', '2021-01-06 16:44:15', null, '0');
INSERT INTO `person` VALUES ('35', '刘琳', '1', '3', '15007128688', '', '', '2021-01-06 16:44:22', null, '0');
INSERT INTO `person` VALUES ('36', '付金鑫', '0', '4', '18872220399', '', '', '2021-01-06 16:44:30', null, '0');
INSERT INTO `person` VALUES ('37', '谢瑞', '0', '4', '18627969619', '', '', '2021-01-06 16:44:48', null, '0');
INSERT INTO `person` VALUES ('38', '梁君', '0', '4', '13971597379', '', '', '2021-01-06 16:45:04', null, '0');
INSERT INTO `person` VALUES ('39', '邓敏', '1', '3', '18602724065', '', '', '2021-01-06 16:45:16', null, '0');
INSERT INTO `person` VALUES ('40', '孙文', '0', '4', '18971679430', '', '', '2021-01-06 16:45:21', null, '0');
INSERT INTO `person` VALUES ('41', '蔡继敏', '1', '3', '13971006686', '', '', '2021-01-06 16:45:37', null, '0');
INSERT INTO `person` VALUES ('42', '董黎', '1', '4', '13545174718', '', '', '2021-01-06 16:45:41', null, '0');
INSERT INTO `person` VALUES ('43', '杨静', '1', '3', '13907127939', '', '', '2021-01-06 16:46:00', null, '0');
INSERT INTO `person` VALUES ('44', '丁丹', '1', '4', '13971314145', '', '', '2021-01-06 16:46:01', null, '0');
INSERT INTO `person` VALUES ('45', '洪宝云', '0', '4', '13971397588', '', '', '2021-01-06 16:46:15', null, '0');
INSERT INTO `person` VALUES ('46', '吴思宁', '1', '3', '13907114339', '', '', '2021-01-06 16:46:23', null, '0');
INSERT INTO `person` VALUES ('47', '刘思雅', '1', '4', '15327410042', '', '', '2021-01-06 16:46:30', null, '0');
INSERT INTO `person` VALUES ('48', '徐杰', '0', '4', '13797038825', '', '', '2021-01-06 16:46:50', null, '0');
INSERT INTO `person` VALUES ('49', '刘新厚', '0', '4', '13487072569', '', '', '2021-01-06 16:47:03', null, '0');
INSERT INTO `person` VALUES ('50', '张春民', '0', '4', '18071035199', '', '', '2021-01-06 16:47:27', null, '0');
INSERT INTO `person` VALUES ('51', '曾四明', '0', '4', '17740525526', '', '', '2021-01-06 16:47:42', null, '0');
INSERT INTO `person` VALUES ('52', '罗杰', '0', '4', '13995610181', '', '', '2021-01-06 16:47:59', null, '0');
INSERT INTO `person` VALUES ('53', '甘雨', '1', '4', '13807140686', '', '', '2021-01-06 16:48:45', null, '0');
INSERT INTO `person` VALUES ('54', '肖军', '0', '4', '13657210167', '', '', '2021-01-06 16:49:00', null, '0');
INSERT INTO `person` VALUES ('55', '伍延光', '0', '4', '15327105760', '', '', '2021-01-06 16:49:14', null, '0');
INSERT INTO `person` VALUES ('56', '黄经理', '0', '4', '15827459584', '', '', '2021-01-06 16:49:30', null, '0');
INSERT INTO `person` VALUES ('57', '沈以', '0', '4', '18672120795', '', '', '2021-01-06 16:49:50', null, '0');
INSERT INTO `person` VALUES ('58', '韩春芳', '0', '4', '13871491679', '', '', '2021-01-06 16:50:03', null, '0');
INSERT INTO `person` VALUES ('59', '彭成勇', '0', '4', '15262817076', '', '', '2021-01-06 16:50:17', null, '0');
INSERT INTO `person` VALUES ('60', '刘淑琴', '1', '4', '18607136786', '', '', '2021-01-06 16:50:32', null, '0');
INSERT INTO `person` VALUES ('61', '赵乾坤', '0', '4', '15927260494', '', '', '2021-01-06 16:50:44', null, '0');
INSERT INTO `person` VALUES ('62', '章家红', '1', '4', '15907104436', '', '', '2021-01-06 16:51:02', null, '0');
INSERT INTO `person` VALUES ('63', '董虹', '1', '4', '18171418271', '', '', '2021-01-06 16:51:25', null, '0');
INSERT INTO `person` VALUES ('64', '尹思', '1', '4', '18627980966', '', '', '2021-01-06 16:51:49', null, '0');
INSERT INTO `person` VALUES ('65', '周金玲', '1', '4', '15927175851', '', '', '2021-01-06 16:52:03', null, '0');
INSERT INTO `person` VALUES ('66', '罗兵', '0', '4', '15927087408', '', '', '2021-01-06 16:52:25', null, '0');
INSERT INTO `person` VALUES ('67', '李张松', '0', '4', '15827138968', '', '', '2021-01-06 16:52:41', null, '0');
INSERT INTO `person` VALUES ('68', '许义武', '0', '4', '15907187439', '', '', '2021-01-06 16:52:53', null, '0');
INSERT INTO `person` VALUES ('69', '洪有义', '0', '4', '13971658550', '', '', '2021-01-06 16:53:06', null, '0');
INSERT INTO `person` VALUES ('70', '郭金明', '0', '4', '13667109424', '', '', '2021-01-06 16:53:20', null, '0');
INSERT INTO `person` VALUES ('71', '刘金凤', '1', '4', '15927336256', '', '', '2021-01-06 16:53:35', null, '0');
INSERT INTO `person` VALUES ('72', '方冬菊', '1', '4', '13125031248', '', '', '2021-01-06 16:53:54', null, '0');
INSERT INTO `person` VALUES ('73', '陈云安', '0', '4', '13667268240', '', '', '2021-01-06 16:54:08', null, '0');
INSERT INTO `person` VALUES ('74', '马克松', '0', '4', '15827216933', '', '', '2021-01-06 16:54:20', null, '0');
INSERT INTO `person` VALUES ('75', '王林 ', '0', '4', '13476670777', '', '', '2021-01-06 16:54:37', null, '0');
INSERT INTO `person` VALUES ('76', '孙昌亮', '0', '4', '13971000530', '', '', '2021-01-06 16:54:49', null, '0');
INSERT INTO `person` VALUES ('77', '熊羽慧 ', '1', '4', '13907107018', '', '', '2021-01-06 16:55:06', null, '0');
INSERT INTO `person` VALUES ('78', '唐丹', '1', '4', '13349880853', '', '', '2021-01-06 16:55:23', null, '0');
INSERT INTO `person` VALUES ('79', '夏爱珍', '1', '4', '18171236249', '', '', '2021-01-06 16:55:37', null, '0');
INSERT INTO `person` VALUES ('80', '冯涛', '0', '3', '13971687871', '', '', '2021-01-07 10:52:58', null, '0');
INSERT INTO `person` VALUES ('81', '李辉', '0', '4', '13971625096', '', '', '2021-01-07 10:53:19', null, '0');
INSERT INTO `person` VALUES ('82', '喻佳', '0', '4', '15972131610', '', '', '2021-01-07 10:53:41', '2021-01-07 10:58:29', '0');
INSERT INTO `person` VALUES ('83', '詹必强', '0', '4', '15172541283', '', '', '2021-01-07 10:53:59', null, '0');
INSERT INTO `person` VALUES ('84', '刘喜安', '0', '4', '13871293630', '', '', '2021-01-07 10:54:14', null, '0');
INSERT INTO `person` VALUES ('85', '魏俨', '0', '4', '15871418328', '', '', '2021-01-07 10:54:27', null, '0');
INSERT INTO `person` VALUES ('86', '李成墙', '0', '4', '18062604922', '', '', '2021-01-07 10:54:44', null, '0');
INSERT INTO `person` VALUES ('87', '易全平', '0', '4', '13871003165', '', '', '2021-01-07 10:55:01', null, '0');
INSERT INTO `person` VALUES ('88', '宋焱丰', '0', '4', '13477022382', '', '', '2021-01-07 10:55:28', null, '0');
INSERT INTO `person` VALUES ('89', '王之刚', '0', '4', '13260609260', '', '', '2021-01-07 10:55:42', null, '0');
INSERT INTO `person` VALUES ('90', '俞响', '0', '4', '15342750505', '', '', '2021-01-07 10:56:03', null, '0');
INSERT INTO `person` VALUES ('91', '谭洪斌', '0', '3', '18108669099', '', '', '2021-01-07 10:56:27', null, '0');
INSERT INTO `person` VALUES ('92', '肖光明', '0', '4', '13545248386', '', '', '2021-01-07 10:56:41', null, '0');
INSERT INTO `person` VALUES ('93', '陈昌盛', '0', '4', '15907174105', '', '', '2021-01-07 10:57:02', null, '0');
INSERT INTO `person` VALUES ('94', '万信伟', '0', '4', '18171011577', '', '', '2021-01-07 10:57:17', null, '0');
INSERT INTO `person` VALUES ('95', '陈仁武', '0', '4', '15872435859', '', '', '2021-01-07 10:57:35', null, '0');
INSERT INTO `person` VALUES ('96', '方添志', '0', '4', '18986167232', '', '', '2021-01-07 10:57:51', null, '0');
INSERT INTO `person` VALUES ('97', '黄国芬', '0', '4', '13667246593', '', '', '2021-01-07 10:58:21', null, '0');
INSERT INTO `person` VALUES ('98', '许佳宗', '0', '4', '15927348875', '', '', '2021-01-07 10:58:53', null, '0');
INSERT INTO `person` VALUES ('99', '周祝华', '0', '4', '18971111170', '', '', '2021-01-07 10:59:08', null, '0');
INSERT INTO `person` VALUES ('100', '李海平', '0', '4', '18971093760', '', '', '2021-01-07 10:59:22', null, '0');
INSERT INTO `person` VALUES ('101', '蔡斌', '0', '3', '13871130771', '', '', '2021-01-07 11:00:49', null, '0');
INSERT INTO `person` VALUES ('102', '罗兵', '0', '3', '15927087408', '', '', '2021-01-07 11:01:05', '2021-01-07 11:08:53', '0');
INSERT INTO `person` VALUES ('103', '蔡雷', '0', '3', '13971649055', '', '', '2021-01-07 11:01:35', null, '0');
INSERT INTO `person` VALUES ('104', '董永平', '0', '4', '13971177931', '', '', '2021-01-07 11:01:51', null, '0');
INSERT INTO `person` VALUES ('105', '侯平', '0', '4', '13871511625', '', '', '2021-01-07 11:02:14', null, '0');
INSERT INTO `person` VALUES ('106', '朱远立', '0', '4', '13545187855', '', '', '2021-01-07 11:02:34', null, '0');
INSERT INTO `person` VALUES ('107', '陈义华', '0', '4', '15071211459', '', '', '2021-01-07 11:03:02', null, '0');
INSERT INTO `person` VALUES ('108', '张学宏', '0', '4', '13871380158', '', '', '2021-01-07 11:03:24', null, '0');
INSERT INTO `person` VALUES ('109', '杨诗伟', '0', '3', '15907190859', '', '', '2021-01-07 11:03:44', null, '0');
INSERT INTO `person` VALUES ('110', '黄毅', '0', '4', '13871322986', '', '', '2021-01-07 11:04:14', null, '0');
INSERT INTO `person` VALUES ('111', '阮小贵', '0', '4', '15827286249', '', '', '2021-01-07 11:04:28', null, '0');
INSERT INTO `person` VALUES ('112', '季燕清', '0', '4', '13627132060', '', '', '2021-01-07 11:04:42', null, '0');
INSERT INTO `person` VALUES ('113', '雷畅', '0', '4', '13886119761', '', '', '2021-01-07 11:04:57', null, '0');
INSERT INTO `person` VALUES ('114', '鲁贤进', '0', '4', '15827188702', '', '', '2021-01-07 11:05:10', null, '0');
INSERT INTO `person` VALUES ('115', '孙有刚', '0', '3', '13986068931', '', '', '2021-01-07 11:05:38', null, '0');
INSERT INTO `person` VALUES ('116', '刘全', '0', '4', '18207186070', '', '', '2021-01-07 11:05:53', null, '0');
INSERT INTO `person` VALUES ('117', '刘波杰', '0', '4', '13477057712', '', '', '2021-01-07 11:06:11', null, '0');
INSERT INTO `person` VALUES ('118', '肖奎', '0', '4', '13554097230', '', '', '2021-01-07 11:06:25', null, '0');
INSERT INTO `person` VALUES ('119', '李选涛', '0', '4', '18207186190', '', '', '2021-01-07 11:06:39', null, '0');
INSERT INTO `person` VALUES ('120', '杨四川', '0', '4', '15927178455', '', '', '2021-01-07 11:06:52', null, '0');
INSERT INTO `person` VALUES ('121', '胡勇', '0', '3', '15902710517', '', '', '2021-01-07 11:07:08', '2021-01-07 11:08:26', '0');
INSERT INTO `person` VALUES ('122', '张照鸿', '0', '4', '13618607938', '', '', '2021-01-07 11:07:21', null, '0');
INSERT INTO `person` VALUES ('123', '蔡晓', '0', '4', '13986228030', '', '', '2021-01-07 11:07:34', null, '0');
INSERT INTO `person` VALUES ('124', '尹木生', '0', '4', '13554683961', '', '', '2021-01-07 11:07:47', null, '0');
INSERT INTO `person` VALUES ('125', '王凯', '0', '4', '13720288686', '', '', '2021-01-07 11:08:01', null, '0');
INSERT INTO `person` VALUES ('126', '刘裴', '0', '3', '18062018600', '', '', '2021-01-07 11:08:20', null, '0');
INSERT INTO `person` VALUES ('127', '晏杰', '0', '4', '15827144494', '', '', '2021-01-07 11:09:30', null, '0');
INSERT INTO `person` VALUES ('128', '蔡淼', '0', '4', '15927219602', '', '', '2021-01-07 11:09:42', null, '0');
INSERT INTO `person` VALUES ('129', '蔡磊', '0', '4', '15527799259', '', '', '2021-01-07 11:09:55', null, '0');
INSERT INTO `person` VALUES ('130', '钟春', '0', '4', '13476274446', '', '', '2021-01-07 11:10:23', null, '0');
INSERT INTO `person` VALUES ('131', '黄瑾', '1', '3', '13871302818', '', '', '2021-01-07 11:12:50', '2021-01-07 11:13:08', '0');
INSERT INTO `person` VALUES ('132', '刘江新', '0', '3', '18911111111', '', '', '2021-01-07 11:14:20', null, '0');
INSERT INTO `person` VALUES ('133', '董传胜', '0', '3', '13349903067', '', '', '2021-01-07 14:59:54', null, '0');
INSERT INTO `person` VALUES ('134', '严雄', '0', '4', '13607190543', '', '', '2021-01-07 17:49:10', null, '0');
INSERT INTO `person` VALUES ('135', '吴清华', '0', '4', '18468007711', '', '', '2021-01-07 17:52:27', null, '0');
INSERT INTO `person` VALUES ('136', '刘念', '1', '4', '15971488262', '', '', '2021-01-07 17:54:10', null, '0');
INSERT INTO `person` VALUES ('137', '涂咏', '0', '4', '18271809877', '', '', '2021-01-07 17:55:00', null, '0');
INSERT INTO `person` VALUES ('138', '武洪飞', '0', '4', '13807191177', '', '', '2021-01-07 17:55:31', null, '0');
INSERT INTO `person` VALUES ('139', '刘耀武', '0', '4', '15927641364', '', '', '2021-01-07 17:57:10', null, '0');
INSERT INTO `person` VALUES ('140', '成小军', '0', '4', '18871889568', '', '', '2021-01-07 17:59:59', null, '0');
INSERT INTO `person` VALUES ('141', '叶莉', '1', '4', '15972072596', '', '', '2021-01-07 18:01:39', null, '0');
INSERT INTO `person` VALUES ('142', '刘裴', '0', '4', '18007121748', '', '', '2021-01-07 18:02:33', null, '0');
INSERT INTO `person` VALUES ('143', '余道华', '0', '4', '13971631261', '', '', '2021-01-07 18:03:05', null, '0');
INSERT INTO `person` VALUES ('144', '胡琳琳', '1', '4', '13907175507', '', '', '2021-01-08 11:02:51', null, '0');
INSERT INTO `person` VALUES ('145', '姚兰', '1', '4', '13554049909', '', '', '2021-01-08 11:04:31', null, '0');
INSERT INTO `person` VALUES ('146', '牛继超', '0', '4', '13995526373', '', '', '2021-01-08 11:05:02', null, '0');
INSERT INTO `person` VALUES ('147', '喻磊', '0', '4', '13986100522', '', '', '2021-01-08 11:05:35', null, '0');
INSERT INTO `person` VALUES ('148', '张鹏', '0', '4', '13971237950', '', '', '2021-01-08 11:05:59', null, '0');
INSERT INTO `person` VALUES ('149', '罗伟', '0', '4', '13871538875', '', '', '2021-01-08 11:06:23', null, '0');
INSERT INTO `person` VALUES ('150', '耿显朝', '0', '4', '13871070978', '', '', '2021-01-08 11:06:41', null, '0');
INSERT INTO `person` VALUES ('151', '胡勇传', '0', '4', '13667173190', '', '', '2021-01-08 11:07:00', null, '0');
INSERT INTO `person` VALUES ('152', '蒋新红', '0', '4', '13339996100', '', '', '2021-01-08 11:07:19', null, '0');
INSERT INTO `person` VALUES ('153', '朱伶俐', '1', '4', '13477081989', '', '', '2021-01-08 11:07:37', null, '0');
INSERT INTO `person` VALUES ('154', '刘敏', '1', '4', '18062779556', '', '', '2021-01-08 11:08:06', null, '0');
INSERT INTO `person` VALUES ('155', '李春', '0', '4', '13720398714', '', '', '2021-01-08 11:08:30', null, '0');
INSERT INTO `person` VALUES ('156', '胡会计', '1', '4', '13986107432', '', '', '2021-01-08 11:08:50', null, '0');
INSERT INTO `person` VALUES ('157', '涂茜', '1', '4', '15172511183', '', '', '2021-01-08 11:09:14', null, '0');
INSERT INTO `person` VALUES ('158', '黄科', '0', '4', '13986154565', '', '', '2021-01-08 11:09:43', null, '0');
INSERT INTO `person` VALUES ('159', '刘祖德', '0', '4', '13545595577', '', '', '2021-01-08 11:10:14', null, '0');
INSERT INTO `person` VALUES ('160', '张建元', '0', '4', '18627948686', '', '', '2021-01-08 11:10:32', null, '0');
INSERT INTO `person` VALUES ('161', '肖国祥', '0', '3', '18871451111', '', '', '2021-01-08 11:18:38', null, '0');

-- ----------------------------
-- Table structure for `person_dangerous_sources_type`
-- ----------------------------
DROP TABLE IF EXISTS `person_dangerous_sources_type`;
CREATE TABLE `person_dangerous_sources_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键/自增/唯一',
  `person_id` int(11) DEFAULT NULL COMMENT '应急人员id',
  `dangerous_sources_type_id` int(11) DEFAULT NULL COMMENT '危险源分类id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='应急人员与危险源分类关联表';

-- ----------------------------
-- Records of person_dangerous_sources_type
-- ----------------------------

-- ----------------------------
-- Table structure for `person_type`
-- ----------------------------
DROP TABLE IF EXISTS `person_type`;
CREATE TABLE `person_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键/自增/唯一',
  `type_name` varchar(255) DEFAULT NULL COMMENT '分类名称',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `del_flag` char(1) DEFAULT '0' COMMENT '逻辑删除(0=正常,1=删除)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='应急人员类型表';

-- ----------------------------
-- Records of person_type
-- ----------------------------
INSERT INTO `person_type` VALUES ('1', '应急专家', '2020-10-21 09:52:39', null, '0');
INSERT INTO `person_type` VALUES ('2', '应急部队', '2020-10-21 09:52:49', null, '0');
INSERT INTO `person_type` VALUES ('3', '应急负责人', '2020-10-21 09:53:01', null, '0');
INSERT INTO `person_type` VALUES ('4', '值班人员', '2020-10-21 09:53:09', null, '0');

-- ----------------------------
-- Table structure for `plan`
-- ----------------------------
DROP TABLE IF EXISTS `plan`;
CREATE TABLE `plan` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键/自增/唯一',
  `plan_title` varchar(255) DEFAULT NULL COMMENT '预案标题',
  `content` longtext COMMENT '预案文档内容，富文本内容包含文字、图片、视频、音频等',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `del_flag` char(1) DEFAULT '0' COMMENT '逻辑删除(0=正常,1=删除)',
  PRIMARY KEY (`id`),
  FULLTEXT KEY `预案标题` (`plan_title`) COMMENT '预案标题'
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8 COMMENT='预案表';

-- ----------------------------
-- Records of plan
-- ----------------------------
INSERT INTO `plan` VALUES ('25', '汉阳经济开发区关于企业复工复产疫情防控的 工作预案（第二版）（2020年3月15日）', '<p>&nbsp;&nbsp;&nbsp;为贯彻落实中央、省市区应对新型冠状病毒感染肺炎疫情工作领导小组会议精神，维护公众生命安全和身体健康，防止新型冠状病毒感染的肺炎疫情扩散和蔓延，湖北省连续推迟了春节后企业复工的时间，并实施分区分级、分类分时有序推进企业复工复产。现就加强辖区各企业复工后疫情防控工作制订本《预案》。</p>\n<p><img class=\"wscnph\" src=\"../../pro-api/admin/sys-file/iot/d1aa02db6e854bd19e9a37107f95cb01.jpg\" /></p>', '2021-01-07 14:23:43', '2021-01-07 14:29:40', '0');
INSERT INTO `plan` VALUES ('26', '汉阳经济开发区防汛应急预案（ 2020年4月3日）', '<p>为了建立健全企业危险废物污染事件应急机制,提高企业对汛期暴雨天气突发性意外事故的应对能力,确保危险废物在产生到最终处置过程中,发生突发性&middot;意外时,能够快速响应,有序行动,高效处置,降低危害,维护和保障公众健康和财产安全。根据国家法律、法规和省应急相关要求,特制订桦南桑德净源水务有限公司暴雨天气意外事故应急预案。</p>\n<p><img class=\"wscnph\" src=\"../../pro-api/admin/sys-file/iot/e5fd8f135cbf4845b1e737b37d70e350.jpg\" /></p>', '2021-01-07 14:31:20', '2021-01-07 15:37:58', '0');
INSERT INTO `plan` VALUES ('27', '汉阳经济开发区黄金口工业园区安全事故应急预案', '<p>本《预案》中的生产安全事故是指突然发生,造成或者可能造成人员伤亡、财产损失、生态环境破坏,需要园区管委会立即采取应对措施加以妥善处理的事件,包括:企业生产安全事故,建设施工事故,特种设备安全事故,火灾、爆炸事故,民爆物品事故,粉尘爆炸事故、有限空间作业事故、人员密集场所踩踏事故,危险化学品泄漏等。</p>\n<p><img class=\"wscnph\" src=\"../../pro-api/admin/sys-file/iot/44ec3e643c8d4bb993d04adcf8aef49a.jpg\" /></p>', '2021-01-07 15:10:47', '2021-01-07 15:38:13', '0');
INSERT INTO `plan` VALUES ('28', '汉阳经济开发区黄金口工业园区人员触电应急预案', '<p>施工现场人员触电时,负责人或安全员应立即指挥其他人员进行脱离电源工作，同时立即断开触电者所触及的导体或设备的电源,设法使触电者脱离带电部分。</p>', '2021-01-07 15:35:17', '2021-01-07 15:40:18', '0');
INSERT INTO `plan` VALUES ('29', '汉阳经济开发区黄金口工业园区火灾应急预案', '<p>炎炎夏日,火灾频发,做好火灾应急救援消防工作,消防着眼于防,尤其是夏日在人群密集的地方如工厂车间等尤为重要。</p>\n<p>为了避免火灾事故发生造成现场混乱,贻误救灾时机,造成重大的人员伤亡和财产损失;明确园区各职能部门在火灾发生时的职责和分工,结合实际情况特制订火灾应急救援消防预案:</p>', '2021-01-07 16:14:40', null, '0');
INSERT INTO `plan` VALUES ('30', '汉阳经济开发区疫情防控复工复产 工作专班工作方案', '<p>根据区政府《关于做好疫情过后辖区企业复工复产相关准备工作的督办通知》精神，为落实省市坚决打赢疫情防控阻击战，统筹落实经济社会发展的工作要求，结合实际，制定本工作方案。</p>\n<p>一、组织领导</p>\n<p>成立汉阳经济开发区疫情防控复工复产工作专班，组成人员名单如下：</p>\n<p>组 &nbsp;长：董传胜 &nbsp;工委书记</p>\n<p>副组长：罗 &nbsp;诚 &nbsp;副主任</p>\n<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;杨锦逾 &nbsp;副主任</p>\n<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;刘 &nbsp;琳 &nbsp;四级调研员</p>\n<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;黄勇明 &nbsp;总工程师</p>\n<p>成 &nbsp;员：邓 &nbsp;敏 &nbsp;综合办公室负责人</p>\n<p>杨 &nbsp;静 &nbsp;企业服务部部长</p>\n<p>蔡继敏 &nbsp;党建部负责人</p>\n<p>吴思宁 &nbsp;规建部部长</p>\n<p>黄 &nbsp;瑾 &nbsp;财务室负责人</p>\n<p>刘江新 &nbsp;城管中队队长</p>\n<p>工作专班下设办公室，在企业服务部办公，负责日常工作。</p>\n<p>二、职责分工</p>\n<p>新型冠状病毒感染的肺炎疫情防控应急保障组总体工作职责：负责完善公共卫生和疾病预防控制体系基础设施建设；指导解决因疫情产生的信访事项，开展相关维稳工作；筹集并核拨突发公共卫生事件应急处理所需资金，审核应急资金支付范围。</p>\n<p>各成员单位职责分工如下：</p>\n<p>综合办公室负责做好值班安排，确保每日上报；做好应急保障物资筹措及发放；安排机关内部消杀工作。</p>\n<p>党建部负责处理因疫情产生的信访事项，统筹做好相关维稳工作。</p>\n<p>城管中队负责统筹做好疫情防控信息对接及辖区巡查清运工作。</p>\n<p>企业服务部负责应急保障预案起草及应急保障组日常工作。 &nbsp;</p>\n<p>财务室负责筹集并核拨应急处置所需资金，审核应急资金支付范围。</p>\n<p>联系人：开发区新型冠状病毒感染的肺炎疫情防控应急保障组 刘江新 &nbsp;</p>\n<p>联系电话：84625163/18986199697</p>\n<p>&nbsp;</p>\n<p>汉阳经济开发区新型冠状病毒感染的肺炎疫情</p>\n<p>防控应急保障组办公室</p>\n<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2020年1月23日</p>', '2021-01-08 11:26:54', '2021-01-08 11:34:12', '0');

-- ----------------------------
-- Table structure for `plan_node`
-- ----------------------------
DROP TABLE IF EXISTS `plan_node`;
CREATE TABLE `plan_node` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `plan_id` int(11) DEFAULT NULL COMMENT '预案id',
  `node_title` varchar(500) DEFAULT NULL COMMENT '预案节点标题',
  `node_content` varchar(1000) DEFAULT NULL COMMENT '预案节点内容',
  `sort` int(11) DEFAULT '1' COMMENT '排序',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `del_flag` char(1) DEFAULT '0' COMMENT '逻辑删除(0=正常,1=删除)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=122 DEFAULT CHARSET=utf8 COMMENT='预案节点表';

-- ----------------------------
-- Records of plan_node
-- ----------------------------
INSERT INTO `plan_node` VALUES ('98', '25', '关于复工时间', '按照要求，在落实差异化防控策略的前提下，将复工复产企业划分为四类有序推进。武汉市第一类企业可以继续复工复产，其他企业按照不早于3月20日24时前复工复产。    第一类，跟生产生活密切相关的企业以及春节以来一直没有停工的“四必需一重大”企业。如供电、供气、供油、供水等企业，以及对全国、全球产业链配套有重大影响的企业。第二类，主要指金融保险、港口和货运站场，重点产业链配套企业，这些企业涉及到物流、资金、产业链等重要环节，是复工复产必须的配套企业。第三类，主要是用工和产业链配套，以本地为主的工业、农业、产业化企业，以室外作业为主的建筑业企业，法律、会计、软件信息服务等相关服务业企业。第四类，主要是影剧院、健身房、培训机构、餐饮等限制清单企业，在疫情解除前不得复工复产。', null, '2021-01-07 14:23:43', null, '0');
INSERT INTO `plan_node` VALUES ('99', '25', '关于强化复工防疫措施', '各企业要严格按照《汉阳区复工复产企业新冠疫情防控指导手册（第一版）》要求，落实疫情防控主体责任，必须制定疫情防控的工作方案和应急处置预案，执行严格的防控措施，确保做到“五到位”。一是防控机制到位，落实专门防控人员，制定疫情防控工作的方案、责任和应急处置预案；二是排查责任要到位，建立返岗人员的登记制度，把好企业员工的入口关，坚决杜绝带病上岗，凡是排查发现有发热、咳嗽等症状，或者是未解除医学观察的，应阻止返岗，并及时上报有关开发区及卫计部门；三是设施物资要到位，企业要采购防护口罩、消毒液、洗手液、红外测温仪等疫情防控用品，并储备不少于五天的用量，应设置临时隔离场所，安排单人单间；四是环境消杀到位，对车间、食堂、宿舍、仓库等公共场所人员聚集场所设施设备进行全方位的消杀，清洗空调的过滤网和排风扇，加强室内通风换气。五是安全生产到位，对操作人员、设备（特种设备）、消防设施等全面排查，逐一排除隐患，确保安全生产。', null, '2021-01-07 14:23:43', null, '0');
INSERT INTO `plan_node` VALUES ('100', '25', '关于复工防疫管控职责分工', '一是企业落实主体责任，建立企业主要负责人负责的企业疫情防控工作领导机构，明确防控专管员，配齐防控物资（如：医用口罩、酒精、84消毒液、测温仪、一次性手套、防护服等），按要求落实好各项防控措施。二是开发区履行属地责任，督促指导和组织相关部门对辖区企业执行复工规定的有关情况进行指导检查。同时将多途径开展疾病防控科普宣传，引导广大员工不信谣、不传谣，科学认知，理性预防，营造上下齐心协力，共同做好疫情防控的良好氛围。三是紧紧依托相关部门的行业监管责任，及时协调解决企业复工过程中疫情防控等问题，积极会同科信、卫健、交通、公安等部门，合力做好疫情防控。', null, '2021-01-07 14:23:43', null, '0');
INSERT INTO `plan_node` VALUES ('101', '25', '关于复工企业出现疫情的处置', '各企业要压实防控责任，筑牢第一道防线，全力确保疫情不发生；其次要运用成熟的疫情处置经验，建立防治结合机制，打住第二道关口，确保疫情不向社会扩散。复工复产企业一旦发现疫情，要做到五个及时：一是及时报告，企业发现员工有发热、干咳、乏力等疑似症状要第一时间向员工所在社区、开发区、疾控机构报告疫情情况。二是及时隔离，对发现的疑似病例应及时送企业的隔离观察场所，采取单独隔离，原则上不得离开房间活动。三是及时送诊，积极配合医疗救治部门按照疫情防控相关要求，将病患转至发热门诊和定点医院就医。四是及时流调，企业应配合区疾控机构立即组织流调，确定感染来源和传播途径，搜索密切接触者，并进行隔离医学观察，指导消毒。五是及时封控，根据疫情严重程度，视情况依法要求企业停产停工。如果企业要求重新恢复生产，必须做到以下三点：一要达到疫情结束，隔离人员得到有效治疗，工作生活场所得到有效消毒，并且14天内未发现新增疑似病例和确诊病例，经区指挥部批准宣布应急结束。二是总结评估，要联合区疾控机构组织对企业的疫情防控工作进行全面分析，查找隐患，完善防控措施，对环境进行全面消毒，开展员工卫生防御知识培训，进一步加强企业全员健康监测管理。三是复工复产，企业在继续加强疫情防控的基础上，全面客观地进行分析，采取积极稳妥的措施，合理调配人员科学制定计划，经批准后依法有序恢复生产经营活动。', null, '2021-01-07 14:23:43', null, '0');
INSERT INTO `plan_node` VALUES ('102', '26', '组织机构与职责', '一、应急指挥部指挥机构的组成总指挥:总经理副指挥:安健环、综合部主管成员:班长及运行工\n二、应急指挥部职责\n(1)贯彻执行国家、当地政府、环保部门关于暴雨天气应急救援的方针、政策及有关规定。\n(2)组织制定、修改暴雨应急预案,组建暴雨天气急小组,有计划地组织实施暴雨、防汛急救援的培训和演习。\n(3)审批并落实暴雨、防汛事应急救援所需的物资。\n(4)检查、督促做好暴雨、防汛的预防措施和应急救援的各项准备工作,督促、协助有关部门及时消除暴雨汛期的影响。\n(5)批准应急救援的启动和终止。', null, '2021-01-07 14:31:20', null, '0');
INSERT INTO `plan_node` VALUES ('103', '26', '应急设施(备)与物资', '厂区内必须备足、备齐沙袋、消防锹、临时泵等应急设施(备)与物资,·并由专人保管,以便在发生突发性环境事故时,保证应急人员在第一时间启用,能快速、正确的投入到应急救援行动中,以及在应急行动结束后,做好人员、设备和环境的清理净化。', null, '2021-01-07 14:31:20', null, '0');
INSERT INTO `plan_node` VALUES ('104', '26', '报警、通讯联络方式通讯联络方式', '管理程序:应急救援人员之间采用内部和外部电话(包括手机等通讯工具)线路进行联系,应急小组的电话必须24小时开机,禁止随意更换电话号码的行为。特殊情况下,电话号码发生变更,必须在变更之日起48小时内报到安健环处。安健环在24小时内向各成员和部门发布变更通知。火警电话: 119急救电话: 120', null, '2021-01-07 14:31:20', null, '0');
INSERT INTO `plan_node` VALUES ('105', '26', '应急现场指挥及程序', '(1) 在暴雨发生天气, 由现场操作人员及时向安健环汇报现场情况,安健环和总经理接到汇报后,在组织现场应急的同时,向县住建局领导汇报,由县领导通知排水处和污水厂宏观调控进水量和给排水方式,成立应急指挥部,明确应急总指挥,宣布立即启动《暴雨防汛应急预案》。\n(2)各应急专业组按照专业划分的职责立即着手进行现场抢险、救援,对事发单位及全公司涉及的生产工艺及时做出调整,避免事件扩大,避免引起连锁事件。\n(3)化验室根据应急情况开展现场环境、水质的监测工作,监测人员根据现场情况作好自身的安全防护措施。\n(4)外援措施如果根据事件抢险的现场情况,需要向政府相关部门汇报并请求支援的,由应急领导小组决定后,由总经理分别向县政府环境保护局、安全生产监督管理局、工会、卫生局、公安局联系。', null, '2021-01-07 14:31:20', null, '0');
INSERT INTO `plan_node` VALUES ('106', '27', '应急响应', '生产安全事故应急响应的启动由园区政府决定,园区主要负责人立即赶赴现场,成立由园区应急指挥部和事故单位组成的现场应急指挥部。园区管委会主要负责人任现场总指挥,各专业处置工作组按照职责,负责具体应急处置工作。当上级应急指挥部人员到达时,应向上级指挥部移交指挥权,并配合上级工作。', null, '2021-01-07 15:10:47', null, '0');
INSERT INTO `plan_node` VALUES ('107', '27', '预案启动', '以下情况启动本预案:\n(1)发生亡人的生产安全事故;\n(2)发生以下涉险事故: 0涉险10人以上的事故; ②造成3人以上被困或下落不明的事故; ③需要紧急疏散500米范围内人员,并需要紧急疏散500人以上和住院观察10人以上的事故④因生产安全事故对环境造成严重污染(人员密集场所、生活水源、农田、河流等)的事故; ⑤危及重要场所和设施安全(重要水利设施、危化品库、油气站、码头及其他人员密集场所等)的事故; ⑥其他;\n(3)接到事故所在条线、村(居)、企业关于事故救援增援的请求;(4)执行其他应急预案时需要或接到上级关于事故救援增援', null, '2021-01-07 15:10:47', null, '0');
INSERT INTO `plan_node` VALUES ('108', '27', '启动程序', '当所发生的事故符合本预案启动条件时,应急指挥部执行如下程序:\n(1)组建现场指挥部,确定现场指挥部成员;\n(2)通知各专业处置工作组、相关成员单位和专家参加现场救援,制定救援方案;\n(3)调动有关装备、物资支援现场救援,通知有关部门做好交通、通信、气象、物资、环保等支援工作;\n(4)及时向公众发布事故应急救援信息,掌握舆论动态,回复有关质询;\n(5)及时向上级部门请求应急支援。', null, '2021-01-07 15:10:47', null, '0');
INSERT INTO `plan_node` VALUES ('109', '27', '应急处置', '(1)事故现场抢救应以人为本,遵循“安全第一、救人为主、减少损失、先控制、后处置”的原则;\n(2)现场指挥和各专业救援队伍之间应保持良好的通信联系\n(3)救援人员应正确佩戴应急救援装备;\n(4)事故区域应根据实际情况确定警戒范围,并有明显的警戒标志;\n(5)按照国家规定保护事故现场,因抢救人员、防止事故扩大等原因需要移动现场物件时,应做出标志、进行记录、拍照和绘制现场图,并妥善保管现场重要物件;\n(6)车辆应服从公安部门或事故单位人员的安排行驶和停放;\n(7)事故发生初期,事故单位或现场人员应积极采取自救措施,防止事故的扩大,并指派专人负责引导指挥人员及各专业队伍进入事故救援现场\n(8)专家到达现场后,迅速对事故情况做出判断,提出处置实施办法和防范措施,事故得到控制后,参与事故调查并提出防范措施:\n(9)在抢险救灾过程中紧急调用的物资、设备、人员以及场地占用,任何组织和个人都必须服从应急救援的大局,不得阻拦或拒绝。', null, '2021-01-07 15:10:47', null, '0');
INSERT INTO `plan_node` VALUES ('110', '27', '现场人员的安全防护', '现场指挥部应对事发地现场的安全情况进行科学评估,保障现场应急工作人员的人身安全。必要时,要对应急工作人员进行现场短暂培训后,再开展救援行动。根据事故的特点及其引发物质的不同以及应急人员的职责取不同的防护措施。现场应急指挥部根据需要,具体协调、调集相应的安全防护装备。', null, '2021-01-07 15:10:47', null, '0');
INSERT INTO `plan_node` VALUES ('111', '27', '群众的安全防护', '根据不同事故的特点,组织和指导群众就地取材,采取简易有效的防护措施自我防护。根据实际情况,制定切实可行的疏散程序,包括疏散组织、指挥机构、疏散范围、疏散方式、疏散路线、疏散集合点、疏散人员的照顾等。组织群众撤离危险区域时,应选择安全的撤离路线,避免横穿危险区域。进入安全区域后,应尽快去除受污染的衣物,防止继发性伤害。', null, '2021-01-07 15:10:47', null, '0');
INSERT INTO `plan_node` VALUES ('112', '28', '低压触电时,采取脱离电源的方法如下', 'A、如果电源开关或插销在触电地点附近,应立即断开或拔掉插销。\nB、如果触电地点离电源开关较远,可使用绝缘钳或干燥的木柄等电工工具切断。\nC、导线如搭在触电者身上或触电人的身体压在导线上,可使用干燥的衣服、手套、绳子、木板等绝缘物做工具,拉开触电者或导线。\nD、导线没有紧缠在触电者者身上,如触电人的身上的衣服是干燥的,则可拉着他的衣服后襟将其脱离带电部分,此时救护人员不得用衣服蒙住触电者,不得直接拉触电者的脚和躯体周围的金属物品。\nE、如果救护人员握有绝缘良好的工具,也可拉着触电者的双脚将其脱离带电部分。', null, '2021-01-07 15:35:17', null, '0');
INSERT INTO `plan_node` VALUES ('113', '28', '人员离带电部位后,应紧进行抢救,具体办法如下', 'A、口对口进行人工呼吸步骤:清理嘴里东西,头尽量往后仰,鼻孔朝上,这样舌头根就不会堵塞气道;同时揭开领口和衣服\nB、在触电人的头部左边或右边,一只手捏住鼻孔,另一只手拇指食指掰开嘴巴,进行吹气。掰不开嘴巴时,可用口对鼻人工呼吸。\nc、吹气主要是使触电人的胸部膨胀,每隔5秒吹一次(吹2秒放松3秒)。\nD、救护人换气时,放松触电人的嘴和鼻,使其自动呼气。', null, '2021-01-07 15:35:17', null, '0');
INSERT INTO `plan_node` VALUES ('114', '28', '胸外心脏挤压方法', 'A、解开触电人上衣,使其仰卧在地上或硬板上(不要躺在较软的东西上);\nB.救护人跨腰蹲在触电人腰部,两手相叠,手掌根部放在心窝稍高一点的地方（胸下三分之二处);\nC、掌根用力向下面(脊背的方向)挤压,压出心脏里面的血液,压陷到3至5厘米,每秒挤压一次。挤压后掌根很快放松,让触电者胸廓自动恢复,血又充满心脏,每次放松时掌根不必完全离开胸部。', null, '2021-01-07 15:35:17', null, '0');
INSERT INTO `plan_node` VALUES ('115', '28', '触电应急措施', 'A、触电人员呼吸心脏停止,将触电者平放在地上或平板上立即进行人工呼吸和体外心脏按压。\nB.立即拨打120与当地急救中心取得联系(医院附近的直接送医院)应详细说明事故地点,严重程度,并派人到路口迎接。\nC、工地负责人及时与本公司应急抢险领导小组汇报事故的发生情况,并寻求支援。\nD、保护好现场秩序,保护好事故现场', null, '2021-01-07 15:35:17', null, '0');
INSERT INTO `plan_node` VALUES ('116', '29', '火灾应急的组织架构', '1、为了统筹指挥,公司确定注册安全主任为火灾总指挥,负责火灾应急时的全盘指挥工作。注册安全主任在火灾发生时不在厂内时总指挥由公司行政副总担任;节假日期间由公司安排的值班负责人担任：\n2、保安组长是火警时的副指挥,在总指挥的领导下负责现场具体的灭火抢救工作;各部门负责人任现场指挥；\n3、总指挥、副指挥和现场指挥应在接到火警后的第一时间内赶到火灾现场;\n4、为配合灭火抢救工作,公司特成立消防突击队,由保安员和各车间的基层骨干组成。在总指挥和现场指挥的领导下进行灭火抢救的具体工作或协助消防队参与灭火抢救工作;\n5、各部门或车间在火灾发生时应随时听任总指挥的调度,参与灭火抢救工作。', null, '2021-01-07 16:14:40', null, '0');
INSERT INTO `plan_node` VALUES ('117', '29', '火灾发生初期的应急救援响应工作', '1、在本部门(或车间)发生火灾时,在岗员工应立即对初起火灾进行扑救,就近原则运用消防救援装备如灭火器材(如灭火器、消防炮、消防栓等)扑灭火源;使用灭火器要注意以下要点:先拉开保险栓,操作者站在上风位置,侧身作业,手按压柄,距火点二米位置胶管对准火源扫射;\n2、当火势未能得到控制时,要立即通知当班保安和安全负责人;\n3、当班保安接到火警后,立即通知全厂警戒并通知保安组长迅速调集全体保安员利用身边的消防设备赶到火灾现场参加扑救,并且做好火灾现场人员秩序维护和无关人员的疏散撤离工作;\n4、当火灾蔓延到非本厂力量所能控制的程度时,在岗员工应立即敲破玻璃按响火灾按钮使用消防水栓,并安排报警--119, (报警人员应向消防部门详细报告火灾的现场情况,包括火场的单位名称和具体位置、燃烧物资、人员围困情况、联系电话和姓名等信息) ,并安排人员到路口接消防车,以便消防队员把握火灾情况和尽快抵达,采取相应的灭火措施,抓住火灾救援时机;\n5、火灾应急总指挥和现场指挥在接到火警后应在第一时间内赶赴火灾现场指挥扑救工作,指挥设备维修组把电梯迫降到底层,并切断生产区的电源,并且保证各消防设施的正常运转;\n6、火灾警报拉响后各部门应立即切断电源,并组织本部门(或车间)人员撤离到安全区域待命;\n7、人资部立即组织司机疏散本厂内停放的车辆和厂门口的障碍物,以确保救灾现场的畅通和车辆用急。', null, '2021-01-07 16:14:40', null, '0');
INSERT INTO `plan_node` VALUES ('118', '29', '火灾的灭火扑救工作', '1、火灾应急总指挥根据现场的情况对消防突击队进行初步分工,分别成立灭火组、抢救组、供水组、后勤组等各个小组,做好消防队到来之前的辅助性工作:如火灾情况的调查、人员受困情况的初步估计、各消防装备的准备就绪、救灾道路的畅通等,并随时与消防队保持联系以汇报情况;\n2、消防队赶到时,应急总指挥和现场总指挥应立即向消防队员详细汇报火灾情况,协助消防队制订灭火扑救方案;\n3、消防突击队应以\"救人重于救火\" , \"先控制后消灭”的原则果断地协助消防队员参与灭火任务\n4、各部门(或车间)的主管人员随时为消防队员和消防突击队提供火灾现场的具体情况,为灭火扑救工作提供有效的建议,并随时听从应急总指挥的调度以参与灭火扑救工作中去,并且积极配合医疗救护人员参与人员的医疗急救护理工作,尽量减少人员伤亡。', null, '2021-01-07 16:14:40', null, '0');
INSERT INTO `plan_node` VALUES ('119', '29', '火灾事故的处理工作', '1、火灾扑灭后,各部门(或车间)应立即清点本部门(或车间)的人员和受损物资,尽快确定人员伤亡和物品损失情况并向厂安委会汇报,安委会应做好详细的记录并存档;\n2、人资部应尽快协调各部做好医疗救护工作,包括医疗经费的提供、受伤人员的住院安排与护理以及以意外伤害保险的理赔工作等;\n3、设备维修组配合相关部门(或车间)人员对受损设备尽快安排修复并投入生产产使用;\n4、以安全主任为主,各安委会成员联合成立事故调查小组,调查火灾发生原因并按\"四不放过\"的原则进行事故处理;\n5、安委会做出事故调查报告,并且总结本次火灾事件的教训,在全体员工中实行安全事故的教育培训，杜绝类似事件的再次发生。', null, '2021-01-07 16:14:40', null, '0');
INSERT INTO `plan_node` VALUES ('120', '30', '强化领导，压实责任', '各部门要以对人民群众生命安全和身体健康高度负责的精神，充分认识做好疫情防控应急保障工作重要性，落实工作责任，坚决服从安排，对因应急保障措施不力，造成不良影响或严重后果的，将严肃追责问责。', null, '2021-01-08 11:26:54', null, '0');
INSERT INTO `plan_node` VALUES ('121', '30', '健全机制，强化协作', '一是建立应急保障联系沟通机制，应急保障组各成员确保24小时通讯、信息畅通。\n二是建立会商调度机制，即日起每天12时前，相关值班人员按要求向区指挥部报送当日应急保障工作简要情况。\n三是建立协调联动机制，应急保障组办公室加强统筹协调，各部门按照职能密切配合，组织动员一切力量，采取有效措施，确保各项应急保障落实。', null, '2021-01-08 11:26:54', null, '0');

-- ----------------------------
-- Table structure for `record`
-- ----------------------------
DROP TABLE IF EXISTS `record`;
CREATE TABLE `record` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键/自增/唯一',
  `event_id` int(11) DEFAULT NULL COMMENT '应急事件id',
  `model_id` int(11) DEFAULT NULL COMMENT '事件模板id',
  `record_title` varchar(255) DEFAULT NULL COMMENT '应急报告标题',
  `disaster_reason` varchar(500) DEFAULT NULL COMMENT '事故原因',
  `casualties_number` int(11) DEFAULT NULL COMMENT '伤亡人数',
  `record_content` longtext COMMENT '应急报告内容',
  `status` char(1) DEFAULT '0' COMMENT '处理结果状态：0-成功 1-失败',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `del_flag` char(1) DEFAULT '0' COMMENT '逻辑删除(0=正常,1=删除)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='应急报告表';

-- ----------------------------
-- Records of record
-- ----------------------------
INSERT INTO `record` VALUES ('10', '178', '17', '电线老化，用电负载过大', '缺乏用电安全知识', '0', '电线老化，用电负载过大，已通知相应部门进行更换和整改', '0', '2021-01-07 15:53:37', null, '0');

-- ----------------------------
-- Table structure for `task_goods`
-- ----------------------------
DROP TABLE IF EXISTS `task_goods`;
CREATE TABLE `task_goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键/自增/唯一',
  `task_id` int(11) DEFAULT NULL COMMENT '应急调度任务节点id',
  `goods_id` int(11) DEFAULT NULL COMMENT '物资id',
  `number` int(11) DEFAULT NULL COMMENT '物资数量',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8 COMMENT='应急调度任务节点物资中间表';

-- ----------------------------
-- Records of task_goods
-- ----------------------------

-- ----------------------------
-- Table structure for `task_node`
-- ----------------------------
DROP TABLE IF EXISTS `task_node`;
CREATE TABLE `task_node` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键/自增/唯一',
  `node_title` varchar(500) DEFAULT NULL COMMENT '节点标题',
  `node_content` varchar(500) DEFAULT NULL COMMENT '节点内容',
  `plan_node_id` int(11) DEFAULT NULL COMMENT '预案节点id',
  `event_id` int(11) DEFAULT NULL COMMENT '事件id',
  `status` char(1) DEFAULT '2' COMMENT '状态: 0-未开始 1-执行中 2-已完成 3-失败',
  `sort` int(11) DEFAULT NULL COMMENT '排序/排序',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `del_flag` char(1) DEFAULT '0' COMMENT '逻辑删除(0=正常,1=删除)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=utf8 COMMENT='应急调度任务节点表';

-- ----------------------------
-- Records of task_node
-- ----------------------------

-- ----------------------------
-- Table structure for `task_user`
-- ----------------------------
DROP TABLE IF EXISTS `task_user`;
CREATE TABLE `task_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键/自增/唯一',
  `task_id` int(11) DEFAULT NULL COMMENT '应急调度任务节点id',
  `person_id` int(11) DEFAULT NULL COMMENT '应急人员id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8 COMMENT='应急调度任务节点人员中间表';

-- ----------------------------
-- Records of task_user
-- ----------------------------

-- ----------------------------
-- Table structure for `warning_analysis`
-- ----------------------------
DROP TABLE IF EXISTS `warning_analysis`;
CREATE TABLE `warning_analysis` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键/自增/唯一',
  `tenant_id` int(11) DEFAULT NULL COMMENT '企业id',
  `tenant_phone` varchar(255) DEFAULT NULL COMMENT '企业电话',
  `tenant_name` varchar(255) DEFAULT NULL COMMENT '企业名称',
  `model_id` int(11) DEFAULT NULL COMMENT '事件模板id',
  `event_reason` varchar(255) DEFAULT NULL COMMENT '事故起因',
  `event_process` varchar(255) DEFAULT NULL COMMENT '事故处理过程',
  `event_result` varchar(255) DEFAULT NULL COMMENT '事故处理结果报告',
  `injury_num` int(11) DEFAULT NULL COMMENT '受伤人数',
  `death_num` int(11) DEFAULT NULL COMMENT '死亡人数',
  `direct_economic_loss` int(11) DEFAULT NULL COMMENT '直接经济损失',
  `indirect_economic_loss` int(11) DEFAULT NULL COMMENT '间接经济损失',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `del_flag` char(1) DEFAULT '0' COMMENT '逻辑删除(0=正常,1=删除)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COMMENT='预警信息统计分析表';

-- ----------------------------
-- Records of warning_analysis
-- ----------------------------

-- ----------------------------
-- Table structure for `week_duty_officer`
-- ----------------------------
DROP TABLE IF EXISTS `week_duty_officer`;
CREATE TABLE `week_duty_officer` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键/自增/唯一',
  `year_month` datetime DEFAULT NULL COMMENT '年-月-日',
  `person_id` int(11) DEFAULT NULL COMMENT '值班人员id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8 COMMENT='星期值班人员中间表';

-- ----------------------------
-- Records of week_duty_officer
-- ----------------------------
INSERT INTO `week_duty_officer` VALUES ('34', '2020-11-19 00:00:00', '20');
INSERT INTO `week_duty_officer` VALUES ('35', '2020-11-20 00:00:00', '20');
INSERT INTO `week_duty_officer` VALUES ('37', '2020-11-21 00:00:00', '20');
INSERT INTO `week_duty_officer` VALUES ('38', '2020-11-23 00:00:00', '20');
