package com.begin.blobfx;

import POJO.Background;
import POJO.Blob;
import POJO.GameController;
import POJO.Plateforme;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import util.GameProcessor;
import util.InitLvl;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

public class BlobApplication extends Application {


    private final int PLATEFORM_SIZE_VARIABLE = 1000;
    private final int PLATEFORM_SIZE_MIN = 250;
    private final int PLATEFORM_H_MAX = 600;
    private final int PLATEFORM_EPAISSEUR = 100;
    private final int NB_PLATEFORME = 5;

    private final int JOUEUR_TAILLE = 50;
    private final int JOUEUR_JUMP_PWR = 25;
    private final int JOUEUR_VCHUTE_MAX = -20;

    private final int STEP_X = 5;
    private final int DELTAFRAME=10000000;
    private final int PARALLAX = 3;


    private Pane root = new Pane();
    private Blob player ;
    private Background back;
    private ArrayList<Plateforme> level ;
    private GameController gameController ;






    public static void main(String[] args) {
        launch();
    }


    @Override
    public void start(Stage stage) {
        AtomicReference<Scene> scene = new AtomicReference<>(new Scene(createContent()));

        scene.get().setOnKeyPressed(e -> {
            switch (e.getCode()) {
                case ENTER -> {
                    if (gameController.getGameSatus() == 0) {
                        gameController.setGameSatus(1);
                    } else {gameController.setGameSatus(0);}
                }
                case SPACE -> player.Jump();

                case TAB ->  createContent();

            }
        });
        stage.setScene(scene.get());
        stage.show();
    }


    private Parent createContent() {
       root.getChildren().clear();
       root.setPrefSize(800, 600);
       player = new Blob(1, JOUEUR_JUMP_PWR, 5, 200, JOUEUR_TAILLE,JOUEUR_VCHUTE_MAX);
       gameController = new GameController();
       level = InitLvl.LvlGenerate(NB_PLATEFORME, PLATEFORM_H_MAX, PLATEFORM_SIZE_VARIABLE,PLATEFORM_EPAISSEUR,PLATEFORM_SIZE_MIN);
       back=new Background((int)level.get(NB_PLATEFORME-1).getTranslateX()+level.get(NB_PLATEFORME-1).getLongueur()+800);
       root.getChildren().add(back);

        for (Plateforme plateforme : level) {
            root.getChildren().add(plateforme);
        }


        root.getChildren().add(player);


        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (GameProcessor.isNextFrame(gameController,DELTAFRAME)) {
                    update();
                }
            }
        };
        timer.start();
        return root;
    }


    private void update() {
        if (gameController.getGameSatus() == 1) {
            GameProcessor.processPlayer(player,level);
            GameProcessor.processLevel(level,back,root, STEP_X,PARALLAX);
            GameProcessor.processCollision(player,level,gameController );
            GameProcessor.processEnding(player,gameController,level,root);
        }
    }

}