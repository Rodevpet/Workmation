package org.openjfx.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import org.openjfx.MainApp;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;

public class Home implements Initializable {
    @FXML
    TabPane Tab_Pane;

    @FXML
    Tab Notion_Tab;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            Notion_Tab.setContent(FXMLLoader.load(MainApp.class.getClassLoader().getResource("Connect_Button.fxml")));
            log_init();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void log_init () throws IOException {
        String IdPropsPath = Thread.currentThread().getContextClassLoader().getResource("Login.properties").getPath();

        Properties IdProps = new Properties();
        IdProps.load(new FileInputStream(IdPropsPath));

    }

    public void Synchronized (){

    }
}
