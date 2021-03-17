public class MaximunDepthOfBinaryTree {
    public int maxDepth(TreeNodeTraversal root) {
        if(root == null){
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
