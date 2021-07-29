package com.choping.choping.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import io.jsonwebtoken.JwtException;

public class JwtTokenFilter extends GenericFilterBean{
private JwtTokenProvider jwtTokenProvider;
	
	public JwtTokenFilter(JwtTokenProvider jwtTokenProvider) {
		this.jwtTokenProvider = jwtTokenProvider;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse res, 
			FilterChain chain)
			throws IOException, ServletException {
		String token = jwtTokenProvider
				.resolveToken((HttpServletRequest) request);
		System.out.println("Token: " + token);
		HttpServletResponse response = (HttpServletResponse) res;
		
		try {
			if (token != null && jwtTokenProvider.validateToken(token)) {
				Authentication auth = 
						token != null 
						? jwtTokenProvider.getAuthentication(token)
						: null;
				SecurityContextHolder.getContext().setAuthentication(auth);
				System.out.println(SecurityContextHolder.getContext()
						.getAuthentication());
			}
			chain.doFilter(request, res);
		} catch(JwtException e) {
			response.sendError(HttpServletResponse.SC_PRECONDITION_FAILED,
					"Token inválido");
			return ;
		}
	}
}
