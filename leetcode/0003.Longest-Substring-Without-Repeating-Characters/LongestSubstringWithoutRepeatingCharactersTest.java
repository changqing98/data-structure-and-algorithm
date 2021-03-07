import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LongestSubstringWithoutRepeatingCharactersTest {

    @Test
    public void test(){
        LongestSubstringWithoutRepeatingCharacters inst = new LongestSubstringWithoutRepeatingCharacters();
        String case1 = "abcabcbb";
        int resutl1 = 3;
        assertEquals(resutl1, inst.lengthOfLongestSubstring(case1));
        String case2 = "bbbbb";
        int resutl2 = 1;
        assertEquals(resutl2, inst.lengthOfLongestSubstring(case2));
    }
    
}
