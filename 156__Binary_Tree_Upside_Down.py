# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def upsideDownBinaryTree(self, root):
        """
        :type root: TreeNode
        :rtype: TreeNode
        """
        if root is None:
            return None

        def recursive(node):
            if node.left is None: # if node.left is None, node.right is None.
                return node, node

            root, rightest = recursive(node.left)

            if node.right:
                rightest.left = node.right
                rightest.left.left = None
                rightest.left.right = None

            node.left = None
            node.right = None
            rightest.right = node

            return root, node
        return recursive(root)[0]


# Or Simpler Way to Code
class Solution(object):
    def upsideDownBinaryTree(self, root):
        """
        :type root: TreeNode
        :rtype: TreeNode
        """
        if root:
            left = self.upsideDownBinaryTree(root.left)
            if root.left:
                root.left.right, root.left.left = root, root.right
                root.right, root.left = None, None
            return left or root
