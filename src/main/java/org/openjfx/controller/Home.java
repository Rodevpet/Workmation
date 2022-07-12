package org.openjfx.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;

public class Home implements Initializable {
    @FXML
    TabPane Tab_Pane;

    @FXML
    TextField Username_Output;

    @FXML
    PasswordField Password_Output;

    @FXML
    Button Sync_Button;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            log_init();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void log_init () throws IOException {
        String IdPropsPath = Thread.currentThread().getContextClassLoader().getResource("ID.properties").getPath();

        Properties IdProps = new Properties();
        IdProps.load(new FileInputStream(IdPropsPath));

        String user = IdProps.getProperty("user");
        String password = IdProps.getProperty("password");
    }

    public void Synchronized (){

    }
}
