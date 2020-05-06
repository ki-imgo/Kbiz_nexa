package com.edu.nexa.common;

import com.edu.nexa.common.JsonUtil;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("unused")
public class JsonUtil {
	
	private static final Logger logger = (Logger)LoggerFactory.getLogger(JsonUtil.class);

  public static JSONObject getJsonStringFromMap(Map<String, Object> map) {
    JSONObject jsonObject = new JSONObject();
    for (Map.Entry<String, Object> entry : map.entrySet()) {
      String key = (String)entry.getKey();
      Object value = entry.getValue();

      if ("RECID".equals(key)) key = "recid";
//      logger.debug("key ==> " + key + "\t value ==> " + value);
      
      jsonObject.put(key, value);

    } 
    
    return jsonObject;
  }
  
  public static JSONArray getJsonArrayFromList(List<Map<String, Object>> list) {
    JSONArray jsonArray = new JSONArray();
    for (Map<String, Object> map : list) {
      jsonArray.add(getJsonStringFromMap(map));
    }
    
    return jsonArray;
  }
  
  public static String getJsonStringFromList(List<Map<String, Object>> list) {
    JSONArray jsonArray = getJsonArrayFromList(list);
    return jsonArray.toJSONString();
  }
  
  @SuppressWarnings({ "unchecked", "rawtypes" })
  public static Map<String, Object> getMapFromJsonObject(JSONObject jsonObj) {
    Map<String, Object> map = null;

    try {
      map = (Map)(new ObjectMapper()).readValue(jsonObj.toJSONString(), Map.class);
    }
    catch (JsonParseException e) {
      e.printStackTrace();
    } catch (JsonMappingException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } 
    
    return map;
  }

  public static List<Map<String, Object>> getListMapFromJsonArray(JSONArray jsonArray) {
    List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
    
    if (jsonArray != null) {
      int jsonSize = jsonArray.size();
      for (int i = 0; i < jsonSize; i++) {
        Map<String, Object> map = getMapFromJsonObject((JSONObject)jsonArray.get(i));
        list.add(map);
      } 
    } 
    
    return list;
  }
}
