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
        gc = new GameController();
        gs = new GameStatus();

        /* pass information and update fragments */
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        FragmentManager fm = getSupportFragmentManager();
                        FragmentTransaction ft = fm.beginTransaction();
                        /* player hit play button */
                        if (gc.playGame){
                            if (fm.findFragmentById(R.id.gameinterface) == null) {
                                gi = new GameInterface();
                                ft.add(R.id.gameinterface, gi);
                                ft.commit();
                            }
                            play();
                        }
                        /* player hit stop button or hasn't started game */
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

        /* update score and player status */
        if (interfaceFrag != null) {
            /* set score */
            Score.setText(Integer.toString(interfaceFrag.getGame().bricksLeft));
            /* pause game */
            if (gc.pause){
                gi.getGame().pause = true;
            }
            /* unpause game */
            else {
                gi.getGame().pause = false;
                /* player won */
                if (interfaceFrag.getGame().playerWon()) {
                    PlayerStatus.setText("Player Won");
                }
                /* player lost or currently playing*/
                else {
                    if (interfaceFrag.getGame().playerLost()) {
                        PlayerStatus.setText("Player Lost");
                        if (interfaceFrag != null) {
                            FragmentTransaction ft = fm.beginTransaction();
                            ft.remove(interfaceFrag).commit();
                            gc.playGame = false;
                        }
                    } else {
                        PlayerStatus.setText(gi.getGame().playerStatus);
                    }
                }
            }
        }
    }
}
