package edu.wwu.csci412.a4;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class GameController extends Fragment {
    public static Boolean playGame = false;
    public static Boolean pause = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        /* Inflate the layout for this fragment */
        View v = inflater.inflate(R.layout.fragment_game_controller, container, false);
        Toolbar toolbar = (Toolbar) v.findViewById(R.id.gamecontroller);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);

        /* Buttons for displaying Game Interface */
        Button play =  v.findViewById(R.id.playbutton);
        Button pause = v.findViewById(R.id.pausebutton);
        Button stop = v.findViewById(R.id.stopbutton);
        play.setOnClickListener(listener);
        pause.setOnClickListener(listener);
        stop.setOnClickListener(listener);

        return v;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.playbutton:
                    /* to start fragment */
                    playGame = true;
                    break;
                case R.id.pausebutton:
                    /* to pause fragment */
                    if (pause && playGame){
                        pause = false;
                    }
                    else if (!pause && playGame) {
                        pause = true;
                    }
                    break;
                case R.id.stopbutton:
                    /* to remove fragment */
                    playGame = false;
                    break;
            }
        }
    };
}
