import org.junit.Assert;
import org.junit.Test;
import org.treasuremap.Main;

public class MainTest{

    @Test
    public static void playerCountValidateAcceptTest(){
        Main.playerCount = 5;
        Assert.assertTrue(Main.validatePlayerCount());
    }

    @Test
    public static void playerCountValidateRejectLowTest(){
        Main.playerCount = 1;
        Assert.assertFalse(Main.validatePlayerCount());
    }

    @Test
    public static void playerCountValidateRejectHighTest(){
        Main.playerCount = 1;
        Assert.assertFalse(Main.validatePlayerCount());
    }

    @Test
    public static void mapSizeSmallValidateAcceptTest(){
        Main.playerCount = 3;
        Main.mapSize = 5;
        Assert.assertTrue(Main.validateMapSize());
    }

    @Test
    public static void mapSizeLargeValidateAcceptTest(){
        Main.playerCount = 5;
        Main.mapSize = 8;
        Assert.assertTrue(Main.validateMapSize());
    }

    @Test
    public static void mapSizeSmallValidateRejectLowTest(){
        Main.playerCount = 3;
        Main.mapSize = 4;
        Assert.assertFalse(Main.validateMapSize());
    }

    @Test
    public static void mapSizeLargeValidateRejectLowTest(){
        Main.playerCount = 5;
        Main.mapSize = 7;
        Assert.assertFalse(Main.validateMapSize());
    }

    @Test
    public static void mapSizeValidateRejectHighTest(){
        Main.playerCount = 5;
        Main.mapSize = 51;
        Assert.assertFalse(Main.validateMapSize());
    }

}
