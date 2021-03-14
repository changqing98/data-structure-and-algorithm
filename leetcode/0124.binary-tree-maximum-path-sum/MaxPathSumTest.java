import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MaxPathSumTest {

    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        MaxPathSum inst = new MaxPathSum();
        int result = inst.maxPathSum(root);
        assertEquals(6, result);
    }
}
