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
    private boolean [][] tilesVisited;
    private int mapSize;
    private int playerNo;
    private Position playerPos;
    private int xPos, yPos;
    private HTMLGeneration htmlGen;

    @Before
    public void setup() {
        turnNo = 1;
        mapSize = 5;
        playerNo = 0;
        player = new Player(0, 0,mapSize);
        map = new Map(mapSize);         
        players = new Player[1];
        players[0] = player;
        tilesVisited = new boolean[mapSize][mapSize];
        htmlGen = null;
        htmlGen = new HTMLGeneration(players, playerNo, map, turnNo);
    }

    @After
    public void tearDown(){
        player = null;
        map = null;
        htmlGen = null;
        turnNo = 0;
        tilesVisited = null;
        mapSize = 0;
        players = null;
        playerNo = 0;
        playerPos = null;
        xPos = 0;
        yPos = 0;
    }

    @Test
    public void getTileColourTest() {
        boolean[][] tilesVisited = {
                {true ,true ,true ,true ,true },
                {true ,false,false,false,false},
                {true ,false,true ,false,true },
                {false,false,true ,false,true },
                {true ,true ,true ,true ,true }};
        player.setTilesVisited(tilesVisited);
        Tile [][] tileMap = {
                {Tile.GRASS,Tile.WATER,Tile.GRASS,Tile.GRASS,Tile.GRASS},
                {Tile.GRASS,Tile.WATER,Tile.GRASS,Tile.GRASS,Tile.GRASS},
                {Tile.GRASS,Tile.GRASS,Tile.TREASURE,Tile.GRASS,Tile.WATER},
                {Tile.GRASS,Tile.GRASS,Tile.GRASS,Tile.GRASS,Tile.GRASS},
                {Tile.GRASS,Tile.WATER,Tile.GRASS,Tile.GRASS,Tile.GRASS}
        };
        map.setMap(tileMap);
        String colour = htmlGen.getTileColour(0,0,map,tilesVisited);
        assertEquals("bgcolor = #00FF00",colour);
        colour = htmlGen.getTileColour(0,1,map,tilesVisited);
        assertEquals("bgcolor = #00FFFF",colour);
        colour = htmlGen.getTileColour(2,2,map,tilesVisited);
        assertEquals("bgcolor = #FFFF00",colour);
        colour = htmlGen.getTileColour(1,1,map,tilesVisited);
        assertEquals("bgcolor = #C4C4C4",colour);
    }

    @Test
    public void isPlayerOnTileTest(){
        xPos = 0;
        yPos = 3;
        players[playerNo] = new Player(xPos,yPos,mapSize);
        playerPos = new Position();
        playerPos.setX(xPos);
        playerPos.setY(yPos);

        String playerMarker = htmlGen.isPlayerOnTile(players, playerNo, xPos, yPos);
        assertEquals("<i class='fas fa-male' style='font-size:24px'></i>",playerMarker);
        playerMarker = htmlGen.isPlayerOnTile(players, playerNo, 0, 0);
        assertEquals("",playerMarker);
    }
}
