package org.openjfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApp extends Application {
    public static Stage stage;
    public static void main(String[] args) throws IOException {
        launch(args);

    }

    @Override
    public void start(Stage stage) throws IOException {
        MainApp.stage = stage;
        Scene scene = new Scene(loadFXML("home"));
        stage.setScene(scene);
        stage.show();
    }

    public static void setFXML(String scene) {
        try {
            stage.setScene(new Scene(loadFXML(scene)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getClassLoader().getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
}
