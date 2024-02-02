package POJO;

import javafx.scene.effect.BlendMode;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class Blob extends Rectangle {

    int mass;
    int jumpForce;
    int vitesseY;
    int taille;
    boolean auSol;
    boolean jumpAsk;


    public Blob(int m, int jumpForce, int initDecalX, int initDecalY, int taille) {
        super(taille,taille, Color.RED);
        this.mass=m;
        this.vitesseY=0;
        this.jumpForce=jumpForce;
        this.taille=taille;

        this.auSol=false;
        this.jumpAsk=false;
        setTranslateX(initDecalX);
        setTranslateY(initDecalY);

        Image visual=new Image(getClass().getResource("/pictures/player.png").toExternalForm());
        ImagePattern imagePattern=new ImagePattern(visual);
        super.setFill(imagePattern);



        super.setBlendMode(BlendMode.HARD_LIGHT);
    }




    public void Jump() {
       this.vitesseY=this.jumpForce;
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

    public boolean isAuSol() {return auSol;}
    public void setAuSol(boolean auSol) {this.auSol = auSol;}

    public boolean isJumpAsk() {return jumpAsk;}

    public void setJumpAsk(boolean jumpAsk) {this.jumpAsk = jumpAsk;}
}
