public class RangeSumBST {
	public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null){
            return 0;
        }
        int cur = root.val >= low && root.val <= high ? root.val : 0;
        return cur + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
    }
}
