import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SingleNumberTest {

    @Test
    public void test(){
        SingleNumber inst = new SingleNumber();
        int[] case1 = new int[]{1,2,2,3,3};
        assertEquals(1, inst.singleNumber(case1));
    }
    
}
