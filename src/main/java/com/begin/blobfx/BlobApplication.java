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
import util.Endings;
import util.GameProcessor;
import util.InitLvl;

import java.util.ArrayList;

public class BlobApplication extends Application {


    private final int PLATEFORM_SIZE_MAX = 1000;
    private final int PLATEFORM_H_MAX = 600;
    private final int PLATEFORM_EPAISSEUR = 100;
    private final int STEP_X = 3;
    private final int TAILLE_JOUEUR = 50;
    private final int NB_PLATEFORME = 10;



    private Pane root = new Pane();
    private Blob player = new Blob(1, 25, 20, 200, TAILLE_JOUEUR);
    private Background back;
    private ArrayList<Plateforme> level = new ArrayList<>();
    private GameController gameController = new GameController(0);






    public static void main(String[] args) {
        launch();
    }


    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(createContent());

        scene.setOnKeyPressed(e -> {
            switch (e.getCode()) {
                case ENTER -> {
                    if (gameController.getGameSatus() == 0) {
                        gameController.setGameSatus(1);
                    }
                }
                case SPACE -> {
                    if ((player.getVitesseY() <= 0) && (player.getVitesseY() >= -player.getMass())) {
                        player.setVitesseY(player.getJumpForce());
                    }
                }
            }
        });
        stage.setScene(scene);
        stage.show();
    }


    private Parent createContent() {

        root.setPrefSize(800, 600);

        level = InitLvl.LvlGenerate(NB_PLATEFORME, PLATEFORM_H_MAX, PLATEFORM_SIZE_MAX,PLATEFORM_EPAISSEUR);
        back=new Background((int)level.get(NB_PLATEFORME-1).getTranslateX()+level.get(NB_PLATEFORME-1).getLongueur()+800);
        root.getChildren().add(back);

        for (Plateforme plateforme : level) {
            root.getChildren().add(plateforme);
        }


        root.getChildren().add(player);
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                update();
            }
        };
        timer.start();
        return root;
    }


    private void update() {

        if (gameController.getGameSatus() == 1) {
            GameProcessor.processPlayer(player);
            GameProcessor.processLevel(level,back,gameController,root, STEP_X);
            GameProcessor.processCollision(player,level,gameController );
        }

        if (gameController.getGameSatus() ==-1) {
            Endings.Perdu(root);

        }


    }


}