package utils;

import map.Cords;
import map.GameMap;
import models.Creature;
import models.Entity;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class PathFinder {

    public PathFinder() {

    }

    public Cords findPath(GameMap map, Cords start, Class<? extends Entity> targetType) {
        int width = map.getWidth();
        int height = map.getHeight();

        boolean[][] visited = new boolean[width][height];
        Queue<Cords> queue = new LinkedList<>();
        Map<Cords, Cords> cameFrom = new HashMap<>();  // запоминаем, откуда пришли

        queue.add(start);
        visited[start.getX()][start.getY()] = true;
        cameFrom.put(start, null);

        while (!queue.isEmpty()) {
            Cords current = queue.poll();

            // Проверяем, является ли текущая клетка целью
            Entity entity = map.getEntity(current);
            if (entity != null && targetType.isInstance(entity)) {
                // Нашли траву! Возвращаем предыдущую клетку (ту, с которой пришли)
                return cameFrom.get(current);
            }

            for (Cords neighbor : current.getNeighbors(width, height)) {
                if (!visited[neighbor.getX()][neighbor.getY()]) {
                    Entity neighborEntity = map.getEntity(neighbor);

                    // Можно идти, если клетка пустая или это цель
                    if (neighborEntity == null || targetType.isInstance(neighborEntity)) {
                        visited[neighbor.getX()][neighbor.getY()] = true;
                        queue.add(neighbor);
                        cameFrom.put(neighbor, current);  // запоминаем путь
                    }
                }
            }
        }
        return null;  // путь не найден
    }
}
