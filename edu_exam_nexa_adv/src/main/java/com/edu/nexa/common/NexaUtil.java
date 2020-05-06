package com.edu.nexa.common;

import com.nexacro17.xapi.data.DataSet;
import com.nexacro17.xapi.data.PlatformData;
import com.nexacro17.xapi.data.VariableList;
import com.nexacro17.xapi.tx.HttpPlatformRequest;
import com.nexacro17.xapi.tx.HttpPlatformResponse;
import com.nexacro17.xapi.tx.PlatformException;
import com.nexacro17.xapi.tx.PlatformType;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.nexa.common.CommandMap;


public class NexaUtil {

	public static CommandMap toCommandMap(HttpServletRequest req) throws Exception {	
		

		HttpPlatformRequest pReq = new HttpPlatformRequest(req);
		
		pReq.receiveData();
		
		PlatformData in_pData = pReq.getData();
		
		VariableList v_list = in_pData.getVariableList();		
		
		CommandMap commandMap = new CommandMap();
		
		ArrayList<Object> key = new ArrayList<Object>();
		ArrayList<Object> value = new ArrayList<Object>();
		
		for(int i = 0 ; i <  v_list.keyList().size() ; i++) {

			key.add(v_list.keyList().get(i));

			if(NullCheck.isEmpty(v_list.valueList().get(i))) {
				value.add(null);

			} else {
				value.add(v_list.valueList().get(i));
			
			}
			
		}
		
		for(int i = 0 ; i < key.size() ; i++) {
			
			if(!NullCheck.isEmpty(value.get(i))) { commandMap.put( key.get(i).toString(), value.get(i)); }
		}		
		
		return commandMap; 
		
	}
	
	public static DataSet toDataSet(List<Map<String, Object>> list, DataSet ds) {	
		
		for(int i = 0 ; i < list.size() ; i++) {
			int row = ds.newRow();
			String columnName = "";
			for(int j = 0 ; j < ds.getColumnCount() ; j++) {
				columnName = ds.getColumn(j).getName();
				ds.set(row, columnName, list.get(i).get(columnName));
			}
		}
		
		return ds;
		
	}

	public static void toSend(DataSet ds, HttpServletResponse resp) {	
		
		PlatformData pData = new PlatformData();
		pData.addDataSet(ds);
		HttpPlatformResponse pResp = new HttpPlatformResponse(resp, PlatformType.CONTENT_TYPE_XML);
		
		try {
			pResp.setData(pData);
			pResp.sendData();
			
		} catch (PlatformException e) {
		
			e.printStackTrace();
		}
		
		
	}

	
}
