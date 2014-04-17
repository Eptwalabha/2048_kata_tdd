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

        Cell newCell;
        do {
            newCell = new Cell(getRandomValue(), getRandomPosition(width), getRandomPosition(height));
        } while (!checkIfCellIsValid(newCell));

        cellList.add(newCell);
        return true;
    }

    private boolean checkIfCellIsValid(Cell newCell) {
        for (Cell cell : cellList)
            if (newCell.doCellOverlaps(cell))
                return false;
        return true;
    }

    protected List<Cell> getRow(int rowIndex) {
        ArrayList<Cell> row = new ArrayList<Cell>();
        for (Cell cell : cellList)
            if (cell.getY() == rowIndex)
                row.add(cell);
        return row;
    }

    protected List<Cell> getColumn(int columnNumber) {
        ArrayList<Cell> column = new ArrayList<Cell>();
        for (Cell cell : cellList)
            if (cell.getX() == columnNumber)
                column.add(cell);
        return column;
    }

    public int getNumberOfCells() {
        return cellList.size();
    }
}
