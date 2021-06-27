package leetcode.p0633_sum_of_square_numbers;

public class JudgeSquareSum {
    public boolean judgeSquareSum(int c) {
        int left = 0;
        int right = (int) Math.sqrt(c);
        while (left <= right) {
            int sum = left * left + right * right;
            if (sum == c) {
                return true;
            } else if (sum < c) {
                left += 1;
            } else {
                right -= 1;
            }
        }
        return false;
    }
}