package org.treasuremap.game;

import org.treasuremap.Player.Player;
import org.treasuremap.board.Map;
import org.treasuremap.board.Position;

import java.util.Scanner;

public class Game {
    private static int turns;
    private static Player[] players;
    private static Map map;
    private static boolean exit;
    private static Scanner scan;



    public static void start(int playerCount, int mapSize) {
        players = new Player[playerCount];
        exit = false;

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
        while (!exit) {
            for (Player p : players) {
                // Move player
                movePlayer(p);

                // Uncover tile

                // Check tile type and perform movement

            }
        }
    }

    private static char askMovement(Player p) {
        char movement;

        System.out.println("Movement options: U | D | L | R");
        scan = new Scanner(System.in);
        movement = scan.next().charAt(0);
        if (movement=='U' || movement=='D' || movement=='L' || movement=='R')
            return movement;
        else {
            System.out.println("Invalid movement option, try again");
            return askMovement(p);
        }
    }

    private static void movePlayer(Player p) {
        Position before = new Position(p.getPosition());
        p.move(askMovement(p));
        if(before.equals(p.getPosition())) {
            System.out.println("Cannot move out of map! Try again.");
            movePlayer(p);
        }
    }


    private static void createPlayers(int playerCount) {
        for (int i=0; i<playerCount; i++) {
            Position p = map.randomGrassPosition();
            players[i] = new Player(p.getX(), p.getY(), map.getSize());
        }
    }
    private static void generateHTMLFiles() {}
}
