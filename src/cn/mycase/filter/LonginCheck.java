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

//ºóÌ¨µÇÂ½À¹½Ø
public class LonginCheck implements Filter {
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest) request;
		HttpServletResponse resp=(HttpServletResponse) response;
		String rootname=null;
		String rootPassword=null;
		
		Cookie[] cookies = req.getCookies();
		if(cookies!=null) {
		for (Cookie cookie : cookies) {
			if("rootname".equals(cookie.getName()) ) {
				rootname=cookie.getValue();
			}
			if("rootPassword".equals(cookie.getName()) ) {
				rootPassword=cookie.getValue();
			}
		}
		}
		if(rootname!=null&&rootPassword!=null) {
			req.getRequestDispatcher("/admin/home.jsp").forward(req, resp);
		}
		else {
			req.getRequestDispatcher("/admin/index.jsp").forward(req, resp);
		}
		chain.doFilter(req, resp);
	}
	
    public LonginCheck() {
    }

	public void destroy() {
	}
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
