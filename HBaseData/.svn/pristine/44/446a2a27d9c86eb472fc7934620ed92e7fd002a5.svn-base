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

import com.alibaba.fastjson.JSON;
import com.sky.pojo.searchScore.ScoreStudentScanImage;
import com.sky.util.HBaseUtil;

@Repository
public class ScoreStudentScanImageDao {
	
	private  HConnection hconnection = HBaseUtil.gethConnection();
	
//	private String params;
//	public ScoreStudentScanImageDao(String params){
//		this.params=params;
//	}
//	public ScoreStudentScanImage call() throws Exception {
//		return queryAllTable(params);
//	}
	 
	public  List<ScoreStudentScanImage> queryAllTable(String prefixStr,String studentId){
    	HTableInterface table =null;
    	List<ScoreStudentScanImage> list = new ArrayList<ScoreStudentScanImage>();
    	try{
			table = hconnection.getTable("TBL_SCORE_STUDENT_SCANIMAGE");

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
				ScoreStudentScanImage sssi = new ScoreStudentScanImage();
				for(Cell cell:rs.rawCells()){		
					map.put(new String(CellUtil.cloneQualifier(cell)), new String(CellUtil.cloneValue(cell)));
			    }
				sssi.setStudent_id(map.get("student_id".toUpperCase()));
				sssi.setStudent_name(map.get("student_name".toUpperCase()));
				sssi.setSubject_id(map.get("subject_id".toUpperCase()));
				sssi.setSubject_name(map.get("subject_name".toUpperCase()));
				sssi.setExamType_id(map.get("examType_id".toUpperCase()));
				sssi.setArea_id(map.get("area_id".toUpperCase()));
				sssi.setExam_date(map.get("exam_date".toUpperCase()));
				sssi.setCard_index(map.get("card_index".toUpperCase()));
				sssi.setFacepic_path(map.get("facepic_path".toUpperCase()));
				sssi.setBackpic_path(map.get("backpic_path".toUpperCase()));
				list.add(sssi);
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
		System.out.println(new ScoreStudentScanImageDao().queryAllTable("gaokao_2014_11","0140000101"));
		//System.out.println(JSON.toJSON(new ScoreStudentScanImageDao().queryAllTable("gaokao_2014_11","0140000101")));
		long two =new Date().getTime();
		System.out.println(two-one);
	}
	
}
