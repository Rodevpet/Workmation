package org.openjfx.model;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;

public class Crypt {
    private byte key [];
    private int resursive = -1;

    private String password = "esggehhh";

    private String Path_To_key [] = {"data","BTC","quote","USD","volume_24h"};

    private String token = "0d4af6b4-5321-4671-87af-70cbc32a986d";

    public void init () throws IOException, UnirestException {

        Unirest.setTimeouts(0, 0);
        HttpResponse<String> response = Unirest.get("https://pro-api.coinmarketcap.com/v1/cryptocurrency/quotes/latest?symbol=BTC&aux=volume_24h_reported")
                .header("X-CMC_PRO_API_KEY",token )
                .asString();
        System.out.println(searchid(new JSONObject(response.getBody())));
        encryption();
    }

    private Object searchid(JSONObject obj){
        resursive += 1;
        if (resursive == (Path_To_key.length-1)){
            return obj.get(Path_To_key[resursive]);
        }
        return searchid(obj.getJSONObject(Path_To_key[resursive]));
    }
    private void define_key (){

    }
    private void encryption (){
        //Split password
        /*ArrayList <char> Password_jspfautrouverqqchose = new ArrayList<char>();
        for (int i=0; i!=password.length();i++){

        }*/
    }
}
