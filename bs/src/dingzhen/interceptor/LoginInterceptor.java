package dingzhen.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import dingzhen.entity.sys.User;


/**
 *@author: wangq
 *@date: 2015-8-15下午12:39:50
 *@version:
 *@description：登录拦截器
 */
public class LoginInterceptor extends HandlerInterceptorAdapter{
	
	
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {

	}

	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {

	}

	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		// 请求的路径

		String url = request.getServletPath().toString();
		HttpSession session = request.getSession();
		User currentUser = ((User) session.getAttribute("currentUser"));
		if (currentUser == null) {
			if (url.contains("login") || url.contains("Login")) {
				return true;
			}
			return true;
		}
		return true;
	}
}
