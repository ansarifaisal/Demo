--To Drop all object
Drop all objects;


CREATE TABLE EMPLOYEE(
id IDENTITY,
first_name varchar(50) NOT NULL,
last_name varchar(50) NOT NULL,
salary number(10,2) NOT NULL,
working boolean DEFAULT 'TRUE',
CONSTRAINT pk_employee_id PRIMARY KEY(id)
);

INSERT INTO EMPLOYEE(first_name,last_name,salary,working) values
('Faisal','Ansari',10000.00,true);

INSERT INTO EMPLOYEE(first_name,last_name,salary,working) values
('Khozema','Nullwala',15000.00);
