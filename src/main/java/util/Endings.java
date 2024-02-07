package util;

import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

import java.util.Objects;

public abstract class Endings {

    public static void Perdu(Pane root){

        Image visual=new Image(Objects.requireNonNull(Endings.class.getResource("/pictures/perdu.png")).toExternalForm());
        ImagePattern imagePattern=new ImagePattern(visual);
        Rectangle rect=new Rectangle(500,225,imagePattern);
        rect.setTranslateX(150);
        rect.setTranslateY(200);

        root.getChildren().add(rect);

    }




    public static void Gagne(Pane root){

        Image visual=new Image(Objects.requireNonNull(Endings.class.getResource("/pictures/victoire.png")).toExternalForm());
        ImagePattern imagePattern=new ImagePattern(visual);
        Rectangle rect=new Rectangle(600,225,imagePattern);
        rect.setTranslateX(100);
        rect.setTranslateY(200);

        root.getChildren().add(rect);



    }




}
