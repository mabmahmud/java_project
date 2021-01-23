                  ****Databse in Java******** 
				  
				  
 
Database 
Refactor the application  (FROM ASSIGNMENT 1) to use a Mysql database instead of the file to store the information.
Database naming standards should be followed.
Reflection details should be added to a table and loaded from the table to be used in the application.  
Each learner should create the database table and include the sql in the submission (createDatabase.sql file).
When the program starts, the OjtReflection details which are loaded in the database must be loaded (as was done from the file in assignment #1).
The database and table are specified below.  This structure must be used in your program.
Additional Notes
Naming standards for database tables and columns should be followed.
The sql should completely setup the database so that after the sql is run the application will work.  
The username/password that I will be using for testing local is root with no password.  
This should be set in the configuration file so that the application will run without modification when tested.
DATABASE to be used!
Note that a primary key has been added to the table in the script below. 
There may be some minor modifications needed from your assignment#2 but the database script here is to be used for assignment #3.
--
-- Database: `ojt`
--

drop database ojt;

create database ojt;

use ojt;

CREATE TABLE IF NOT EXISTS OjtReflection ( 

id int(5) NOT NULL PRIMARY KEY AUTO_INCREMENT, 

studentId int(5) NOT NULL, 

studentName varchar(20) NOT NULL, 

reflection varchar(140) NOT NULL )