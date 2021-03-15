public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        return root == null ? true : helper(root.left, root.right);
    }

    public boolean helper(TreeNode left, TreeNode right){
        if(left == null && right == null){
            return true;
        }
        if(left == null || right == null || left.val != right.val){
            return false;
        }
        return helper(left.left, right.right) && helper(left.right, right.left);
    }

    public static void main(String[] args) {

    }

	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}