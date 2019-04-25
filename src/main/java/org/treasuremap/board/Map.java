package org.treasuremap.board;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Map {
    private int size;
    private Tile[][] map;
    private List<Position> grassTiles;

    public Map(int size) {
        this.size = size;
        map = new Tile[size][size];
        grassTiles = new ArrayList<Position>();

        // Generate map
        generate();
    }

    public Tile getTileType(int x, int y) {
        return map[x][y];
    }

    public Tile getTileType(Position p) {
        return map[p.getX()][p.getY()];
    }

    public Position randomGrassPosition() {
        Random r= new Random();
        return grassTiles.get(r.nextInt(grassTiles.size()));
    }

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

    public int getSize() {
        return size;
    }
}
