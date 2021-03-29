import java.util.Deque;
import java.util.LinkedList;

public class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0){
            return nums;
        }
        Deque<Integer> deque = new LinkedList<>();
        int i = 0;
        int[] result = new int[nums.length - k + 1];
        while (i < k) {
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.pollLast();
            }
            deque.addLast(nums[i]);
            i++;
        }
        result[0] = deque.peekFirst();
        for (; i < nums.length; i++) {
            if (deque.peekFirst() == nums[i - k]) {
                deque.pollFirst();
            }
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.pollLast();
            }
            deque.addLast(nums[i]);
            result[i - k + 1] = deque.peekFirst();
        }
        return result;
    }
}
