package org.treasuremap.board;

import java.util.Random;

enum Tile {
    WATER,
    GRASS,
    TREASURE
}

public class Map {
    private int size;
    private Tile[][] map;

    public Map(int size) {
        // Set size of map
        this.size = size;

        // Generate map
        generate();
    }

    public Tile getTileType(int x, int y) {
        return map[x][y];
    }

    private void generate() {
        // Create 2D map
        map = new Tile[size][size];

        // Set Treasure location
        Random r = new Random();
        map[r.nextInt(size)][r.nextInt(size)] = Tile.TREASURE;

        // Set all other tiles (90% grass) (10% water)
        for (int i=0; i<size; i++) {
            for (int j=0; j<size; j++) {
                if (!(map[i][j] == Tile.TREASURE))
                    map[i][j] = r.nextInt(10) < 9 ? Tile.GRASS : Tile.WATER;
            }
        }
    }
}
