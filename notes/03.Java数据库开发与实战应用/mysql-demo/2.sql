-- 创建慕课网数据库 imooc
CREATE DATABASE IF NOT EXISTS imooc DEFAULT CHARACTER SET 'UTF8';

-- 打开慕课网数据库
USE imooc;

-- 创建用户表imooc_uer
CREATE TABLE IF NOT EXISTS imooc_user(
    id INT,
    username VARCHAR(20),
    age TINYINT,
    email VARCHAR(50),
    tel CHAR(11),
    salary float(8,2),
    married TINYINT(1),
    password char(32),
    card char(18),
    sex ENUM('男','女','保密')
)ENGINE=INNODB CHARSET=UTF8;

-- 查看imooc_user表的表结构
DESC imooc_user;

DESCRIBE imooc_user;

SHOW COLUMS FROM imooc_user;

-- 删除imooc_user表
DROP TABLES IF EXISTS imooc_user;

--查看当前数据库下的数据表
SHOW TABLES;

-- 查看imooc_user表的详细信息
SHOW CREATE TABLE imooc_user;