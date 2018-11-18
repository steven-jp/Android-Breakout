package edu.wwu.csci412.a4;

import android.graphics.Point;

public class Game {
    public float batStartX;
    public float batStartY;
    public float batStopX;
    public float batStopY;
    private boolean ballStarted;
    public Point ballCenter;
    public float ballRadius;
    private int ballSpeed;
    private float ballAngle;


    public Game(int ballSpeed) {
        ballStarted = false;
        this.ballSpeed = ballSpeed;
        ballAngle = (float) ((Math.random() * 5 + 1) * (Math.PI/6));
    }

    public boolean isBallStarted(){
        return ballStarted;
    }

    public boolean ballOffScreen(){
        return false;
    }

    public void moveBall() {
        ballStarted = true;
        ballCenter.x += ballSpeed * Math.cos(ballAngle);
        ballCenter.y -= ballSpeed * Math.sin(ballAngle);
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

    }
    public boolean ballHitBrick() {
    //play sound
        return false;
    }
    public boolean ballHitBat() {
    // play sound
        return false;
    }




}
