package cn.app.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import cn.app.pojo.BackendUser;
import cn.app.pojo.DevUser;
import cn.app.tools.Constants;

public class FirstInterceptor implements HandlerInterceptor {

	private String[] devmethods = { "/appsInfo", "/appsUpdate", "/appAdd", "/showCategory", "/deleteApp", "/appsSearch",
			"/appsPutOrDwon", "/categorys", "/appVersion", "/addVersion", "/download" };

	private String[] backmethods = {};
	private String[] unchecks = { "/index", "devLogin", "backLogin" };

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		String path = request.getServletPath();
		for (String uncheck : unchecks) {
			if (uncheck.contains(path)) {
				return true;
			}
		}
		BackendUser user = (BackendUser) session.getAttribute(Constants.USER_SESSION);
		if (user != null && user.getUsertype() == 1) {
			path = request.getServletPath();
			for (String path2 : devmethods) {
				if (path2.contains(path)) {
					System.out.println("aaa");
					session.removeAttribute(Constants.USER_SESSION);
					response.sendRedirect("goto.jsp");
					return false;
				}
			}
		} else if (user != null && user.getUsertype() == 2) {
			path = request.getServletPath();
			for (String path2 : backmethods) {
				if (path2.contains(path)) {
					System.out.println("bbb");
					session.removeAttribute(Constants.USER_SESSION);
					response.sendRedirect("goto.jsp");
					System.out.println(path);
					return false;
				}
			}
		}

		System.out.println("[FirstInterceptor] postHandle");
		return true;
	}

	/**
	 * 调用目标方法之后, 但渲染视图之前. 可以对请求域中的属性或视图做出修改.
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		boolean flag = false;
		HttpSession session = request.getSession();
		if (session.getAttribute(Constants.USER_SESSION) == null) {
			response.sendRedirect("index.jsp");
		}
		System.out.println("[FirstInterceptor] preHandle");

	}

	/**
	 * 渲染视图之后被调用. 释放资源
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("[FirstInterceptor] afterCompletion");
	}

}
