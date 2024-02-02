package POJO;

import javafx.scene.effect.Bloom;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class Background extends Rectangle {

    private int longueur;


    public Background(  int longu){
        super(longu,800, Color.BLUE);
        this.longueur=longu;

        setTranslateX(0);
        setTranslateY(0);

        Image visual=new Image(getClass().getResource("/pictures/background.jpg").toExternalForm());
        ImagePattern imagePattern=new ImagePattern(visual,0,0,800,600,false);
        super.setFill(imagePattern);

//        Bloom bloom = new Bloom();
//        bloom.setThreshold(0.7);
//        super.setEffect(bloom);




    }



}
