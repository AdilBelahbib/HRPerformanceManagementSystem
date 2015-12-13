package com.echallenge.restservice;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

@Provider
public class AuthSecurityInterceptor implements ContainerRequestFilter {
	
	// 401 - Access denied
    private static final Response ACCESS_UNAUTHORIZED = Response.status(Response.Status.UNAUTHORIZED).entity("Not authorized.").build();
	
    @Context
    private HttpServletRequest request;
	
	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		String mail = requestContext.getHeaderString("auth-id");
		String token = requestContext.getHeaderString("auth-token");
		
		if(request.getSession().getAttribute(mail) != null)
			if(!request.getSession().getAttribute(mail).equals(token))
				requestContext.abortWith(ACCESS_UNAUTHORIZED);
	}

}
