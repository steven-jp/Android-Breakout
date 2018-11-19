package edu.wwu.csci412.a4;

import android.graphics.Point;
import android.graphics.Rect;
import android.util.Log;
import android.widget.Toast;

import static java.security.AccessController.getContext;

public class Game {
    public float batStartX;
    public float batStartY;
    public float batStopX;
    public float batStopY;
    private boolean ballStarted;
    public Point ballCenter;
    public int ballRadius;
    public int batWidth;
    private int ballSpeed;
    private float ballAngle;
    private String direction;
    private int screenHeight;
    private int screenWidth;
    public int bricks;
    public int bricksLeft;
    public Rect[][] allBricks;



    public Game(int ballSpeed, int screenWidth, int screenHeight) {
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        ballStarted = false;
        this.ballSpeed = ballSpeed;
        ballAngle = (float) ((Math.random() * 3 + 1) * (Math.PI/6));
        direction = "PosNeg";
        bricksLeft = bricks;
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
    public void setBat(float startx, float starty, float stopx, float stopy) {
        this.batStartX = startx;
        this.batStartY = starty;
        this.batStopX = stopx;
        this.batStopY = stopy;
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
                    //Log.w("yaaaaa","in rect");
                    allBricks[i][j] = null;
                    return true;
                }
            }
        }
        return false;
    }
    public boolean ballHitBat() {
    // play sound
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
        return false;
    }



}
