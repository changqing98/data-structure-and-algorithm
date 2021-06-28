package leetcode.jian_zhi_offer.p0033_verifysquenceofbst;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */
public class VerifyBSTPostOrder {

    public boolean verifyPostorder(int[] postorder) {
        return dfs(postorder, 0, postorder.length - 1);
    }

    public boolean dfs(int[] postorder, int start, int end) {
        if (start >= end) {
            return true;
        }
        int root = postorder[end];
        int rightTreeStart = start;
        while (rightTreeStart < end && postorder[rightTreeStart] < root) {
            rightTreeStart++;
        }
        for (int i = rightTreeStart; i < end; i++) {
            if (postorder[i] < root) {
                return false;
            }
        }
        return dfs(postorder, start, rightTreeStart - 1) && dfs(postorder, rightTreeStart, end - 1);
    }
}
