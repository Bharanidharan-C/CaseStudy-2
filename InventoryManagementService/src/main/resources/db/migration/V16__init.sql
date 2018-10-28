
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

