import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CountBitOneTest {

    @Test
    public void test1(){
        var inst = new CountBitOne();
        assertEquals(3, inst.hammingWeight(0b00000000000000000000000000001011));
        assertEquals(31, inst.hammingWeight(0b11111111111111111111111111111101));
    }

    @Test
    public void test2(){
        var inst = new CountBitOne();
        assertEquals(3, inst.hammingWeight2(0b00000000000000000000000000001011));
        assertEquals(31, inst.hammingWeight2(0b11111111111111111111111111111101));
    }
}
