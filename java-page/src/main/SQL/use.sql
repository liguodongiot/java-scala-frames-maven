DROP TABLE IF EXISTS student;
CREATE TABLE student(
  id int(11) NOT NULL AUTO_INCREMENT ,
  name varchar(16) NOT NULL ,
  gender int(11) DEFAULT NULL ,
  age int(11) DEFAULT NULL ,
  address varchar(128) DEFAULT NULL ,
  PRIMARY KEY (id)
)ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

INSERT INTO student VALUES (1,'mark',1,43,'');
INSERT INTO student VALUES (2,'32',2,22,'fdfdsfdsfdsfds');
INSERT INTO student VALUES (3,'32',2,25,'dsa');
INSERT INTO student VALUES (4,'32',2,33,'dsa');
INSERT INTO student VALUES (5,'33',1,32,'dsa');
INSERT INTO student VALUES (6,'33',1,43,'dsa');
INSERT INTO student VALUES (7,'eew',2,22,'dsa');
INSERT INTO student VALUES (8,'ee',2,25,'fds');
INSERT INTO student VALUES (9,'ee',2,33,'fds');
INSERT INTO student VALUES (10,'w',1,32,'rew');
INSERT INTO student VALUES (11,'ee',2,25,'tr');
INSERT INTO student VALUES (12,'e',2,33,'ew');
INSERT INTO student VALUES (13,'ew',1,32,'re');
/*
INSERT INTO student VALUES (1,'周杰伦',1,43,'北京市西城区');
INSERT INTO student VALUES (2,'唐嫣',2,22,'成都市武侯区');
INSERT INTO student VALUES (3,'邓紫棋',2,25,'北京市朝阳区');
INSERT INTO student VALUES (4,'李冰冰',2,33,'广安市广安区');
INSERT INTO student VALUES (5,'林志炫',1,32,'成都市新都区');
INSERT INTO student VALUES (6,'周杰伦',1,43,'北京市西城区');
INSERT INTO student VALUES (7,'唐嫣',2,22,'成都市武侯区');
INSERT INTO student VALUES (8,'邓紫棋',2,25,'北京市朝阳区');
INSERT INTO student VALUES (9,'李冰冰',2,33,'广安市广安区');
INSERT INTO student VALUES (10,'林志炫',1,32,'成都市新都区');
INSERT INTO student VALUES (11,'邓紫棋',2,25,'北京市朝阳区');
INSERT INTO student VALUES (12,'李冰冰',2,33,'广安市广安区');
INSERT INTO student VALUES (13,'林志炫',1,32,'成都市新都区');*/
