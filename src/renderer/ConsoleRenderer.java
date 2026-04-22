package renderer;

import map.Cords;
import map.GameMap;
import models.*;

import java.util.HashMap;
import java.util.Map;

public class ConsoleRenderer implements Renderer {
    private static final Map<Class<?>, String> SYMBOLS = new HashMap<>();
    static {
        SYMBOLS.put(Grass.class, " w");
        SYMBOLS.put(Rock.class, " o");
        SYMBOLS.put(Tree.class, " i");
        SYMBOLS.put(Herbivore.class, " H");
        SYMBOLS.put(Predator.class, " P");
    }

    @Override
    public void render(GameMap map) {
        int width = map.getWidth();
        int height = map.getHeight();

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                Cords currentCords = new Cords (x, y);
                if (map.isEmpty(currentCords)) {
                    System.out.print(" .");
                } else {
                    Entity currentEntity = map.getEntity(currentCords);
                    String symbol = SYMBOLS.get(currentEntity.getClass());
                    System.out.print(symbol);
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}