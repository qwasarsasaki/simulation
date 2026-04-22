package map;

import models.Creature;

import java.util.ArrayList;
import java.util.List;

public class Cords {
    private int x;
    private int y;

    public Cords(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {return x; }
    public int getY() {return y; }

    public List<Cords> getNeighbors(int width, int height) {
        List<Cords> neighbors = new ArrayList<>();
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            if (newX >= 0 && newX < width && newY >= 0 && newY < height) {
                neighbors.add(new Cords(newX, newY));
            }
        }

        return neighbors;
    }

    public int getDist(Cords target) {
        return Math.abs(x - target.getX()) + Math.abs(y - target.getY());
    }

    private Cords moveTowards(Cords from, Cords to, int steps) {
        int dx = to.getX() - from.getX();
        int dy = to.getY() - from.getY();

        int newX = from.getX();
        int newY = from.getY();

        if (dx != 0) {
            newX += Integer.compare(dx, 0) * Math.min(steps, Math.abs(dx));
            steps -= Math.min(steps, Math.abs(dx));
        }

        if (dy != 0 && steps > 0) {
            newY += Integer.compare(dy, 0) * Math.min(steps, Math.abs(dy));
        }

        return new Cords(newX, newY);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Cords)) return false;
        Cords that = (Cords) obj;
        return that.getX() == x && that.getY() == y;
    }

    @Override
    public int hashCode() {
        return 31 * x + y;
    }
}
