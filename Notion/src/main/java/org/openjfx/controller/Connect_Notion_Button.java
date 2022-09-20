package org.openjfx.controller;



import javafx.fxml.FXML;
import javafx.scene.control.Button;
import org.openjfx.model.Connection.Loading_Information;
import org.openjfx.model.Loading_Properties;
import org.openjfx.model.Connection.Token;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class Connect_Notion_Button {
    protected String client_id;
    @FXML
    Button Connect_Button;

    public Connect_Notion_Button() throws IOException {
    }

    public void Connect_Button_Clicked() throws IOException, URISyntaxException, InterruptedException {
        URL urle = new URL("https://api.notion.com/v1/oauth/authorize?owner="+Loading_Properties.getOwner()+"&client_id="+Loading_Properties.getClientId()+"&redirect_uri="+Loading_Properties.getRedirectUri()+"&response_type="+ Loading_Information.getResponseType());
        if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
            Desktop.getDesktop().browse(new URI(urle.toString()));
        }
        new Token();

    }

}
