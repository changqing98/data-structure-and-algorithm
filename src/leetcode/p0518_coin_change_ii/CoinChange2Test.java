import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CoinChange2Test {

  @Test
  public void test() {
    CoinChange2 test = new CoinChange2();
    assertEquals(4, test.change(5, new int[] {1, 2, 5}));
  }

}
