package world;

/**
 * Created by eptwalabha on 17/04/14.
 */
public class Cell {

    private int value;
    private int y;
    private int x;
    private boolean toRemoveFromWorld;

    public Cell(int value, int x, int y) {
        this.value = value;
        this.x = x;
        this.y = y;
        toRemoveFromWorld = false;
    }

    public int getValue() {
        return value;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean doCellOverlaps(Cell cell) {
        return x == cell.x && y == cell.y;
    }

    public void doubleValue() {
        value *= 2;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void removeFromWorld() {
        toRemoveFromWorld = true;
    }

    public boolean hasToBeRemoved() {
        return toRemoveFromWorld;
    }
}
