package POJO;

public class GameController {



    private int gameSatus;
    private int posX;

    private long frameTime;

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



    public long getFrameTime() {return frameTime;}

    public void setFrameTime(long frameTime) {this.frameTime = frameTime;}

    public GameController(int posInit){
        this.gameSatus=0;
        this.posX=posInit;
        this.frameTime=System.nanoTime();
    }






}
