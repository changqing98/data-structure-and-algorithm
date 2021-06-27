package leetcode.p1011_capacity_to_ship_packages_within_d_days;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ShipWithinDaysTest {
  @Test
  public void test() {
    ShipWithinDays test = new ShipWithinDays();
    assertEquals(3, test.shipWithinDays(new int[] {1, 2, 3, 1, 1}, 4));
    assertEquals(6, test.shipWithinDays(new int[] {3, 2, 2, 4, 1, 4}, 3));
    assertEquals(15, test.shipWithinDays(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 5));
  }
}
