package com.sky.dao.searchScore;

import java.io.IOException;
import java.util.ArrayList;
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
import org.springframework.stereotype.Repository;

import com.sky.pojo.searchScore.ScoreSubjectTeachers;
import com.sky.util.HBaseUtil;

@Repository
public class ScoreSubjectTeachersDao  {
	
	
	private  HConnection hconnection = HBaseUtil.gethConnection();
	
	
//	public List<ScoreSubjectTeachers> call() throws Exception {
//		return queryAllTable();
//	}
	
	public  List<ScoreSubjectTeachers> queryAllTable(){
    	HTableInterface table =null;
    	List<ScoreSubjectTeachers> list = new ArrayList<ScoreSubjectTeachers>();
    	try{
    		table = hconnection.getTable("TBL_SCORE_SUBJECT_TEACHERS");
			Scan scan = new Scan();
			ResultScanner  resultScanner= table.getScanner(scan);
			
			for(Result rs :resultScanner){
				Map<String,String> map = new HashMap<String,String>();
				for(Cell cell:rs.rawCells()){		
					 map.put(new String(CellUtil.cloneQualifier(cell)), new String(CellUtil.cloneValue(cell)));
		    	}
				ScoreSubjectTeachers sst = new ScoreSubjectTeachers();
				sst.setSubject_id(map.get("subject_id".toUpperCase()));
				sst.setSubject_name(map.get("subject_name".toUpperCase()));
				sst.setExamType_id(map.get("examType_id".toUpperCase()));
				sst.setArea_id(map.get("examType_id".toUpperCase()));
				sst.setExam_date(map.get("exam_date".toUpperCase()));
				sst.setLogin_id(map.get("login_id".toUpperCase()));
				sst.setLogin_name(map.get("login_name".toUpperCase()));
				sst.setItem_id(map.get("item_id".toUpperCase()));
				list.add(sst);
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
	


}
