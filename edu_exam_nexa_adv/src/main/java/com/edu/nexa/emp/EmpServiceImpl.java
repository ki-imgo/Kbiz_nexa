package com.edu.nexa.emp;

import com.edu.nexa.boardmng.BoardDAO;
import com.edu.nexa.boardmng.BoardService;
import com.edu.nexa.boardmng.BoardServiceImpl;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service("empService")
@SuppressWarnings("unused")
public class EmpServiceImpl implements EmpService {
	
private static final Logger logger = LoggerFactory.getLogger(EmpServiceImpl.class);

	@Resource(name = "empDAO")
	private EmpDAO empDAO;

	public List<Map<String, Object>> selectEmpList(Map<String, Object> map) throws Exception { 
		return this.empDAO.selectEmpList(map);
	}

//	@Override
//	public void update(Map<String, Object> map) throws Exception {
//		this.boardDAO.Update(map);
//	}
	
}
