-- 测试整型
CREATE TABLE test_int(
    a tinyint,
    b smallint,
    c mediumint,
    d int,
    e bigint
);

INSERT test_int(a) VALUES(-128);
-- 如果超出数据范围，会产生截断现象，比如：int的范围是-128~127，赋值给-129的话，会被截断成-128
INSERT test_int(a) VALUES(-129);
-- 此结果是截断为127
INSERT test_int(a) VALUES(1270);

-- 测试无符号

CREATE TABLE test_unsigned(
    a tinyint,
    b tinyint unsigned
);

-- b如果填入一个负数，会直接报警告，同样也会产生截断的现象
INSERT test_unsigned(a,b) VALUES(-12,-12)

-- 测试零填充 ZEROFILL
CREATE TABLE test_int1(
    a tinyint ZEROFILL,
    b smallint ZEROFILL,
    c mediumint ZEROFILL,
    d int ZEROFILL,
    e bigint ZEROFILL
);

INSERT test_int1(a,b,c,d,e) VALUE(1,1,1,1,1);

-- 测试指定显示位数
-- 指定两位显示位数，数据超过显示位数，也能正常写入无错，但是会被类型规定范围所阻断
CREATE TABLES test_int2(
    a tinyint(2),
    b smallint(2)
);
INSERT test_int2(a,b) VALUE(123,45678);