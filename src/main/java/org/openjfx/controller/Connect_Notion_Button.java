package org.openjfx.controller;



import javafx.fxml.FXML;
import javafx.scene.control.Button;
import org.openjfx.model.Loading_Properties;
import org.openjfx.model.Token;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class Connect_Notion_Button extends Loading_Properties {
    protected String client_id;
    @FXML
    Button Connect_Button;

    public Connect_Notion_Button() throws IOException {
    }

    public void Connect_Button_Clicked() throws IOException, URISyntaxException {
        URL urle = new URL("https://api.notion.com/v1/oauth/authorize?owner="+super.owner+"&client_id="+super.client_id+"&redirect_uri="+super.redirect_uri+"&response_type="+super.response_type);
        if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
            Desktop.getDesktop().browse(new URI(urle.toString()));
        }
        new Token();

    }

}
