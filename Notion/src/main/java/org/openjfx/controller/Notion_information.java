package org.openjfx.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import org.openjfx.model.Connection.Loading_Information;
import org.openjfx.model.Connection.Token;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Notion_information implements Initializable {
    @FXML
    TextField Workspace_Name_Entry;
    @FXML
    TextField Bot_Id_Entry;
    @FXML
    TextField Owner_Entry;
    @FXML
    TextField Token_Entry;
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            new Loading_Information(Workspace_Name_Entry, Bot_Id_Entry, Owner_Entry, Token_Entry);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
