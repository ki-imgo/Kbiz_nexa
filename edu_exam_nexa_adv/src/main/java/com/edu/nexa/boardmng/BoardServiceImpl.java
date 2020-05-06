package com.edu.nexa.boardmng;

import com.edu.nexa.boardmng.BoardDAO;
import com.edu.nexa.boardmng.BoardService;
import com.edu.nexa.boardmng.BoardServiceImpl;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service("boardService")
@SuppressWarnings("unused")
public class BoardServiceImpl implements BoardService {
	
private static final Logger logger = LoggerFactory.getLogger(BoardServiceImpl.class);

	@Resource(name = "boardDAO")
	private BoardDAO boardDAO;

	public List<Map<String, Object>> selectBoardList(Map<String, Object> map) throws Exception { 
		return this.boardDAO.selectBoardList(map);
	}

	@Override
	public void update(Map<String, Object> map) throws Exception {
		this.boardDAO.Update(map);
	}
	
}
