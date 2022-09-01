package org.openjfx.model;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Loading_Properties {
    protected static String client_id;
    protected static String token;
    protected static boolean configured;
    protected static String redirect_uri;
    protected static String response_type;
    protected static String owner;
    protected static String workspace_name;
    protected static String workspace_id;
    protected static String workspace_icon;
    protected static String owner_user;
    protected static String bot_id;

    protected static String client_secret;
    private String Path_Properties = Thread.currentThread().getContextClassLoader().getResource("Login.properties").getPath();
    public Loading_Properties () throws IOException {

        Properties appProps = new Properties();
        appProps.load(new FileInputStream(Path_Properties));
        client_id = appProps.getProperty("client_id");
        token = appProps.getProperty("token");
        response_type = appProps.getProperty("response_type");
        owner = appProps.getProperty("owner");
        redirect_uri = appProps.getProperty("redirect_uri");
        configured = appProps.getProperty("configured").equals("true");
        client_secret = appProps.getProperty("client_secret");
        Path_Properties = Thread.currentThread().getContextClassLoader().getResource("WorkspaceInfo.properties").getPath();
        appProps.load(new FileInputStream(Path_Properties));
        workspace_name = appProps.getProperty("workspace_name");
        workspace_id = appProps.getProperty("workspace_id");
        workspace_icon = appProps.getProperty("workspace_icon");
        owner_user = appProps.getProperty("owner_user");
        bot_id = appProps.getProperty("bot_id");
    }

    public static String get_Workspace_Name() {
        return workspace_name;
    }

    public static String get_Bot_Id() {
        return bot_id;
    }

    public static String get_Owner() {
        return owner;
    }

    public static String get_Token() {
        return token;
    }

    public static boolean get_Configured() {
        return configured;
    }

    public static String get_Workspace_Id() {
        return workspace_id;
    }

    public static String get_Workspace_Icon() {
        return workspace_icon;
    }

    public static String get_Owner_User() {
        return owner_user;
    }

    public static String get_Redirect_Uri() {
        return redirect_uri;
    }

    public static String get_Response_Type() {
        return response_type;
    }

    public static String get_Client_Id() {
        return client_id;
    }

    public static String get_Client_Secret() {
        return client_secret;
    }
    public void set_Token(String token) throws IOException {
        Loading_Properties.token = token;
        Properties appProps = new Properties();
        appProps.load(new FileInputStream(Path_Properties));
        appProps.setProperty("token", token);
    }
}
