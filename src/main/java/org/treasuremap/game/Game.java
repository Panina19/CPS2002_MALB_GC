package org.treasuremap.game;

import org.treasuremap.display.HTMLGeneration;
import org.treasuremap.player.Player;
import org.treasuremap.board.Map;
import org.treasuremap.board.MapCreator;
import org.treasuremap.board.Position;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    private static int turns;
    private static Player[] players;
    private static List<Player> winners;
    private static Map map;
    private static boolean exit;
    private static Scanner scan;

    /**
     * Method used to start the game, by setting global variable exit as false (since its not signalled to be
     * terminated yet), creating an array of players, a new map and calling the respective functions.
     * @param playerCount - number of players joining the game
     * @param mapSize - size of side of the map
     */
    public static void start(int playerCount, int mapSize, char mapType) {
        turns=0;
        players = new Player[playerCount];
        winners = new ArrayList<Player>();
        exit = false;

        // Generate Map, according to the type
        MapCreator mapCreator = new MapCreator();
        map = mapCreator.createMap(mapType, mapSize);

        // Create Players
        createPlayers(playerCount);

        // Generate HTML files for each player
        generateHTMLFiles();

        // Start game loop
        loop();

    }

    /**
     * This method represents a run of a round between each player in the list asking them to move, upon valid moves,
     * their position is updated thus so is their tilesVisited 2d array. The tile landed on is checked to see if it's
     * grass, water or treasure. In the first case nothing happens. In the second case the player restarts from the
     * starting position next turn. In the last case the exit is updated to true and the player wins, however the round
     * continues till all the players finish in case of ties.
     */
    private static void loop() {
        while (!exit) {
            turns++;
            // Request player movement
            for (Player p : players) {
                movePlayer(p);
            }

            // Check tiles players moved to
            for (Player p : players) {
                switch (map.getTileType(p.getPosition())) {
                    case TREASURE:
                        winners.add(p);
                        break;
                    case WATER:
                        p.setPosition(p.getStartPosition());
                    case GRASS: break;
                    default: break;
                }
            }

            // display players' respective map
            generateHTMLFiles();

            // Declare winners
            if (winners.size()!=0){
                declareWinners();
                exit=true;
            }
        }
    }

    /**
     * This method requests the direction of movement to the user and retrieves it to the system. Ensures to check the
     * inputted direction is valid.
     * @param p - the player associated
     * @return the valid inputted character
     */
    private static char askMovement(Player p) {
        char movement;

        System.out.println("Player # "+ p.getPlayerNumber() +", Movement options: U | D | L | R");
        scan = new Scanner(System.in);
        movement = scan.next().charAt(0);
        if (movement=='U' || movement=='D' || movement=='L' || movement=='R')
            return movement;
        else {
            System.out.println("Invalid movement option, try again");
            return askMovement(p);
        }
    }

    /**
     * Method used to move the player by calling the askMovement method and also the player move method from the player
     * class, if the position remains the same that implies the boundaries of the wall were hit. Thus the method starts
     * over.
     * @param p - the associated player
     */
    private static void movePlayer(Player p) {
        Position before = new Position(p.getPosition());
        p.move(askMovement(p));
        if(before.equals(p.getPosition())) {
            System.out.println("Cannot move out of map! Try again.");
            movePlayer(p);
        }
    }

    /**
     * Method to setup the players and assign them their respective random starting position
     * @param playerCount - the number of players in the game
     */
    private static void createPlayers(int playerCount) {
        for (int i=0; i<playerCount; i++) {
            Position p = map.randomGrassPosition();
            players[i] = new Player(p.getX(), p.getY(), map.getSize(), i+1, 1);
        }
    }

    /**
     * Method calling the HTMLGeneration class to display the contents, i.e. map, of each player in a round.
     */
    private static void generateHTMLFiles() {
        for (int i=0; i<players.length; i++)
            try {
                new HTMLGeneration(players, i, map, turns).displayFile();
            } catch(IOException e){
                e.printStackTrace();
            }
    }

    /**
     * Displays the winners of the game on screen.
     */
    private static void declareWinners() {
        if (winners.size()==1){
            System.out.println("The winner is player " + winners.get(0).getPlayerNumber());
        }
        else {
            System.out.print("The winners are: ");
            for (Player p : winners) {
                System.out.print("Player " + p.getPlayerNumber() + " ");
            }
        }
    }
}
