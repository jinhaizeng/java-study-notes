-- 测试char和varchar
CREATE TABLE test_str(
    a CHAR(5),
    b VARCHAR(5)
);

-- 插入多条记录
INSERT test_str(a,b) VALUE('','');
INSERT test_str(a,b) VALUE('a','a');
INSERT test_str(a,b) VALUE('ab','ab');
INSERT test_str(a,b) VALUE('abc','abc');
INSERT test_str(a,b) VALUE('abcd','abcd');
INSERT test_str(a,b) VALUE('abcde','abcde');
INSERT test_str(a,b) VALUE('abcdef','abcdef');      -- 超出规定位数，弹出警告，会进行数据的截取


----------------------------------------------------------------------------------------------------------
-- 测试ENUM
CREATE TABLE test_enum(
    sex ENUM('男','女','保密')
);

-- 插入ENUM类型的记录
INSERT test_enum(sex) VALUES('男');
INSERT test_enum(sex) VALUES('男1');    -- 不在枚举类型里面，会直接报错
INSERT test_enum(sex) VALUES(NULL);     -- NULL值是可以被插入的
INSERT test_enum(sex) VALUES(1);        -- 采用编号的方式，1对应的是男，2对应的是女，3对应的是保密，但是如果越界了，比如5，就会直接报错

-- 枚举类型会自动过滤掉空格，所以一下插入方式也不会报错
CREATE TABLE test_num(
    sex ENUM('男    ','女     ','保密  ')
);

-- 插入记录

----------------------------------------------------------------------------------------------------------
-- 测试set
CREATE TABLE test_num(
    a set('A','B','C','D','E','F')
);

INSERT test_num(a) VALUES('A');

 # 采用cookies和headers的方法实现反爬，注意每次每次使用之前更新下cookies
    f_cookies = open('cookie.txt', 'r')
    # proxies = {'http': 'http://112.85.129.217:9999', 'https': 'https://112.85.129.217:9999'}
    cookies = {}
    for line in f_cookies.read().split(';'):
        name, value = line.strip().split('=', 1)
        cookies[name] = value

    headers = {
        'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.121 Safari/537.36'
    }


r = requests.get(url, headers=headers,cookies=cookies)
time.sleep(1 + float(random.randint(1, 100)) / 20)