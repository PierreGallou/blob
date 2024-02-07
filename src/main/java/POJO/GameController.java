package POJO;

public class GameController {

    private int gameSatus;

    private long frameTime;

    public int getGameSatus() {return gameSatus;}
    public void setGameSatus(int gameSatus) {
        this.gameSatus = gameSatus;
    }


    public long getFrameTime() {return frameTime;}
    public void setFrameTime(long frameTime) {this.frameTime = frameTime;}


    public GameController(){
        this.gameSatus=0;
        this.frameTime=System.nanoTime();
    }




}
