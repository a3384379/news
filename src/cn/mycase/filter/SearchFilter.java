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
 * Servlet Filter implementation class SearchFilter
 */
public class SearchFilter implements Filter {
	
	//判断用户是否登陆，要登陆才能使用搜索
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest) request;
		HttpServletResponse resp=(HttpServletResponse) response;
		String username=null;
		String password=null;
		
		Cookie[] cookies = req.getCookies();
		if(cookies!=null) {
		for (Cookie cookie : cookies) {
			if("username".equals(cookie.getName()) ) {
				username=cookie.getValue();
			}
			if("password".equals(cookie.getName()) ) {
				password=cookie.getValue();
			}
		}
		}
		if(username!=null&&password!=null) {
			req.getRequestDispatcher("searchResult.action").forward(req, resp);
		}
		else {
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}
		chain.doFilter(req, resp);
	}


    /**
     * Default constructor. 
     */
    public SearchFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
