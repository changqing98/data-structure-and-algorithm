package jian_zhi_offer.p0021_reorder_array;

public class ReOrderArray {

	/**
	 * 需要保证相对顺序
	 */
	static void reOrderArray(int[] array) {
		int k = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] % 2 == 1) {
				int tem = array[i];
				int j = i;
				while (k < j) {
					array[j] = array[j - 1];
					j--;
				}
				array[j] = tem;
				k++;
			}
		}
	}

	/**
	 * 不需要保证相对顺序
	 */
	public int[] exchange(int[] nums) {
		int i = 0;
		int j = nums.length - 1;
		while (i < j) {
			while (i < j && (nums[i] & 1) == 1) {
				i++;
			}
			while (i < j && (nums[j] & 1) == 0) {
				j--;
			}
			swap(nums, i, j);
		}
		return nums;
	}

	private void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}

	public static void main(String[] args) {
		int[] a = new int[] { 1, 5, 2, 6, 7, 8, 3 };
		reOrderArray(a);
		for (int i : a) {
			System.out.print(i + " ");
		}
	}
}
