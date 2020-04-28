package dimitri.towerdefense;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.ArrayList;

public class Renderer {

    private Canvas canvas;
    private SurfaceHolder surfaceHolder;
    private Paint paint;

    Renderer(SurfaceView surfaceView) {
        surfaceHolder = surfaceView.getHolder();
        paint = new Paint();
    }

    void draw(ArrayList<GameObject> gameObjects, GameState gameState, HUD hud, ParticleSystem particleSystem) {

        if (surfaceHolder.getSurface().isValid()) {
            canvas = surfaceHolder.lockCanvas();
            canvas.drawColor(Color.argb(255, 0, 0, 0));
            Point displaySize = TowerDefense.getScreenSize();

//            new BitmapFactory();
//            Bitmap unscaledBitmap = BitmapFactory.decodeResource(TowerDefense.getContext().getResources(), R.drawable.background);
//            Bitmap scaledBitmap = Bitmap.createScaledBitmap(
//                    unscaledBitmap,
//                    displaySize.x,
//                    displaySize.y,
//                    false);
//            canvas.drawBitmap(scaledBitmap, 0, 0, null);

            if (gameState.getDrawing()) {

                for (GameObject gameObject : gameObjects) {
//                    System.out.println("Number of game objects: ");
//                    System.out.println(gameObjects.size());
//                    System.out.println(gameObject.checkActive());
                    if (gameObject.checkActive()) {
                        gameObject.draw(canvas, paint);
                        System.out.println(gameObject.toString());
                    }
                }

                if (particleSystem.isRunning) {
                    particleSystem.draw(canvas, paint);
                }
            }

            if(gameState.getGameOver()) {
            // Draw a background graphic here
                gameObjects.get(Level.BACKGROUND_INDEX)
                        .draw(canvas, paint);
            }

            hud.draw(canvas, gameState);
            surfaceHolder.unlockCanvasAndPost(canvas);
        }
    }
}

