package board;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.treasuremap.board.Map;
import org.treasuremap.board.MapCreator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * This test class is used to test the methods found in the class MapCreator and associated methods.
 */
public class MapCreatorTest {
    private int mapSize;
    private MapCreator mapCreator1;
    private MapCreator mapCreator2;

    @Before
    public void setUp() {
        mapSize = 10;
        mapCreator1 = new MapCreator();
        mapCreator2 = new MapCreator();
    }

    @After
    public void tearDown() {
        mapSize = 0;
        mapCreator1 = null;
        mapCreator2 = null;
    }

    /**
     * This test is used to check if when creating a map from this class, it is truly creating a Hazardous map with the
     * properties of the inputted map size.
     */
    @Test
    public void testCreateHazardousMap() {
        Map hazardousMap = mapCreator1.createMap('H', mapSize);
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
        Map hazardousMap = mapCreator1.createMap('h', mapSize);
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
        Map hazardousMap = mapCreator1.createMap('S', mapSize);
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
        Map hazardousMap = mapCreator1.createMap('s', mapSize);
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
        Map untypedMap = mapCreator1.createMap('X', mapSize);
        int size = untypedMap.getSize();
        String type = untypedMap.getType();
        assertEquals(10, size);
        assertEquals("Safe", type);
    }

    /**
     * This test checks that calling the creation of a safe map from different mapCreator objects brings the same
     * instance.
     */
    @Test
    public void testSameSafeMapInstance() {
        Map map1 = mapCreator1.createMap('S', mapSize);
        Map map2 = mapCreator2.createMap('s', mapSize);
        assertEquals(map1, map2);
    }
    /**
     * This test checks that calling the creation of a hazardous map from different mapCreator objects brings the same
     * instance.
     */
    @Test
    public void testSameHazardousMapInstance() {
        Map map1 = mapCreator1.createMap('H', mapSize);
        Map map2 = mapCreator2.createMap('h', mapSize);
        assertEquals(map1, map2);
    }

    /**
     * This test checks that calling the creation of an untyped map from different mapCreator objects brings the same
     * instance.
     */
    @Test
    public void testSameUntypedMapInstance() {
        Map map1 = mapCreator1.createMap('X', mapSize);
        Map map2 = mapCreator2.createMap('x', mapSize);
        assertEquals(map1, map2);
    }

    /**
     * This test checks that calling the creation of a safe map and a hazardous map from different mapCreator objects
     * does NOT bring the same instance.
     */
    @Test
    public void testDiffMapTypeInstance() {
        Map map1 = mapCreator1.createMap('S', mapSize);
        Map map2 = mapCreator2.createMap('H', mapSize);
        assertNotEquals(map1, map2);
    }
}
