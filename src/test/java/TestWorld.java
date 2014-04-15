import org.junit.Before;
import org.junit.Test;
import world.World2048;

import static org.fest.assertions.Assertions.assertThat;

/**
 * User: Eptwalabha
 * Date: 15/04/2014
 * Time: 21:49
 */
public class TestWorld {

    private World2048 world;

    @Before
    public void setUp() {
        world = new World2048();
        world.initialize();
    }

    @Test
    public void canTestIfABasicWorldHasABasicDimensions() {
        assertThat(world.getWidth()).isEqualTo(4);
        assertThat(world.getHeight()).isEqualTo(4);
    }

    @Test
    public void canTestIfACustomWorldHasASpecificDimension() {
        world = new World2048(10, 6);
        assertThat(world.getWidth()).isEqualTo(10);
        assertThat(world.getHeight()).isEqualTo(6);
    }

    @Test
    public void canTestThatTheWorldContainsExactlyTwoCells() {
        assertThat(world.getNumberOfCells()).isEqualTo(2);
    }

    @Test
    public void canTestThatWorldHasTwoCellsOfValueTwo() {
        world = new World2048Mock(new int[]{2, 2, 2, 4, 3, 3});
        world.initialize();
        assertThat(world.getCellList().get(0).getCellValue()).isEqualTo(2);
        assertThat(world.getCellList().get(1).getCellValue()).isEqualTo(4);
    }

    @Test
    public void canTestThatWorldHasTwoCellsOfCertainPosition() {
        world = new World2048Mock(new int[]{2, 2, 2, 4, 3, 3});
        world.initialize();
        assertThat(world.getCellList().get(0).getPositionX()).isEqualTo(2);
        assertThat(world.getCellList().get(0).getPositionY()).isEqualTo(2);
        assertThat(world.getCellList().get(1).getPositionX()).isEqualTo(3);
        assertThat(world.getCellList().get(1).getPositionY()).isEqualTo(3);
    }

    private class World2048Mock extends World2048 {

        private int[] randomValues;
        private int counter = 0;

        public World2048Mock(int[] randomValues) {
            super(4, 4);
            this.randomValues = randomValues;
        }

        @Override
        protected int getRandomValue() {
            return pop();
        }

        @Override
        public int getRandomPositionY() {
            return pop();
        }

        @Override
        protected int getRandomPositionX() {
            return pop();
        }

        private int pop() {
            return (counter < randomValues.length) ? randomValues[counter++] : 0;
        }
    }
}
