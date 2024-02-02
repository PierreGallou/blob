package util;

import POJO.Background;
import POJO.Blob;
import POJO.GameController;
import POJO.Plateforme;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

public abstract class GameProcessor {


    public static void processPlayer(Blob player){
        player.setTranslateY(player.getTranslateY()-player.getVitesseY());

        int updateVitessseY=player.getVitesseY()-player.getMass();
        if  (updateVitessseY<-10){updateVitessseY=-10;}     //bridage de la vitesse de chute
        player.setVitesseY(updateVitessseY);

        player.setAuSol(false);



    }



    public static void processLevel(ArrayList<Plateforme> gatesLvl, Background back, GameController gameController, Pane root, int STEP_X) {

        for (int i = 0; i < gatesLvl.size(); ) {
            gatesLvl.get(i).setTranslateX(gatesLvl.get(i).getTranslateX() - STEP_X);
            if (gatesLvl.get(i).getTranslateX() < -gatesLvl.get(i).getLongueur()) {
                root.getChildren().remove(gatesLvl.get(0));
                gatesLvl.remove(i);
            } else {i++;}
        }

        back.setTranslateX(back.getTranslateX()-STEP_X);

        gameController.setPosX(gameController.getPosX()+STEP_X);

    }


    public static void processCollision (Blob player, ArrayList<Plateforme> level, GameController gameController) {

        for (int i = 0; i < level.size(); i++) {       //0 plateforme actuelle  1plateforme suivante
                if (player.getBoundsInParent().intersects(level.get(i).getBoundsInParent())) {


                    if (player.getVitesseY() <= 0) {
                        if (player.getTranslateY() <= (level.get(i).getTranslateY() - player.getVitesseY())) {
                            //le joueur marche sur la plateforme
                            player.setTranslateY(level.get(i).getTranslateY() - player.getTaille());   // on repositionne bien au dessus de la plateforme
                            player.setVitesseY(0);                                  // pas de chute
                            player.setAuSol(true);
                        } else { // contact par le coté
                            gameController.setGameSatus(-1);
                            }
                    }
                    else {
                        gameController.setGameSatus(-1);// contact par le bas
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
