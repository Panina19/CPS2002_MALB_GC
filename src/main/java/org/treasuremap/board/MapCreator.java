package org.treasuremap.board;

import org.treasuremap.board.mapcreators.HazardousMapCreator;
import org.treasuremap.board.mapcreators.SafeMapCreator;

public class MapCreator {
    /**
     * This method accomodates the creation of the map according to the below parameters. For any type given it will
     * retrieve the appropriate object and create the map from the extended class.
     * @param mapType: holds the type of the map inputted
     * @param mapSize: holds the size of the map inputted
     * @return the instance of the creator which creates the appropriate map
     */
    public Map createMap(char mapType, int mapSize){
        MapCreator mapCreator = getCreator(mapType, mapSize); //get the class depending on the mapType passed by user
        return mapCreator.createMap(mapType, mapSize); // call its factory method
    }

    /**
     * This method is used to return the instance of the creator according to the type that the user passed by
     * @param mapType: holds the type of the map inputted
     * @param mapSize: holds the size of the map inputted
     * @return the instance of the creator which creates the appropriate map
     */
    private MapCreator getCreator(char mapType,int mapSize){
        try {
            if (mapType=='s' || mapType=='S') {
                return new SafeMapCreator();
            } else if (mapType=='h' || mapType=='H') {
                return new HazardousMapCreator();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return new SafeMapCreator();
    }
}
