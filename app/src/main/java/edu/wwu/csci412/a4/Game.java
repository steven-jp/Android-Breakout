package edu.wwu.csci412.a4;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.media.SoundPool;
import android.util.Log;
import android.widget.Toast;

import static java.security.AccessController.getContext;

public class Game {
    /* bat location */
    public int batStartX;
    public int batStartY;
    public int batStopX;
    public int batStopY;
    public Rect batRect;
    /* ball location and interactions */
    private boolean ballStarted;
    public Point ballCenter;
    public int ballRadius;
    public int batWidth;
    private int ballSpeed;
    private float ballAngle;
    private String direction;
    /* screen */
    private int screenHeight;
    private int screenWidth;
    /* bricks */
    public int bricks;
    public int bricksLeft;
    public Rect[][] allBricks;
    /* Play/pause/Stop */
    public String playerStatus;
    /* sounds */
    private SoundPool pool;
    private int brickSound;
    private int batSound;
    private Context context;



    public Game(Context context, int ballSpeed, int screenWidth, int screenHeight, int bricks) {
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        ballStarted = false;
        this.ballSpeed = ballSpeed;
        ballAngle = (float) ((Math.random() * 3 + 1) * (Math.PI/6));
        direction = "PosNeg";
        playerStatus = "playing";
        this.bricks = bricks;
        bricksLeft = bricks;
        this.context = context;
        /* sound setup */
        SoundPool.Builder pb = new SoundPool.Builder();
        pb.setMaxStreams(2);
        pool = pb.build();
        brickSound = pool.load(context,R.raw.brick,1);
        batSound = pool.load(context,R.raw.bat,1);

    }

    public boolean isBallStarted(){
        return ballStarted;
    }

    /* needs work */
    public void moveBall() {
        ballStarted = true;
        switch(direction) {
            case "PosNeg":
                ballCenter.x += ballSpeed * Math.cos(ballAngle);
                ballCenter.y -= ballSpeed * Math.sin(ballAngle);
                break;
            case "NegNeg":
                ballCenter.x -= ballSpeed * Math.cos(ballAngle);
                ballCenter.y -= ballSpeed * Math.sin(ballAngle);
                break;
            case "NegPos":
                ballCenter.x -= ballSpeed * Math.cos(ballAngle);
                ballCenter.y += ballSpeed * Math.sin(ballAngle);
                break;
            case "PosPos":
                ballCenter.x += ballSpeed * Math.cos(ballAngle);
                ballCenter.y += ballSpeed * Math.sin(ballAngle);
                break;
        }
    }



    public void setBallSpeed() {

    }
    public void updateBat(){
        batRect.left = batStartX;
        batRect.right = batStopX;
        batRect.top = batStartY;
        batRect.bottom = batStopY;
    }
    public void setBat(int startx, int starty, int stopx, int stopy) {
        this.batStartX = startx;
        this.batStartY = starty;
        this.batStopX = stopx;
        this.batStopY = stopy;
        batRect = new Rect(batStartX,batStartY,batStopX,batStopY);
    }

    /* maybe half circle and whatever range it intersects it goes to opposite */
    public void newBallDirection(){
        /* calc new angle */

        /* update ball coords based on direction it was going */
        switch(direction) {
            case "PosNeg":
                ballAngle += 90;
                direction = "NegNeg";
                break;
            case "NegNeg":
                ballAngle -= 90;
                direction = "NegPos";
                break;
            case "NegPos":
                ballAngle += 90;
                direction = "PosPos";
                break;
            case "PosPos":
                ballAngle -= 90;
                direction = "PosNeg";
                break;
        }
//        if (ballAngle <= 90) {
//            ballAngle += 90;
//            direction = "PosNeg";
//        }
//        else if (ballAngle >= 90 && ballAngle <= 180) {
//            ballAngle -= 90;
//            direction = "NegNeg";
//        }
//        else if (ballAngle >= 180 && ballAngle <= 270) {
//            ballAngle += 90;
//            direction = "NegPos";
//        }
//        else {
//            ballAngle -= 90;
//            direction = "PosPos";
//        }

    }
    public boolean ballHitBrick() {
    //play sound
        for (int i = 0; i < allBricks.length; i++) {
            for (int j = 0; j < allBricks[i].length; j++) {
                if (allBricks[i][j] != null && allBricks[i][j].intersects(ballCenter.x-ballRadius,ballCenter.y-ballRadius,
                        ballCenter.x+ballRadius,ballCenter.y+ballRadius)) {
                    allBricks[i][j] = null;
                    bricksLeft--;
                    pool.play(brickSound,1.0f,1.0f,1,0,1);
                    return true;
                }
            }
        }
        return false;
    }
    public boolean ballHitBat() {
        Rect rect = new Rect(batStartX,batStartY,batStopX,batStopY);
        if (rect.intersects(ballCenter.x-ballRadius,ballCenter.y-ballRadius,
                ballCenter.x+ballRadius,ballCenter.y+ballRadius)){
            pool.play(batSound,1.0f,1.0f,1,0,1);
            return true;
        }

        return false;
    }
    public boolean ballHitWall(){
        if (ballCenter.x+ballRadius >= screenWidth || ballCenter.x+ballRadius <= 0 || ballCenter.y+ballRadius <= 0) {
            return true;
        }
        return false;
    }
    public boolean playerLost(){
        if (ballCenter.y >= screenHeight) {
            return true;
        }
        return false;
    }
    public boolean playerWon(){
        if (bricksLeft == 0){
            return true;
        }
        return false;
    }



}
