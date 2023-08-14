module Notion {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires okhttp3;

    opens org.openjfx.model.Request to org.json;
    opens org.openjfx.model to okhttp3;
    opens org.openjfx to javafx.fxml;
    opens org.openjfx.controller to javafx.fxml;
    exports org.openjfx;
    exports org.openjfx.controller;
    exports org.openjfx.model;
    exports org.openjfx.model.Request;
    exports org.openjfx.model.Connection;
}