import org.junit.Before;
import org.junit.Test;
import world.Cell;
import world.World2048;

import java.util.List;

import static org.fest.assertions.Assertions.assertThat;

/**
 * User: Eptwalabha
 * Date: 15/04/2014
 * Time: 21:49
 */
public class WorldTest {

    private World2048 world;
    private WorldMock worldMock;

    @Before
    public void setUp() {
        world = new World2048();
        world.initialize();
    }

    @Test
    public void canTestIfABasicWorldHasA4By4Dimension() {
        assertThat(world.width).isEqualTo(4);
        assertThat(world.height).isEqualTo(4);
    }

    @Test
    public void canTestIfACustomWorldHasASpecificDimension() {
        world = new World2048(10, 6);
        assertThat(world.width).isEqualTo(10);
        assertThat(world.height).isEqualTo(6);
    }

    @Test
    public void canTestThatTheWorldContainsExactlyTwoCellsAtTheBeginning() {
        assertThat(world.getNumberOfCells()).isEqualTo(2);
    }

    @Test
    public void canTestThatWorldHasTwoCellsOfValue2And4() {
        initializeWorldWithThisValues(4, 4, new int[]{2, 2, 2, 4, 3, 3});
        assertThat(worldMock.getCellList().get(0).getValue()).isEqualTo(2);
        assertThat(worldMock.getCellList().get(1).getValue()).isEqualTo(4);
    }

    @Test
    public void canTestThatWorldHasTwoCellsOfCertainPosition() {
        initializeWorldWithThisValues(4, 4, new int[]{2, 2, 2, 4, 3, 3});
        assertThat(worldMock.getCellList().get(0).getX()).isEqualTo(2);
        assertThat(worldMock.getCellList().get(0).getY()).isEqualTo(2);
        assertThat(worldMock.getCellList().get(1).getX()).isEqualTo(3);
        assertThat(worldMock.getCellList().get(1).getY()).isEqualTo(3);
    }

    @Test
    public void canAddANewCellToTheWorld() {
        initializeWorldWithThisValues(4, 4, new int[]{2, 2, 2, 2, 2, 3, 2, 2, 4});
        assertThat(worldMock.getNumberOfCells()).isEqualTo(2);
        assertThat(worldMock.addNewCellToWorld()).isTrue();
        assertThat(worldMock.getNumberOfCells()).isEqualTo(3);
    }

    @Test
    public void cannotAddAnymoreCellToWorldIfThereIsNoPlaceLeft() {
        initializeWorldWithThisValues(3, 1, new int[]{2, 0, 0, 4, 0, 1, 2, 0, 2});
        assertThat(worldMock.getNumberOfCells()).isEqualTo(2);
        assertThat(worldMock.addNewCellToWorld()).isTrue();
        assertThat(worldMock.getNumberOfCells()).isEqualTo(3);
        assertThat(worldMock.addNewCellToWorld()).isFalse();
        assertThat(worldMock.getNumberOfCells()).isEqualTo(3);
    }

    @Test
    public void cannotPlaceTwoNewCellsAtTheSamePlace() {
        initializeWorldWithThisValues(4, 4, new int[]{2, 0, 0, 2, 0, 0, 2, 1, 2});
        Cell cellA = worldMock.getCellList().get(0);
        Cell cellB = worldMock.getCellList().get(1);
        assertThat(cellA.getX()).isEqualTo(0);
        assertThat(cellA.getY()).isEqualTo(0);
        assertThat(cellB.getX()).isEqualTo(1);
        assertThat(cellB.getY()).isEqualTo(2);
    }

    @Test
    public void canRetrieveAnEmptyLineOfCell() {
        initializeWorldWithThisValues(4, 4, new int[]{2, 0, 0, 2, 3, 0});
        List<Cell> cellList = worldMock.getRow(1);
        assertThat(cellList.size()).isEqualTo(0);
    }

    @Test
    public void canRetrieveAListOfCellOfTwoElements() {
        initializeWorldWithThisValues(4, 4, new int[]{2, 0, 0, 2, 1, 0, 2, 1, 1});
        List<Cell> cellList = worldMock.getRow(0);
        assertThat(cellList.size()).isEqualTo(2);
        worldMock.addNewCellToWorld();
        cellList = worldMock.getRow(1);
        assertThat(cellList.size()).isEqualTo(1);
    }

    @Test
    public void canRetrieveAnEmptyListOfCellForAnEmptyColumn() {
        initializeWorldWithThisValues(4, 4, new int[]{2, 1, 0, 2, 1, 1, 2, 1, 1});
        List<Cell> cellList = worldMock.getColumn(0);
        assertThat(cellList.size()).isEqualTo(0);
    }

    @Test
    public void canRetrieveAListOfCellForAnGivenColumn() {
        initializeWorldWithThisValues(4, 4, new int[]{2, 0, 0, 2, 0, 1, 2, 1, 1});
        List<Cell> cellList = worldMock.getColumn(0);
        assertThat(cellList.size()).isEqualTo(2);
    }

    @Test
    public void canDeleteCellOfTheWorld() {
        initializeWorldWithThisValues(4, 4, new int[]{2, 0, 0, 2, 1, 0});
        worldMock.getRow(0).get(0).removeFromWorld();
        worldMock.cleanWorld();
        assertThat(worldMock.getRow(0).size()).isEqualTo(1);

    }

    private void initializeWorldWithThisValues(int width, int height, int[] cellsInformation) {
        worldMock = new WorldMock(width, height, cellsInformation);
        worldMock.initialize();
    }

    private class WorldMock extends World2048 {

        private int[] randomValues;
        private int counter = 0;

        public WorldMock(int width, int height, int[] randomValues) {
            super(width, height);
            this.randomValues = randomValues;
        }

        @Override
        protected int getRandomValue() {
            return random();
        }

        @Override
        protected int getRandomPosition(int size) {
            return random();
        }

        @Override
        public boolean addNewCellToWorld() {
            return super.addNewCellToWorld();
        }

        @Override
        public List<Cell> getRow(int rowIndex) {
            return super.getRow(rowIndex);
        }

        @Override
        public List<Cell> getColumn(int columnIndex) {
            return super.getColumn(columnIndex);
        }

        public List<Cell> getCellList() {
            return cellList;
        }

        private int random() {
            return (counter < randomValues.length) ? randomValues[counter++] : 0;
        }

        public void cleanWorld() {
            super.cleanWorld();
        }
    }
}
