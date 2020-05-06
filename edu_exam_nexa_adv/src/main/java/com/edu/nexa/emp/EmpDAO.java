package com.edu.nexa.emp;

import com.edu.nexa.common.AbstractDAO;
import com.edu.nexa.boardmng.BoardDAO;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;


@Repository("empDAO")
@SuppressWarnings("unchecked")
public class EmpDAO extends AbstractDAO {

	public List<Map<String, Object>> selectEmpList(Map<String, Object> map) throws Exception { 
		return selectList("empMng.selectEmpList", map);
	}
	
//	public void Update(Map<String, Object> map) throws Exception{
//		update("boardMng.updateBoard", map);
//	}
	
	
}
