package edu.wwu.csci412.a4;

import java.util.TimerTask;

public class GameTimerTask extends TimerTask {
     private GameView gv;
     private Game game = null;

    public GameTimerTask(GameView gv){
        this.gv = gv;
        game = gv.getGame();

    }
    @Override
    public void run(){
        if (game != null) {
            game.moveBall();
        }
        if (game.ballHitWall() || game.ballHitBrick() || game.ballHitBat()) {
            game.newBallDirection();
        }
        if (game.playerWon()){
            game.playerStatus = "Player won";
        }
        if (game.playerLost()){
            game.playerStatus = "Player Lost";
        }


        gv.postInvalidate();
    }



}
