package dimitri.towerdefense;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PointF;
import android.view.SurfaceView;

import java.util.List;

public class AreaOfEffectTurret extends Tower  {
    public AreaOfEffectTurret(){
        Context newContext = TowerDefense.getContext();
        new BitmapFactory();
        Bitmap unscaledBitmap = BitmapFactory.decodeResource(newContext.getResources(), R.drawable.aoeturret);
        Bitmap scaledBitmap = Bitmap
                .createScaledBitmap(unscaledBitmap,
                        200, 200, false);
        this.setObjectBitmap(scaledBitmap);

        this.setLocation(new PointF(100,50));
        this.setRange(600);
        this.setDamage(7);
        this.setAttackSpeed(700);
        this.attackStrategy = new AreaOfEffectAttackStrategy();
    }

    @Override
    void spawn(PointF location) {
        this.setLocation(location);
    }


    @Override
    void draw(Canvas canvas, Paint paint) {
        canvas.drawBitmap(this.getObjectBitmap(), this.getLocation().x, this.getLocation().y, paint);
    }
}
