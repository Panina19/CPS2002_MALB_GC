package java.org.treasuremap.game;

public class Game {
    private static int turns;
//    private static Player [] players;
//    private static  Map map;



    public static void start(int playerCount, int mapSize) {
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


    private static void createPlayers(int playerCount) {}
    private static void generateHTMLFiles() {}
}
