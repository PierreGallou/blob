package util;

import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public abstract class Endings {

    public static void Perdu(Pane root){

        Text textePerdu=new Text(200,300,"PERDU!" );
        textePerdu.setFont(Font.font("stencil", FontWeight.BOLD, FontPosture.REGULAR, 100));
        textePerdu.setFill(Color.color(0.8, 0.8, 0.8));
        textePerdu.setStrokeWidth(6);
        textePerdu.setStroke(Color.color(0.2, 0.1, 0.1));

        DropShadow ombrage=new DropShadow();
        ombrage.setRadius(10.0);
        ombrage.setOffsetX(0);
        ombrage.setOffsetY(0);
        ombrage.setColor(Color.color(0.7, 0.7, 0.2));

        textePerdu.setEffect(ombrage);

        root.getChildren().add(textePerdu);



    }




    public static void Gagne(Pane root){

        Text textePerdu=new Text(200,300,"VICTOIRE!" );
        textePerdu.setFont(Font.font("stencil", FontWeight.BOLD, FontPosture.REGULAR, 100));
        textePerdu.setFill(Color.color(0.8, 0.8, 0.8));
        textePerdu.setStrokeWidth(6);
        textePerdu.setStroke(Color.color(0.2, 0.1, 0.1));

        DropShadow ombrage=new DropShadow();
        ombrage.setRadius(10.0);
        ombrage.setOffsetX(0);
        ombrage.setOffsetY(0);
        ombrage.setColor(Color.color(0.7, 0.7, 0.2));

        textePerdu.setEffect(ombrage);

        root.getChildren().add(textePerdu);



    }




}
