

package Player;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.treasuremap.Player.Player;
import org.treasuremap.Position;

public class PlayerTest{
    private Player player;

    @Before
    public void setup() {
        player = new Player(5,5,10);
    }

    @After
    public void cleanup() {
        player = null;
    }

    @Test
    public void playerMovesUpTest(){
        player.move('U');
        Assert.assertEquals(5,player.getPosition().getX());
        Assert.assertEquals(6,player.getPosition().getY());
    }
    @Test
    public void playerMovesDownTest(){
        player.move('D');
        Assert.assertEquals(5,player.getPosition().getX());
        Assert.assertEquals(4,player.getPosition().getY());
    }
    @Test
    public void playerMovesLeftTest(){
        player.move('L');
        Assert.assertEquals(4,player.getPosition().getX());
        Assert.assertEquals(5,player.getPosition().getY());
    }
    @Test
    public void playerMovesRightTest(){
        player.move('R');
        Assert.assertEquals(6,player.getPosition().getX());
        Assert.assertEquals(5,player.getPosition().getY());
    }
    @Test
    public void playerNonSpecifiedMoveTest(){
        player.move('I');
        Assert.assertEquals(5,player.getPosition().getX());
        Assert.assertEquals(5,player.getPosition().getY());
    }
    @Test
    public void playerInvalidMoveTest(){
        player.setPosition(0,0);
        player.move('L');
        Assert.assertEquals(0,player.getPosition().getX());
        Assert.assertEquals(0,player.getPosition().getY());
    }
}
