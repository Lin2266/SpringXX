CREATE TABLE ACG_Character.employee
(
ID 			INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
FirstName	VARCHAR(30),
LastName	VARCHAR(30),
Birthdate   DATE,
Salary	 	FLOAT,
PRIMARY KEY (ID)
);