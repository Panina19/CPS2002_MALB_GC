package player;

import org.treasuremap.player.Player;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.treasuremap.board.Position;

public class PlayerTest{
    private Player player;
    private Position pos;
    /**
     * Sets up a new object of type player, with the size of map as 10 and the player's position at (5,5)
     */
    @Before
    public void setup() {
        player = new Player(5,5,10, 1, 1);
    }

    /**
     * Nullifies the player object
     */
    @After
    public void cleanup() {
        player = null;
        pos = null;
    }

    /**
     * Tests the move up function expects from the player's position of (5,5) to be updated to become (5,6)
     */
    @Test
    public void playerMovesUpTest(){
        player.move('U');
        Assert.assertEquals(5,player.getPosition().getX());
        Assert.assertEquals(6,player.getPosition().getY());
    }

    /**
     * Tests the move down function expects from the player's position of (5,5) to be updated to become (5,4)
     */
    @Test
    public void playerMovesDownTest(){
        player.move('D');
        Assert.assertEquals(5,player.getPosition().getX());
        Assert.assertEquals(4,player.getPosition().getY());
    }

    /**
     * Tests the move left function expects from the player's position of (5,5) to be updated to become (4,5)
     */
    @Test
    public void playerMovesLeftTest(){
        player.move('L');
        Assert.assertEquals(4,player.getPosition().getX());
        Assert.assertEquals(5,player.getPosition().getY());
    }

    /**
     * Tests the move right function expects from the player's position of (5,5) to be updated to become (6,5)
     */
    @Test
    public void playerMovesRightTest(){
        player.move('R');
        Assert.assertEquals(6,player.getPosition().getX());
        Assert.assertEquals(5,player.getPosition().getY());
    }

    /**
     * Tests the non-existant move "I" function thus expects from the player's position of (5,5) to be updated to
     * become (5,5)
     */
    @Test
    public void playerNonSpecifiedMoveTest(){
        player.move('I');
        Assert.assertEquals(5,player.getPosition().getX());
        Assert.assertEquals(5,player.getPosition().getY());
    }

    /**
     *  Sets the player's position to (0,0) and moves left. This causes teh request of moving outside of the map. Thus
     *  we expect the player's position to go from (0,0) to (0,0).
     */
    @Test
    public void playerInvalidMoveTest(){
        player.setPosition(0,0);
        player.move('L');
        Assert.assertEquals(0,player.getPosition().getX());
        Assert.assertEquals(0,player.getPosition().getY());
    }

    /**
     * Test to ensure that a start position exists
     */
    @Test
    public void playerValidStartPositionTest(){
        pos = player.getStartPosition();
        Assert.assertNotNull(pos);
    }

    /**
     * Test to check that the setter of object type Position and integer type (x,y) do indeed work successfully
     */
    @Test
    public void setPositionValidTest(){
        pos = new Position(1,1);
        player.setPosition(pos);
        Assert.assertEquals(1,player.getPosition().getX());
        Assert.assertEquals(1,player.getPosition().getY());

        player.setPosition(2,2);
        Assert.assertEquals(2,player.getPosition().getX());
        Assert.assertEquals(2,player.getPosition().getY());
    }

    /**
     * Checks that the player is associated with an assigned player number.
     */

    @Test
    public void existingPlayerNumberTest(){
        Assert.assertNotNull(player.getPlayerNumber());
    }

    /**
     * Checks that the player is correctly associated with the assigned player number.
     */

    @Test
    public void correctPlayerNumberTest(){
        Assert.assertEquals(1,player.getPlayerNumber());
    }

    /**
     * Checks that players in the same team can see each other's tiles when notified
     */
    @Test
    public void notifyUpdatesAllTeamTiles() {
        Player player2 = new Player(0,0,10,2,1);
        player2.register(player);
        player.register(player2);

        player.notifyObservers();
        Assert.assertTrue(player2.getTilesVisited()[5][5]);
    }
}
