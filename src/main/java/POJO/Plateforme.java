package POJO;

import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class Plateforme extends Rectangle {

    private int epaisseur;
    private int longueur;


    public Plateforme( int haut, int longu, int posX, int epaisseur){
        super(longu,epaisseur, Color.BLUE);
        super.setArcHeight(50);
        super.setArcWidth(100);


        this.longueur=longu;
        this.epaisseur=epaisseur;
        setTranslateX(posX);
        setTranslateY(haut);

        Image visual=new Image(getClass().getResource("/pictures/pattern1.jpg").toExternalForm());
        ImagePattern imagePattern=new ImagePattern(visual,0,0,200,200,false);

        DropShadow ombrage=new DropShadow();
        ombrage.setRadius(40.0);
        ombrage.setOffsetX(10.0);
        ombrage.setOffsetY(40.0);
        ombrage.setColor(Color.color(0.2, 0.1, 0.1));

        super.setFill(imagePattern);
        super.setEffect(ombrage);



    }


    public int getLongueur() {return longueur;}
    public int getEpaisseur() {return epaisseur;}
}
