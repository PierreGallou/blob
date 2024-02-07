package util;

import POJO.Plateforme;

import java.util.ArrayList;

public abstract class InitLvl {

    public static ArrayList<Plateforme> LvlGenerate(int nbPlateforme, int hWindow , int pSizeVar, int epaisseur, int pSizeMin) {

        ArrayList<Plateforme> PlateformeList=new ArrayList<>();
        int posX=0;

        //placement de la 1ere plateforme au centre de l'écran
        Plateforme startPlateforme= new Plateforme(hWindow/2, pSizeMin,0 ,epaisseur);
        PlateformeList.add(startPlateforme);

        posX=posX+startPlateforme.getLongueur();


        // génération aléatoire des autres plateformes
        for (int i=1;i<nbPlateforme;i++){

            int randHauteur=(int)(Math.random()*600);
            if (PlateformeList.get(i-1).getTranslateY()-(randHauteur)>300)
            {randHauteur=(int)PlateformeList.get(i-1).getTranslateY()-300;}     //on limite a 300 le décallage max pour rester jouable

            int randLongueur=(int)(Math.random()*pSizeVar+pSizeMin);

            Plateforme plateformeTmp=new Plateforme(randHauteur,randLongueur,posX,epaisseur);
            PlateformeList.add(plateformeTmp);

            posX=posX+plateformeTmp.getLongueur();

        }





        return  PlateformeList;
    }
}
