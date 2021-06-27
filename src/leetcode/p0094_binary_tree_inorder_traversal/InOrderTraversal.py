from typing import List

from common.TreeNode import TreeNode


class InOrderTraversal:
  def inorderTraverse(self, root: TreeNode) -> List[int]:
    result = []
    stack = []
    while root or stack:
      while root:
        stack.append(root)
        root = root.left
      root = stack.pop()
      result.append(root.val)
      root = root.right
    return result
