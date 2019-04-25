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
        Assert.assertNotNull(map.getTileType(0,5));
        Assert.assertNotNull(map.getTileType(5,5));
        Assert.assertNotNull(map.getTileType(9,5));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void getOutOfRangeTileTypeTest() {
        Assert.assertNull(map.getTileType(10,10));
    }

    @Test
    public void randomGrassPositionIsGrassTest() {
        Assert.assertEquals(Tile.GRASS, map.getTileType(map.randomGrassPosition()));
    }

    @Test
    public void randomGrassPositionInMapTest() {
        Assert.assertTrue(map.randomGrassPosition().getX()>=0 && map.randomGrassPosition().getX()<map.getSize());
        Assert.assertTrue(map.randomGrassPosition().getY()>=0 && map.randomGrassPosition().getY()<map.getSize());
    }
}
