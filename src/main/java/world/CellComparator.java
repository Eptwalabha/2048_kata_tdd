package world;

import java.util.Comparator;

/**
 * Created by eptwalabha on 21/04/14.
 */
public enum CellComparator implements Comparator<Cell> {
    ROW_ASC {
        @Override
        public int compare(Cell cellA, Cell cellB) {
            return (cellA.getX() == cellB.getX()) ? 0 : (cellA.getX() < cellB.getX()) ? -1 : 1;
        }
    },
    ROW_DESC {
        @Override
        public int compare(Cell cellA, Cell cellB) {
            return (cellA.getX() == cellB.getX()) ? 0 : (cellA.getX() < cellB.getX()) ? 1 : -1;
        }
    },
    COLUMN_ASC {
        @Override
        public int compare(Cell cellA, Cell cellB) {
            return (cellA.getY() == cellB.getY()) ? 0 : (cellA.getY() < cellB.getY()) ? -1 : 1;
        }
    },
    COLUMN_DESC {
        @Override
        public int compare(Cell cellA, Cell cellB) {
            return (cellA.getY() == cellB.getY()) ? 0 : (cellA.getY() < cellB.getY()) ? 1 : -1;
        }
    }
}
