package com.supinfo.supcommerce.filter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter (urlPatterns = "/auth/*")
public class AuthenticateFilter implements Filter {
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// do nothing
	}

	@Override
	public void doFilter(ServletRequest servletRequest,
		ServletResponse servletResponse,
		FilterChain filterChain)
		throws IOException, ServletException {

		HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
		HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;

		if (httpRequest.getSession()
					   .getAttribute("username") != null) {
			filterChain.doFilter(httpRequest, httpResponse);
			return;
		}

		httpResponse.sendRedirect(httpRequest.getContextPath() + "/login");
	}

	@Override
	public void destroy() {
		// do nothing
	}
}
