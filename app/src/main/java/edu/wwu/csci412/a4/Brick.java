package edu.wwu.csci412.a4;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

import java.util.Random;

public class Brick extends View {

    public Brick(Context context){
        super(context);
    }

    @Override
    public void onDraw(Canvas canvas){
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        /* randomize brick colors */
        int randNum = (int)(Math.random() * 3 + 1);
        switch(randNum) {
            case  1:
                paint.setColor(Color.RED);
                break;
            case  2:
                paint.setColor(Color.GREEN);
                break;
            case  3:
                paint.setColor(Color.BLUE);
                break;
        }
        canvas.drawRect(100,100,100,100, paint);
    }


}
