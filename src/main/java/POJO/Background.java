package POJO;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

import java.util.Objects;

public class Background extends Rectangle {


    public Background(  int longu){
        super(longu,800, Color.BLUE);

        setTranslateX(0);
        setTranslateY(0);

        Image visual=new Image(Objects.requireNonNull(getClass().getResource("/pictures/background.jpg")).toExternalForm());
        ImagePattern imagePattern=new ImagePattern(visual,0,0,1250,1250,false);
        super.setFill(imagePattern);



    }



}
