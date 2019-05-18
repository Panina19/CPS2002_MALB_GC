package org.treasuremap.board.maptypes;

import org.treasuremap.board.Map;
import org.treasuremap.board.Position;
import org.treasuremap.board.Tile;

import java.util.Random;

public class SafeMap extends Map {
    /**
     * Constructor which creates a new square map of tiles with length of size of size and initially an empty grass
     * tile arraylist. Also runs the generate method to run the associated functions which shal be explained later on.
     *
     * @param size denotes the length of a side of the square map
     */
    public SafeMap(int size) {
        super(size);
        type = "Safe";
    }

    /**
     * Generates the map, by randomly positioning the treasure tile. Next goes through the different tiles available and
     * fills them as grass or water tiles with a 90% and 10% chance respectively. When a grass tile is added it is also
     * added in the list of grassTiles.
     */
    public void generate() {
        // Set Treasure location
        Random r = new Random();
        map[r.nextInt(size)][r.nextInt(size)] = Tile.TREASURE;

        // Set all other tiles (65-75% grass) (25-35% water)
        for (int i=0; i<size; i++) {
            for (int j=0; j<size; j++) {
                if (!(map[i][j] == Tile.TREASURE))
                    map[i][j] = r.nextInt(100) < 90 ? Tile.GRASS : Tile.WATER;
                if (map[i][j] == Tile.GRASS)
                    grassTiles.add(new Position(j,size-i-1));
            }
        }
    }
}
