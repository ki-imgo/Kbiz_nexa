package com.edu.nexa.emp;

import java.util.List;
import java.util.Map;

public interface EmpService {
	List<Map<String, Object>> selectEmpList(Map<String, Object> map) throws Exception;
	
//	void update(Map<String, Object>map) throws Exception;
}
