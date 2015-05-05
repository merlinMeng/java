package com.sky.pojo;

import java.io.Serializable;
import java.util.Date;

public class JobInfo implements Serializable {
	private int jobId ;
	private String jobDes;
	private int packageId;
	private String jobType;
	private String status;
	
	public int getJobId() {
		return jobId;
	}
	public void setJobId(int jobId) {
		this.jobId = jobId;
	}
	public String getJobDes() {
		return jobDes;
	}
	public void setJobDes(String jobDes) {
		this.jobDes = jobDes;
	}
	public int getPackageId() {
		return packageId;
	}
	public void setPackageId(int packageId) {
		this.packageId = packageId;
	}
	
	public String getJobType() {
		return jobType;
	}
	public void setJobType(String jobType) {
		this.jobType = jobType;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "JobInfo [jobId=" + jobId + ", jobDes=" + jobDes
				+ ", packageId=" + packageId + ", jobType=" + jobType
				+ ", status=" + status + "] \n";
	}
	
	
}
