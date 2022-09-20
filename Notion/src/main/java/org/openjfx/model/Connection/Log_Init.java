package org.openjfx.model.Connection;

import org.openjfx.model.Loading_Properties;

import java.io.IOException;

public class Log_Init {
    public Log_Init() throws IOException {
        super();
    }

    public boolean Logged () throws IOException {
        if (Loading_Properties.getToken().equals("")){
            return false;
        }else {
            return true;
        }
    }
}
