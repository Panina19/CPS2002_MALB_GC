package org.treasuremap;

import java.util.Scanner;

public class Main {
    public static int playerCount;
    public static int mapSize;
    public static Scanner scan = new Scanner(System.in);

    public static void validatePlayerCount() {

    }

    public static void validateMapSize() {

    }

    private static void gameQuestionPlayers() {
        System.out.println("How many players?");
        try {
            playerCount = scan.nextInt();
            validatePlayerCount();
        } catch (Exception e) {
            System.out.println("Invalid input, let's try that again!");
            gameQuestionPlayers();
        }
    }

    private static void gameQuestionMapSize() {
        System.out.println("How big should the map be?");
        try {
            mapSize = scan.nextInt();
            validateMapSize();
        } catch (Exception e) {
            System.out.println("Invalid input, let's try that again!");
            gameQuestionMapSize();
        }
    }
}
