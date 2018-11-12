package edu.wwu.csci412.a4;

import android.content.Context;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;


public class GameInterface extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //View view = inflater.inflate(R.layout.fragment_game_interface, container, false);
        return new GameView(getActivity());
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





}
