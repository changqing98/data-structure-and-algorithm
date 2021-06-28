package leetcode.jian_zhi_offer.p0038_permutation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StringPermutation {

	public String[] permutation(String s) {
		char[] c = s.toCharArray();
		ArrayList<String> result = new ArrayList<>();
		dfs(c, 0, result);
		return result.toArray(new String[result.size()]);
	}

	private void dfs(char[] array, int k, List<String> result) {
		if (k == array.length) {
			result.add(String.valueOf(array));
			return;
		}
		Set<Character> set = new HashSet<>();
		for (int i = k; i < array.length; i++) {
			if (set.contains(array[i])) {
				continue;
			}
			set.add(array[i]);
			swap(array, i, k);
			dfs(array, k + 1, result);
			swap(array, i, k);
		}
	}

	private void swap(char[] array, int a, int b) {
		char tmp = array[a];
		array[a] = array[b];
		array[b] = tmp;
	}
}
