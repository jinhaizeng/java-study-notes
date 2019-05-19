-- 测试浮点型
CREATE TABLE test_float(
    a FLOAT(6,2),
    b DOUBLE(6,2),
    c DECIMAL(6,2)
);

INSERT test_float(a,b,c) VALUES(4.143,4.146,4.149);
-- 结果就是都被截断了

CREATE TABLE test_float1(
    a FLOAT,
    b DOUBLE,
    c DECIMAL
);

INSERT test_float1(a,b,c) VALUES(4.143,4.146,4.149);
-- DECIMAL如果没有指定小数部分位数，被把他截断成整数