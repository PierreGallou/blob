package POJO;

import javafx.scene.effect.DropShadow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

import java.util.Objects;

public class Plateforme extends Rectangle {


    private int longueur;

    public int getLongueur() {return longueur;}


    public Plateforme( int haut, int longu, int posX, int epaisseur){
        super(longu,epaisseur, Color.BLUE);
        super.setArcHeight(50);
        super.setArcWidth(100);
        this.longueur=longu;

        setTranslateX(posX);
        setTranslateY(haut);

        Image visual=new Image(Objects.requireNonNull(getClass().getResource("/pictures/pattern1.jpg")).toExternalForm());
        ImagePattern imagePattern=new ImagePattern(visual,0,0,200,200,false);

        DropShadow ombrage=new DropShadow();
        ombrage.setRadius(10.0);
        ombrage.setOffsetX(5.0);
        ombrage.setOffsetY(5.0);
        ombrage.setColor(Color.color(0.2, 0.1, 0.1));


        InnerShadow lueurSombre=new InnerShadow();
        lueurSombre.setRadius(20.0);
        lueurSombre.setOffsetX(-10.0);
        lueurSombre.setOffsetY(-10);
        lueurSombre.setColor(Color.color(0.2, 0.1, 0.1));


        final Light.Distant light = new Light.Distant();
        light.setAzimuth(-90.0);
        final Lighting lighting = new Lighting();
        lighting.setLight(light);
        lighting.setSurfaceScale(3.0);

        lueurSombre.setInput(lighting);
        ombrage.setInput(lueurSombre);

        super.setFill(imagePattern);
        super.setEffect(ombrage);
    }



}
