package org.treasuremap.board.mapcreators;

import org.treasuremap.board.Map;
import org.treasuremap.board.MapCreator;
import org.treasuremap.board.maptypes.SafeMap;

/**
 * This class is used to help serve the creator part of the Factory Design Pattern
 */
public class SafeMapCreator extends MapCreator {

    /**
     * This method is used to take over the createMap method of the MapCreator class and create the map and its
     * behaviour according to how it wants
     * @param mapType: holds the type of the map inputted
     * @param mapSize: holds the size of the map inputted
     * @return the instance of the generated safe map
     */
    public Map createMap(char mapType, int mapSize){
        SafeMap safeMap = new SafeMap(mapSize);
        return safeMap;
    }
}
