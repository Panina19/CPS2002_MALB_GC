package game.board;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.org.treasuremap.board.Map;

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
        Assert.assertNotEquals(0,map.getTileType(0,0));
        Assert.assertNotEquals(0,map.getTileType(5,5));
        Assert.assertNotEquals(0,map.getTileType(9,9));
    }

    @Test(expected = InvalidCoordinatesException.class)
    public void getOutOfRangeTileTypeTest() {
        Assert.assertEquals(0, map.getTyileType(10,10));
    }

}
