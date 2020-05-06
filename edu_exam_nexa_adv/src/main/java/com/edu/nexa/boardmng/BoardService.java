package com.edu.nexa.boardmng;

import java.util.List;
import java.util.Map;

public interface BoardService {
	List<Map<String, Object>> selectBoardList(Map<String, Object> map) throws Exception;
	
	void update(Map<String, Object>map) throws Exception;
}
