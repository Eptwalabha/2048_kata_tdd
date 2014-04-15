package world;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Eptwalabha
 * Date: 15/04/2014
 * Time: 21:51
 */
public class World2048 {

    protected int width;
    protected int height;
    protected List<Cell> cellList;

    public World2048(int width, int height) {
        this.width = width;
        this.height = height;
        cellList = new ArrayList<Cell>();
    }

    public void initialize() {
        addARandomCellToWorld();
        addARandomCellToWorld();
    }

    protected int getRandomValue() {
        return Math.random() <= 0.1 ? 4 : 2;
    }

    protected int getRandomPositionX() {
        return (int) (Math.random() * width);
    }

    protected int getRandomPositionY() {
        return (int) (Math.random() * height);
    }

    public World2048() {
        this(4, 4);
    }

    protected void addARandomCellToWorld() {
        cellList.add(new Cell(getRandomValue(), getRandomPositionX(), getRandomPositionY()));
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public List<Cell> getCellList() {
        return cellList;
    }

    public int getNumberOfCells() {
        return cellList.size();
    }

    public class Cell {

        public int y;
        public int x;
        public int value;

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
