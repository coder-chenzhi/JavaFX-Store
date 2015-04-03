CREATE DATABASE Store;
USE Store;

CREATE TABLE Students (
	studentID INT,
	realName TEXT NOT NULL,
	sex VARCHAR(255) NOT NULL,
	birthday VARCHAR(8),
	major TEXT NOT NULL,
	level TEXT,
	School TEXT,
	classGrade TEXT,
	hobby TEXT,
	instrument TEXT,
	parentsName TEXT,
	phone TEXT,
	address TEXT,
	enrollDay VARCHAR(8),
	classType TEXT,
	balance FLOAT NOT NULL,
	status BOOLEAN NOT NULL,
	other TEXT,
	PRIMARY KEY(studentID)
);


CREATE TABLE Teachers (
	teacherID INT,
	realName TEXT NOT NULL,
	sex VARCHAR(255) NOT NULL,
	birthday VARCHAR(8),
	major TEXT NOT NULL,
	level TEXT,
	education TEXT,
	school TEXT,
	identifyCard TEXT,
	phone TEXT,
	address TEXT,
	enrollDay VARCHAR(8) NOT NULL,
	status BOOLEAN NOT NULL,
	other TEXT,
	PRIMARY KEY(teacherID)
);

CREATE TABLE Rooms (
	roomID INT,
	name TEXT NOT NULL,
	volume INT NOT NULL,
	other TEXT,
	PRIMARY KEY(roomID)
);

CREATE TABLE Periods(
	periodID VARCHAR(255),
	startTime VARCHAR(4),
	endTime VARCHAR(4),
	PRIMARY KEY(periodID)
);

CREATE TABLE Courses (
	courseID INT,
	teacherID INT NOT NULL,
	startDate VARCHAR(8) NOT NULL,
	periodID VARCHAR(255) NOT NULL,
	roomID INT NOT NULL,
	weeks INT NOT NULL,
	type VARCHAR(255) NOT NULL,
	instrument VARCHAR(255) NOT NULL,
	expense FLOAT NOT NULL,
	volume INT NOT NULL,
	selected INT NOT NULL DEFAULT 0,
	other TEXT,
	PRIMARY KEY (courseID)
	/*
	FOREIGN KEY (teacherID) REFERENCES Teachers(teacherID),
	FOREIGN KEY (roomID) REFERENCES Rooms(roomID),
	FOREIGN KEY (periodID) REFERENCES Periods(periodID)
	*/
);

CREATE TABLE Classes(
	courseID INT,
	classID INT,
	teacherID INT,
	onDate VARCHAR(8),
	periodID VARCHAR(255),
	roomID INT,
	PRIMARY KEY (courseID, classID)
	/*
	FOREIGN KEY (courseID) REFERENCES Courses(courseID),
	FOREIGN KEY (teacherID) REFERENCES Teachers(teacherID),
	FOREIGN KEY (roomID) REFERENCES Rooms(roomID),
	FOREIGN KEY (periodID) REFERENCES Periods(periodID)
	*/
);

CREATE TABLE CourseRecords (
	courseID INT,
	classID INT,
	studentID INT,
	status TEXT NOT NULL,
	PRIMARY KEY (courseID, studentID)
	/*
	FOREIGN KEY (studentID) REFERENCES Students(studentID),
	FOREIGN KEY (courseID) REFERENCES Courses(courseID),
	FOREIGN KEY (classID) REFERENCES Classes(classID)
	*/
);

CREATE TABLE TeacherCheckIn (
	teacherID INT,
	checkDate VARCHAR(8),
	checkTime VARCHAR(6),
	type TEXT NOT NULL,
	PRIMARY KEY(teacherID,checkDate,checkTime)
	/*
	FOREIGN KEY (teacherID) REFERENCES Teachers(teacherID)
	*/
);

CREATE TABLE TeacherLeaveOut (
	teacherID INT,
	startDate VARCHAR(8),
	startTime VARCHAR(6),
	endDate VARCHAR(8),
	endTime VARCHAR(6),
	other TEXT,
	PRIMARY KEY(teacherID,StartDate,StartTime)
	/*
	FOREIGN KEY (teacherID) REFERENCES Teachers(teacherID)
	*/
);

CREATE TABLE StudentLeaveOut (
	studentID INT,
	startDate VARCHAR(8),
	startTime VARCHAR(6),
	endDate VARCHAR(8),
	endTime VARCHAR(6),
	other TEXT,
	PRIMARY KEY(studentID,startDate,startTime)
	/*
	FOREIGN KEY (studentID) REFERENCES Students(studentID)
	*/
);

CREATE TABLE Pass (
	id INT,
	type VARCHAR(16),
	password TEXT,
	PRIMARY KEY(id, type) 
);