package org.openjfx.controller;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import org.openjfx.model.Loading_Properties;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class Connect_Notion_Button extends Loading_Properties {
    protected String client_id;
    @FXML
    Button Connect_Button;

    public Connect_Notion_Button() throws IOException {
    }

    public void Connect_Button_Clicked() throws UnirestException, IOException {
        Stage esge = new Stage();
        WebView Notion_WebView = new WebView();
        Scene esg = new Scene(Notion_WebView);
        esge.setScene(esg);
        Notion_WebView.setPrefHeight(600);
        Notion_WebView.setPrefWidth(800);
        esge.show();
        URL urle = new URL("https://api.notion.com/v1/oauth/authorize?owner="+super.owner+"&client_id="+super.client_id+"&redirect_uri="+super.redirect_uri+"&response_type="+super.response_type);
        HttpURLConnection connection = (HttpURLConnection) urle.openConnection();
        WebEngine url = Notion_WebView.getEngine();
        url.load(urle.toString());
        url.getLoadWorker().stateProperty().addListener(
                new ChangeListener<Worker.State>() {

                    @Override
                    public void changed(ObservableValue<? extends Worker.State> observableValue, Worker.State state, Worker.State t1) {
                        System.out.println(url.getLocation());
                        if (url.getLocation().charAt(9)=='r'){
                            String matche = url.getLocation().substring(0,21);
                            if (matche.equals("https://robinpetit.fr")){
                                String hurle = url.getLocation();
                                char [] e = hurle.toCharArray();

                                for (char i:e){
                                    if (i=='='){

                                    }
                                }
                            }

                        }
                    }
                });
        //System.out.println(url.getHistory().getEntries().get(1));
    }

}
