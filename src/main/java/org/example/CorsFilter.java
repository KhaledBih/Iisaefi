package org.example;


import javax.ws.rs.container.*;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

@Provider
public class CorsFilter implements ContainerRequestFilter, ContainerResponseFilter {
    @Override
    public void filter(ContainerRequestContext request, ContainerResponseContext response)
            throws IOException {
        response.getHeaders().add(
                "Access-Control-Allow-Origin", "*");
        response.getHeaders().add(
                "Access-Control-Allow-Headers",
                "origin, content-type, accept, authorization");
        response.getHeaders().add(
                "Access-Control-Allow-Methods",
                "GET, POST, PUT, DELETE, OPTIONS, HEAD");
        }

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		// TODO Auto-generated method stub
		return;
	}



}

