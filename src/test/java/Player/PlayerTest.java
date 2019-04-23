

package Player;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.treasuremap.Player.Player;

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
        Assert.assertEquals(6,player.getPosition.getY());
    }
    @Test
    public void playerMovesDownTest(){
        player.move('D');
        Assert.assertEquals(4,player.getPosition.getY());
    }
    @Test
    public void playerMovesLeftTest(){
        player.move('L');
        Assert.assertEquals(4,player.getPosition.getX());
    }
    @Test
    public void playerMovesUpTest(){
        player.move('R');
        Assert.assertEquals(6,player.getPosition.getX());
    }
}
