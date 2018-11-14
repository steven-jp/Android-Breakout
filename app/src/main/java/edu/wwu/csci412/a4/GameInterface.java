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
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;


public class GameInterface extends Fragment {
    private GameView gv;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_game_interface, container, false);
        //View v = inflater.inflate(R.layout.fragment_game_interface, container, false);
        Resources res = getResources( );
        int statusBarHeight = 0;
        int statusBarId = res.getIdentifier( "status_bar_height", "dimen", "android" );
        if( statusBarId > 0 ) {
            statusBarHeight = res.getDimensionPixelSize(statusBarId);
        }
        Point size = new Point( );
        getActivity().getWindowManager().getDefaultDisplay( ).getSize( size );

        /* gestures here  ====================================================== */

        /* ====================================================== */

        return (new GameView(getActivity(), size.x, size.y - statusBarHeight ));
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


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
    private class TouchHandler extends GestureDetector.SimpleOnGestureListener {
     public TouchHandler() {

     }

    }
}
