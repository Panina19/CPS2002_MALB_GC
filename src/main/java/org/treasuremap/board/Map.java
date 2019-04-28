package org.treasuremap.board;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Map {
    private int size; //size of map (length of side)
    private Tile[][] map; //2d array of type Tiles, denoting the tile types per map tile
    private List<Position> grassTiles;  //list of different position of grass tiles, useful for the start position
                                        // ensuring a player can land/start from there

    /**
     * Constructor which creates a new square map of tiles with length of size of size and initially an empty grass
     * tile arraylist. Also runs the generate method to run the associated functions which shal be explained later on.
     * @param size denotes the length of a side of the square map
     */
    public Map(int size) {
        this.size = size;
        map = new Tile[size][size];
        grassTiles = new ArrayList<Position>();

        generate();
    }

    /**
     * A method used to gather a specific tile from 2 coordinates on the map
     * @param x - x coordinate of the position
     * @param y - y coordinate of the position
     * @return the tile found
     */
    public Tile getTileType(int x, int y) {
        return map[y][x];
    }

    /**
     * A method used to gather a specific tile from a position on the map
     * @param p - the position inserted
     * @return the tile found
     */
    public Tile getTileType(Position p) {
        return map[p.getY()][p.getX()];
    }

    /**
     * Method used to get a random position from a list of grass positions. This shall be useful for the starting
     * position of the players.
     * @return the random position from the list
     */
    public Position randomGrassPosition() {
        Random r= new Random();
        return grassTiles.get(r.nextInt(grassTiles.size()));
    }

    /**
     * Generates the map, by randomly positioning the treasure tile. Next goes through the different tiles available and
     * fills them as grass or water tiles with a 90% and 10% chance respectively. When a grass tile is added it is also
     * added in the list of grassTiles.
     */
    private void generate() {
        // Set Treasure location
        Random r = new Random();
        map[r.nextInt(size)][r.nextInt(size)] = Tile.TREASURE;

        // Set all other tiles (90% grass) (10% water)
        for (int i=0; i<size; i++) {
            for (int j=0; j<size; j++) {
                if (!(map[i][j] == Tile.TREASURE))
                    map[i][j] = r.nextInt(10) < 9 ? Tile.GRASS : Tile.WATER;
                if (map[i][j] == Tile.GRASS)
                    grassTiles.add(new Position(j,i));
            }
        }
    }

    /**
     * The use of this is to retrieve the map size, essential for the player and HTML generation file classes.
     * @return the size of the map
     */
    public int getSize() {
        return size;
    }

    /**
     * A setter method of the size of the map. Would be solely used in tests
     * @param size - an integer denoting the length of a side of the square map
     */
    public void setSize(int size){
        this.size = size;
    }

    /**
     * A method used solely in tests to set a tile map as one would want to be done to test around.
     * @param tileMap 2d array of Tiles
     */
    public void setMap(Tile[][] tileMap) {
        if(tileMap.length == map.length && tileMap[0].length == map[0].length) {
            map = tileMap;
        }
    }
}
