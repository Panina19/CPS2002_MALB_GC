package org.treasuremap.board;

public class Position {

    /**
     * The global variables represent the x and y coordinate which shall be used for every position
     */
    private int xCoord;
    private int yCoord;

    /**
     * Default constructor, creates object named Position
     */
    public Position(){}

    /**
     * Constructor of a Position object with ready coordinates to set.
     * Notice if any coordinate value has a negative value, it is set to 0.
     * @param xCoord - represents the x coordinate value of the Position
     * @param yCoord - represents the y coordinate value of the Position
     */
    public Position(int xCoord, int yCoord){
        if(xCoord >= 0) {
            this.xCoord = xCoord;
        } else{
            this.xCoord = 0;
        }
        if(yCoord >= 0){
            this.yCoord = yCoord;
        } else{
            this.yCoord = 0;
        }
    }

    /**
     * Constructor of a Position object to copy the coords of a different Position object.
     * @param p - represents the Position object used to copy the coords
     */
    public Position(Position p) {
        this.xCoord = p.getX();
        this.yCoord = p.getY();
    }

    /**
     * Sets the x coordinate value of the position
     * @param xCoord - the x coordinate value to be set to
     */
    public void setX(int xCoord){
        this.xCoord = xCoord;
    }

    /**
     * Sets the x coordinate value of the position
     * @param yCoord - the x coordinate value to be set to
     */
    public void setY(int yCoord){
        this.yCoord = yCoord;
    }

    /**
     * Gets the x coordinate value of the position
     * @return the x coordinate
     */
    public int getX(){
        return xCoord;
    }

    /**
     * Gets the y coordinate value of the position
     * @return the y coordinate
     */
    public int getY(){
        return yCoord;
    }

    /**
     * Method used in game and tests to indicate if a position object is equal to the current position
     * @param obj the object to be compared
     * @return true or false, depending if the object is equal to the current position or not.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (obj instanceof Position)
            return (this.xCoord==((Position) obj).getX() && this.yCoord==((Position) obj).getY());
        return false;
    }
}
