package org.openjfx.model.Request;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.openjfx.model.Loading_Properties;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.util.HashMap;

public class NotionRequest {
    HttpClient client = HttpClient.newHttpClient();
    public NotionRequest(HttpRequest request) throws IOException, InterruptedException {
        var response = client.send(request, new JSon_Read<>(APOD.class));
        System.out.println(response.body().get().title);
    }

    public static class NotionRequestBuilder extends Loading_Properties{
        HttpRequest.BodyPublisher bodyPublisher;
        HttpRequest.Builder request;
        public NotionRequestBuilder(String url, HashMap<String,String> header) throws IOException {
             request = HttpRequest.newBuilder(
                            URI.create("https://api.notion.com/v1/"+url))
                    .header("Content-Type", "application/json");
             if (header != null){
                 for (String i : header.keySet()) {
                     request.header(i, header.get(i));
             }
            }
        }
        public NotionRequestBuilder body(String encoded, HashMap<String,String> body) throws JsonProcessingException {
            bodyPublisher = HttpRequest.BodyPublishers.ofString(new ObjectMapper().writeValueAsString(body));
            return this;
        }
        public NotionRequestBuilder GET (){
            request.method("GET", bodyPublisher);
            return this;
        }
        public NotionRequestBuilder POST (){
            request.POST(bodyPublisher);
            return this;
        }
        public NotionRequestBuilder PATCH (){
            request.method("PATCH", bodyPublisher);
            return this;
        }
        public NotionRequestBuilder DELETE (){
            request.method("DELETE", bodyPublisher);
            return this;
        }

        public NotionRequestBuilder AUTH_BASIC (String auhtorization){
            request.header("Authorization","Basic "+auhtorization);
            return this;
        }
        public NotionRequestBuilder AUTH_BEARER () {
            request.header("Authorization", "Bearer " + Loading_Properties.get_Token());
            return this;
        }
        public HttpRequest build (){
            return request.build();
        }
    }
}
