package world;

import java.util.Collections;
import java.util.List;

/**
 * Created by eptwalabha on 21/04/14.
 */
public class GameLogic {
    public static void orderCells(List<Cell> cellList, CellComparator comparator) {
        Collections.sort(cellList, comparator);
    }

    public static void mergeNeighbourCells(List<Cell> cellList) {
        for (int index = 0; index < cellList.size() - 1; index++) {
            Cell cellA = cellList.get(index);
            Cell cellB = cellList.get(index + 1);

            if (cellA.getValue() == cellB.getValue()) {
                cellA.doubleValue();
                cellB.removeFromWorld();
                cellList.remove(index + 1);
            }
        }
    }

    public static void pushCellsLeft(List<Cell> cellList) {
        for (int index = 0, size = cellList.size(); index < size; index++)
            cellList.get(index).setX(index);
    }

    public static void pushCellsRight(List<Cell> cellList, int width) {
        for (int index = 0, size = cellList.size(); index < size; index++)
            cellList.get(index).setX(width - (index + 1));
    }

    public static void pushCellsTop(List<Cell> cellList) {
        for (int index = 0, size = cellList.size(); index < size; index++)
            cellList.get(index).setY(index);
    }

    public static void pushCellsDown(List<Cell> cellList, int height) {
        for (int index = 0, size = cellList.size(); index < size; index++)
            cellList.get(index).setY(height - (index + 1));
    }
}
