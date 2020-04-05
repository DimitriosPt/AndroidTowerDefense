package dimitri.towerdefense;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.BitmapFactory;
import android.util.DisplayMetrics;

import java.util.ArrayList;
import java.util.List;

class Human extends Enemy {
    Human(Context context, int health, int speed, List<damageResistances> resistances) {
        super(context, health, speed, resistances);

        new BitmapFactory();
        this.setObjectBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.human));
        this.setLocation(new Point(0,0));
    }


    @Override
    void move() {
        Point newLocation = this.getLocation();

        switch (this.getHeading()) {
            case NORTH:
                newLocation.y += this.getSpeed();
                this.setLocation(newLocation);
                break;

            case EAST:
                newLocation.x += this.getSpeed();
                this.setLocation(newLocation);
                System.out.println("moving right");
                break;

            case SOUTH:
                newLocation.y -= this.getSpeed();
                this.setLocation(newLocation);
                break;

            case WEST:
                newLocation.x -= this.getSpeed();
                this.setLocation(newLocation);
                break;

        }
    }

    @Override
    void spawn(Point location) {
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        int blockSize = displayMetrics.widthPixels / 40;
        // How many blocks of the same size will fit into the height
        int mNumBlocksHigh = displayMetrics.heightPixels / blockSize;
        // Reset the heading
        this.setHeading(EAST);

        // Start with a single snake segment
        this.setLocation(new Point(30, mNumBlocksHigh / 2));
    }

    @Override
    void draw(Canvas canvas, Paint paint) {
        canvas.drawBitmap(this.getObjectBitmap(), this.getLocation().x, this.getLocation().y, paint);
    }
}
