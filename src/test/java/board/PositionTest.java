package board;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.treasuremap.board.Position;

public class PositionTest {
    Position p1;
    Position p2;

    @Before
    public void setup() {
        p1 = new Position(0,0);
        p2 = new Position(1,1);
    }

    @After
    public void cleanup() {
        p1 = null;
        p2 = null;
    }

    @Test
    public void equalsTestSameCoord() {
        Assert.assertTrue(p1.equals(new Position(0,0)));
    }

    @Test
    public void equalsTestDiffCoord() {
        Assert.assertFalse(p1.equals(p2));
    }
}
