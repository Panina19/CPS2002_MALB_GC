package org.treasuremap;

import org.treasuremap.game.Game;

import java.util.Scanner;

public class Main {
    private static int playerCount;
    private static int mapSize;
    private static char mapType;
    private static Scanner scan;

    /**
     * This method checks if the number of players joinng the game fits in the limits given in the task overview.
     * @param playerCount - the number of players joining the game
     * @return boolean value according to the limits
     */
    public static boolean validatePlayerCount(int playerCount) {
        return (playerCount>=2 && playerCount<=8);
    }

    /**
     * This method checks if the map size assigned fits the limits of the scope of the assignment. This depends on
     * the playerCount variable
     * @param playerCount - the number of players joining the game
     * @param mapSize - the size of the map
     * @return boolean value according to the limits
     */
    public static boolean validateMapSize(int playerCount, int mapSize) {
        if (playerCount>=2 && playerCount<=4) {
            return (mapSize>=5 && mapSize<=50);
        }
        else return (mapSize>=8 && mapSize<=50);
    }

    public static boolean validateMapType(char mapType){
        return (mapType=='H'||mapType=='h'||mapType=='S'||mapType=='s');
    }

    /**
     * This method is used to gather the initial game information from the user related to the number of players
     */
    private static void gameQuestionPlayers() {
        System.out.println("How many players?");
        try {
            scan = new Scanner(System.in);
            playerCount = scan.nextInt();
            if (!validatePlayerCount(playerCount)) {
                System.out.println("Must have between 2 and 8 players.");
                gameQuestionPlayers();
            }
        } catch (Exception e) {
            System.out.println("Invalid input, let's try that again!");
            gameQuestionPlayers();
        }
    }

    /**
     * This method is used to gather the initial game information from the user related to the size of the map
     */
    private static void gameQuestionMapSize() {
        System.out.println("How big should the map be?");
        try {
            scan = new Scanner(System.in);
            mapSize = scan.nextInt();
            if (!validateMapSize(playerCount, mapSize)) {
                System.out.println("Map size restrictions:\n" +
                        "2-4 players: min 5x5 - max 50x50\n" +
                        "5-8 players: min 8x8 - max 50x50");
                gameQuestionMapSize();
            }
        } catch (Exception e) {
            System.out.println("Invalid input, let's try that again!");
            gameQuestionMapSize();
        }
    }

    /**
     * This method requests the type of map to the user, which shall be generated.
     */
    private static void gameQuestionMapType() {
        System.out.println("Choose Map Type: (S)afe or (H)azardous");
        try {
            scan = new Scanner(System.in);
            mapType = scan.next().charAt(0);
            if (!validateMapType(mapType)){
                System.out.println("Invalid map type, let's try again!");
                gameQuestionMapType();
            }
        } catch (Exception e) {
            System.out.println("Invalid input, let's try again!");
            gameQuestionMapType();
        }
    }

    /**
     * Main method, used to gather the initial game information and then run the game.
     */
    public static void main(String[] args) {
        System.out.println("-- TREASURE MAP --");
        gameQuestionPlayers();
        gameQuestionMapSize();
        gameQuestionMapType();
        Game.start(playerCount, mapSize, mapType);
    }

}
