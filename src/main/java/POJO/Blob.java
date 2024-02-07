package POJO;

import javafx.scene.effect.BlendMode;
import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

import java.util.Objects;

public class Blob extends Rectangle {

    int mass;
    int jumpForce;
    int vitesseY;
    int taille;
    boolean auSol;
    int vChuteMax;

    public Blob(int m, int jumpForce, int initDecalX, int initDecalY, int taille, int vChute) {
        super(taille,taille, Color.RED);
        this.mass=m;
        this.vitesseY=0;
        this.jumpForce=jumpForce;
        this.taille=taille;
        this.vChuteMax=vChute;
        this.auSol=false;

        setTranslateX(initDecalX);
        setTranslateY(initDecalY);

        Image visual=new Image(Objects.requireNonNull(getClass().getResource("/pictures/player.png")).toExternalForm());
        ImagePattern imagePattern=new ImagePattern(visual);
        super.setFill(imagePattern);


        final Light.Distant light = new Light.Distant();
        light.setAzimuth(-45.0);
        final Lighting lighting = new Lighting();
        lighting.setLight(light);
        lighting.setSurfaceScale(3.0);
        lighting.setDiffuseConstant(1.5);
        lighting.setSpecularConstant(0.75);


        super.setEffect(lighting);
        super.setBlendMode(BlendMode.HARD_LIGHT);

    }




    public void Jump() {
        if (this.auSol) {this.vitesseY=this.jumpForce;}
    }




    public boolean calculateJump ( ) {

        //TODO: logique a integrer


        return false;
    }



    public void updateVitessseY() {
        this.vitesseY=this.vitesseY-this.mass;
        if (this.vitesseY<this.vChuteMax){
            this.vitesseY=this.vChuteMax;
        }
    }







    public int getVitesseY() { return vitesseY; }
    public int getTaille() {return taille;}
    public boolean isAuSol() {return auSol;}


    public void setVitesseY(int Vitesse) {this.vitesseY = Vitesse;}
    public void setAuSol(boolean auSol) {this.auSol = auSol;}


}
