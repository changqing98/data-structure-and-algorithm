public class BinarySearch {
	public int search(int target, int[] arr) {
		int l = 0;
		int r = arr.length - 1;
		while (l <= r) {
			int mid = l + (r - l) / 2;
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
		int r = arr.length - 1;
		int result = -1;
		while (l <= r) {
			int mid = l + (r - l) / 2;
			if (arr[mid] >= target) {
				r = mid - 1;
			} else {
				l = mid + 1;
			}
			if (arr[mid] == target) {
				result = mid;
			}
		}
		return result;
	}

	public int searchRightMost(int target, int[] arr) {
		int l = 0;
		int r = arr.length - 1;
		int result = -1;
		while (l <= r) {
			int mid = l + (r - l) / 2;
			if (arr[mid] <= target) {
				l = mid + 1;
			} else {
				r = mid - 1;
			}
			if (arr[mid] == target) {
				result = mid;
			}
		}
		return result;
	}
}
