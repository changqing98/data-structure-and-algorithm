from unittest import TestCase

from InOrderTraversal import InOrderTraversal
from common import TreeNode


class TestInOrderTraversal(TestCase):
    def test_inorder_traversal(self):
        inst = InOrderTraversal()
        result = inst.inorderTraverse(TreeNode)
        self.assertEqual([4, 2, 5, 1, 3], result)
