package board.mapcreators;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.treasuremap.board.Map;
import org.treasuremap.board.mapcreators.HazardousMapCreator;

import static org.junit.Assert.*;
/**
 * This test class is used to test the methods found in the class HazardousMapCreator
 */
public class HazardousMapCreatorTest {
    private int mapSize;
    private HazardousMapCreator hazardousCreator;
    @Before
    public void setUp() {
        mapSize = 10;
        hazardousCreator = new HazardousMapCreator();
    }

    @After
    public void tearDown() {
        mapSize = 0;
        hazardousCreator = null;
    }

    /**
     * This test is used to check if when creating a map from this class, it is truly creating a Hazardous map with the
     * properties of the inputted map size.
     */
    @Test
    public void testCreateHazardousMap() {
        Map hazardousMap = hazardousCreator.createMap('H',mapSize);
        int size =  hazardousMap.getSize();
        String type =  hazardousMap.getType();
        assertEquals(10,size);
        assertEquals("Hazardous",type);
    }

    /**
     * This test is used to check if when creating a map from this class, it is truly creating a 'h'azardous map with the
     * properties of the inputted map size.
     */
    @Test
    public void testCreateHazardousMap2() {
        Map hazardousMap = hazardousCreator.createMap('h',mapSize);
        int size =  hazardousMap.getSize();
        String type =  hazardousMap.getType();
        assertEquals(10,size);
        assertEquals("Hazardous",type);
    }

}