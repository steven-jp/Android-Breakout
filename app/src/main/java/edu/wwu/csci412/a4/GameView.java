package edu.wwu.csci412.a4;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class GameView extends View {
    private int height;

    public GameView(Context context) {
        super(context);
    }
    @Override
    public void onDraw(Canvas canvas){
        super.onDraw(canvas);
        canvas.drawRect(100,100,100,100, brickColor());
       // canvas.drawLine();
       // canvas.drawCircle();
    }






    public Paint brickColor() {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
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
        return paint;
    }

}