package edu.wwu.csci412.a4;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Point;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.Timer;


public class GameInterface extends Fragment {
    private GameView gv;
    private Game game;


    // private GestureDetector gestures;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        /* move bat */
        gv.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_MOVE) {
                    updateBat(event);
                }
                return true;
            }
        });
        return gv;
    }
    public void updateBat(MotionEvent event){
        float x = event.getX();
        /* update view and game coords of bat */
        gv.batStopX = (gv.batStopX-gv.batStartX) + (int)x;
        gv.batStartX = (int)x;
        game.batStopX =  gv.batStopX;
        game.batStartX = gv.batStartX;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /* view setup */
        Resources res = getResources( );
        int statusBarHeight = 0;
        int statusBarId = res.getIdentifier( "status_bar_height", "dimen", "android" );
        if( statusBarId > 0 ) {
            statusBarHeight = res.getDimensionPixelSize(statusBarId);
        }
        Point size = new Point( );
        getActivity().getWindowManager().getDefaultDisplay( ).getSize( size );
        gv = new GameView(getActivity(), size.x, size.y - statusBarHeight );


        /* timer setup */
        Timer gt = new Timer();
        gt.schedule(new GameTimerTask(gv),0,gv.GAME_SPEED);

        /* game and touch setup */
        game = gv.getGame();
        //TouchHandler th = new TouchHandler();

        //gestures = new GestureDetector(this, th);
        //gestures.setBat

    }

    public void addBricks() {

    }
    public void addBall() {

    }
    public void addBat() {

    }

    /*
    @Override
    public void onCreate(Bundle savedInstanceState) {

    }
*/


    public Game getGame(){
        return this.game;
    }
}
