package board;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.treasuremap.board.Position;

public class PositionTest {
    Position p1;
    Position p2;

    /**
     * Sets up 2 positions
     */
    @Before
    public void setup() {
        p1 = new Position(0,0);
        p2 = new Position(1,1);
    }

    /**
     * Tears down the variables set up
     */
    @After
    public void cleanup() {
        p1 = null;
        p2 = null;
    }

    /**
     * Tests the first position if it is equal to an object of type position of (0,0)
     */
    @Test
    public void equalsTestSameCoord() {
        Assert.assertTrue(p1.equals(new Position(0,0)));
    }

    /**
     * Tests the first position if it is equal to the second position
     */
    @Test
    public void equalsTestDiffCoord() {
        Assert.assertFalse(p1.equals(p2));
    }
}
