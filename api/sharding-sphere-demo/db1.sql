/*
 Navicat Premium Data Transfer

 Source Server         : 192.168.199.127_3326
 Source Server Type    : MySQL
 Source Server Version : 50724
 Source Host           : 192.168.199.127:3326
 Source Schema         : db1

 Target Server Type    : MySQL
 Target Server Version : 50724
 File Encoding         : 65001

 Date: 01/06/2019 10:17:41
*/

SET
NAMES
utf8mb4;
SET
FOREIGN_KEY_CHECKS
=
0;

-- ----------------------------
-- Table structure for score
-- ----------------------------
DROP TABLE IF EXISTS `score`;
CREATE TABLE `score`
(
  `id`      int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `score`   int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE =utf8mb4_bin;

-- ----------------------------
-- Records of score
-- ----------------------------
BEGIN;
INSERT INTO `score`
VALUES (1, 1, 10);
INSERT INTO `score`
VALUES (2, 2, 20);
COMMIT;

-- ----------------------------
-- Table structure for user_0
-- ----------------------------
DROP TABLE IF EXISTS `user_0`;
CREATE TABLE `user_0`
(
  `id`   int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `age`  int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of user_0
-- ----------------------------
BEGIN;
INSERT INTO `user_0`
VALUES (1, 'test1', 12);
INSERT INTO `user_0`
VALUES (3, 'test3', 14);
INSERT INTO `user_0`
VALUES (5, 'test5', 16);
INSERT INTO `user_0`
VALUES (7, 'test7', 18);
INSERT INTO `user_0`
VALUES (9, 'test9', 20);
INSERT INTO `user_0`
VALUES (11, 'test11', 22);
INSERT INTO `user_0`
VALUES (13, 'test13', 24);
INSERT INTO `user_0`
VALUES (15, 'test15', 26);
INSERT INTO `user_0`
VALUES (17, 'test17', 28);
INSERT INTO `user_0`
VALUES (19, 'test19', 30);
INSERT INTO `user_0`
VALUES (21, 'test21', 32);
INSERT INTO `user_0`
VALUES (23, 'test23', 34);
INSERT INTO `user_0`
VALUES (25, 'test25', 36);
INSERT INTO `user_0`
VALUES (27, 'test27', 38);
INSERT INTO `user_0`
VALUES (29, 'test29', 40);
INSERT INTO `user_0`
VALUES (31, 'test31', 42);
INSERT INTO `user_0`
VALUES (33, 'test33', 44);
INSERT INTO `user_0`
VALUES (35, 'test35', 46);
INSERT INTO `user_0`
VALUES (37, 'test37', 48);
INSERT INTO `user_0`
VALUES (39, 'test39', 50);
INSERT INTO `user_0`
VALUES (41, 'test41', 52);
INSERT INTO `user_0`
VALUES (43, 'test43', 54);
INSERT INTO `user_0`
VALUES (45, 'test45', 56);
INSERT INTO `user_0`
VALUES (47, 'test47', 58);
INSERT INTO `user_0`
VALUES (49, 'test49', 60);
COMMIT;

-- ----------------------------
-- Table structure for user_1
-- ----------------------------
DROP TABLE IF EXISTS `user_1`;
CREATE TABLE `user_1`
(
  `id`   int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `age`  int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of user_1
-- ----------------------------
BEGIN;
INSERT INTO `user_1`
VALUES (51, 'test51', 61);
INSERT INTO `user_1`
VALUES (53, 'test53', 63);
INSERT INTO `user_1`
VALUES (55, 'test55', 65);
INSERT INTO `user_1`
VALUES (57, 'test57', 67);
INSERT INTO `user_1`
VALUES (59, 'test59', 69);
INSERT INTO `user_1`
VALUES (61, 'test61', 71);
INSERT INTO `user_1`
VALUES (63, 'test63', 73);
INSERT INTO `user_1`
VALUES (65, 'test65', 75);
INSERT INTO `user_1`
VALUES (67, 'test67', 77);
INSERT INTO `user_1`
VALUES (69, 'test69', 79);
INSERT INTO `user_1`
VALUES (71, 'test71', 81);
INSERT INTO `user_1`
VALUES (73, 'test73', 83);
INSERT INTO `user_1`
VALUES (75, 'test75', 85);
INSERT INTO `user_1`
VALUES (77, 'test77', 87);
INSERT INTO `user_1`
VALUES (79, 'test79', 89);
INSERT INTO `user_1`
VALUES (81, 'test81', 91);
INSERT INTO `user_1`
VALUES (83, 'test83', 93);
INSERT INTO `user_1`
VALUES (85, 'test85', 95);
INSERT INTO `user_1`
VALUES (87, 'test87', 97);
INSERT INTO `user_1`
VALUES (89, 'test89', 99);
INSERT INTO `user_1`
VALUES (91, 'test91', 101);
INSERT INTO `user_1`
VALUES (93, 'test93', 103);
INSERT INTO `user_1`
VALUES (95, 'test95', 105);
INSERT INTO `user_1`
VALUES (97, 'test97', 107);
INSERT INTO `user_1`
VALUES (99, 'test99', 109);
COMMIT;

SET
FOREIGN_KEY_CHECKS
=
1;
