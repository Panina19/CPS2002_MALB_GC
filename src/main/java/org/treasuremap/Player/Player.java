package org.treasuremap.Player;
import org.treasuremap.Position;

public class Player {

    /**
     * The global variables declared here are:
     * mapSize:         Useful fot the tileVisited 2-d array, and checking if a player is within bound of the map
     * Position:        Each player will be placed in a specific x and y coordinate on the map
     * tilesVisited:    A boolean 2-d array which shows which tiles have been uncovered,
     *                  useful when generating the HTML files
     */

    private int mapSize;
    private Position position;
    private boolean[][] tilesVisited;

    /**
     * A contructor to create an object of type Player
     * @param xCoord    - indicates the x-coordinate, used to set up the player's position
     * @param yCoord    - indicates the y-coordinate, used to set up the player's position
     * @param mapSize   - indicates the length of a side of the square map (in tiles),
     *                    used to create the size of the 2d array of tilesVisited
     */
    public Player (int xCoord, int yCoord, int mapSize){
        tilesVisited =  new boolean[mapSize][mapSize];

        position = new Position(xCoord,yCoord);
        this.mapSize = mapSize;
    }

    /**
     * Used to get the player's position
     * @return position object
     */
    public Position getPosition(){
        return position;
    }

    /**
     * Sets the player's position depending on the parameters below. Also updates the tilesVisited array to include the
     * new tile uncovered.
     * @param x - represents the x coordinate
     * @param y - represents the y coordinate
     */
    public void setPosition(int x, int y){
        position.setX(x);
        position.setY(y);
        tilesVisited[x][y] = true;
    }

    /**
     * Tries to move the player 1 tile to the specified direction. If it goes out of the map boundaries or is an
     * invalid character then the player doesn't move. When the move is valid, the player's position is updated.
     * @param direction - a character indicating which tile the player should move to.
     */
    public void move(char direction){
        int newX = position.getX();
        int newY = position.getY();
        switch (direction){
            case 'U':
                newY++;
                if(newY < mapSize) {
                    setPosition(position.getX(), position.getY() + 1);
                }
                break;
            case 'D':
                newY--;
                if(newY >= 0) {
                    setPosition(position.getX(), position.getY() - 1);
                }
                break;
            case 'L':
                newX--;
                if(newX >= 0) {
                    setPosition(position.getX() - 1, position.getY());
                }
                break;
            case 'R':
                newX++;
                if(newX < mapSize) {
                    setPosition(position.getX() + 1, position.getY());
                }
                break;
            default:
                break;
        }
    }
}
