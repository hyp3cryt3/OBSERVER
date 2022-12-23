package com.example;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import model.*;
import javafx.event.ActionEvent;

import java.net.URL;
import java.util.ResourceBundle;


public class HelloController implements Initializable {
    @FXML
    public VBox container;
    public ImageCollection imgs = new ImageCollection();
    public Iterator iter_main = imgs.getIterator();

    public TimeServer timeServer = new TimeServer();
    public AnimationDevice sw = new AnimationDevice();

    public void onNext(ActionEvent actionEvent) {
        if (iter_main.hasNext()) {
            Image name = (Image) iter_main.next();
            sw.setImage(name);
        }
    }

    public void onBack(ActionEvent event) {
        if (iter_main.hasPreview()) {
            Image name = (Image) iter_main.preview();
            sw.setImage(name);
        }
    }
    public void start(ActionEvent event) {
        timeServer.attach(sw);
    }

    public void onStop(ActionEvent event) {
        timeServer.detach(sw);
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        container.getChildren().add(sw);
    }
}