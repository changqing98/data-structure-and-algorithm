package nowcoder.nc0093_lru;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class LRUCacheTest {

  @Test
  public void test() {
    LRUCache test = new LRUCache();
    assertArrayEquals(new int[] {1, -1}, test.LRU(new int[][] {{1, 1, 1},
      {1, 2, 2}, {1, 3, 2},
      {2, 1}, {1, 4, 4}, {2, 2}}, 3));
  }
}

