import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CountBitOneTest {

    @Test
    public void test(){
        var inst = new CountBitOne();
        assertEquals(3, inst.countBitOne(0b00000000000000000000000000001011));
        assertEquals(31, inst.countBitOne(0b11111111111111111111111111111101));
    }
}
