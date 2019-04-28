package board;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import org.treasuremap.board.Map;
import org.treasuremap.board.Tile;

import static org.junit.Assert.fail;

public class MapTest {
    private Map map;

    /**
     * Sets up a map object of size 10
     */
    @Before
    public void setup() {
        map = new Map(10);
    }

    /**
     * Nullifies the variable map
     */
    @After
    public void cleanup() {
        map = null;
    }

    /**
     * Tests that the map created does not have any tiles possessing null values
     */
    @Test
    public void getExistingTileTypeTest() {
        Assert.assertNotNull(map.getTileType(0,5));
        Assert.assertNotNull(map.getTileType(5,5));
        Assert.assertNotNull(map.getTileType(9,5));
    }

    /**
     * Test to try access a position which is out of the map boundaries
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void getOutOfRangeTileTypeTest() {
        Assert.assertNull(map.getTileType(10,10));
    }

    /**
     * Tests 1 random tile from the grass positions list is a position which is indeed a GRASS tile.
     */
    @Test
    public void randomGrassPositionIsGrassTest() {
        Assert.assertEquals(Tile.GRASS, map.getTileType(map.randomGrassPosition()));
    }

    /**
     * Tests 2 grass positions ensuring they are within the bounds of the x or y axis respectively.
     */
    @Test
    public void randomGrassPositionInMapTest() {
        Assert.assertTrue(map.randomGrassPosition().getX()>=0 && map.randomGrassPosition().getX()<map.getSize());
        Assert.assertTrue(map.randomGrassPosition().getY()>=0 && map.randomGrassPosition().getY()<map.getSize());
    }
}
