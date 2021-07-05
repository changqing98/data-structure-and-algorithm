package nowcoder.nc0041_max_length;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MaxLengthTest {

  @Test
  public void test() {
    MaxLength test = new MaxLength();
    assertEquals(3, test.maxLength(new int[] {3, 3, 2, 1, 3, 3, 3, 1}));
  }
}
