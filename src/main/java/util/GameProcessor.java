package util;

import POJO.Background;
import POJO.Blob;
import POJO.GameController;
import POJO.Plateforme;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

public abstract class GameProcessor {


    public static void processPlayer(Blob player, ArrayList<Plateforme> level){

        player.setTranslateY(player.getTranslateY()-player.getVitesseY());
        player.updateVitessseY();

        if (level.size()>1) {
            if (player.calculateJump( )) {  //TODO: mettre a jour arguments en fonction du prototype
                player.Jump();
            }
        }

        player.setAuSol(false);

    }



    public static void processLevel(ArrayList<Plateforme> gatesLvl, Background back, Pane root, int STEP_X,int parallax) {

        for (int i = 0; i < gatesLvl.size(); ) {
            gatesLvl.get(i).setTranslateX(gatesLvl.get(i).getTranslateX() - STEP_X);
            if (gatesLvl.get(i).getTranslateX() < -gatesLvl.get(i).getLongueur()) {
                root.getChildren().remove(gatesLvl.get(0));
                gatesLvl.remove(i);
            } else {i++;}
        }

        back.setTranslateX(back.getTranslateX()-STEP_X/parallax);


    }


    public static void processCollision (Blob player, ArrayList<Plateforme> level, GameController gameController) {

        for (Plateforme plateforme : level) {       //0 plateforme actuelle  1plateforme suivante
            if (player.getBoundsInParent().intersects(plateforme.getBoundsInParent())) {

                if (player.getTranslateY() <= (plateforme.getTranslateY() - player.getVitesseY())) {
                    //le joueur est sur la plateforme
                    player.setTranslateY(plateforme.getTranslateY() - player.getTaille());   // on repositionne bien au dessus de la plateforme
                    if (player.getVitesseY() <= 0) {
                        player.setVitesseY(0);
                    }                // pas de chute
                    player.setAuSol(true);
                } else { // contact par le coté ou le bas
                    gameController.setGameSatus(-1);
                }
            }
        }



            if (player.getTranslateY()>800){
                gameController.setGameSatus(-1);   //perdu
            }
    }




    public static boolean isNextFrame(GameController gameController, int minBetweenFrame) {

    long deltaT=System.nanoTime()- gameController.getFrameTime();

    if (deltaT>=minBetweenFrame)
        {
        gameController.setFrameTime(System.nanoTime());
        return true;
        }
    else {return false;}

    }


    public static void processEnding(Blob player,GameController gameController, ArrayList<Plateforme> level,Pane root) {

        if ((level.size()<=1)&&(player.isAuSol())) {
            gameController.setGameSatus(2);
        }



        if (gameController.getGameSatus() ==-1) {Endings.Perdu(root);}
        if (gameController.getGameSatus() ==2) {Endings.Gagne(root);}




    }





}
