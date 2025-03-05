-- 向sys_dict_item表中插入字典数据
-- 根据图片中的数据生成INSERT语句

-- 设置字典ID为固定值18970978341729976733
SET @DICT_ID = 18970978341729976733;

-- 设置初始ID值，每次自增10
SET @CURRENT_ID = 1897099435294023682;

-- 插入数据
-- 注意：根据图二可以看到部分数据已经存在，这里只插入剩余的数据

-- E05 - 账期为5天
INSERT INTO sys_dict_item (ID, DICT_ID, ITEM_TEXT, ITEM_VALUE, DESCRIPTION, SORT_ORDER, STATUS, CREATE_BY, CREATE_TIME)
VALUES (@CURRENT_ID, @DICT_ID, 'T/T within 5 days upon B/L date', 'E05', '账期为5天', 1, 1, 'admin', NOW());
SET @CURRENT_ID = @CURRENT_ID + 10;

-- E07 - 账期为7天
INSERT INTO sys_dict_item (ID, DICT_ID, ITEM_TEXT, ITEM_VALUE, DESCRIPTION, SORT_ORDER, STATUS, CREATE_BY, CREATE_TIME)
VALUES (@CURRENT_ID, @DICT_ID, 'T/T within 7 days upon B/L date', 'E07', '账期为7天', 1, 1, 'admin', NOW());
SET @CURRENT_ID = @CURRENT_ID + 10;

-- E10 - 账期为10天
INSERT INTO sys_dict_item (ID, DICT_ID, ITEM_TEXT, ITEM_VALUE, DESCRIPTION, SORT_ORDER, STATUS, CREATE_BY, CREATE_TIME)
VALUES (@CURRENT_ID, @DICT_ID, 'T/T within 10 days upon B/L date', 'E10', '账期为10天', 1, 1, 'admin', NOW());
SET @CURRENT_ID = @CURRENT_ID + 10;

-- E14 - 账期为14天
INSERT INTO sys_dict_item (ID, DICT_ID, ITEM_TEXT, ITEM_VALUE, DESCRIPTION, SORT_ORDER, STATUS, CREATE_BY, CREATE_TIME)
VALUES (@CURRENT_ID, @DICT_ID, 'T/T within 14 days upon B/L date', 'E14', '账期为14天', 1, 1, 'admin', NOW());
SET @CURRENT_ID = @CURRENT_ID + 10;

-- E15 - 账期为15天
INSERT INTO sys_dict_item (ID, DICT_ID, ITEM_TEXT, ITEM_VALUE, DESCRIPTION, SORT_ORDER, STATUS, CREATE_BY, CREATE_TIME)
VALUES (@CURRENT_ID, @DICT_ID, 'T/T within 15 days upon B/L date', 'E15', '账期为15天', 1, 1, 'admin', NOW());
SET @CURRENT_ID = @CURRENT_ID + 10;

-- E20 - 账期为20天
INSERT INTO sys_dict_item (ID, DICT_ID, ITEM_TEXT, ITEM_VALUE, DESCRIPTION, SORT_ORDER, STATUS, CREATE_BY, CREATE_TIME)
VALUES (@CURRENT_ID, @DICT_ID, 'T/T within 20 days upon B/L date', 'E20', '账期为20天', 1, 1, 'admin', NOW());
SET @CURRENT_ID = @CURRENT_ID + 10;

-- E30 - 账期为30天
INSERT INTO sys_dict_item (ID, DICT_ID, ITEM_TEXT, ITEM_VALUE, DESCRIPTION, SORT_ORDER, STATUS, CREATE_BY, CREATE_TIME)
VALUES (@CURRENT_ID, @DICT_ID, 'T/T within 30 days upon B/L date', 'E30', '账期为30天', 1, 1, 'admin', NOW());
SET @CURRENT_ID = @CURRENT_ID + 10;

-- E35 - 账期为35天
INSERT INTO sys_dict_item (ID, DICT_ID, ITEM_TEXT, ITEM_VALUE, DESCRIPTION, SORT_ORDER, STATUS, CREATE_BY, CREATE_TIME)
VALUES (@CURRENT_ID, @DICT_ID, 'T/T within 35 days upon B/L date', 'E35', '账期为35天', 1, 1, 'admin', NOW());
SET @CURRENT_ID = @CURRENT_ID + 10;

