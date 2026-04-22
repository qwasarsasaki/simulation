package map;

import models.Creature;
import models.Entity;

import java.util.*;

public class GameMap {
    private int width;
    private int height;
    private Map<Cords, Entity> data;

    public GameMap(int width, int height) {
        this.width = width;
        this.height = height;
        data = new HashMap<Cords, Entity>();
    }

    public int getWidth() { return width; }
    public int getHeight() { return height; }

    public void addEntity(Cords cords, Entity entity) {
        data.put(cords, entity);
    }

    public void moveEntity(Cords from, Cords to) {
        Entity entity = data.remove(from);
        if (entity != null) {
            data.put(to, entity);
        }
    }

    public Entity getEntity(Cords cords) {
        return data.get(cords);
    }

    public void removeEntity(Cords cords) {
        data.remove(cords);
    }

    public boolean isEmpty(Cords cords) {
        return (null == data.get(cords));
    }

    public Set<Map.Entry<Cords, Entity>> getAllEntries() {
        return new HashSet<>(data.entrySet());
    }
}
