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

    }



    public static void processLevel(ArrayList<Plateforme> gatesLvl, Background back, GameController gameController, Pane root, int STEP_X) {

        for (int i = 0; i < gatesLvl.size()-1; ) {
            gatesLvl.get(i).setTranslateX(gatesLvl.get(i).getTranslateX() - STEP_X);
            if (gatesLvl.get(i).getTranslateX() < -gatesLvl.get(i).getLongueur()) {
                gameController.setNextPlateforme(gameController.getNextPlateforme() + 1);
                root.getChildren().remove(gatesLvl.get(0));
                gatesLvl.remove(i);
            } else {i++;}
        }

        back.setTranslateX(back.getTranslateX()-STEP_X);

        gameController.setPosX(gameController.getPosX()+STEP_X);

    }


    public static void processCollision (Blob player, ArrayList<Plateforme> gatesLvl, GameController gameController) {
            for (int i = 0; i < 2; i++) {       //0 plateforme actuelle  1plateforme suivante
                if (player.getBoundsInParent().intersects(gatesLvl.get(i).getBoundsInParent())) {

                    System.out.println("process");
                    if (player.getVitesseY() < 0) {
                        if (player.getTranslateY() <= (gatesLvl.get(i).getTranslateY() - player.getVitesseY())) {
                            //le joueur marche sur la plateforme
                            player.setTranslateY(gatesLvl.get(i).getTranslateY() - player.getTaille());   // on repositionne bien au dessus de la plateforme
                            player.setVitesseY(0);                                  // pas de chute
                        } else { // perdu
                            gameController.setGameSatus(-1);
                        }
                    }
                }
            }



            if (player.getTranslateY()>800){
                gameController.setGameSatus(-1);   //perdu
            }
    }






}
