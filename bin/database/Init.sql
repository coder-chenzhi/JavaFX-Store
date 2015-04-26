CREATE DATABASE Store;
USE Store;

CREATE TABLE Students (
	studentID INT, /* 学生ID */
	realName TEXT NOT NULL, /* 学生真实姓名，不为空 */
	sex VARCHAR(255) NOT NULL, /* 性别，不为空 */
	birthday VARCHAR(8), /* 生日，8位字符*/
	major TEXT NOT NULL, /* 专业，不为空 */
	level TEXT, /* 等级 */
	School TEXT, /* 学校 */
	classGrade TEXT, /* 班级 */
	hobby TEXT, /* 兴趣 */
	instrument TEXT, /* 乐器 */
	parentsName TEXT, /* 家长姓名 */
	phone TEXT, /* 手机 */
	address TEXT, /* 联系地址 */
	enrollDay VARCHAR(8), /* 入学日期 */
	classType TEXT, /* 课程类型 */
	balance FLOAT NOT NULL, /* 帐户余额 */
	status BOOLEAN NOT NULL, /* 状态（在校，离校） */
	other TEXT, /* 备注*/
	PRIMARY KEY(studentID) /* 主键，学生ID*/
);


CREATE TABLE Teachers (
	teacherID INT, /* 教师ID*/
	realName TEXT NOT NULL, /* 真实姓名 */
	sex VARCHAR(255) NOT NULL, /* 性别，不为空 */
	birthday VARCHAR(8), /* 生日，8位字符 */
	major TEXT NOT NULL, /* 专业 */
	level TEXT, /* 等级 */
	education TEXT, /* 学历 */
	school TEXT, /* 学校 */
	identifyCard TEXT, /* 身份证 */
	phone TEXT, /* 联系电话 */
	address TEXT, /* 联系地址 */
	enrollDay VARCHAR(8) NOT NULL, /* 入职日期 */
	status BOOLEAN NOT NULL, /* 状态（在校，离校）*/
	other TEXT, /* 备注 */
	PRIMARY KEY(teacherID) /* 主键，教师ID*/
);

CREATE TABLE Rooms (
	roomID INT, /* 教室ID */
	name TEXT NOT NULL, /* 教室名称，不为空 */
	volume INT NOT NULL, /* 教师容纳人数，不为空 */
	other TEXT, /* 备注 */
	PRIMARY KEY(roomID) /* 主键，教室ID */
);

CREATE TABLE Periods(
	periodID VARCHAR(255), /* 上课时段ID */
	startTime VARCHAR(4), /* 上课时段开始时间 */
	endTime VARCHAR(4), /* 上课时段结束时间 */
	PRIMARY KEY(periodID) /* 主键，上课时段ID */
);

CREATE TABLE Courses (
	courseID INT, /* 课程ID */
	teacherID INT NOT NULL, /* 教师ID */
	startDate VARCHAR(8) NOT NULL, /* 课程开始日期 */
	periodID VARCHAR(255) NOT NULL, /* 上课时段ID */
	roomID INT NOT NULL, /* 上课教室ID */
	weeks INT NOT NULL, /* 上课周数 */
	type VARCHAR(255) NOT NULL, /* 课程类型 */
	instrument VARCHAR(255) NOT NULL, /* 乐器 */
	expense FLOAT NOT NULL, /* 课程价格 */
	volume INT NOT NULL, /* 课程容纳人数 */
	selected INT NOT NULL DEFAULT 0, /* 已选人数 */
	other TEXT, /* 备注 */
	PRIMARY KEY (courseID) /* 主键，课程ID*/
	/*
	FOREIGN KEY (teacherID) REFERENCES Teachers(teacherID),
	FOREIGN KEY (roomID) REFERENCES Rooms(roomID),
	FOREIGN KEY (periodID) REFERENCES Periods(periodID)
	*/
);

CREATE TABLE Classes(
	courseID INT, /* 课程ID */
	classID INT, /* 课时ID */
	teacherID INT, /* 教师ID */
	onDate VARCHAR(8), /* 上课日期 */
	periodID VARCHAR(255), /* 上课时段ID */
	roomID INT, /* 上课教室ID */
	status VARCHAR(255), /* 课程状态，一共有三种状态，“课时未开始”，“教师请假”，“已上课” */
	PRIMARY KEY (courseID, classID) /* 主键，课程ID，课时ID*/
	/*
	FOREIGN KEY (courseID) REFERENCES Courses(courseID),
	FOREIGN KEY (teacherID) REFERENCES Teachers(teacherID),
	FOREIGN KEY (roomID) REFERENCES Rooms(roomID),
	FOREIGN KEY (periodID) REFERENCES Periods(periodID)
	*/
);

