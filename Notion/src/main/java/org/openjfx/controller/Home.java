package org.openjfx.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import org.openjfx.MainApp;
import org.openjfx.model.Connection.Log_Init;

import java.io.IOException;
import java.net.URL;
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
                Notion_Tab.setContent(FXMLLoader.load(MainApp.class.getClassLoader().getResource("Connect_Button.fxml")));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void Synchronized (){

    }
}
