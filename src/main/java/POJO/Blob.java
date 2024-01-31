package POJO;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Blob extends Rectangle {

    int mass;
    int jumpForce;
    int vitesseY;
    int taille;


    public Blob(int m, int jumpForce,int initDecalX, int initDecalY, int taille) {
        super(taille,taille, Color.RED);
        this.mass=m;
        this.vitesseY=0;
        this.jumpForce=jumpForce;
        this.taille=taille;
        setTranslateX(initDecalX);
        setTranslateY(initDecalY);
    }


    public int getMass() {
        return mass;
    }
    public int getJumpForce() {
        return jumpForce;
    }
    public int getVitesseY() { return vitesseY; }
    public int getTaille() {return taille;}

    public void setVitesseY(int Vitesse) {
        this.vitesseY = Vitesse;
    }



}
