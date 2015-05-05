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

import com.sky.pojo.searchScore.ScoreSubjectWyResult;
import com.sky.util.HBaseUtil;

@Repository
public class ScoreSubjectWyResultDao  {
	
	private  HConnection hconnection = HBaseUtil.gethConnection();
	
//	private String params;
//	public ScoreSubjectWyResultDao(String params){
//		this.params=params;
//	}
//	public List<ScoreSubjectWyResult> call() throws Exception {
//		return queryAllTable(params);
//	}
	public  List<ScoreSubjectWyResult> queryAllTable(String prefixStr,String studentId){
    	HTableInterface table =null;
    	List<ScoreSubjectWyResult> list = new ArrayList<ScoreSubjectWyResult>();
    	
    	try{
			table = hconnection.getTable("TBL_SCORE_SUBJECT_WYRESULT");
			
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
					ScoreSubjectWyResult sswyr = new ScoreSubjectWyResult();
					sswyr.setStudent_id(map.get("student_id".toUpperCase()));
					sswyr.setStudent_name(map.get("student_name".toUpperCase()));
					sswyr.setSubject_id(map.get("subject_id".toUpperCase()));
					sswyr.setSubject_name(map.get("subject_name".toUpperCase()));
					sswyr.setExamType_id(map.get("examType_id".toUpperCase()));
					sswyr.setArea_id(map.get("area_id".toUpperCase()));
					sswyr.setExam_date(map.get("exam_date".toUpperCase()));
					sswyr.setEncode_id(map.get("encode_id".toUpperCase()));
					sswyr.setItem_id(map.get("item_id".toUpperCase()));
					sswyr.setLogin_id1(map.get("login_id1".toUpperCase()));
					sswyr.setLogin_name1(map.get("login_name1".toUpperCase()));
					sswyr.setLogin_id2(map.get("login_id2".toUpperCase()));
					sswyr.setLogin_name2(map.get("login_name2".toUpperCase()));
					sswyr.setDtime(map.get("dtime".toUpperCase()));
					sswyr.setScore_type(map.get("score_type".toUpperCase()));
					sswyr.setScore(map.get("score".toUpperCase()));
					sswyr.setSub_score(map.get("sub_score".toUpperCase()));
					sswyr.setScore1(map.get("score1".toUpperCase()));
					sswyr.setSub_score1(map.get("sub_score1".toUpperCase()));
					sswyr.setScore2(map.get("score2".toUpperCase()));
					sswyr.setSub_score2(map.get("sub_score2".toUpperCase()));
					list.add(sswyr);
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
		long one =new Date().getTime();
		System.out.println(new ScoreSubjectWyResultDao().queryAllTable("gaokao_2014_11","0140000101"));
		long two =new Date().getTime();
		System.out.println(two-one);
	}
	
}