-- E40 - 账期为40天
INSERT INTO sys_dict_item (ID, DICT_ID, ITEM_TEXT, ITEM_VALUE, DESCRIPTION, SORT_ORDER, STATUS, CREATE_BY, CREATE_TIME)
VALUES (@CURRENT_ID, @DICT_ID, 'T/T within 40 days upon B/L date', 'E40', '账期为40天', 1, 1, 'admin', NOW());
SET @CURRENT_ID = @CURRENT_ID + 10;

-- E45 - 账期为45天
INSERT INTO sys_dict_item (ID, DICT_ID, ITEM_TEXT, ITEM_VALUE, DESCRIPTION, SORT_ORDER, STATUS, CREATE_BY, CREATE_TIME)
VALUES (@CURRENT_ID, @DICT_ID, 'T/T within 45 days upon B/L date', 'E45', '账期为45天', 1, 1, 'admin', NOW());
SET @CURRENT_ID = @CURRENT_ID + 10;

-- E50 - 账期为50天
INSERT INTO sys_dict_item (ID, DICT_ID, ITEM_TEXT, ITEM_VALUE, DESCRIPTION, SORT_ORDER, STATUS, CREATE_BY, CREATE_TIME)
VALUES (@CURRENT_ID, @DICT_ID, 'T/T within 50 days upon B/L date', 'E50', '账期为50天', 1, 1, 'admin', NOW());
SET @CURRENT_ID = @CURRENT_ID + 10;

-- E55 - 账期为55天
INSERT INTO sys_dict_item (ID, DICT_ID, ITEM_TEXT, ITEM_VALUE, DESCRIPTION, SORT_ORDER, STATUS, CREATE_BY, CREATE_TIME)
VALUES (@CURRENT_ID, @DICT_ID, 'T/T within 55 days upon B/L date', 'E55', '账期为55天', 1, 1, 'admin', NOW());
SET @CURRENT_ID = @CURRENT_ID + 10;

-- E60 - 账期为60天
INSERT INTO sys_dict_item (ID, DICT_ID, ITEM_TEXT, ITEM_VALUE, DESCRIPTION, SORT_ORDER, STATUS, CREATE_BY, CREATE_TIME)
VALUES (@CURRENT_ID, @DICT_ID, 'T/T within 60 days upon B/L date', 'E60', '账期为60天', 1, 1, 'admin', NOW());
SET @CURRENT_ID = @CURRENT_ID + 10;

-- E70 - 账期为70天
INSERT INTO sys_dict_item (ID, DICT_ID, ITEM_TEXT, ITEM_VALUE, DESCRIPTION, SORT_ORDER, STATUS, CREATE_BY, CREATE_TIME)
VALUES (@CURRENT_ID, @DICT_ID, 'T/T within 70 days upon B/L date', 'E70', '账期为70天', 1, 1, 'admin', NOW());
SET @CURRENT_ID = @CURRENT_ID + 10;

-- E75 - 账期为75天
INSERT INTO sys_dict_item (ID, DICT_ID, ITEM_TEXT, ITEM_VALUE, DESCRIPTION, SORT_ORDER, STATUS, CREATE_BY, CREATE_TIME)
VALUES (@CURRENT_ID, @DICT_ID, 'T/T within 75 days upon B/L date', 'E75', '账期为75天', 1, 1, 'admin', NOW());
SET @CURRENT_ID = @CURRENT_ID + 10;

-- E80 - 账期为80天
INSERT INTO sys_dict_item (ID, DICT_ID, ITEM_TEXT, ITEM_VALUE, DESCRIPTION, SORT_ORDER, STATUS, CREATE_BY, CREATE_TIME)
VALUES (@CURRENT_ID, @DICT_ID, 'T/T within 80 days upon B/L date', 'E80', '账期为80天', 1, 1, 'admin', NOW());
SET @CURRENT_ID = @CURRENT_ID + 10;

-- E85 - 账期为85天
INSERT INTO sys_dict_item (ID, DICT_ID, ITEM_TEXT, ITEM_VALUE, DESCRIPTION, SORT_ORDER, STATUS, CREATE_BY, CREATE_TIME)
VALUES (@CURRENT_ID, @DICT_ID, 'T/T within 85 days upon B/L date', 'E85', '账期为85天', 1, 1, 'admin', NOW());
SET @CURRENT_ID = @CURRENT_ID + 10;

