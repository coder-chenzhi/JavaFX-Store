CREATE DATABASE store;
USE store;

CREATE TABLE student (
	studentID Int AUTO_INCREMENT,
	realName Text NOT NULL,
	sex Char,
	birthday Varchar(8),
	major Text NOT NULL,
	level Text,
	School Text,
	classGrade Text,
	hobby Text,
	instrument Text,
	parentsName Text,
	phone Text,
	address Text,
	enrollDay Varchar(8),
	classType Text,
	balance FLOAT,
	status Boolean,
	other Text,
	Primary Key(StudentID)
);


CREATE TABLE teacher (
	teacherID Int AUTO_INCREMENT,
	realName Text NOT NULL,
	sex Char,
	birthday Varchar(8),
	major Text NOT NULL,
	level Text,
	education Text,
	school Text,
	identifyCard Text,
	phone Text,
	address Text,
	enrollDay Varchar(8),
	status Boolean,
	other Text,
	Primary Key(TeacherID)
);

CREATE TABLE course (
	courseID Int AUTO_INCREMENT,
	teacherID Int NOT NULL,
	launchDate Varchar(8),
	launchTime Varchar(6),
	length Float,
	type Text,
	instrument Text,
	roomID Int NOT NULL,
	expense Float,
	volume Int,
	other Text,
	Primary Key(CourseID)
);

CREATE TABLE room (
	roomID Int AUTO_INCREMENT,
	name Text,
	volume Int,
	other Text,
	Primary Key(RoomID)
);

CREATE TABLE courseRecord (
	courseID Int NOT NULL,
	studentID Int NOT NULL,
	status Text,
	Primary Key(CourseID, StudentID)
);

CREATE TABLE teacherCheckIn (
	teacherID Int,
	checkDate Varchar(8),
	checkTime Varchar(6),
	type Text,
	Primary Key(TeacherID,checkDate,checkTime)
);

CREATE TABLE teacherLeaveOut (
	teacherID Int,
	startDate Varchar(8),
	startTime Varchar(6),
	endDate Varchar(8),
	endTime Varchar(6),
	other Text,
	Primary Key(TeacherID,StartDate,StartTime)
);

CREATE TABLE studentLeaveOut (
	studentID Int,
	startDate Varchar(8),
	startTime Varchar(6),
	endDate Varchar(8),
	endTime Varchar(6),
	other Text,
	Primary Key(StudentID,StartDate,StartTime)
);

CREATE TABLE pass (
	id Int,
	type Varchar(16),
	password Text,
	Primary Key(id, type) 
);