SELECT * FROM (SELECT * FROM "bank-service".users) as E;

SELECT u.id, u.name, u.age FROM "bank-service".users u;

INSERT INTO "bank-service".users VALUES (1, 'user1', 19);

INSERT INTO "bank-service".users (id, name) VALUES (id, 'user1');

INSERT INTO "bank-service".users (id, age) VALUES (3, 25);

INSERT INTO "bank-service".users VALUES (4, 'user4', 27);
INSERT INTO "bank-service".users VALUES (5, 'user5', 30);
INSERT INTO "bank-service".users VALUES (6, 'user6', 45);

UPDATE "bank-service".users 
SET name = 'new-user'
WHERE age >= 30;

DELETE FROM "bank-service".users
WHERE age < 30 OR age IS NULL;


INSERT INTO "bank-service".card (card_number, user_id, amount) VALUES (123412345, 1, 100);

SELECT * FROM "bank-service".card;

DELETE FROM "bank-service".card
WHERE card_number = 12341234;

explain select * from "bank-service".users;

INSERT INTO "bank-service".students (first_name, last_name,birth_day,gender) 
			VALUES('David','Williams','1999-08-01','male');
INSERT INTO "bank-service".students (first_name, last_name,birth_day,gender) 
			VALUES('Dan','Ion','2001-08-01','male');	
INSERT INTO "bank-service".students (first_name, last_name,birth_day,gender) 
			VALUES('Popa','Elena','2004-08-01','female');			
INSERT INTO "bank-service".students (first_name, last_name,birth_day,gender) 
			VALUES('Bogdan','Anton','2004-08-01','female');	
INSERT INTO "bank-service".students (first_name, last_name,birth_day,gender) 
			VALUES('Ionut','Sferle','2004-08-01','female');	
		
select * from "bank-service".students;

select * from "bank-service".students
where lower(gender) = 'female'

'FEMALE' -> 'female'

INSERT INTO "bank-service".students (first_name, last_name,birth_day,gender) 
			VALUES('John','Doe','2001-08-01','male');	
			
			
select count(first_name) from "bank-service".students

select distinct first_name from "bank-service".students

select first_name, concat('gender: ', gender) as something from "bank-service".students;

INSERT INTO "bank-service".employee (name, dept_id) 
	VALUES('Ionut', 2);	
	
INSERT INTO "bank-service".employee (name, dept_id) 
	VALUES('George', 1);	
	
INSERT INTO "bank-service".department (name, location) 
	VALUES('IT', 'Timisoara');	
	
INSERT INTO "bank-service".department (name, location) 
	VALUES('Accounting', 'Iasi');	
	
select * from "bank-service".employee

select * from "bank-service".department

// inner join
select * from "bank-service".employee e
inner join "bank-service".department d on e.dept_id = d.id

// right join
select * from "bank-service".employee e
right join "bank-service".department d on e.dept_id = d.id

// left join
select * from "bank-service".employee e
left join "bank-service".department d on e.dept_id = d.id

// right outer join
select * from "bank-service".employee e
right join "bank-service".department d on e.dept_id = d.id
where e.dept_id is null



		



