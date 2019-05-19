-- 创建用户表imooc_uer
CREATE TABLE IF NOT EXISTS imooc_user(
    id INT,
    username VARCHAR(20),
    age TINYINT,
    email VARCHAR(50),
    tel CHAR(11),
    salary float(8,2),
    married TINYINT(1),
    addr VARCHAR(100),
    password char(32),
    card char(18),
    sex ENUM('男','女','保密')
)ENGINE=INNODB CHARSET=UTF8;

-- 向表中插入一项纪录
-- INSERT [INTO] tbl_name(id,username,...) VALUES(1,'KING',...)

-- 向imooc_user表插入一条纪录
INSERT imooc_user(id,username,age,email,tel,salary,married,addr,password,card,sex)
VALUES(1,'king',24,'382771946@qq.com','13812345678',88888.68,0,'北京','king','123456789123456789','男');

-- 查询表中所有记录
SELECT * FROM imooc_user;