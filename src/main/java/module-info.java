module Workmation {
    requires javafx.controls;
    requires javafx.fxml;
    requires unirest.java;
    requires org.json;
    opens org.openjfx to javafx.fxml;
    opens org.openjfx.controller to javafx.fxml;
    exports org.openjfx;
    exports org.openjfx.controller;
}