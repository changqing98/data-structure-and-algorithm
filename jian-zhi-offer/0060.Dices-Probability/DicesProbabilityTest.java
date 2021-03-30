import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DicesProbabilityTest {
    @Test
    public void test(){
        var inst = new DicesProbability();
        var expect = new double[]{0.02778,0.05556,0.08333,0.11111,0.13889,0.16667,0.13889,0.11111,0.08333,0.05556,0.02778};
        var result = inst.dicesProbability(2);
        for(int i = 0; i < result.length; i++){
            assertEquals(expect[i], result[i], 0.0001);
        }
    }
    
}
