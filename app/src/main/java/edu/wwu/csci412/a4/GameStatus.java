package edu.wwu.csci412.a4;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class GameStatus extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        /* Inflate the layout for this fragment */
        View v = inflater.inflate(R.layout.fragment_game_status, container, false);
        Toolbar toolbar = (Toolbar) v.findViewById(R.id.gamestatus);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        return v;
    }

}
