from unittest import TestCase

from common.TreeNode import TreeNode

from . import InOrderTraversal


class TestInOrderTraversal(TestCase):
    def test_inorder_traversal(self):
        inst = InOrderTraversal()
        result = inst.inorderTraversal(TreeNode)
        self.assertEqual([4, 2, 5, 1, 3], result)
