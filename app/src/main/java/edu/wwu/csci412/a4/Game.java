package edu.wwu.csci412.a4;

public class Game {
    public float batStartX;
    public float batStartY;
    public float batStopX;
    public float batStopY;
    private boolean ballStarted;

    public Game() {
        ballStarted = false;
    }

    public boolean isBallStarted(){
        return ballStarted;
    }

    public boolean ballOffScreen(){
        return false;
    }

    public void moveBall() {
        ballStarted = true;
    }



    public void setBallSpeed() {

    }
    public void setBat(float startx, float starty, float stopx, float stopy) {
        this.batStartX = startx;
        this.batStartY = starty;
        this.batStopX = stopx;
        this.batStopY = stopy;
    }
    // set ball in center
    public void setBall() {

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
