package leetcode.jian_zhi_offer.p0020_is_number;

public class IsNumber {
	public boolean isNumber(String s) {
		boolean hasSign = false;
		boolean hasE = false;
		boolean hasNumber = false;
		boolean hasPoint = false;
		int i = 0;
		int len = s.length();
		while (i < len && s.charAt(i) == ' ') {
			i++;
		}
		while (i < len) {
			if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
				hasNumber = true;
				i++;
			} else if (s.charAt(i) == 'e' || s.charAt(i) == 'E') {
				if (!hasNumber || hasE) {
					return false;
				}
				hasE = true;
				hasSign = hasNumber = hasPoint = false;
				i++;
			} else if (s.charAt(i) == '+' || s.charAt(i) == '-') {
				if (hasSign || hasNumber || hasPoint) {
					return false;
				}
				i++;
			} else if (s.charAt(i) == '.') {
				if (hasPoint || hasE) {
					return false;
				}
				hasPoint = true;
				i++;
			} else {
				break;
			}
		}
		while (i < len && s.charAt(i) == ' ') {
			i++;
		}
		return hasNumber && i == len;
	}
}