package model;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class AnimationDevice extends ImageView implements IObserver{
    @FXML
    public ImageCollection imgs = new ImageCollection();
    public Iterator iter_main = imgs.getIterator();
    public  int counter = 0;

    public AnimationDevice() {
       setFitHeight(405.0);
       setFitWidth(600.0);
    }
    @Override
    public void update() {
        counter++;
        if(counter % 5 == 0){
            if (iter_main.hasNext()) {
                Image name = (Image) iter_main.next();
                setImage(name);
            }
            counter = 0;
        }

    }
}
