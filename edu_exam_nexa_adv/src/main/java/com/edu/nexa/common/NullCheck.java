package com.edu.nexa.common;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.edu.nexa.boardmng.BoardController;

/**
 * @author dev
 *  null 체크 (공백포함)
 *
 */
public class NullCheck {
	
	private static final Logger logger = LoggerFactory.getLogger(NullCheck.class);

	public static boolean isEmpty(Object obj) {

		if(obj == null) return true;

		if ((obj instanceof String) && (((String)obj).trim().length() == 0)) { 
			
			return true; 
		}

		if ((obj instanceof String) && obj.hashCode() < 0) {
			
			return true; 
		}

        if (obj instanceof Map) { 
        	
        	return ((Map<?, ?>) obj).isEmpty(); 
    	}

        if (obj instanceof Map) { 
        	
        	return ((Map<?, ?>)obj).isEmpty(); 
    	} 

        if (obj instanceof List) { 
        	
        	return ((List<?>)obj).isEmpty(); 
    	}

        if (obj instanceof Object[]) { 
        	
        	return (((Object[])obj).length == 0); 
    	}

		return false;

	}

	
}
