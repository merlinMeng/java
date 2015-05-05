
CREATE DATABASE /*!32312 IF NOT EXISTS*/`edcenter` /*!40100 DEFAULT CHARACTER SET utf8 */;

/*Table structure for table `ed_user` */

DROP TABLE IF EXISTS `ed_user`;

CREATE TABLE `ed_user` (
  `UserId` varchar(10) NOT NULL COMMENT '用户编号',
  `UserName` varchar(50) NOT NULL,
  `Password` varchar(20) NOT NULL,
  `UserGroup` varchar(10) NOT NULL,
  `CreateDate` date NOT NULL,
  PRIMARY KEY (`UserId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

ALTER TABLE ed_user MODIFY userid INTEGER AUTO_INCREMENT ;  


DROP TABLE IF EXISTS `packagecurseinfo`;

CREATE TABLE `packagecurseinfo` (
  `PackageId` varchar(10) NOT NULL COMMENT '包id',
  `ExamName` varchar(100) NOT NULL COMMENT '考试名称',
  `CourseId` varchar(10) NOT NULL COMMENT '课程id',
  `CourseName` varchar(100) NOT NULL COMMENT '课程名字',
  `BMKFileName` varchar(255) NOT NULL COMMENT '报名文件名',
  `BMKMode` varchar(40) NOT NULL COMMENT '报名文件格式',
  `ScanFileName` varchar(255) NOT NULL COMMENT '扫描文件名',
  `ScanMode` varchar(40) NOT NULL COMMENT '扫描文件格式',
  `PjFileName` varchar(255) NOT NULL COMMENT '评卷文件名',
  `PjMode` varchar(40) NOT NULL COMMENT '评卷文件格式',
  `CjFileName` varchar(255) NOT NULL COMMENT '成绩文件名',
  `CjMode` varchar(40) NOT NULL COMMENT '成绩文件格式',
  `ScanImgDir` varchar(255) NOT NULL COMMENT '扫描图片路径',
  `WriteItemId` int(11) DEFAULT '-1' COMMENT '作为题目',
  `CardNum` int(11) DEFAULT '1' COMMENT '答题卡的数量',
  `FullScore` int(11) DEFAULT NULL COMMENT '满分',
  `KgMaxScore` decimal(6,0) DEFAULT NULL COMMENT '客观题分数'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `packageinfo`;

CREATE TABLE `packageinfo` (
  `PackageId` varchar(10) NOT NULL COMMENT '包id',
  `ExamName` varchar(100) NOT NULL COMMENT '考试名称',
  `ExamTypeID` varchar(10) NOT NULL COMMENT '考试类型id',
  `AreaId` varchar(10) NOT NULL COMMENT '地区id',
  `AreaName` varchar(100) NOT NULL COMMENT '地区名字',
  `ExamYear` char(4) NOT NULL COMMENT '考试年份',
  `ExamDate` date NOT NULL COMMENT '考试日期',
  `CourseNum` int(11) NOT NULL COMMENT '考试科目数',
  `RootDir` varchar(255) NOT NULL COMMENT '根路径',
  `CourseStr` varchar(255) NOT NULL COMMENT '考试科目',
  `Reg_Date` date NOT NULL COMMENT '注册日期',
  `State` char(10) NOT NULL COMMENT '状态',
  PRIMARY KEY (`PackageId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `user_tables` */

DROP TABLE IF EXISTS `user_tables`;

CREATE TABLE `user_tables` (
  `table_name` varchar(50) NOT NULL,
  `dir_name` varchar(100) DEFAULT NULL,
  `tbl_desc` varchar(255) DEFAULT NULL,
  `creator` varchar(50) DEFAULT NULL,
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`table_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


/*Table structure for table `user_tbl_cols` */

DROP TABLE IF EXISTS `user_tbl_cols`;

CREATE TABLE `user_tbl_cols` (
  `table_name` varchar(50) NOT NULL,
  `column_name` varchar(50) DEFAULT NULL,
  `col_description` varchar(500) DEFAULT NULL,
  `data_type` varchar(50) DEFAULT NULL,
  `data_lenght` varchar(50) DEFAULT NULL,
  `creator` varchar(50) DEFAULT NULL,
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



