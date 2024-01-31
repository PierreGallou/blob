package POJO;

public class GameController {



    private int gameSatus;
    private int posX;
    private int nextPlateforme;

    public int getGameSatus() {return gameSatus;}

    public void setGameSatus(int gameSatus) {
        this.gameSatus = gameSatus;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getNextPlateforme() {
        return nextPlateforme;
    }

    public void setNextPlateforme(int nextGate) {
        this.nextPlateforme = nextGate;
    }





    public GameController(int posInit){
        this.gameSatus=0;
        this.posX=posInit;
        this.nextPlateforme=0;
    }






}
