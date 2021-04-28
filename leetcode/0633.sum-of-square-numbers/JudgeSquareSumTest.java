import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class JudgeSquareSumTest {

    @Test
    public void test() {
        JudgeSquareSum test = new JudgeSquareSum();
        assertEquals(true, test.judgeSquareSum(5));
        assertEquals(false, test.judgeSquareSum(3));
        assertEquals(true, test.judgeSquareSum(4));
        assertEquals(true, test.judgeSquareSum(2));
    }
}
