/*
 Navicat Premium Data Transfer

 Source Server         : 192.168.199.127_3316
 Source Server Type    : MySQL
 Source Server Version : 50724
 Source Host           : 192.168.199.127:3316
 Source Schema         : db0

 Target Server Type    : MySQL
 Target Server Version : 50724
 File Encoding         : 65001

 Date: 01/06/2019 10:17:49
*/

SET
NAMES
utf8mb4;
SET
FOREIGN_KEY_CHECKS
=
0;

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
VALUES (50, 'test50', 60);
INSERT INTO `user_0`
VALUES (52, 'test52', 62);
INSERT INTO `user_0`
VALUES (54, 'test54', 64);
INSERT INTO `user_0`
VALUES (56, 'test56', 66);
INSERT INTO `user_0`
VALUES (58, 'test58', 68);
INSERT INTO `user_0`
VALUES (60, 'test60', 70);
INSERT INTO `user_0`
VALUES (62, 'test62', 72);
INSERT INTO `user_0`
VALUES (64, 'test64', 74);
INSERT INTO `user_0`
VALUES (66, 'test66', 76);
INSERT INTO `user_0`
VALUES (68, 'test68', 78);
INSERT INTO `user_0`
VALUES (70, 'test70', 80);
INSERT INTO `user_0`
VALUES (72, 'test72', 82);
INSERT INTO `user_0`
VALUES (74, 'test74', 84);
INSERT INTO `user_0`
VALUES (76, 'test76', 86);
INSERT INTO `user_0`
VALUES (78, 'test78', 88);
INSERT INTO `user_0`
VALUES (80, 'test80', 90);
INSERT INTO `user_0`
VALUES (82, 'test82', 92);
INSERT INTO `user_0`
VALUES (84, 'test84', 94);
INSERT INTO `user_0`
VALUES (86, 'test86', 96);
INSERT INTO `user_0`
VALUES (88, 'test88', 98);
INSERT INTO `user_0`
VALUES (90, 'test90', 100);
INSERT INTO `user_0`
VALUES (92, 'test92', 102);
INSERT INTO `user_0`
VALUES (94, 'test94', 104);
INSERT INTO `user_0`
VALUES (96, 'test96', 106);
INSERT INTO `user_0`
VALUES (98, 'test98', 108);
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
VALUES (2, 'test2', 13);
INSERT INTO `user_1`
VALUES (4, 'test4', 15);
INSERT INTO `user_1`
VALUES (6, 'test6', 17);
INSERT INTO `user_1`
VALUES (8, 'test8', 19);
INSERT INTO `user_1`
VALUES (10, 'test10', 21);
INSERT INTO `user_1`
VALUES (12, 'test12', 23);
INSERT INTO `user_1`
VALUES (14, 'test14', 25);
INSERT INTO `user_1`
VALUES (16, 'test16', 27);
INSERT INTO `user_1`
VALUES (18, 'test18', 29);
INSERT INTO `user_1`
VALUES (20, 'test20', 31);
INSERT INTO `user_1`
VALUES (22, 'test22', 33);
INSERT INTO `user_1`
VALUES (24, 'test24', 35);
INSERT INTO `user_1`
VALUES (26, 'test26', 37);
INSERT INTO `user_1`
VALUES (28, 'test28', 39);
INSERT INTO `user_1`
VALUES (30, 'test30', 41);
INSERT INTO `user_1`
VALUES (32, 'test32', 43);
INSERT INTO `user_1`
VALUES (34, 'test34', 45);
INSERT INTO `user_1`
VALUES (36, 'test36', 47);
INSERT INTO `user_1`
VALUES (38, 'test38', 49);
INSERT INTO `user_1`
VALUES (40, 'test40', 51);
INSERT INTO `user_1`
VALUES (42, 'test42', 53);
INSERT INTO `user_1`
VALUES (44, 'test44', 55);
INSERT INTO `user_1`
VALUES (46, 'test46', 57);
INSERT INTO `user_1`
VALUES (48, 'test48', 59);
COMMIT;

SET
FOREIGN_KEY_CHECKS
=
1;
