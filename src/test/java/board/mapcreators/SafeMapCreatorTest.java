package board.mapcreators;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.treasuremap.board.Map;
import org.treasuremap.board.mapcreators.SafeMapCreator;

import static org.junit.Assert.*;
/**
 * This test class is used to test the methods found in the class SafeMapCreator
 */
public class SafeMapCreatorTest {
    private int mapSize;
    private SafeMapCreator safeCreator;
    @Before
    public void setUp() {
        mapSize = 10;
        safeCreator = new SafeMapCreator();
    }

    @After
    public void tearDown() {
        mapSize = 0;
        safeCreator = null;
    }

    /**
     * This test is used to check if creating a map from this class, it is truly creating a Safe map with the
     * properties of the inputted map size.
     */
    @Test
    public void testCreateSafeMap() {
        Map safeMap = safeCreator.createMap('S',mapSize);
        int size =  safeMap.getSize();
        String type =  safeMap.getType();
        assertEquals(10,size);
        assertEquals("Safe",type);
    }

    /**
     * This test is used to check if when creating a map from this class, it is truly creating a 's'afe map with the
     * properties of the inputted map size.
     */
    @Test
    public void testCreateHazardousMap2() {
        Map safeMap = safeCreator.createMap('s',mapSize);
        int size =  safeMap.getSize();
        String type =  safeMap.getType();
        assertEquals(10,size);
        assertEquals("Safe",type);
    }
}