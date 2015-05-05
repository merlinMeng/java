package com.sky.pojo;

import java.io.Serializable;
import java.util.Date;

public class PackageInfo implements Serializable {
	private int packageId;
	private String examName;
	private String examTypeID;
	private String areaId;
	private String areaName;
	private String examYear;
	private Date examDate;
	private int courseNum;
	private String rootDir;
	private String courseStr;
	private Date reg_Date;
	private String state;
	private String imageUploadStatus;
	public int getPackageId() {
		return packageId;
	}
	public void setPackageId(int packageId) {
		this.packageId = packageId;
	}
	public String getExamName() {
		return examName;
	}
	public void setExamName(String examName) {
		this.examName = examName;
	}
	
	
	public String getExamTypeID() {
		return examTypeID;
	}
	public void setExamTypeID(String examTypeID) {
		this.examTypeID = examTypeID;
	}
	public String getAreaId() {
		return areaId;
	}
	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public String getExamYear() {
		return examYear;
	}
	public void setExamYear(String examYear) {
		this.examYear = examYear;
	}
	public Date getExamDate() {
		return examDate;
	}
	public void setExamDate(Date examDate) {
		this.examDate = examDate;
	}
	
	public int getCourseNum() {
		return courseNum;
	}
	public void setCourseNum(int courseNum) {
		this.courseNum = courseNum;
	}
	public String getRootDir() {
		return rootDir;
	}
	public void setRootDir(String rootDir) {
		this.rootDir = rootDir;
	}
	public String getCourseStr() {
		return courseStr;
	}
	public void setCourseStr(String courseStr) {
		this.courseStr = courseStr;
	}
	public Date getReg_Date() {
		return reg_Date;
	}
	public void setReg_Date(Date reg_Date) {
		this.reg_Date = reg_Date;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	public String getImageUploadStatus() {
		return imageUploadStatus;
	}
	public void setImageUploadStatus(String imageUploadStatus) {
		this.imageUploadStatus = imageUploadStatus;
	}
	@Override
	public String toString() {
		return "PackageInfo [packageId=" + packageId + ", examName=" + examName
				+ ", examTypeID=" + examTypeID + ", areaId=" + areaId
				+ ", areaName=" + areaName + ", examYear=" + examYear
				+ ", examDate=" + examDate + ", courseNum=" + courseNum
				+ ", rootDir=" + rootDir + ", courseStr=" + courseStr
				+ ", reg_Date=" + reg_Date + ", state=" + state
				+ ", imageUploadStatus=" + imageUploadStatus + "] \n";
	}
	
	
	
	
	
	
}
