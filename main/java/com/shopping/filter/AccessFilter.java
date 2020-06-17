package com.shopping.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class AccessFilter
 */
@WebFilter(filterName = "/AccessFilter", urlPatterns={"/*"})
public class AccessFilter implements Filter {

	public void destroy() {}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		HttpServletResponse httpResponse = (HttpServletResponse)response;
		/*允许跨域的主机地址 */
		httpResponse.setHeader("Access-Control-Allow-Origin", "*");
		/*允许跨域的请求方法GET, POST, HEAD 等 */
		httpResponse.setHeader("Access-Control-Allow-Methods", "*");
		/*重新预检验跨域的缓存时间 (s) */
		httpResponse.setHeader("Access-Control-Max-Age", "3600");
		/*允许跨域的请求头 */
		httpResponse.setHeader("Access-Control-Allow-Headers", "*");
		/*是否携带cookie */
		httpResponse.setHeader("Access-Control-Allow-Credentials", "true");
		chain.doFilter(request, httpResponse);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}
}
