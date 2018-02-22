CREATE TABLE customer(
   id INT NOT NULL AUTO_INCREMENT,
   first_name VARCHAR(20) NOT NULL,
   last_name VARCHAR(20) NOT NULL,
   age INT NOT NULL,
   PRIMARY KEY (id)
);

INSERT INTO testdb.customer (first_name, last_name, age) VALUES ("Peter", "Smith", 20);
INSERT INTO testdb.customer (first_name, last_name, age) VALUES ("Mary", "Taylor", 25);
INSERT INTO testdb.customer (first_name, last_name, age) VALUES ("Lauren", "Taylor", 30);
INSERT INTO testdb.customer (first_name, last_name, age) VALUES ("Peter", "Johnson ", 22);
INSERT INTO testdb.customer (first_name, last_name, age) VALUES ("Mary", "Harris  ", 27);


CREATE TABLE backup_customer(
   id INT NOT NULL AUTO_INCREMENT,
   first_name VARCHAR(20) NOT NULL,
   last_name VARCHAR(20) NOT NULL,
   age INT NOT NULL,
   PRIMARY KEY (id)
);

INSERT INTO testdb.backup_customer (first_name, last_name, age) VALUES ("John", "Scott", 18);
INSERT INTO testdb.backup_customer (first_name, last_name, age) VALUES ("Richard", "Taylor", 15);
INSERT INTO testdb.backup_customer (first_name, last_name, age) VALUES ("Joseph", "Taylor", 35);
INSERT INTO testdb.backup_customer (first_name, last_name, age) VALUES ("Peter", "Murphy", 77);
INSERT INTO testdb.backup_customer (first_name, last_name, age) VALUES ("Donald", "Harris  ", 37);