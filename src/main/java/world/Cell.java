package world;

import java.util.Comparator;

/**
 * Created by eptwalabha on 17/04/14.
 */
public class Cell {

    private int value;
    private int y;
    private int x;

    public Cell(int value, int x, int y) {
        this.value = value;
        this.x = x;
        this.y = y;
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
}
