import org.junit.Assert;
import org.junit.Test;
import org.treasuremap.Main;

public class MainTest{

    @Test
    public void playerCountValidateAcceptTest(){
        Assert.assertTrue(Main.validatePlayerCount(5));
    }

    @Test
    public void playerCountValidateRejectLowTest(){
        Assert.assertFalse(Main.validatePlayerCount(1));
    }

    @Test
    public void playerCountValidateRejectHighTest(){
        Assert.assertFalse(Main.validatePlayerCount(10));
    }

    @Test
    public void mapSizeSmallValidateAcceptTest(){
        Assert.assertTrue(Main.validateMapSize(3,5));
    }

    @Test
    public void mapSizeLargeValidateAcceptTest(){
        Assert.assertTrue(Main.validateMapSize(5,8));
    }

    @Test
    public void mapSizeSmallValidateRejectLowTest(){
        Assert.assertFalse(Main.validateMapSize(3,4));
    }

    @Test
    public void mapSizeLargeValidateRejectLowTest(){
        Assert.assertFalse(Main.validateMapSize(5,7));
    }

    @Test
    public void mapSizeValidateRejectHighTest(){
        Assert.assertFalse(Main.validateMapSize(5,51));
    }

}
