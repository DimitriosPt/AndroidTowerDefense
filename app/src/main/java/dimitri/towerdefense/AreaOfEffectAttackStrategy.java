package dimitri.towerdefense;

import android.graphics.PointF;

import java.util.ArrayList;
import java.util.List;

public class AreaOfEffectAttackStrategy implements AttackStrategy {
    @Override
    public void attack(Tower tower, List<Enemy> enemies) {

        for(Enemy enemy:enemies) {

            if (tower.isInRange(enemy))
            {
                enemy.setCurrentHealth(enemy.getCurrentHealth() - tower.getDamage());
            }
        }
        tower.setTimeOfLastAttack(System.currentTimeMillis());
    }

    @Override
    public List<TowerProjectile> spawnProjectiles(PointF towerLocation, double heading, float range){
        System.out.println("Spawning AOE Projectiles");
        List<TowerProjectile> projectiles = new ArrayList<TowerProjectile>();

        //the math for projectile movement converts the heading assumes the input is radians
        //so to make it clear we are spawning every 60 degrees we show it here
        for (int i = 0; i < 6; i++) {
            projectiles.add(new TowerProjectile(20, (int) Math.toRadians(60 * i), range));
        }

        for(TowerProjectile projectile : projectiles )
        {
            projectile.spawn(new PointF(towerLocation.x, towerLocation.y));
        }


        return (List<TowerProjectile>) projectiles;
    }
}