-- E90 - 账期为90天
INSERT INTO sys_dict_item (ID, DICT_ID, ITEM_TEXT, ITEM_VALUE, DESCRIPTION, SORT_ORDER, STATUS, CREATE_BY, CREATE_TIME)
VALUES (@CURRENT_ID, @DICT_ID, 'T/T within 90 days upon B/L date', 'E90', '账期为90天', 1, 1, 'admin', NOW());
SET @CURRENT_ID = @CURRENT_ID + 10;

-- E95 - 账期为95天
INSERT INTO sys_dict_item (ID, DICT_ID, ITEM_TEXT, ITEM_VALUE, DESCRIPTION, SORT_ORDER, STATUS, CREATE_BY, CREATE_TIME)
VALUES (@CURRENT_ID, @DICT_ID, 'T/T within 95 days upon B/L date', 'E95', '账期为95天', 1, 1, 'admin', NOW());
SET @CURRENT_ID = @CURRENT_ID + 10;

-- F00 - 账期为100天
INSERT INTO sys_dict_item (ID, DICT_ID, ITEM_TEXT, ITEM_VALUE, DESCRIPTION, SORT_ORDER, STATUS, CREATE_BY, CREATE_TIME)
VALUES (@CURRENT_ID, @DICT_ID, 'T/T within 100 days upon B/L date', 'F00', '账期为100天', 1, 1, 'admin', NOW());
SET @CURRENT_ID = @CURRENT_ID + 10;

-- F20 - 账期为120天
INSERT INTO sys_dict_item (ID, DICT_ID, ITEM_TEXT, ITEM_VALUE, DESCRIPTION, SORT_ORDER, STATUS, CREATE_BY, CREATE_TIME)
VALUES (@CURRENT_ID, @DICT_ID, 'T/T within 120 days upon B/L date', 'F20', '账期为120天', 1, 1, 'admin', NOW());
SET @CURRENT_ID = @CURRENT_ID + 10;

-- F35 - 账期为135天
INSERT INTO sys_dict_item (ID, DICT_ID, ITEM_TEXT, ITEM_VALUE, DESCRIPTION, SORT_ORDER, STATUS, CREATE_BY, CREATE_TIME)
VALUES (@CURRENT_ID, @DICT_ID, 'T/T within 135 days upon B/L date', 'F35', '账期为135天', 1, 1, 'admin', NOW());
SET @CURRENT_ID = @CURRENT_ID + 10;

-- F50 - 账期为150天
INSERT INTO sys_dict_item (ID, DICT_ID, ITEM_TEXT, ITEM_VALUE, DESCRIPTION, SORT_ORDER, STATUS, CREATE_BY, CREATE_TIME)
VALUES (@CURRENT_ID, @DICT_ID, 'T/T within 150 days upon B/L date', 'F50', '账期为150天', 1, 1, 'admin', NOW());
SET @CURRENT_ID = @CURRENT_ID + 10;

-- F80 - 账期为180天
INSERT INTO sys_dict_item (ID, DICT_ID, ITEM_TEXT, ITEM_VALUE, DESCRIPTION, SORT_ORDER, STATUS, CREATE_BY, CREATE_TIME)
VALUES (@CURRENT_ID, @DICT_ID, 'T/T within 180 days upon B/L date', 'F80', '账期为180天', 1, 1, 'admin', NOW());
SET @CURRENT_ID = @CURRENT_ID + 10;

-- H50 - 账期为350天
INSERT INTO sys_dict_item (ID, DICT_ID, ITEM_TEXT, ITEM_VALUE, DESCRIPTION, SORT_ORDER, STATUS, CREATE_BY, CREATE_TIME)
VALUES (@CURRENT_ID, @DICT_ID, 'T/T within 350 days upon B/L date', 'H50', '账期为350天', 1, 1, 'admin', NOW());

-- 注意：执行此SQL前，请确认以下几点：
-- 1. 确认DICT_ID是否正确
-- 2. 确认表结构是否与SQL语句匹配
-- 3. 确认初始ID值是否符合要求