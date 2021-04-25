public class IncreasingOrderSearchTree {
	TreeNode head = new TreeNode(-1);
    TreeNode pre = head;
    public TreeNode increasingBST(TreeNode root) {
        dfs(root);
        return head.right;
    }

    public void dfs(TreeNode root){
        if(root != null){
            dfs(root.left);
            pre.right = new TreeNode(root.val);
            pre = pre.right;
            dfs(root.right);
        }
    }
}
