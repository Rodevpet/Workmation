package org.openjfx.model;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Loading_Properties {
    protected String client_id;
    protected String token;
    protected boolean configured;
    protected String redirect_uri;
    protected String response_type;
    protected String owner;
    public Loading_Properties () throws IOException {
        String Path_Properties = Thread.currentThread().getContextClassLoader().getResource("Login.properties").getPath();
        Properties appProps = new Properties();
        appProps.load(new FileInputStream(Path_Properties));
        client_id = appProps.getProperty("client_id");
        token = appProps.getProperty("token");
        response_type = appProps.getProperty("response_type");
        owner = appProps.getProperty("owner");
        redirect_uri = appProps.getProperty("redirect_uri");
        configured = appProps.getProperty("configured").equals("true");

    }
}
