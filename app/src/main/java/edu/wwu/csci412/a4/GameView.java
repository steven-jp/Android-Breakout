package edu.wwu.csci412.a4;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.support.constraint.solver.widgets.Rectangle;
import android.view.View;
import android.widget.Toast;

public class GameView extends View {
    private int height;
    private int width;
    private Game game;
    public int GAME_SPEED = 100;
    /* location of bat */
    public int batStartX;
    public int batStartY;
    public int batStopX;
    public int batStopY;

    @Override
    public boolean performClick() {
        super.performClick();
        return true;
    }

    public GameView(Context context, int width, int height) {
        super(context);
        this.width = width;
        this.height = height;
        game = new Game(context,90, this.width, this.height, 30, 3);
        /* setup and location of bat */
        batStartX = this.width/3;
        batStartY = this.height-(this.height/8);
        batStopX = this.width-(this.width/3);
        batStopY = this.height-(this.height/8)+30;
        game.setBat(batStartX,batStartY,batStopX,batStopY);
        /* setup and location of ball */
        game.ballCenter = new Point((width/2),(int)(batStartY - 100));
        game.ballStart = new Point((width/2),(int)(batStartY - 100));
        game.ballRadius = 30;
        game.batWidth = 30;
        /* create bricks */
        setUpBricks(game.bricks);
    }

    @Override
    public void onDraw(Canvas canvas){
        super.onDraw(canvas);
        /* drawing of brick, bat, and ball */
        canvas.drawColor(Color.BLACK);
        drawBricks(canvas);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.WHITE);
        canvas.drawRect(game.batRect,paint);
        paint.setStrokeWidth(game.ballRadius);
        canvas.drawCircle(game.ballCenter.x, game.ballCenter.y,game.ballRadius,paint);
    }

    public void setUpBricks(int brickCount) {
        /* brick dimensions */
        int brickHeight = 120;
        int brickWidth = 200;
        /* where we can start placing the bricks */
        int bricksWidthStart = 200;
        int bricksHeightStart = 100;
        /* number of bricks we can fit in each column */
        int maxPerCol = 5;
        int spaceBetween = 10;
        /* spaces each brick width and height by its size */
        int row = 0, col = 0;

        /* draw the bricks */
        game.allBricks = new Rect[brickCount/maxPerCol][maxPerCol];
        for (int i = 0; i < brickCount/maxPerCol; i++) {
            col = 0;
            for (int j = 0; j < maxPerCol; j++){
                game.allBricks[i][j] = new Rect(bricksWidthStart+col,bricksHeightStart+row,bricksWidthStart+brickWidth+col,bricksHeightStart+brickHeight+row);
                col += brickWidth+spaceBetween;
            }
            row += brickHeight+spaceBetween;
        }
    }

    public void drawBricks(Canvas canvas) {
        /* draw/keep original positions of bricks on screen */
        for (int i = 0; i < game.allBricks.length; i++) {
            for (int j = 0; j < game.allBricks[i].length; j++) {
                /* hasn't already been hit */
                if (game.allBricks[i][j] != null) {
                    canvas.drawRect(game.allBricks[i][j], brickColor());
                }
            }
        }
    }


    /* randomize brick colors */
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

    public Game getGame(){
        return this.game;
    }

}