import org.junit.Test;
import world.Cell;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Created by eptwalabha on 17/04/14.
 */
public class CellTest {
    @Test
    public void canReturnTrueWhenTwoCellsOverlap() {
        Cell cellA = new Cell(2,0,0);
        Cell cellB = new Cell(2,0,0);
        assertThat(cellA.doCellOverlaps(cellB)).isTrue();
    }

    @Test
    public void canReturnFalseWhenTwoCellsDoNotOverlap() {
        Cell cellA = new Cell(2,0,0);
        Cell cellB = new Cell(2,1,0);
        assertThat(cellA.doCellOverlaps(cellB)).isFalse();
    }

    @Test
    public void canDoubleTheValueOfACell() {
        Cell cell = new Cell(2, 0, 0);
        cell.doubleValue();
        assertThat(cell.getValue()).isEqualTo(4);
        cell.doubleValue();
        cell.doubleValue();
        assertThat(cell.getValue()).isEqualTo(16);
    }
}
