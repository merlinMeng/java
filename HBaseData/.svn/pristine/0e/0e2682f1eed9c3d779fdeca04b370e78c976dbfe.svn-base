package com.sky.dao.searchScore;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.CellUtil;
import org.apache.hadoop.hbase.client.HConnection;
import org.apache.hadoop.hbase.client.HTableInterface;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.filter.CompareFilter;
import org.apache.hadoop.hbase.filter.Filter;
import org.apache.hadoop.hbase.filter.FilterList;
import org.apache.hadoop.hbase.filter.PrefixFilter;
import org.apache.hadoop.hbase.filter.RowFilter;
import org.apache.hadoop.hbase.filter.SubstringComparator;
import org.apache.hadoop.hbase.util.Bytes;
import org.springframework.stereotype.Repository;

import com.sky.pojo.searchScore.ScoreSubjectItemLog;
import com.sky.util.HBaseUtil;

@Repository
public class ScoreSubjectItemLogDao  {
	
	private  HConnection hconnection = HBaseUtil.gethConnection();
	
//	private String params;
//	public ScoreSubjectItemLogDao(String params){
//		this.params=params;
//	}
//	public List<ScoreSubjectItemLog> call() throws Exception {
//		return queryAllTable(params);
//	}
	public  List<ScoreSubjectItemLog> queryAllTable(String prefixStr,String studentId){
    	HTableInterface table =null;
    	List<ScoreSubjectItemLog> list = new ArrayList<ScoreSubjectItemLog>();
    	
    	try{
			table = hconnection.getTable("TBL_SCORE_SUBJECT_ITEMLOG");
			
			
			List<Filter> filters = new ArrayList<Filter>();
			Filter prefixFilter =new PrefixFilter(Bytes.toBytes(prefixStr));
			Filter rowFilter =new RowFilter(CompareFilter.CompareOp.EQUAL,new SubstringComparator(studentId));
			filters.add(prefixFilter);
			filters.add(rowFilter);
			FilterList filterlist = new FilterList(filters);
			
			Scan scan = new Scan();
			scan.setFilter(filterlist);
			ResultScanner resultScanner = table.getScanner(scan);
			for(Result rs :resultScanner){
				 	Map<String,String> map = new HashMap<String,String>();
					for(Cell cell:rs.rawCells()){		
						map.put(new String(CellUtil.cloneQualifier(cell)), new String(CellUtil.cloneValue(cell)));
				    }
					ScoreSubjectItemLog ssil = new ScoreSubjectItemLog();
					ssil.setStudent_id(map.get("student_id".toUpperCase()));
					ssil.setStudent_name(map.get("student_name".toUpperCase()));
					ssil.setSubject_id(map.get("subject_id".toUpperCase()));
					ssil.setSubject_name(map.get("subject_name".toUpperCase()));
					ssil.setExamType_id(map.get("examType_id".toUpperCase()));
					ssil.setArea_id(map.get("area_id".toUpperCase()));
					ssil.setExam_date(map.get("exam_date".toUpperCase()));
					ssil.setPj_type(map.get("pj_type".toUpperCase()));
					ssil.setLogin_id(map.get("login_id".toUpperCase()));
					ssil.setLogin_name(map.get("login_name".toUpperCase()));
					ssil.setEncode_id(map.get("encode_id".toUpperCase()));
					ssil.setItem_id(map.get("item_id".toUpperCase()));
					ssil.setTask_type(map.get("task_type".toUpperCase()));
					ssil.setJudge_n(map.get("judge_n".toUpperCase()));
					ssil.setScore(map.get("score".toUpperCase()));
					ssil.setDoubt_flag(map.get("doubt_flag".toUpperCase()));
					ssil.setSubmit_time(map.get("submit_time".toUpperCase()));
					ssil.setUsed_time(map.get("used_time".toUpperCase()));
					ssil.setSub_score(map.get("sub_score".toUpperCase()));
					list.add(ssil);
			}
    	}catch(Exception e){
    		e.printStackTrace();
    	}finally{
    		try {
				table.close();
				//hconnection.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
    	}
    	return list;
    }
	public static void main(String[] args) throws Exception {
		//System.out.println(new ScoreSubjectItemLogDao("gaokao_2014_11_liz_0140000101").call());
		long one =new Date().getTime();
		
		System.out.println(new ScoreSubjectItemLogDao().queryAllTable("gaokao_2014_11","0140000101"));
		long two =new Date().getTime();
		System.out.println(two-one);
	}
	
}
