package com.sky.pojo.searchScore;

import com.alibaba.fastjson.JSONObject;

public class ScoreStudentCode {
	
	private String student_id;
	private String student_name;
	private String subject_id;
	private String subject_name;
	private String idFor_subject;//考生的本科目编号
	private String idFor_firstChange;
	private String idFor_lastChange;
	private String OMR_str;
	private String OMR_score;
	private String OMR_scoreStr;
	private String absent_flag;
	private JSONObject zg_str;
	private String zg_score;
	private String examtype_id;
	private String area_id;
	private String exam_date;
	
	public String getStudent_id() {
		return student_id;
	}
	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}
	public String getSubject_id() {
		return subject_id;
	}
	public void setSubject_id(String subject_id) {
		this.subject_id = subject_id;
	}
	public String getSubject_name() {
		return subject_name;
	}
	public void setSubject_name(String subject_name) {
		this.subject_name = subject_name;
	}
	public String getIdFor_subject() {
		return idFor_subject;
	}
	public void setIdFor_subject(String idFor_subject) {
		this.idFor_subject = idFor_subject;
	}
	public String getIdFor_firstChange() {
		return idFor_firstChange;
	}
	public void setIdFor_firstChange(String idFor_firstChange) {
		this.idFor_firstChange = idFor_firstChange;
	}
	public String getIdFor_lastChange() {
		return idFor_lastChange;
	}
	public void setIdFor_lastChange(String idFor_lastChange) {
		this.idFor_lastChange = idFor_lastChange;
	}
	public String getOMR_str() {
		return OMR_str;
	}
	public void setOMR_str(String oMR_str) {
		OMR_str = oMR_str;
	}
	public String getOMR_score() {
		return OMR_score;
	}
	public void setOMR_score(String oMR_score) {
		OMR_score = oMR_score;
	}
	public String getStudent_name() {
		return student_name;
	}
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}
	public String getAbsent_flag() {
		return absent_flag;
	}
	public void setAbsent_flag(String absent_flag) {
		this.absent_flag = absent_flag;
	}
	
	public JSONObject getZg_str() {
		return zg_str;
	}
	public void setZg_str(JSONObject zg_str) {
		this.zg_str = zg_str;
	}
	public String getZg_score() {
		return zg_score;
	}
	public void setZg_score(String zg_score) {
		this.zg_score = zg_score;
	}
	public String getExamtype_id() {
		return examtype_id;
	}
	public void setExamtype_id(String examtype_id) {
		this.examtype_id = examtype_id;
	}
	public String getArea_id() {
		return area_id;
	}
	public void setArea_id(String area_id) {
		this.area_id = area_id;
	}
	public String getExam_date() {
		return exam_date;
	}
	public void setExam_date(String exam_date) {
		this.exam_date = exam_date;
	}
	public String getOMR_scoreStr() {
		return OMR_scoreStr;
	}
	public void setOMR_scoreStr(String oMR_scoreStr) {
		OMR_scoreStr = oMR_scoreStr;
	}
	@Override
	public String toString() {
		return "ScoreStudentCode [student_id=" + student_id + ", subject_id="
				+ subject_id + ", subject_name=" + subject_name
				+ ", idFor_subject=" + idFor_subject + ", idFor_firstChange="
				+ idFor_firstChange + ", idFor_lastChange=" + idFor_lastChange
				+ ", OMR_str=" + OMR_str + ", OMR_score=" + OMR_score
				+ ", student_name=" + student_name + ", absent_flag="
				+ absent_flag + ", zg_str=" + zg_str + ", zg_score=" + zg_score
				+ ", examtype_id=" + examtype_id + ", area_id=" + area_id
				+ ", exam_date=" + exam_date + ", OMR_scoreStr=" + OMR_scoreStr
				+ "] \n";
	}
	
	
	
	

}
