package org.openjfx.model.Request;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.security.Key;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Stream;

public class Header_Read {
    HashMap<String,String> decoded_params;
    public Header_Read(String header) throws UnsupportedEncodingException {
        decoded_params = new HashMap<>();
        header = URLDecoder.decode(header,"UTF-8");
        String [] Line = header.split("\n");
        String procotol = Line[0].split(" ")[0];
        String Line_param = Line[0].split(" ")[1];
        String HTTP_version = Line[0].split(" ")[2];
        String [] KeyValue_param = Line_param.split("&");
        for (String KeyValue : KeyValue_param){
            String [] KeyValueSplit = KeyValue.split("=");
            if (KeyValueSplit.length == 2){
                decoded_params.put(KeyValueSplit[0],KeyValueSplit[1]);
            } else if (KeyValueSplit.length == 1){
                decoded_params.put(KeyValueSplit[0],"undefined");
            } {

            }
        }
        HashMap <String,String> decoded_params_1 = new HashMap<>();
        for (String i : decoded_params.keySet()){
            if (i.contains("?")==true){
                String[] x = i.split("\\?");
                decoded_params_1.put(x[1],decoded_params.get(i));
            }else{
                decoded_params_1.put(i,decoded_params.get(i));
            }

        }
        decoded_params.clear();
        for (String i : decoded_params_1.keySet()){
            decoded_params.put(i,decoded_params_1.get(i));
        }
    }

    public HashMap<String,String> getDecoded_params(){
        return decoded_params;
    }
}
