package Display;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.treasuremap.Display.HTMLGeneration;
import org.treasuremap.Player.Player;
import org.treasuremap.board.Map;
import org.treasuremap.board.Position;
import org.treasuremap.board.Tile;

import static org.junit.Assert.assertEquals;

public class HTMLGenerationTest {
    private Player [] players;
    private Player player;
    private int turnNo;
    private Map map;
    private int mapSize;
    private int playerNo;
    private Position playerPos;
    private int xPos, yPos;
    boolean[][] tilesVisited;
    private HTMLGeneration htmlGen;

    /**
     * Sets up multiple variables which respectively include the turn number, size of map, player count, a player
     * object, a map object, an array of 1 player and an HTML generator instance.
     */
    @Before
    public void setup() {
        turnNo = 1;
        mapSize = 5;
        playerNo = 0;
        player = new Player(0, 0,mapSize, 1);
        map = new Map(mapSize);         
        players = new Player[1];
        players[0] = player;
        htmlGen = new HTMLGeneration(players, playerNo, map, turnNo);
    }

    /**
     * Tears down the previously set up variables
     */
    @After
    public void tearDown(){
        player = null;
        map = null;
        htmlGen = null;
        turnNo = 0;
        mapSize = 0;
        players = null;
        playerNo = 0;
        playerPos = null;
        xPos = 0;
        yPos = 0;
        tilesVisited = null;
    }

    /**
     * Tests that the tile colour matches the tile on the map. This is done by first updating the tilesVisited array and
     * the tileMap to be static (thus not incurring any race conditions). Then grab 4 cases, for each case the string
     * returned is HTML code and is compared to the expected HTML colour code. In successive order the cases are an
     * uncovered grass tile, an uncovered water tile, an uncovered treasure tile and a covered water tile.
     */
    @Test
    public void getTileColourTest() {
        tilesVisited = new boolean[][]{
                {true, true, true, true, true},
                {true, false, false, false, false},
                {true, false, true, false, true},
                {false, false, true, false, true},
                {true, true, true, true, true}};
        player.setTilesVisited(tilesVisited);
        Tile [][] tileMap = {
                {Tile.GRASS,Tile.WATER,Tile.GRASS,Tile.GRASS,Tile.GRASS},
                {Tile.GRASS,Tile.WATER,Tile.GRASS,Tile.GRASS,Tile.GRASS},
                {Tile.GRASS,Tile.GRASS,Tile.TREASURE,Tile.GRASS,Tile.WATER},
                {Tile.GRASS,Tile.GRASS,Tile.GRASS,Tile.GRASS,Tile.GRASS},
                {Tile.GRASS,Tile.WATER,Tile.GRASS,Tile.GRASS,Tile.GRASS}
        };
        map.setMap(tileMap);
        String colour = htmlGen.getTileColour(0,0,tilesVisited);
        assertEquals("bgcolor = #00FF00",colour);
        colour = htmlGen.getTileColour(0,1,tilesVisited);
        assertEquals("bgcolor = #00FFFF",colour);
        colour = htmlGen.getTileColour(2,2,tilesVisited);
        assertEquals("bgcolor = #FFFF00",colour);
        colour = htmlGen.getTileColour(1,1,tilesVisited);
        assertEquals("bgcolor = #C4C4C4",colour);
    }

    /**
     * This test is used to check if a player is indicated to be only on the correct position. This means that the
     * player's icon would only appear on their position. Thus 2 positions are tested one with the player and one
     * without. It is expected the player icon HTML code to only appear on the former and the latter returning nothing.
     */
    @Test
    public void isPlayerOnTileTest(){
        xPos = 0;
        yPos = 3;
        players[playerNo] = new Player(xPos,yPos,mapSize, 1);
        playerPos = new Position();
        playerPos.setX(xPos);
        playerPos.setY(yPos);

        String playerMarker = htmlGen.isPlayerOnTile(mapSize-yPos-1, xPos);
        assertEquals("<i class='fas fa-male' style='font-size:24px'></i>",playerMarker);
        playerMarker = htmlGen.isPlayerOnTile(0, 0);
        assertEquals("",playerMarker);
    }
}
