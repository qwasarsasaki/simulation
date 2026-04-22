package actions.turn;

import actions.Action;
import map.Cords;
import map.GameMap;
import models.Creature;
import models.Entity;

import java.util.List;
import java.util.Map;

public class MoveCreaturesAction implements Action {
    @Override
    public void execute(GameMap map) {
        for (Map.Entry<Cords, Entity> entity : map.getAllEntries()) {
            Cords cords = entity.getKey();
            Entity currentEntity = entity.getValue();
            if (currentEntity instanceof Creature) {
                ((Creature) currentEntity).makeMove(map, cords);
            }
        }
    }
}
