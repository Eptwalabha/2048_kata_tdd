import org.junit.Before;
import org.junit.Test;
import world.World2048;

import java.util.List;

import static org.fest.assertions.Assertions.assertThat;

/**
 * User: Eptwalabha
 * Date: 15/04/2014
 * Time: 21:49
 */
public class TestWorld {

    private World2048 world;
    private World2048Mock worldMock;

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
        worldMock = new World2048Mock(new int[]{2, 2, 2, 4, 3, 3});
        worldMock.initialize();
        assertThat(worldMock.getCellList().get(0).getCellValue()).isEqualTo(2);
        assertThat(worldMock.getCellList().get(1).getCellValue()).isEqualTo(4);
    }

    @Test
    public void canTestThatWorldHasTwoCellsOfCertainPosition() {
        worldMock = new World2048Mock(new int[]{2, 2, 2, 4, 3, 3});
        worldMock.initialize();
        assertThat(worldMock.getCellList().get(0).getPositionX()).isEqualTo(2);
        assertThat(worldMock.getCellList().get(0).getPositionY()).isEqualTo(2);
        assertThat(worldMock.getCellList().get(1).getPositionX()).isEqualTo(3);
        assertThat(worldMock.getCellList().get(1).getPositionY()).isEqualTo(3);
    }

    @Test
    public void canAddANewCellToTheWorld() {
        worldMock = new World2048Mock(new int[]{2, 2, 2, 2, 2, 3, 2, 2, 4});
        worldMock.initialize();
        assertThat(worldMock.getNumberOfCells()).isEqualTo(2);
        assertThat(worldMock.addNewCellToWorld()).isTrue();
        assertThat(worldMock.getNumberOfCells()).isEqualTo(3);
    }

    @Test
    public void cannotAddAnymoreCellToWorldIfThereIsNoPlaceLeft() {
        worldMock = new World2048Mock(3, 1, new int[]{2, 0, 0, 4, 0, 1, 2, 1, 0});
        worldMock.initialize();
        assertThat(worldMock.addNewCellToWorld()).isTrue();
        assertThat(worldMock.addNewCellToWorld()).isFalse();
    }

    private class World2048Mock extends World2048 {

        private int[] randomValues;
        private int counter = 0;

        public World2048Mock(int[] randomValues) {
            this.randomValues = randomValues;
        }

        public World2048Mock(int width, int height, int[] randomValues) {
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

        public List<Cell> getCellList() {
            return cellList;
        }

        private int random() {
            return (counter < randomValues.length) ? randomValues[counter++] : 0;
        }
    }
}
