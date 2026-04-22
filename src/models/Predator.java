package models;

import map.GameMap;
import map.Cords;
import utils.PathFinder;

public class Predator extends Creature {
    private int power;

    public Predator(int speed, int hp, int power) {
        super(speed, hp);
        this.power = power;
    }

    @Override
    public void makeMove(GameMap map, Cords currentCords) {
        PathFinder finder = new PathFinder();
        Cords grassCords = finder.findPath(map, currentCords, Herbivore.class);
        if (grassCords == null) {
            return;
        }
        if (currentCords.getDist(grassCords) <= getSpeed()) {
            map.moveEntity(currentCords, grassCords);
        } else {
            if (Math.abs(grassCords.getX() - currentCords.getX()) - getSpeed() < 0) {
                int newX = grassCords.getX();
                int newY = getSpeed() - Math.abs(grassCords.getX() - currentCords.getX());
                Cords newCords = new Cords(newX, newY);
                map.moveEntity(currentCords, newCords);
            }
        }
    }
}
