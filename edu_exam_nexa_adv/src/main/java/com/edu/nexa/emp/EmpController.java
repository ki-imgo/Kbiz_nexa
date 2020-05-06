package com.edu.nexa.emp;

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
public class EmpController {
	
	private static final Logger logger = LoggerFactory.getLogger(EmpController.class);
  
	@Resource(name = "empService")
	private EmpService empService;


	@RequestMapping({"/selectEmpList"})
	public void openSelectEmpList(HttpServletRequest req, HttpServletResponse resp) throws Exception { 
		System.out.println("@@@@@@@@@");
		//NexaUtil 에서 CommandMap 변환 작업 
		CommandMap commandMap = NexaUtil.toCommandMap(req);

//		logger.info("\t■-------- commandMap : " + commandMap.getMap());
		
		List<Map<String, Object>> emp = empService.selectEmpList(commandMap.getMap());
//		List<Map<String, Object>> emp = empService.selectEmpList();
		System.out.println("####"+emp);
		
		DataSet ds = new DataSet("emp");
		ds.addColumn("ENAME",DataTypes.STRING);
		ds.addColumn("COMM",DataTypes.INT);
		ds.addColumn("HIREDATE",DataTypes.DATE);
		ds.addColumn("EMPNO",DataTypes.INT);
		ds.addColumn("MGR",DataTypes.INT);
		ds.addColumn("JOB",DataTypes.STRING);
		ds.addColumn("DEPTNO",DataTypes.INT);
		ds.addColumn("SAL",DataTypes.INT);
//		System.out.println("@@@@@@"+ds.);
		
		//NexaUtil 에서 DataSet 작업 
		ds = NexaUtil.toDataSet(emp, ds);
		
		//NexaUtil 에서 View로 보내기 
		NexaUtil.toSend(ds, resp);

	}
	
//	@RequestMapping({"/update"})
//	public String update(HttpServletRequest req,HttpServletResponse resp)throws Exception{
//		CommandMap commandMap = NexaUtil.toCommandMap(req);
//		boardService.update(commandMap.getMap());
//		
//		logger.info("\t■-------- commandMap : " + commandMap.getMap());
//		
//		return "redirect:/selectListBoard";
//		
//	}

}
