package com.edu.nexa.boardmng;

import com.edu.nexa.common.AbstractDAO;
import com.edu.nexa.boardmng.BoardDAO;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;


@Repository("boardDAO")
@SuppressWarnings("unchecked")
public class BoardDAO extends AbstractDAO {

	public List<Map<String, Object>> selectBoardList(Map<String, Object> map) throws Exception { 
		return selectList("boardMng.selectListBoard", map);
	}
	
	public void Update(Map<String, Object> map) throws Exception{
		update("boardMng.updateBoard", map);
	}
	
	
}
