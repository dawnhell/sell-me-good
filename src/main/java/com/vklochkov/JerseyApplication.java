package com.vklochkov;

import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("api")
public class JerseyApplication extends ResourceConfig {
    public JerseyApplication() {
        register(CORSFilter.class);
    }
}
