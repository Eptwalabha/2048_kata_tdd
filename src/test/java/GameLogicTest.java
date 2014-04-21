import org.junit.Before;
import org.junit.Test;
import world.Cell;
import world.CellComparator;
import world.GameLogic;

import java.util.ArrayList;
import java.util.List;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Created by eptwalabha on 21/04/14.
 */
public class GameLogicTest {

    private List<Cell> cellList;

    @Before
    public void setUp() {
        cellList = new ArrayList<Cell>();
    }

    @Test
    public void canSortAListOfCellByRowAscendant() {
        cellList.add(new Cell(2, 0, 0));
        cellList.add(new Cell(4, 3, 0));
        cellList.add(new Cell(8, 1, 0));
        GameLogic.orderCells(cellList, CellComparator.ROW_ASC);
        assertThat(cellList.get(0).getX()).isEqualTo(0);
        assertThat(cellList.get(1).getX()).isEqualTo(1);
        assertThat(cellList.get(2).getX()).isEqualTo(3);
    }

    @Test
    public void canSortAListOfCellByRowDescendant() {
        cellList.add(new Cell(2, 0, 0));
        cellList.add(new Cell(4, 3, 0));
        cellList.add(new Cell(8, 1, 0));
        GameLogic.orderCells(cellList, CellComparator.ROW_DESC);
        assertThat(cellList.get(0).getX()).isEqualTo(3);
        assertThat(cellList.get(1).getX()).isEqualTo(1);
        assertThat(cellList.get(2).getX()).isEqualTo(0);
    }

    @Test
    public void canSortAListOfCellByColumnAscendant() {
        cellList.add(new Cell(2, 0, 0));
        cellList.add(new Cell(4, 0, 3));
        cellList.add(new Cell(8, 0, 1));
        GameLogic.orderCells(cellList, CellComparator.COLUMN_ASC);
        assertThat(cellList.get(0).getY()).isEqualTo(0);
        assertThat(cellList.get(1).getY()).isEqualTo(1);
        assertThat(cellList.get(2).getY()).isEqualTo(3);
    }

    @Test
    public void canSortAListOfCellByColumnDescendant() {
        cellList.add(new Cell(2, 0, 0));
        cellList.add(new Cell(4, 0, 3));
        cellList.add(new Cell(8, 0, 1));
        GameLogic.orderCells(cellList, CellComparator.COLUMN_DESC);
        assertThat(cellList.get(0).getY()).isEqualTo(3);
        assertThat(cellList.get(1).getY()).isEqualTo(1);
        assertThat(cellList.get(2).getY()).isEqualTo(0);
    }

    @Test
    public void canMergeNeighbourCellsOfSameValueInAList() {
        cellList = getListOfCells(2, 0, 0, 2);
        GameLogic.mergeNeighbourCells(cellList);
        assertThat(cellList.size()).isEqualTo(1);
        assertThat(cellList.get(0).getValue()).isEqualTo(4);
    }

    @Test
    public void canMergeNeighboursOfSameValueInAList() {
        cellList = getListOfCells(4, 4, 4, 4);
        GameLogic.mergeNeighbourCells(cellList);
        assertThat(cellList.size()).isEqualTo(2);
        assertThat(cellList.get(0).getValue()).isEqualTo(8);
        assertThat(cellList.get(1).getValue()).isEqualTo(8);
    }

    @Test
    public void cannotMergeCellsOfListWithDifferentValues() {
        cellList = getListOfCells(2, 4, 2, 4);
        GameLogic.mergeNeighbourCells(cellList);
        assertThat(cellList.size()).isEqualTo(4);
    }

    @Test
    public void canPushCellsLeft() {
        cellList.add(new Cell(2, 1, 0));
        cellList.add(new Cell(4, 3, 0));
        GameLogic.pushCellsLeft(cellList);
        assertThat(cellList.get(0).getX()).isEqualTo(0);
        assertThat(cellList.get(1).getX()).isEqualTo(1);
    }

    @Test
    public void canPushCellsRight() {
        cellList.add(new Cell(2, 0, 0));
        cellList.add(new Cell(4, 1, 0));
        GameLogic.pushCellsRight(cellList, 6);
        assertThat(cellList.get(0).getX()).isEqualTo(5);
        assertThat(cellList.get(1).getX()).isEqualTo(4);
    }

    @Test
    public void canPushCellsTop() {
        cellList.add(new Cell(2, 0, 1));
        cellList.add(new Cell(4, 0, 3));
        GameLogic.pushCellsTop(cellList);
        assertThat(cellList.get(0).getY()).isEqualTo(0);
        assertThat(cellList.get(1).getY()).isEqualTo(1);
    }

    @Test
    public void canPushCellsDown() {
        cellList.add(new Cell(2, 0, 0));
        cellList.add(new Cell(4, 0, 1));
        GameLogic.pushCellsDown(cellList, 5);
        assertThat(cellList.get(0).getY()).isEqualTo(4);
        assertThat(cellList.get(1).getY()).isEqualTo(3);
    }

    private List<Cell> getListOfCells(int ... values) {
        List<Cell> newCellList = new ArrayList<Cell>();
        for (int index = 0, size = values.length; index < size; index++) {
            if (values[index] == 0)
                continue;
            newCellList.add(new Cell(values[index], index, 0));
        }
        return newCellList;
    }
}
