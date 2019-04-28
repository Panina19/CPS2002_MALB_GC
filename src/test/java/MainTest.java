import org.junit.Assert;
import org.junit.Test;
import org.treasuremap.Main;

public class MainTest{

    /**
     * Tests validating an appropriate player count
     */
    @Test
    public void playerCountValidateAcceptTest(){
        Assert.assertTrue(Main.validatePlayerCount(5));
    }

    /**
     * Tests validating an inappropriate (too low) player count
     */
    @Test
    public void playerCountValidateRejectLowTest(){
        Assert.assertFalse(Main.validatePlayerCount(1));
    }

    /**
     * Tests validating an inappropriate (too high) player count
     */
    @Test
    public void playerCountValidateRejectHighTest(){
        Assert.assertFalse(Main.validatePlayerCount(10));
    }

    /**
     * Tests validating an appropriate map size, of a smaller setting
     */
    @Test
    public void mapSizeSmallValidateAcceptTest(){
        Assert.assertTrue(Main.validateMapSize(3,5));
    }

    /**
     * Tests validating an appropriate map size, of a larger setting
     */
    @Test
    public void mapSizeLargeValidateAcceptTest(){
        Assert.assertTrue(Main.validateMapSize(5,8));
    }

    /**
     * Tests validating an inappropriate (too low) map size, of a smaller setting
     */
    @Test
    public void mapSizeSmallValidateRejectLowTest(){
        Assert.assertFalse(Main.validateMapSize(3,4));
    }

    /**
     * Tests validating an inappropriate (too low) map size, of a larger setting
     */
    @Test
    public void mapSizeLargeValidateRejectLowTest(){
        Assert.assertFalse(Main.validateMapSize(5,7));
    }

    /**
     * Tests validating an inappropriate (too high) map size
     */
    @Test
    public void mapSizeValidateRejectHighTest(){
        Assert.assertFalse(Main.validateMapSize(5,51));
    }

}
