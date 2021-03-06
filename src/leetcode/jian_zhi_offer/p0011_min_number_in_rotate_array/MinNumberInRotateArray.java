package leetcode.jian_zhi_offer.p0011_min_number_in_rotate_array;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */
public class MinNumberInRotateArray {
	static int minNumberInRotateArray(int[] nums) {
		int l = 0;
		int r = nums.length - 1;
		while (l <= r) {
			int mid = l + (r - l) / 2;
			if (nums[l] < nums[r]) {
				return nums[l];
			}
			if (nums[mid] > nums[mid + 1]) {
				return nums[mid + 1];
			}
			if (nums[mid] < nums[mid - 1]) {
				return nums[mid];
			}
			if (nums[mid] > nums[0]) {
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}
		return nums[l];
	}

	public static void main(String[] args) {
		System.out.println(minNumberInRotateArray(new int[]{4, 5, 6, 1, 2, 3}));
	}
}
