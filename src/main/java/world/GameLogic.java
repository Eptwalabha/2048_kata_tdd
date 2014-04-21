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
                cellList.remove(index + 1);
            }
        }
    }
}
