package org.treasuremap.Player;
import org.treasuremap.Position;

public class Player {

    private Position position;
    private boolean[][] tilesVisited;
    private int mapSize;

    public Player (int xCoord, int yCoord, int mapSize){
        tilesVisited =  new boolean[mapSize][mapSize];

        position = new Position(xCoord,yCoord);
        this.mapSize = mapSize;
    }

    public Position getPosition(){
        return position;
    }

    public void setPosition(int x,int y){
        position.setX(x);
        position.setY(y);
        tilesVisited[x][y] = true;
    }
    public void move(char direction){
        Position Position = position;
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
