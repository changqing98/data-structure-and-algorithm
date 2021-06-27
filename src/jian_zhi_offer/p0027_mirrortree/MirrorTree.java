package jian_zhi_offer.p0027_mirrortree;

import java.util.Stack;

import common.TreeNode;

public class MirrorTree {
    /**
     * 递归算法
     */
    public TreeNode mirrorTree(TreeNode root) {
        if (root != null) {
            TreeNode tmp = root.left;
            root.left = mirrorTree(root.right);
            root.right = mirrorTree(tmp);
        }
        return root;
    }

    /**
     * 镜像二叉树非递归
     */
    public TreeNode mirrorTreeNonRecursion(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode result = root;
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                TreeNode tmp = root.left;
                root.left = root.right;
                root.right = tmp;
                stack.add(root);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }
        return result;
    }
}
