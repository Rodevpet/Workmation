package org.openjfx.model.Request;

import okhttp3.*;
import org.openjfx.model.Loading_Properties;

import java.io.IOException;
import java.util.HashMap;

public class NotionRequest {
    public String NotionRequest(Request request) throws IOException, InterruptedException {
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        Response response = client.newCall(request).execute();
        return(response.body().string());
    }

    public static class NotionRequestBuilder extends Loading_Properties{
        Request.Builder request = new Request.Builder();
        RequestBody requestBody;
        public NotionRequestBuilder(String url, HashMap<String,String> header) throws IOException {
             request.url("https://api.notion.com/v1/"+url);
             request.header("Content-Type", "application/json");
             if (header != null){
                 for (String i : header.keySet()) {
                     request.header(i, header.get(i));
             }
            }
        }
        public NotionRequestBuilder body(HashMap<String,String> body) {
            FormBody.Builder formBody = new FormBody.Builder();
            for (String key:body.keySet()){
                formBody.add(key,body.get(key));
            }
            requestBody = formBody.build();
            return this;
        }
        public NotionRequestBuilder GET (){
            request.method("GET", requestBody);
            return this;
        }
        public NotionRequestBuilder POST (){
            request.method("POST",requestBody);
            return this;
        }
        public NotionRequestBuilder PATCH (){
            request.method("PATCH", requestBody);
            return this;
        }
        public NotionRequestBuilder DELETE (){
            request.method("DELETE", requestBody);
            return this;
        }

        public NotionRequestBuilder AUTH_BASIC (String auhtorization){
            request.header("Authorization","Basic "+auhtorization);
            return this;
        }
        public NotionRequestBuilder AUTH_BEARER () {
            request.header("Authorization", "Bearer " + Loading_Properties.getToken());
            return this;
        }
        public Request build (){
            return request.build();
        }
    }
}
