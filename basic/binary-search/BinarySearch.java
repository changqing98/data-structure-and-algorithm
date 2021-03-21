public class BinarySearch {
	public int search(int target, int[] arr) {
		int l = 0;
		int r = arr.length - 1;
		while (l <= r) {
			int mid = (l + r) / 2;
			if (arr[mid] > target) {
				r = mid;
			} else if (arr[mid] < target) {
				l = mid + 1;
			} else {
				return mid;
			}
		}
		return -1;
	}

	public int searchLeftMost(int target, int[] arr) {
		int l = 0;
		int r = arr.length;
		while (l < r) {
			int mid = (l + r) / 2;
			if (arr[mid] >= target) {
				r = mid;
			} else {
				l = mid + 1;
			}
		}
		return l;
	}

	public int searchRightMost(int target, int[] arr) {
		int l = 0;
		int r = arr.length;
		while (l < r) {
			int mid = (l + r) / 2;
			if (arr[mid] > target) {
				r = mid;
			} else {
				l = mid + 1;
			}
		}
		return l - 1;
	}
}
