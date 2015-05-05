package com.sky.pojo;

import java.io.Serializable;

public class PackageDic implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private String examTypeID;
	private String areaId;
	private String examYear;
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
	public String getExamYear() {
		return examYear;
	}
	public void setExamYear(String examYear) {
		this.examYear = examYear;
	}
	@Override
	public String toString() {
		return "PackageDic [examTypeID=" + examTypeID + ", areaId=" + areaId
				+ ", examYear=" + examYear + "]";
	}
	
	
	
	
	
}
