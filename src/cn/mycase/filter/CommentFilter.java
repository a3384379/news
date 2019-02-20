package cn.mycase.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class CommentFilter
 */
public class CommentFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		String username = null;
		String password = null;

		Cookie[] cookies = req.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if ("username".equals(cookie.getName())) {
					username = cookie.getValue();
				}
				if ("password".equals(cookie.getName())) {
					password = cookie.getValue();
				}
			}
		}
		if (username == null && password == null) {
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}
		chain.doFilter(req, resp);
	}

	public CommentFilter() {
		// TODO Auto-generated constructor stub
	}

	public void destroy() {
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
