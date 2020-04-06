package dimitri.towerdefense;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;

import java.util.List;

public class BasicAOETower extends Tower{
    AttackStrategy attackStrategy = new AreaOfEffectAttackStrategy();
    public BasicAOETower(Context context){
        new BitmapFactory();
        Bitmap unscaledBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.basic_tower);
        Bitmap scaledBitmap = Bitmap
                .createScaledBitmap(unscaledBitmap,
                        200, 200, false);
        this.setObjectBitmap(scaledBitmap);

        this.setLocation(new Point(100,50));
        this.setRange(50);
        this.setDamage(3);
        this.setAttackSpeed(100);
    }

    @Override
    void spawn(Point location) {
        this.setLocation(location);
    }

    @Override
    void attack(List<Enemy> enemies)
    {
        attackStrategy.attack(this, enemies);
    }

    @Override
    void draw(Canvas canvas, Paint paint) {
        canvas.drawBitmap(this.getObjectBitmap(), this.getLocation().x, this.getLocation().y, paint);
    }
}