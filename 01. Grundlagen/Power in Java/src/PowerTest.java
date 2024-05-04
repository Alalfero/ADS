import static org.junit.Assert.*;

import org.junit.Test;

public class PowerTest {

  @Test
  public void test1() {
    assertEquals(Power.powerMod( 2,    8,  1000), 256);
    assertEquals(Power.powerMod( 2,   16,   100), 36);
    assertEquals(Power.powerMod(10,   10,   100),  0);
    assertEquals(Power.powerMod(42,   20,  1232), 672);
    assertEquals(Power.powerMod(17, 4711,  1234), 425);
 
  }

  @Test
  public void test2() {

    assertEquals(Power.fastPowerMod( 2,   16,   100), 36);
    assertEquals(Power.fastPowerMod(10,   10,   100),  0);
    assertEquals(Power.fastPowerMod(42,   20,  1232), 672);
    assertEquals(Power.fastPowerMod(17, 4711,  1234), 425);

  }
}
