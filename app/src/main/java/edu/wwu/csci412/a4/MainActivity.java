package edu.wwu.csci412.a4;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Timer;
import java.util.TimerTask;

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


        gc = new GameController();
        gs = new GameStatus();



        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        FragmentManager fm = getSupportFragmentManager();
                        FragmentTransaction ft = fm.beginTransaction();
                        Log.w("ahhhh","here");

                        if (gc.playGame){
                            Log.w("ahhhh",gc.playGame + "");
                            if (fm.findFragmentById(R.id.gameinterface) == null) {
                                Log.w("ahhhh","here2");
                                gi = new GameInterface();
                                ft.add(R.id.gameinterface, gi);
                                ft.commit();
                            }
                            play();
                        }

                        else {
                            if (fm.findFragmentById(R.id.gameinterface) != null) {
                                ft.remove(fm.findFragmentById(R.id.gameinterface)).commit();
                            }
                        }

                    }
                });
            }
        }, 500,500);



    }

    public void play(){
        FragmentManager fm = getSupportFragmentManager();
        /* fragments */
        GameInterface interfaceFrag = (GameInterface) fm.findFragmentById(R.id.gameinterface);
        GameStatus statusFrag = (GameStatus) fm.findFragmentById(R.id.gamestatus);
        GameController controllerFrag = (GameController) fm.findFragmentById(R.id.gamecontroller);
        /* game status view */
        View statusView = statusFrag.getView();
        TextView Score = statusView.findViewById(R.id.currentscorevalue);
        TextView PlayerStatus = statusView.findViewById(R.id.playerstatusvalue);

        /* player has hit play button */
      //  if (controllerFrag.playGame) {



        /* update score and player status */
        if (interfaceFrag != null) {
            if (interfaceFrag.getGame() != null) {
                Score.setText(Integer.toString(interfaceFrag.getGame().bricksLeft));
            }

            if (interfaceFrag.getGame().playerWon()) {
                PlayerStatus.setText("Player Won");
            } else {
                if (interfaceFrag.getGame().playerLost()) {
                    PlayerStatus.setText("Player Lost");
                    // remove fragment
                } else {
                    PlayerStatus.setText("Playing");
                }
            }
        }
}



}
