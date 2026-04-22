package models;

import map.GameMap;
import map.Cords;

public abstract class Creature extends Entity {
    private int speed;
    private int hp;

    public int getHp() { return hp; }

    public int getSpeed() { return speed; }

    public void setHp(int hp) {
        this.hp = Math.max(0, hp);
    }

    public Creature(int speed, int hp) {
        this.speed = speed;
        this.hp = hp;
    }

    public abstract void makeMove(GameMap map, Cords currentCords);
}
