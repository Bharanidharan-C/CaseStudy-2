CREATE TABLE CUSTOMER (
	customer_id bigint NOT NULL,
	customer_name varchar(100),
	contact_number bigint NOT NULL,
	address varchar(100),
	gender varchar(8),
	PRIMARY KEY (customer_id)
);

INSERT INTO CUSTOMER VALUES (0, 'Anu', 1234567890, 'xxx','female');
INSERT INTO CUSTOMER VALUES (1, 'Akash', 1234567891, 'yyy','male');




CREATE TABLE VENDOR (
	vendor_id bigint NOT NULL,
	vendor_name varchar(50),
	vendor_contactno bigint,
	vendor_email varchar(50),
	vendor_username varchar(50),
	vendor_address varchar(50),
	PRIMARY KEY (vendor_id)
);



INSERT INTO VENDOR VALUES(0,'vendor1',1234512345,'xx@yy.com','vendor1','chennai');
INSERT INTO VENDOR VALUES(1,'vendor2',1234512345,'xx@yy.com','vendor2','chennai');

CREATE TABLE INVENTORY (
	sku_id bigint NOT NULL,
	product_name varchar(100),
	poduct_label varchar(100),
	inventory_onhand int,
	reqminqty int,
	price double,
	PRIMARY KEY (sku_id)
);

INSERT INTO INVENTORY VALUES(0,'REDMI NOTE','REDMI NOTE4',10,2,10000.00);
INSERT INTO INVENTORY VALUES(1,'MI A1','MI ANDROID ONE',10,2,14000.00);

