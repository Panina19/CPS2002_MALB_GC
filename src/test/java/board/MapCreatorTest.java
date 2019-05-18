package board;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.treasuremap.board.Map;
import org.treasuremap.board.MapCreator;

import static org.junit.Assert.assertEquals;

/**
 * This test class is used to test the methods found in the class MapCreator and associated methods.
 */
public class MapCreatorTest {
    private int mapSize;
    private MapCreator mapCreator;

    @Before
    public void setUp() {
        mapSize = 10;
        mapCreator = new MapCreator();
    }

    @After
    public void tearDown() {
        mapSize = 0;
        mapCreator = null;
    }

    /**
     * This test is used to check if when creating a map from this class, it is truly creating a Hazardous map with the
     * properties of the inputted map size.
     */
    @Test
    public void testCreateHazardousMap() {
        Map hazardousMap = mapCreator.createMap('H', mapSize);
        int size = hazardousMap.getSize();
        String type = hazardousMap.getType();
        assertEquals(10, size);
        assertEquals("Hazardous", type);
    }
    /**
     * This test is used to check if when creating a map from this class, it is truly creating a 'h'azardous map with the
     * properties of the inputted map size.
     */
    @Test
    public void testCreateHazardousMap2() {
        Map hazardousMap = mapCreator.createMap('h', mapSize);
        int size = hazardousMap.getSize();
        String type = hazardousMap.getType();
        assertEquals(10, size);
        assertEquals("Hazardous", type);
    }
    /**
     * This test is used to check if when creating a map from this class, it is truly creating a Safe map with the
     * properties of the inputted map size.
     */
    @Test
    public void testCreateSafeMap() {
        Map hazardousMap = mapCreator.createMap('S', mapSize);
        int size = hazardousMap.getSize();
        String type = hazardousMap.getType();
        assertEquals(10, size);
        assertEquals("Safe", type);
    }
    /**
     * This test is used to check if when creating a map from this class, it is truly creating a 's'afe map with the
     * properties of the inputted map size.
     */
    @Test
    public void testCreateSafeMap2() {
        Map hazardousMap = mapCreator.createMap('s', mapSize);
        int size = hazardousMap.getSize();
        String type = hazardousMap.getType();
        assertEquals(10, size);
        assertEquals("Safe", type);
    }

    /**
     * Currently when an unknown type is given, it is defaulted to set the map type to 'Safe', thus NOT 'Hazardous'
     * in this test we demonstrate if this holds true.
     */
    @Test
    public void testCreateUntypedMap() {
        Map hazardousMap = mapCreator.createMap('X', mapSize);
        int size = hazardousMap.getSize();
        String type = hazardousMap.getType();
        assertEquals(10, size);
        assertEquals("Safe", type);
    }
}
