import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.shellcode.Calculator;

import static org.junit.Assert.fail;

public class CalculatorTest{
    private Calculator calc;

    @Before
    public void setup() {
        calc = new Calculator();
    }

    @After
    public void cleanup() {
        calc = null;
    }

    @Test
    public void addTest() {
        Assert.assertEquals(3, calc.add(1, 2));
    }

    @Test
    public void subtractTest() {
        Assert.assertEquals(0, calc.subtract(2, 2));
    }

    @Test
    public void multiplyTest() {
        Assert.assertEquals(10, calc.multiply(5, 2));
    }

    @Test
    public void divideTest() {
        Assert.assertEquals(2, calc.divide(10, 5));
    }

    @Test(expected = IllegalArgumentException.class)
    public void divideBy0Test() {
        calc.divide(10, 0);
    }
}
