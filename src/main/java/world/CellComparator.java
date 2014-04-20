package world;

import java.util.Comparator;

/**
 * Created by eptwalabha on 21/04/14.
 */
public enum CellComparator implements Comparator<Cell> {
    ROW {
        @Override
        public int compare(Cell cellA, Cell cellB) {
            return (cellA.getX() == cellB.getX()) ? 0 : (cellA.getX() < cellB.getX()) ? -1 : 1;
        }
    },
    COLUMN {
        @Override
        public int compare(Cell cellA, Cell cellB) {
            return (cellA.getY() == cellB.getY()) ? 0 : (cellA.getY() < cellB.getY()) ? -1 : 1;
        }
    };

    public static Comparator<Cell> desc(final CellComparator comparator) {
        return new Comparator<Cell>() {
            @Override
            public int compare(Cell o1, Cell o2) {
                return comparator.compare(o1, o2) * -1;
            }
        };
    }
}
