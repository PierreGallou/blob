package POJO;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Plateforme extends Rectangle {

    private int epaisseur;
    private int longueur;


    public Plateforme( int haut, int longu, int posX, int epaisseur){
        super(longu,epaisseur, Color.BLUE);

        this.longueur=longu;
        this.epaisseur=epaisseur;
        setTranslateX(posX);
        setTranslateY(haut);
    }


    public int getLongueur() {return longueur;}
    public int getEpaisseur() {return epaisseur;}
}
