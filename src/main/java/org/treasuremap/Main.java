package org.treasuremap;

import org.treasuremap.game.Game;

import java.util.Scanner;

public class Main {
    private static int playerCount;
    private static int mapSize;
    private static Scanner scan;

    public static boolean validatePlayerCount(int playerCount) {
        return (playerCount>=2 && playerCount<=8);
    }

    public static boolean validateMapSize(int playerCount, int mapSize) {
        if (playerCount>=2 && playerCount<=4) {
            return (mapSize>=5 && mapSize<=50);
        }
        else return (mapSize>=8 && mapSize<=50);
    }

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

    public static void main(String[] args) {
        System.out.println("-- TREASURE MAP --");
        gameQuestionPlayers();
        gameQuestionMapSize();
        Game.start(playerCount, mapSize);
    }
}
