package com.exus.config;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.exus.endpoint.UserEndpoint;

@Component
@ApplicationPath("/")
public class JerseyConfig extends ResourceConfig {
	public JerseyConfig() {
		register(UserEndpoint.class);
	}
}
