package org.openjfx.model;

import java.io.*;
import java.security.KeyStore;
import java.security.KeyStoreException;
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

    protected static String encoding;
    private static String Path_Login_Properties = Thread.currentThread().getContextClassLoader().getResource("Login.properties").getPath();

    public static void  Loading_Properties () throws IOException {
        Loading_Login_Properties();
    }

    public static void Loading_Login_Properties ()throws IOException{
        Properties appProps = new Properties();
        appProps.load(new FileInputStream(Path_Login_Properties));
        client_id = appProps.getProperty("client_id");
        token = appProps.getProperty("token");
        response_type = appProps.getProperty("response_type");
        owner = appProps.getProperty("owner");
        redirect_uri = appProps.getProperty("redirect_uri");
        configured = appProps.getProperty("configured").equals("true");
        encoding = appProps.getProperty("encoding");
    }

    public static String get_Workspace_Name() {
        return workspace_name;
    }

    public static String get_Bot_Id() {
        return bot_id;
    }

    public static String getOwner() {
        return owner;
    }

    public static String getToken() {
        return token;
    }

    public static boolean getConfigured() {
        return configured;
    }

    public static String getWorkspaceId() {
        return workspace_id;
    }

    public static String getWorkspaceIcon() {
        return workspace_icon;
    }

    public static String getOwnerUser() {
        return owner_user;
    }

    public static String getRedirectUri() {
        return redirect_uri;
    }

    public static String getResponseType() {
        return response_type;
    }

    public static String getClientId() {
        return client_id;
    }

    public static String getEncoding() {
        return encoding;
    }
    public static void setToken(String token) {
        Loading_Properties.token = token;

    }

    public static void setWorkspace_name(String workspace_name) {
        Loading_Properties.workspace_name = workspace_name;
    }

    public static void setBot_id(String bot_id){
        Loading_Properties.bot_id = bot_id;
    }

    public static void setOwner(String owner){
        Loading_Properties.owner = owner;
    }
    public static void setClient_id(String client_id) throws IOException {
        Loading_Properties.client_id = client_id;
        Properties appProps = new Properties();
        appProps.load(new FileInputStream(Path_Login_Properties));
        appProps.setProperty("client_id", client_id);
    }
}
