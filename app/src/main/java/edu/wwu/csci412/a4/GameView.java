package edu.wwu.csci412.a4;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;
import android.widget.Toast;

public class GameView extends View {
    private int height;
    private int width;
    private Game game;


    public GameView(Context context, int width, int height) {
        super(context);
        this.width = width;
        this.height = height;
        game = new Game();
    }
    @Override
    public void onDraw(Canvas canvas){
        super.onDraw(canvas);
        canvas.drawColor(Color.BLACK);
        drawBricks(canvas, 30);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.WHITE);
        paint.setStrokeWidth(30);
        canvas.drawLine(width/3,height-(height/8),width-(width/3),height-(height/8),paint);
//        Toast.makeText(getContext(),
//                "This is a message displayed in a Toast",
//                Toast.LENGTH_SHORT).show();
       // canvas.drawLine();
       // canvas.drawCircle();
    }

    public void drawBricks(Canvas canvas, int brickCount) {
        /* brick dimensions */
        int brickHeight = 80;
        int brickWidth = 200;
        /* where we can start placing the bricks */
        int bricksWidthStart = 40;
        int bricksWidthEnd = width-40;
        /* how far down we can go */
        int bricksHeightStart = 100;
        int bricksHeightEnd = height-300;
        /* number of bricks we can fit in each row and column */
        int maxPerRow = (bricksWidthEnd-bricksWidthStart) / brickWidth;
        int maxPerCol = height/brickHeight;

        /* draw the bricks */
        int row, col;
        row = 0;
        for (int i = 0; i < brickCount; i+=maxPerRow) {
            col = 0;
            for (int j = 0; j < maxPerRow; j++){
                canvas.drawRect(bricksWidthStart+col,bricksHeightStart+row,brickWidth+col,brickHeight+row,brickColor());
                col += brickWidth;
            }
            row += brickHeight;
        }


    }



    private Paint brickColor() {
        Paint paint = new Paint();
        paint.setAntiAlias(true);

        switch((int)(Math.random() * 3 + 1)) {
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