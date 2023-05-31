package dingzhen.common.util;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

/**
 *@author: wangq
 *@date: 2015-5-18上午11:46:02
 *@version:
 *@description：
 */
public class WriterUtil {
	
	public static void write(HttpServletResponse response,String obj){
		try {
			 response.getWriter().write(obj);
		} catch (IOException e) {
			
		}
	}
}
