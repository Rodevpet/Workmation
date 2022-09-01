package org.openjfx.model.Connection;

import org.openjfx.model.Loading_Properties;
import org.openjfx.model.Request.Header_Read;
import org.openjfx.model.Request.NotionRequest;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Token {
    public Token() throws IOException {
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
        //TODO : Finish to connection
        String encoding = Loading_Properties.get_Client_Id()+Loading_Properties.get_Client_Secret();
        encoding = Base64.getEncoder().encodeToString(encoding.getBytes(StandardCharsets.UTF_8));
        new NotionRequest.NotionRequestBuilder("oauth/token",null).POST().AUTH_BASIC(new Header_Read(headerTempData).getDecoded_params().get("Code"))
        serverSocket.setSoTimeout(5000);
        clientSocket.close();
        serverSocket.close();

    }
}