CREATE TABLE ClassRecords (
	courseID INT, /* 课程ID */
	classID INT, /* 课时ID */
	studentID INT, /* 学生ID */
	status TEXT NOT NULL, /* 一共有三种状态，“课时未开始”，“学生请假”，“已上课” */
	PRIMARY KEY (courseID, classID, studentID) /* 主键，课程ID，课时ID，学生ID*/
	/*
	FOREIGN KEY (studentID) REFERENCES Students(studentID),
	FOREIGN KEY (courseID) REFERENCES Courses(courseID),
	FOREIGN KEY (classID) REFERENCES Classes(classID)
	*/
);


CREATE TABLE TeacherCheckIn (
	teacherID INT, /* 教师ID */
	checkDate VARCHAR(8), /* 打卡日期 */
	checkTime VARCHAR(6), /* 打卡时间 */
	type TEXT NOT NULL, /* 类型，两种，上班或下班*/
	PRIMARY KEY(teacherID,checkDate,checkTime) /* 主键，教师ID，打卡日期，打卡时间 */
	/*
	FOREIGN KEY (teacherID) REFERENCES Teachers(teacherID)
	*/
);

CREATE TABLE TeacherLeaveOut (
	teacherID INT, /* 教师ID */
	startDate VARCHAR(8), /* 请假开始日期 */
	startTime VARCHAR(6), /* 请假开始时间 */
	endDate VARCHAR(8), /* 请假结束日期 */
	endTime VARCHAR(6), /* 请假结束时间 */
	other TEXT, /* 备注 */
	PRIMARY KEY(teacherID,StartDate,StartTime) /* 主键，教师ID，请假开始日期， 请假开始时间 */
	/*
	FOREIGN KEY (teacherID) REFERENCES Teachers(teacherID)
	*/
);

CREATE TABLE StudentLeaveOut (
	studentID INT, /* 学生ID */
	startDate VARCHAR(8), /* 请假开始日期 */
	startTime VARCHAR(6), /* 请假开始时间 */
	endDate VARCHAR(8), /* 请假结束日期 */
	endTime VARCHAR(6), /* 请假结束时间 */
	other TEXT, /* 备注 */
	PRIMARY KEY(studentID,startDate,startTime) /* 主键，学生ID，请假开始日期， 请假开始时间 */
	/*
	FOREIGN KEY (studentID) REFERENCES Students(studentID)
	*/
);

CREATE TABLE Pass (
	id INT, /* ID */
	type VARCHAR(255), /* 类型，包括教师和管理员 */
	password TEXT, /* 密码 */
	PRIMARY KEY(id, type)  /* 主键，ID和类型*/
);

CREATE TABLE Customers (
	customerID INT, /* 顾客ID */
	customerName VARCHAR(255) UNIQUE, /* 顾客姓名，全表唯一*/
	contactName Text, /* 联系人姓名*/
	contactAddress Text, /* 联系人地址*/
	contactPhone Text, /* 联系人电话*/
	other Text, /* 备注*/
	PRIMARY KEY (customerID) /* 主键，顾客ID*/
);

CREATE TABLE Suppliers (
	supplierID INT, /* 供应商ID */
	supplierName VARCHAR(255) UNIQUE, /* 供应商姓名，全表唯一*/
	contactName Text, /* 联系人姓名*/
	contactAddress Text, /* 联系人地址*/
	contactPhone Text, /* 联系人电话*/
	other Text, /* 备注*/
	PRIMARY KEY (supplierID) /* 主键，供应商ID*/
);

CREATE TABLE PurchaseOrders (
	orderID INT, /* 进货订单ID */
	goodID INT, /* 商品ID */
	supplierID INT, /* 供应商ID */
	amount INT, /* 数量 */
	price INT, /* 价格 */
	commitDate VARCHAR(8), /* 下单日期 */
	status Text, /* 状态 */
	PRIMARY KEY (orderID, goodID, supplierID) /* 主键，进货订单ID，商品ID，供应商ID*/
);

CREATE TABLE SellOrders (
	orderID INT, /* 销售订单ID */
	goodID INT, /* 商品ID */
	customerID INT, /* 顾客ID */
	amount INT, /* 数量 */
	price INT, /* 价格 */
	commitDate VARCHAR(8), /* 下单日期 */
	status Text, /* 状态 */
	PRIMARY KEY (orderID, goodID, customerID) /* 主键，销售订单ID，商品ID，顾客ID */
);


CREATE TABLE Goods (
	goodID INT, /* 商品ID */
	goodName VARCHAR(255) UNIQUE, /* 商品名称 */
	goodType Text, /* 乐器类型 */
	manufact Text, /* 生产厂商*/
	defalutPurchasePrice INT, /* 默认进价 */
	defalutSellPrice INT, /* 默认售价 */
	other Text, /* 备注 */
	PRIMARY KEY (goodID) /* 主键，商品ID */
);

CREATE TABLE Stocks (
	goodID INT, /* 库存商品ID */
	amount INT, /* 数量 */
	PRIMARY KEY (goodID) /* 主键，库存商品ID */
);