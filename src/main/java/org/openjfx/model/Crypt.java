package org.openjfx.model;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.net.URL;

public class Crypt {
    private byte key [];
    private String token = "";

    public void init () throws IOException {
        URL url = new URL("https://pro-api.coinmarketcap.com/v1/cryptocurrency/quotes/latest?symbol=BTC");
        HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
    }
    private void define_key (){

    }
    public void encrypted (){

    }
}
