package board;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import org.treasuremap.board.Map;

import static org.junit.Assert.fail;

public class MapTest {
    private Map map;

    @Before
    public void setup() {
        map = new Map(10);
    }

    @After
    public void cleanup() {
        map = null;
    }

    @Test
    public void getExistingTileTypeTest() {
        Assert.assertNotNull(map.getTileType(5,5));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void getOutOfRangeTileTypeTest() {
        Assert.assertNull(map.getTileType(10,10));
    }

}
