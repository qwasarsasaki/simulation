package actions.init;

import actions.Action;
import map.Cords;
import map.GameMap;
import models.Grass;
import models.Herbivore;

import java.util.Random;

public class SpawnHerbivoreAction implements Action {
    private Random random = new Random();

    @Override
    public void execute(GameMap map) {
        for (int attempt = 0; attempt < 5; attempt++) {
            int x = random.nextInt(map.getWidth());
            int y = random.nextInt(map.getHeight());
            int hp = random.nextInt(7) + 15;
            int speed = random.nextInt(2) + 1;
            Cords cord = new Cords(x, y);

            if (map.isEmpty(cord)) {
                map.addEntity(cord, new Herbivore(speed, hp));
                return;
            }
        }
    }
}
