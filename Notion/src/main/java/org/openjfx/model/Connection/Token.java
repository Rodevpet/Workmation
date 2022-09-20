package org.openjfx.model.Connection;

import org.json.JSONObject;
import org.openjfx.model.Loading_Properties;
import org.openjfx.model.Request.Header_Read;
import org.openjfx.model.Request.NotionRequest;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Base64;
import java.util.HashMap;

public class Token {
    public Token() throws IOException, InterruptedException {
        String headerTempData = "";
                ServerSocket serverSocket = new ServerSocket(82);
                Socket clientSocket = serverSocket.accept();
                InputStream in = clientSocket.getInputStream();
                Reader inr = new InputStreamReader(in);
        //in.reset();
        //inr.reset();

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
        udpate(response);
        serverSocket.setSoTimeout(1000);
        in.close();
        inr.close();
        serverSocket.close();
        clientSocket.close();
    }
    public void udpate (String request_response) throws IOException {
        JSONObject obj = new JSONObject(request_response);
        Loading_Properties.setToken(obj.get("access_token").toString());
    }
}
