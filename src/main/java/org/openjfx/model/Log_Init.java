package org.openjfx.model;

import java.io.IOException;

public class Log_Init extends Loading_Properties {
    public Log_Init() throws IOException {
        super();
    }

    public boolean Logged () throws IOException {
        if (super.token.equals("")){
            return false;
        }else {
            return true;
        }
    }
}
