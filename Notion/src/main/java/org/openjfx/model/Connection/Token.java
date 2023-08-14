package org.openjfx.model.Connection;

import org.json.JSONObject;
import org.openjfx.controller.Home;
import org.openjfx.model.Loading_Properties;
import org.openjfx.model.Request.Header_Read;
import org.openjfx.model.Request.NotionRequest;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyStoreException;
import java.util.Base64;
import java.util.HashMap;

public class Token {
    public Token(Home connect) throws IOException, InterruptedException {
        String headerTempData = "";
                ServerSocket serverSocket = new ServerSocket(82);
                Socket clientSocket = serverSocket.accept();
                InputStream in = clientSocket.getInputStream();
                Reader inr = new InputStreamReader(in);
        try {
            int c;
            while ((c = inr.read()) != -1) {
                System.out.print((char)c);
                headerTempData += ((char)c);
                if (headerTempData.contains("\r\n\r\n"))
                    break;
            }
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
        System.out.println(Loading_Properties.getEncoding());
        String code = new Header_Read(headerTempData).getDecoded_params().get("code");
        System.out.println(code);
        HashMap <String, String> body = new HashMap<>();
        body.put("grant_type","authorization_code");
        body.put("redirect_uri",Loading_Properties.getRedirectUri());
        body.put("code",code);
        String response = new NotionRequest().NotionRequest(new NotionRequest.NotionRequestBuilder("oauth/token", null).AUTH_BASIC(Loading_Properties.getEncoding()).body(body).POST().build());
        System.out.println(response);
        udpate(response,connect);
        serverSocket.setSoTimeout(1000);
        in.close();
        inr.close();
        serverSocket.close();
        clientSocket.close();
    }
    public void udpate (String request_response,Home connect) throws IOException {
        JSONObject obj = new JSONObject(request_response);
        Loading_Properties.setToken(obj.get("access_token").toString());
        Loading_Properties.setWorkspace_name(obj.get("workspace_name").toString());
        Loading_Properties.setOwner(obj.get("owner").toString());
        Loading_Properties.setBot_id(obj.get("bot_id").toString());
        connect.Connected();
    }
}
