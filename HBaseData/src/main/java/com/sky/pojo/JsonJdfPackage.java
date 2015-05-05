package com.sky.pojo;

import java.io.Serializable;
import java.util.Arrays;

public class JsonJdfPackage implements Serializable {
	private String parent_dir;
	private String district_code;
	private String project_manager;
	private String AreaId;
	private String ks_bh;
	private String file_num;
	private String package_bh;
	private String directory_num;
	private String byte_num;
	private String CourseStr;
	private String CourseNum;
	private String district;
	private String submit_person;
	private String city_code;
	private String city;
	private String ExamYear;
	private String ExamName;
	private String kstype;
	private String AreaName;
	private String ExamTypeID;
	private JsonJdfCourse[] km;
	public String getParent_dir() {
		return parent_dir;
	}
	public void setParent_dir(String parent_dir) {
		this.parent_dir = parent_dir;
	}
	public String getDistrict_code() {
		return district_code;
	}
	public void setDistrict_code(String district_code) {
		this.district_code = district_code;
	}
	public String getProject_manager() {
		return project_manager;
	}
	public void setProject_manager(String project_manager) {
		this.project_manager = project_manager;
	}
	public String getAreaId() {
		return AreaId;
	}
	public void setAreaId(String areaId) {
		AreaId = areaId;
	}
	public String getKs_bh() {
		return ks_bh;
	}
	public void setKs_bh(String ks_bh) {
		this.ks_bh = ks_bh;
	}
	public String getFile_num() {
		return file_num;
	}
	public void setFile_num(String file_num) {
		this.file_num = file_num;
	}
	public String getPackage_bh() {
		return package_bh;
	}
	public void setPackage_bh(String package_bh) {
		this.package_bh = package_bh;
	}
	public String getDirectory_num() {
		return directory_num;
	}
	public void setDirectory_num(String directory_num) {
		this.directory_num = directory_num;
	}
	public String getByte_num() {
		return byte_num;
	}
	public void setByte_num(String byte_num) {
		this.byte_num = byte_num;
	}
	public String getCourseStr() {
		return CourseStr;
	}
	public void setCourseStr(String courseStr) {
		CourseStr = courseStr;
	}
	public String getCourseNum() {
		return CourseNum;
	}
	public void setCourseNum(String courseNum) {
		CourseNum = courseNum;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getSubmit_person() {
		return submit_person;
	}
	public void setSubmit_person(String submit_person) {
		this.submit_person = submit_person;
	}
	public String getCity_code() {
		return city_code;
	}
	public void setCity_code(String city_code) {
		this.city_code = city_code;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getExamYear() {
		return ExamYear;
	}
	public void setExamYear(String examYear) {
		ExamYear = examYear;
	}
	public String getExamName() {
		return ExamName;
	}
	public void setExamName(String examName) {
		ExamName = examName;
	}
	public String getKstype() {
		return kstype;
	}
	public void setKstype(String kstype) {
		this.kstype = kstype;
	}
	public String getAreaName() {
		return AreaName;
	}
	public void setAreaName(String areaName) {
		AreaName = areaName;
	}
	public String getExamTypeID() {
		return ExamTypeID;
	}
	public void setExamTypeID(String examTypeID) {
		ExamTypeID = examTypeID;
	}
	public JsonJdfCourse[] getKm() {
		return km;
	}
	public void setKm(JsonJdfCourse[] km) {
		this.km = km;
	}
	@Override
	public String toString() {
		return "JsonJdfPackage [parent_dir=" + parent_dir + ", district_code="
				+ district_code + ", project_manager=" + project_manager
				+ ", AreaId=" + AreaId + ", ks_bh=" + ks_bh + ", file_num="
				+ file_num + ", package_bh=" + package_bh + ", directory_num="
				+ directory_num + ", byte_num=" + byte_num + ", CourseStr="
				+ CourseStr + ", CourseNum=" + CourseNum + ", district="
				+ district + ", submit_person=" + submit_person
				+ ", city_code=" + city_code + ", city=" + city + ", ExamYear="
				+ ExamYear + ", ExamName=" + ExamName + ", kstype=" + kstype
				+ ", AreaName=" + AreaName + ", ExamTypeID=" + ExamTypeID
				+ ", km=" + Arrays.toString(km) + "]";
	}
	
	
	
	
	
	
	
	
	
	
	

}
