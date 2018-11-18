package edu.wwu.csci412.a4;

import java.util.TimerTask;

public class GameTimerTask extends TimerTask {
     private GameView gv;
     private Game game;

    public GameTimerTask(GameView gv){
        this.gv = gv;
        gv.getGame();

    }
    @Override
    public void run(){
       // game.moveBall();
//        if (game.ballOffScreen() || game.ballHitBrick() || game.ballHitBat()) {
//            game.newBallDirection();
//        }
        gv.postInvalidate();
    }



}
