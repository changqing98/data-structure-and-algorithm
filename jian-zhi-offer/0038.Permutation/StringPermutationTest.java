import org.junit.Test;

public class StringPermutationTest {

	@Test
	public void test() {
		StringPermutation test = new StringPermutation();
		var result = test.permutation("asd");
		for (String str : result) {
			System.out.println(str);
		}
	}
}
