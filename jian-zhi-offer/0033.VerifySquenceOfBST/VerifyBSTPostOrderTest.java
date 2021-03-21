import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class VerifyBSTPostOrderTest {

    @Test
    public void test() {
        VerifyBSTPostOrder inst = new VerifyBSTPostOrder();
        int[] arr = new int[] { 1, 6, 3, 2, 5 };
        boolean result = false;
        assertEquals(result, inst.verifyPostorder(arr));

        arr = new int[] { 1, 3, 2, 6, 5 };
        result = true;
        assertEquals(result, inst.verifyPostorder(arr));
    }
}
