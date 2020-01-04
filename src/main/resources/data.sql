GRANT ALL PRIVILEGES ON *.* TO 'root'@'%' WITH GRANT OPTION;
FLUSH PRIVILEGES;
show grants;


--- Rule Info table
INSERT INTO jarvis.rule_info
(id, active, created_date, last_modified_date, description, rule_condition, rule_name, created_by, last_modified_by)
VALUES(1, 0, now(), now(), 'This is for Bday', '0', 'BDAY', 1, 1);

INSERT INTO jarvis.rule_info
(id, active, created_date, last_modified_date, description, rule_condition, rule_name, created_by, last_modified_by)
VALUES(2, 0, now(), now(), 'This is for Bday', '5', 'BDAY', 1, 1);

INSERT INTO jarvis.rule_info
(id, active, created_date, last_modified_date, description, rule_condition, rule_name, created_by, last_modified_by)
VALUES(3, 0, now(), now(), 'This is for Name Change for member', '1', 'MEMCHG', 1, 1);

INSERT INTO jarvis.rule_info
(id, active, created_date, last_modified_date, description, rule_condition, rule_name, created_by, last_modified_by)
VALUES(4, 0, now(), now(), 'This is for Address Change for member', '0', 'MEMCHG', 1, 1);



----Action info

INSERT INTO jarvis.action_info
(id, active, created_date, last_modified_date, action_id_preference, actionid_name, description, templete_preference, created_by, last_modified_by)
VALUES(1, 1, now(), now(), 'BOTH', 'BDAY1', 'This is for birthday', 'SMS', 1, 1);

INSERT INTO jarvis.action_info
(id, active, created_date, last_modified_date, action_id_preference, actionid_name, description, templete_preference, created_by, last_modified_by)
VALUES(2, 1, now(), now(), 'BOTH', 'MEMCHG1', 'This is for member change', 'BOTH', 1, 1);

INSERT INTO jarvis.action_info
(id, active, created_date, last_modified_date, action_id_preference, actionid_name, description, templete_preference, created_by, last_modified_by)
VALUES(3, 1, now(), now(), 'BOTH', 'ENROLL1', 'This is for enroll', 'EMAIL', 1, 1);

INSERT INTO jarvis.action_info
(id, active, created_date, last_modified_date, action_id_preference, actionid_name, description, templete_preference, created_by, last_modified_by)
VALUES(4, 1, now(), now(), 'BOTH', 'IDCARD1', 'This is for Id card', 'BOTH', 1, 1);


UPDATE action_info set created_date=NULL , last_modified_date=NULL
