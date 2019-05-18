package org.treasuremap.board.mapcreators;

import org.treasuremap.board.Map;
import org.treasuremap.board.MapCreator;
import org.treasuremap.board.maptypes.HazardousMap;

public class HazardousMapCreator  extends MapCreator {
    /**
     * This method is used to take over the createMap method of the MapCreator class and create the map and its
     * behaviour according to how it wants
     * @param mapType: holds the type of the map inputted
     * @param mapSize: holds the size of the map inputted
     * @return the instance of the generated hazardous map
     */
    public Map createMap(char mapType, int mapSize){
        HazardousMap hazardMap = new HazardousMap(mapSize);
        return hazardMap;
    }
}
