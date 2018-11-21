package edu.wwu.csci412.a4;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private GameController gc;
    private GameStatus gs;
    private GameInterface gi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);


        GameController gc = new GameController();
        GameStatus gs = new GameStatus();

        FragmentManager fm = getSupportFragmentManager();       // added this
        if (gc.readyToPlay && fm.findFragmentById(R.id.gameinterface) != null) {
            FragmentTransaction ft = fm.beginTransaction();
            GameInterface gi = new GameInterface();
            ft.add(R.id.gameinterface, gi);
            ft.commit();
        }
    }


//    public void chooseFragment() {
//        FragmentManager fm = getSupportFragmentManager();
//        FragmentTransaction ft = fm.beginTransaction();
//        ft.add()
//    }


}
