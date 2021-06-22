import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ValidateStackSequencesTest {
  @Test
  public void test() {
    ValidateStackSequences inst = new ValidateStackSequences();
    assertEquals(true, inst.validateStackSequences(new int[] { 1, 2, 3, 4, 5 }, new int[] { 4, 5, 3, 2, 1 }));
  }
}
