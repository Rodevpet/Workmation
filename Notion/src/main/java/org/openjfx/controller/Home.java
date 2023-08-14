package org.openjfx.controller;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import org.openjfx.MainApp;
import org.openjfx.model.Connection.Loading_Information;
import org.openjfx.model.Connection.Log_Init;
import org.openjfx.model.Connection.Token;
import org.openjfx.model.Loading_Properties;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.EventListener;
import java.util.ResourceBundle;

public class Home implements Initializable {
    @FXML
    TabPane Tab_Pane;

    @FXML
    Tab Notion_Tab;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            boolean Logged = new Log_Init().Logged();
            if (Logged == true){
                Notion_Tab.setContent(FXMLLoader.load(MainApp.class.getClassLoader().getResource("Notion_Information.fxml")));
            } else if (Logged == false){
                AnchorPane Pane_Button = FXMLLoader.load(MainApp.class.getClassLoader().getResource("Connect_Button.fxml"));
                Notion_Tab.setContent(Pane_Button);
                Button Connect_Button = (Button) Pane_Button.getChildren().get(0);
                Connect_Button.setOnMouseClicked((Event event)->{
                    try {
                        URL urle = new URL("https://api.notion.com/v1/oauth/authorize?owner="+ Loading_Properties.getOwner()+"&client_id="+Loading_Properties.getClientId()+"&redirect_uri="+Loading_Properties.getRedirectUri()+"&response_type="+ Loading_Information.getResponseType());
                        if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                            Desktop.getDesktop().browse(new URI(urle.toString()));
                        }
                        new Token(this);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    } catch (URISyntaxException e) {
                        throw new RuntimeException(e);
                    }
                });
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void Synchronized (){

    }

    public void Connected() throws IOException {
        Notion_Tab.setContent(FXMLLoader.load(MainApp.class.getClassLoader().getResource("Notion_Information.fxml")));
    }
}
