package org.treasuremap.game;

import org.treasuremap.Player.Player;
import org.treasuremap.board.Map;
import org.treasuremap.board.Position;

public class Game {
    private static int turns;
    private static Player[] players;
    private static Map map;



    public static void start(int playerCount, int mapSize) {
        players = new Player[playerCount];

        // Generate Map
        // TODO: map object

        // Create Players
        createPlayers(playerCount);

        // Generate HTML files for each player
        generateHTMLFiles();

        // Start game loop
        loop();

    }

    private static void loop() {
        // Ask directions

        // Uncover tile

        // Check tile type and perform movement
        
    }


    private static void createPlayers(int playerCount) {
        for (int i=0; i<playerCount; i++) {
            Position p = map.randomGrassPosition();
            players[i] = new Player(p.getX(), p.getY(), map.getSize());
        }
    }
    private static void generateHTMLFiles() {}
}
