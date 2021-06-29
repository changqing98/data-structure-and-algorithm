package leetcode.jian_zhi_offer.p0020_is_number;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class IsNumberTest {

	@Test
	public void test() {
		IsNumber test = new IsNumber();
		assertFalse(test.isNumber("e"));
		assertFalse(test.isNumber("+"));
		assertTrue(test.isNumber("32.e-80123"));
		assertTrue(test.isNumber(".1"));
	}

}
