package com.example.task4;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import model.ImageCollection;
import model.Iterator;
import javafx.event.ActionEvent;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;


public class HelloController implements Initializable {
    @FXML
    public ImageView pleer;
    @FXML
    public ImageCollection imgs = new ImageCollection();
    @FXML
    public Iterator iter_main = imgs.getIterator();
    @FXML
    public Timeline timeline = new Timeline();

    public void onNext(ActionEvent actionEvent) {
        if (iter_main.hasNext()) {
            Image name = (Image) iter_main.next();
            pleer.setImage(name);
        }
    }
    public void onBack(ActionEvent event) {
        if (iter_main.hasPreview()) {
            Image name = (Image) iter_main.preview();
            pleer.setImage(name);
        }
    }
    public void onPlay(ActionEvent event)
    {
        timeline.play();
    }

    public void onStop(ActionEvent event)
    {
        timeline.stop();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        timeline.setCycleCount(Timeline.INDEFINITE); //количество повторов
        timeline.getKeyFrames().add(new KeyFrame(new Duration(15000), new EventHandler() {
            @Override
            public void handle(Event event) {
                if (iter_main.hasNext()) {
                    Image name = (Image) iter_main.next();
                    pleer.setImage(name);
                }
            }
        }));
    }
}