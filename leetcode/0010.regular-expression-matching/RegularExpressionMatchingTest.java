import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class RegularExpressionMatchingTest {

    @Test
    public void test(){
        var inst = new RegularExpressionMatching();
        assertFalse(inst.isMatch("aa", "a"));
        assertTrue(inst.isMatch("aa", "a*"));
        assertTrue(inst.isMatch("ab", ".*"));
    }
}
