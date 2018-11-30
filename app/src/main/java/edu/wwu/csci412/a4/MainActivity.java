package edu.wwu.csci412.a4;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
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

        FragmentManager fm = getSupportFragmentManager();       // added this
        if (gc.readyToPlay && fm.findFragmentById(R.id.gameinterface) != null) {
            FragmentTransaction ft = fm.beginTransaction();
            gi = new GameInterface();
            ft.add(R.id.gameinterface, gi);
            ft.commit();
        }
        play();
    }

    public void play(){
    //        /* update score and player status */
//        FragmentManager fm = getSupportFragmentManager();
//        //Fragment frag = (Fragment);
//        GameInterface frag = (GameInterface) fm.findFragmentById(R.id.gameinterface);
//        //View fragView = frag.getView();
//        TextView Score = findViewById(R.id.currentscorevalue);
//        TextView PlayerStatus = findViewById(R.id.playerstatusvalue);
//        if (frag.getGame() != null) {
//            Score.setText(Integer.toString(frag.getGame().bricksLeft));
//        }
//        if (frag.getGame().bricksLeft == 0){
//            // set you won
//           // PlayerStatus.setText();
//        }
//        else {
//            // you lose
//           // PlayerStatus.setText();
//        }


        /* update score and player status */

//        Timer timer = new Timer();
//        TimerTask task = new TimerTask() {
//            @Override
//            public void run() {
//                FragmentManager fm = getSupportFragmentManager();
//                GameInterface frag = (GameInterface) fm.findFragmentById(R.id.gameinterface);
//                TextView Score = findViewById(R.id.currentscorevalue);
//                TextView PlayerStatus = findViewById(R.id.playerstatusvalue);
//
//                if (frag.getGame() != null) {
//                    Score.setText(Integer.toString(frag.getGame().bricksLeft));
//                }
//                if (frag.getGame().bricksLeft == 0){
//                    // set you won
//                    // PlayerStatus.setText();
//                }
//                else {
//                    // you lose
//                    // PlayerStatus.setText();
//                }
//            }
//        };
//        timer.schedule(task,500,1000);
}



}
