package com.multicampus.view.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class filter implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		String uri = req.getRequestURI();
		long start = System.currentTimeMillis();
		
		req.setCharacterEncoding("UTF-8");
		chain.doFilter(request, response);
		
		
		long end = System.currentTimeMillis();
		
		System.out.println(uri + "서블릿 수행에 걸리 시간 : " + 
				(end - start) + "(ms)초");
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
