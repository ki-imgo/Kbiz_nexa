package com.edu.nexa.boardmng;

import com.edu.nexa.common.CommandMap;
import com.edu.nexa.common.NexaUtil;
import com.edu.nexa.common.NullCheck;
import com.nexacro17.xapi.data.DataSet;
import com.nexacro17.xapi.data.DataTypes;
import com.nexacro17.xapi.data.PlatformData;
import com.nexacro17.xapi.data.VariableList;
import com.nexacro17.xapi.data.datatype.DataType;
import com.nexacro17.xapi.tx.HttpPlatformRequest;
import com.nexacro17.xapi.tx.HttpPlatformResponse;
import com.nexacro17.xapi.tx.PlatformException;
import com.nexacro17.xapi.tx.PlatformType;
import com.edu.nexa.boardmng.BoardController;
import com.edu.nexa.boardmng.BoardService;

import java.lang.ProcessBuilder.Redirect;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
  
	@Resource(name = "boardService")
	private BoardService boardService;


	@RequestMapping({"/selectListBoard"})
	public void openSelectListBoard(HttpServletRequest req, HttpServletResponse resp) throws Exception { 

		//NexaUtil 에서 CommandMap 변환 작업 
		CommandMap commandMap = NexaUtil.toCommandMap(req);

//		logger.info("\t■-------- commandMap : " + commandMap.getMap());
		
		List<Map<String, Object>> list = boardService.selectBoardList(commandMap.getMap());
		System.out.println("####"+list);
		
		DataSet ds = new DataSet("list");
		ds.addColumn("BOARD_NO",DataTypes.INT);
		ds.addColumn("SUBJECT",DataTypes.STRING);
		ds.addColumn("CONTENT",DataTypes.STRING);
//		System.out.println("@@@@@@@@@@"+ds.getString(0, "CONTENT"));
		ds.addColumn("WRITER",DataTypes.STRING);
		ds.addColumn("REG_DATE",DataTypes.STRING);
		
		//NexaUtil 에서 DataSet 작업 
		ds = NexaUtil.toDataSet(list, ds);
		
		//NexaUtil 에서 View로 보내기 
		NexaUtil.toSend(ds, resp);

	}
	
	@RequestMapping({"/update"})
	public String update(HttpServletRequest req,HttpServletResponse resp)throws Exception{
		CommandMap commandMap = NexaUtil.toCommandMap(req);
		boardService.update(commandMap.getMap());
		
		logger.info("\t■-------- commandMap : " + commandMap.getMap());
		
		return "redirect:/selectListBoard";
		
	}

}
