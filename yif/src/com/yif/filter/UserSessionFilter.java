package com.yif.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yif.bean.User;
import com.yif.common.AppConstants;

public class UserSessionFilter implements Filter {

	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest servletRequest,
			ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;

		HttpSession session = request.getSession();
		// clear session if session id in URL
		if (request.isRequestedSessionIdFromURL()) {
			if (session != null)
				session.invalidate();
		}

		String contextPath = request.getContextPath();
		if (contextPath == null) {
			contextPath = "";
		}

		String url = request.getServletPath();
		if (url == null) {
			url = "";
		}
		session.setAttribute("clickUrl", url);

		User user = (User) session.getAttribute(AppConstants.USER_SESSION_KEY);
		if (user == null) {
			response.sendRedirect(contextPath + "/login/login.do");
		} else {
			// 如果是手机应用，那么会在拦截器中根据token，对用户进行登录
			chain.doFilter(request, response);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}
}
