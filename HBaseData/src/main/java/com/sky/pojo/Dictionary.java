package com.sky.pojo;

import java.io.Serializable;

public class Dictionary implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String examTypeID;
	private String areaId;
	private String areaName;
	private String examYear;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	@Override
	public String toString() {
		return "Dictionary [id=" + id + ", examTypeID=" + examTypeID
				+ ", areaId=" + areaId + ", areaName=" + areaName
				+ ", examYear=" + examYear + "] \n";
	}
	
	
	
	
}
