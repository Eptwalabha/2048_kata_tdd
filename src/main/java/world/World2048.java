package world;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Eptwalabha
 * Date: 15/04/2014
 * Time: 21:51
 */
public class World2048 {

    public final int width;
    public final int height;
    protected List<Cell> cellList;

    public World2048() {
        this(4, 4);
    }

    public World2048(int width, int height) {
        this.width = width;
        this.height = height;
        cellList = new ArrayList<Cell>();
    }

    public void initialize() {
        addNewCellToWorld();
        addNewCellToWorld();
    }

    protected int getRandomValue() {
        return Math.random() <= 0.1 ? 4 : 2;
    }

    protected int getRandomPosition(int size) {
        return (int) (Math.random() * size);
    }

    protected boolean addNewCellToWorld() {
        if (cellList.size() == width * height)
            return false;
        cellList.add(new Cell(getRandomValue(), getRandomPosition(width), getRandomPosition(height)));
        return true;
    }

    public int getNumberOfCells() {
        return cellList.size();
    }

    public class Cell {

        public int value;
        public int y;
        public int x;

        public Cell(int value, int x, int y) {
            this.value = value;
            this.x = x;
            this.y = y;
        }

        public int getCellValue() {
            return value;
        }

        public int getPositionX() {
            return x;
        }

        public int getPositionY() {
            return y;
        }
    }
}
