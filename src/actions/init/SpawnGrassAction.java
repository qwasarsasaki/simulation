package actions.init;

import actions.Action;
import map.Cords;
import map.GameMap;
import models.Grass;

import java.util.Random;

public class SpawnGrassAction implements Action {
    private Random random = new Random();

    @Override
    public void execute(GameMap map) {
        for (int attempt = 0; attempt < 5; attempt++) {
            int x = random.nextInt(map.getWidth());
            int y = random.nextInt(map.getHeight());
            Cords cord = new Cords(x, y);

            if (map.isEmpty(cord)) {
                map.addEntity(cord, new Grass());
                return;
            }
        }
    }
}
