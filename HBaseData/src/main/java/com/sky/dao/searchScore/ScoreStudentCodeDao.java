package com.sky.dao.searchScore;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.CellUtil;
import org.apache.hadoop.hbase.client.Get;
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
import org.codehaus.jackson.JsonEncoding;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Repository;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sky.pojo.searchScore.ScoreStudentCode;
import com.sky.util.HBaseUtil;



@Repository
public class ScoreStudentCodeDao {
	
	private  HConnection hconnection = HBaseUtil.gethConnection();
	
	//private String params;
//	public ScoreStudentCodeDao(String params){
//		this.params=params;
//	}
//	public ScoreStudentCode call() throws Exception {
//		return queryAllTable(params);
//	}
	public  List<ScoreStudentCode> queryAllTable(String prefixStr,String studentId){
    	HTableInterface table =null;
    	List<ScoreStudentCode> list = new ArrayList<ScoreStudentCode>();
    	try{
			table = hconnection.getTable("TBL_SCORE_STUDENT_CODE");
			
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
				ScoreStudentCode ssc = new ScoreStudentCode();
				Map<String,String> map = new HashMap<String,String>();
				for(Cell cell:rs.rawCells()){		
					map.put(new String(CellUtil.cloneQualifier(cell)), new String(CellUtil.cloneValue(cell)));
			    }
				ssc.setStudent_id(map.get("student_id".toUpperCase()));
				ssc.setStudent_name(map.get("student_name".toUpperCase()));
				ssc.setSubject_id(map.get("subject_id".toUpperCase()));
				ssc.setSubject_name(map.get("subject_name".toUpperCase()));
				ssc.setIdFor_subject(map.get("idFor_subject".toUpperCase()));
				ssc.setIdFor_firstChange(map.get("idFor_firstChange".toUpperCase()));
				ssc.setIdFor_lastChange(map.get("idFor_lastChange".toUpperCase()));
				ssc.setOMR_str(map.get("oMR_str".toUpperCase()));
				ssc.setOMR_score(map.get("oMR_score".toUpperCase()));
				ssc.setOMR_scoreStr(map.get("oMR_scoreStr".toUpperCase()));
				ssc.setAbsent_flag(map.get("absent_flag".toUpperCase()));
				ssc.setZg_score(map.get("zg_score".toUpperCase()));
				ssc.setZg_str(JSON.parseObject(map.get("zg_str".toUpperCase()).toString()));
				ssc.setExamtype_id(map.get("examtype_id".toUpperCase()));
				ssc.setExam_date(map.get("exam_date".toUpperCase()));
				ssc.setArea_id(map.get("area_id".toUpperCase()));
				list.add(ssc);
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
	
	
	
	public  List<ScoreStudentCode> querysingle(String params){
    	HTableInterface table =null;
    	List<ScoreStudentCode> list = new ArrayList<ScoreStudentCode>();
    	try{
			table = hconnection.getTable("TBL_SCORE_STUDENT_CODE");
			Get get = new Get(Bytes.toBytes(params));
		
			Result rs = table.get(get);
			
			
				ScoreStudentCode ssc = new ScoreStudentCode();
				Map<String,String> map = new HashMap<String,String>();
				for(Cell cell:rs.rawCells()){		
					map.put(new String(CellUtil.cloneQualifier(cell)), new String(CellUtil.cloneValue(cell)));
			    }
				ssc.setStudent_id(map.get("student_id".toUpperCase()));
				ssc.setStudent_name(map.get("student_name".toUpperCase()));
				ssc.setSubject_id(map.get("subject_id".toUpperCase()));
				ssc.setSubject_name(map.get("subject_name".toUpperCase()));
				ssc.setIdFor_subject(map.get("idFor_subject".toUpperCase()));
				ssc.setIdFor_firstChange(map.get("idFor_firstChange".toUpperCase()));
				ssc.setIdFor_lastChange(map.get("idFor_lastChange".toUpperCase()));
				ssc.setOMR_str(map.get("oMR_str".toUpperCase()));
				ssc.setOMR_score(map.get("oMR_score".toUpperCase()));
				ssc.setOMR_scoreStr(map.get("oMR_scoreStr".toUpperCase()));
				ssc.setAbsent_flag(map.get("absent_flag".toUpperCase()));
				ssc.setZg_score(map.get("zg_score".toUpperCase()));
				ssc.setZg_str(JSON.parseObject(map.get("zg_str".toUpperCase()).toString()));
				ssc.setExamtype_id(map.get("examtype_id".toUpperCase()));
				ssc.setExam_date(map.get("exam_date".toUpperCase()));
				ssc.setArea_id(map.get("area_id".toUpperCase()));
				list.add(ssc);
		}catch(Exception e){
    		e.printStackTrace();
    	}finally{
    		try {
				table.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
    	}
    	return list;
    }
	
//	public static void main(String[] args) throws Exception {
//		long one =new Date().getTime();
//		//System.out.println(new ScoreStudentCodeDao().queryAllTable("gaokao_2014_11", "0140000101"));
//		List<ScoreStudentCode>  list= new ScoreStudentCodeDao().querysingle("gaokao_2014_11_liz_0140000101");
//		System.out.println(list);
//		//System.out.println(JSON.toJSON(list));
//		//ObjectMapper objectMapper = new ObjectMapper();
//		 //JsonGenerator jsonGenerator =objectMapper.getJsonFactory().createJsonGenerator(System.out, JsonEncoding.UTF8);
//	//	 System.out.println("jackson:--------");
////		 jsonGenerator.writeObject(list);
////		 System.out.println();
////		 System.out.println("fastjson:---"+JSON.toJSON(list));
////		 System.out.println("json-lib:--"+JSONArray.fromObject(list));
//		// Object ob = JSON.toJSON(list);
//	
//		//System.out.println(JSON.parse(ob.toString()));
//		// two =new Date().getTime();
//		//System.out.println(two-one);
//	}
	
}
