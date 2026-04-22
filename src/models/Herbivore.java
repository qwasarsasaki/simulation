package models;

import map.Cords;
import map.GameMap;
import utils.PathFinder;

public class Herbivore extends Creature {

    public Herbivore(int speed, int hp) {
        super(speed, hp);
    }
    @Override
    public void makeMove(GameMap map, Cords currentCords) {
        PathFinder finder = new PathFinder();
        Cords grassCords = finder.findPath(map, currentCords, Grass.class);

        if (grassCords == null) {
            return;
        }

        if (currentCords.getDist(grassCords) <= getSpeed()) {
            map.moveEntity(currentCords, grassCords);
        } else {
            int dx = grassCords.getX() - currentCords.getX();
            int dy = grassCords.getY() - currentCords.getY();

            if (Math.abs(dx) - getSpeed() < 0) {
                int newX = grassCords.getX();
                int newY = currentCords.getY() + (int) Math.signum(dy) * (getSpeed() - Math.abs(dx));
                Cords newCords = new Cords(newX, newY);
                map.moveEntity(currentCords, newCords);
            } else {
                int newX = currentCords.getX() + (int) Math.signum(dx) * getSpeed();
                int newY = currentCords.getY();
                Cords newCords = new Cords(newX, newY);
                map.moveEntity(currentCords, newCords);
            }
        }

    }
}
