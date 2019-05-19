package org.treasuremap.player;
import org.treasuremap.board.Position;
import org.treasuremap.observable.Observer;
import org.treasuremap.observable.Subject;

import java.util.ArrayList;

public class Player implements Observer, Subject {

    /**
     * The global variables declared here are:
     * mapSize:         Useful fot the tileVisited 2-d array, and checking if a player is within bound of the map
     * playerNumber:    Unique identifier for each player
     * startPosition:   Indicates the position each player started the game at
     * position:        Each player will be placed in a specific x and y coordinate on the map
     * tilesVisited:    A boolean 2-d array which shows which tiles have been uncovered,
     *                  useful when generating the HTML files
     * observers:       An array-list of all observers for this player
     * teamNumber:      An int representing which team this player belongs to
     */

    private int mapSize;
    private int playerNumber;
    private Position startPosition;
    private Position position;
    private boolean[][] tilesVisited;
    private ArrayList<Observer> observers;
    private int teamNumber;

    /**
     * A contructor to create an object of type player
     * @param xCoord    - indicates the x-coordinate, used to set up the player's position
     * @param yCoord    - indicates the y-coordinate, used to set up the player's position
     * @param mapSize   - indicates the length of a side of the square map (in tiles),
     *                    used to create the size of the 2d array of tilesVisited
     */
    public Player (int xCoord, int yCoord, int mapSize, int playerNumber, int teamNumber){
        this.mapSize = mapSize;
        this.playerNumber = playerNumber;
        this.observers = new ArrayList<Observer>();
        this.teamNumber = teamNumber;

        tilesVisited =  new boolean[mapSize][mapSize];

        startPosition = new Position(xCoord, yCoord);
        position = new Position(xCoord,yCoord);
        setPosition(xCoord,yCoord);
    }

    /**
     * Used to get the player's starting position
     * @return position object
     */
    public Position getStartPosition() {
        return startPosition;
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
        tilesVisited[mapSize - y-1][x] = true;
    }

    /**
     * Sets the player's position depending on the parameter below. Also updates the tilesVisited array to include the
     * new tile uncovered.
     * @param p - Position opbject representing the coordinates to move to
     */
    public void setPosition(Position p){
        position.setX(p.getX());
        position.setY(p.getY());
        tilesVisited[mapSize - p.getY()][p.getX()] = true;
    }

    /**
     * Used to get the player's map of visited tiles
     * @return tilesVisited 2d boolean array
     */
    public boolean[][] getTilesVisited(){
        return tilesVisited;
    }

    /**
     * Sets the player's tilesVisited array depending on the parameters below. Useful for tests.
     * @param newTilesVisited - the updated 2d boolean array
     */
    public void setTilesVisited(boolean[][] newTilesVisited){
        tilesVisited = newTilesVisited;
    }

    /**
     * Used to get the player's unique identifier
     * @return playerNumber integer
     */
    public int getPlayerNumber() {
        return playerNumber;
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
        notifyObservers();
    }

    /**
     * If the player that moved is in the same team as this player then update tiles visited.
     * @param teamNumber - the team of the player that moved.
     * @param pos - the position the player moved to.
     */
    public void update(int teamNumber, Position pos) {
        if (this.teamNumber==teamNumber)
            tilesVisited[mapSize - pos.getY()][pos.getX()] = true;
    }

    /**
     * Add an observer for the current player.
     * @param o - the observer to be registered.
     */
    public void register(Observer o) {
        observers.add(o);
    }

    /**
     * Remove an observer for the current player.
     * @param o - the observer to be removed.
     */
    public void unregister(Observer o) {
        observers.remove(o);
    }

    /**
     * Loops through all the current player's observers notifying them to update with
     * the new information.
     */
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this.teamNumber, this.position);
        }
    }
}
