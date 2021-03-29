import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ReverseLeftWordsTest {
    @Test
    public void test(){
        ReverseLeftWords inst = new ReverseLeftWords();
        assertEquals("cdefab", inst.reverseLeftWords("abcdef", 2));
    }
}
