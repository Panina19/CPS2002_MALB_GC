package org.treasuremap;

public class Position {
    private int xCoord;
    private int yCoord;

    public Position(){}

    public Position(int xCoord, int yCoord){
        this.xCoord = xCoord;
        this.yCoord = yCoord;
    }

    public void setX(int xCoord){
        this.xCoord = xCoord;
    }
    public void setY(int yCoord){
        this.yCoord = yCoord;
    }

    public int getX(){
        return xCoord;
    }

    public int getY(){
        return yCoord;
    }
}
