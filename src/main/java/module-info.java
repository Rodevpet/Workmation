module Workmation {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires java.desktop;
    requires java.net.http;
    requires com.fasterxml.jackson.databind;

    opens org.openjfx.model to com.fasterxml.jackson.databind;
    opens org.openjfx to javafx.fxml;
    opens org.openjfx.controller to javafx.fxml;
    exports org.openjfx;
    exports org.openjfx.controller;
    exports org.openjfx.model;
    exports org.openjfx.model.Request;
    opens org.openjfx.model.Request to com.fasterxml.jackson.databind;
}