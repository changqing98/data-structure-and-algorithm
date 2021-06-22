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
		int r = arr.length - 1;
		while (l <= r) {
			int mid = (l + r) / 2;
			if (arr[mid] == target) {
				if (mid == 0 || arr[mid - 1] != target) {
					return mid;
				} else {
					l = mid - 1;
				}
			} else if (arr[mid] > target) {
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}
		return -1;
	}

	public int searchRightMost(int target, int[] arr) {
		int l = 0;
		int r = arr.length - 1;
		while (l <= r) {
			int mid = (l + r) / 2;
			if (arr[mid] == target) {
				if (mid == arr.length - 1 || arr[mid + 1] != target) {
					return mid;
				} else {
					l = mid + 1;
				}
			} else if (arr[mid] > target) {
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}
		return -1;
	}
}
