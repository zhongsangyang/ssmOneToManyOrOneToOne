use shujuguanxi;
DROP TABLE IF EXISTS t_customer;
CREATE TABLE t_customer(
customerId INT PRIMARY KEY AUTO_INCREMENT,
customerName VARCHAR(20) NOT NULL,
customerTel INT NOT NULL
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS t_ticket;
CREATE TABLE t_ticket(
ticketId INT PRIMARY KEY  AUTO_INCREMENT,
ticketAddress VARCHAR(50) NOT NULL,
ticketPrice INT NOT NULL,
ticketCId INT NOT NULL
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into t_customer values(1,'小王',1222222226);
insert into t_customer values(2,'天天',1222222226);
insert into t_customer values(3,'阿大',1222222226);

insert into  t_ticket values(1,'武汉到重庆',100,1);
insert into  t_ticket values(2,'北京到上海',200,1);
insert into  t_ticket values(3,'深圳到广州',50,1);

ALTER TABLE t_customer MODIFY customerTel INT(11) NOT NULL;
TRUNCATE TABLE t_customer;TRUNCATE TABLE t_ticket;

select c.*,t.* from t_customer c  JOIN t_ticket t ON (c.customerId=t.ticketCId) where c.customerName ='小王';
