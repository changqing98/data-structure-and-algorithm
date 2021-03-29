import static org.junit.Assert.assertArrayEquals;

public class MaxSlidingWindowTest {
    @Test
    public void test() {
        MaxSlidingWindow inst = new MaxSlidingWindow();
        assertArrayEquals(new int[] {}, inst.maxSlidingWindow(new int[] {}, 0));
 		int[] case1 = new int[] { 1, 3, -1, -3, 5, 3, 6, 7 };
		int[] result1 = new int[] { 3, 3, 5, 5, 6, 7 };
        assertArrayEquals(result1, inst.maxSlidingWindow(case1, 3));
    }
}
