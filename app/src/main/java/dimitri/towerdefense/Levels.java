package dimitri.towerdefense;

import android.content.Context;
import android.graphics.Point;
import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

// Will instantiate all of the objexts that are being passed in
// Will also randomly choose which kind of enemy will get instaniated ONLY ADDS ENEMIES
public  class Levels {
    Context context = TowerDefense.getContext();
    private List<GameObject> objects;
    private EnemyBuilder enemyBuilder;
    private int startingEnemyCount;
    private Base base;
    private MovementStrategy movementStrategy;
    private Background background;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public Levels(int level) {
        int randomNum;
        ArrayList<Enemy.damageResistances> resistance = new ArrayList<Enemy.damageResistances>();
        resistance.add(Enemy.damageResistances.FIRE);
        base=new Base();
        enemyBuilder = new EnemyBuilder();
        objects = new ArrayList<>();
        background = new Background(level);
        objects.add(background);
        objects.add(base);
        movementStrategy = new LevelOneEnemyMovement();
        for (startingEnemyCount = 0; startingEnemyCount < (int)(5* level*.7); startingEnemyCount++) {
            randomNum = ThreadLocalRandom.current().nextInt(10, 20);
            objects.add(enemyBuilder.Location(new Point(-500, 600)).
                    EnemyType("Human").EnemyHP(30)
                    .Speed(randomNum)
                    .EnemyResistances(resistance)
                    .MovementStrategy(movementStrategy)
                    .build());
        }

        for (startingEnemyCount = 0; startingEnemyCount < (int)(3*level*.7); startingEnemyCount++) {
            randomNum = ThreadLocalRandom.current().nextInt(20, 30);
            objects.add(enemyBuilder.Location(new Point(0, 0)).
                    EnemyType("Orc").EnemyHP(60)
                    .Speed(randomNum)
                    .EnemyResistances(resistance)
                    .MovementStrategy(movementStrategy)
                    .build());
        }

    }

    public List<GameObject> getObjects() {
        return objects;
    }
}
