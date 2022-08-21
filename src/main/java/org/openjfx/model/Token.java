package org.openjfx.model;

import org.openjfx.model.Request.Header_Read;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Token {
    public Token() throws IOException {
        String headerTempData = "";
                ServerSocket serverSocket = new ServerSocket(82);
                Socket clientSocket = serverSocket.accept();
                PrintWriter out =
                        new PrintWriter(clientSocket.getOutputStream(), true);
                InputStream in = clientSocket.getInputStream();
                Reader e = new InputStreamReader(in);
        try {
            int c;
            while ((c = e.read()) != -1) {
                System.out.print((char) c);
                headerTempData += (char) c;
                if (headerTempData.contains("\r\n\r\n"))
                    break;
            }
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
        //TODO : Finish to connection
        new Header_Read(headerTempData).getDecoded_params();
        serverSocket.setSoTimeout(10);
        clientSocket.close();
        serverSocket.close();

    }
}
