# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def hasPathSum(self, root, sum):
        """
        :type root: TreeNode
        :type sum: int
        :rtype: bool
        """
        if not root:
            return False

        sum -= root.val
        if not root.left and not root.right:  # if reach a leaf
            return sum == 0
        return self.hasPathSum(root.left, sum) or self.hasPathSum(root.right, sum)

# Iterations
class Solution:
    def hasPathSum(self, root, sum):
        """
        :type root: TreeNode
        :type sum: int
        :rtype: bool
        """
        if not root:
            return False

        deque = [(root, sum - root.val)]
        while deque:
            node, curr_sum = deque.pop()
            if not node.left and not node.right and curr_sum == 0:
                return True
            if node.right:
                deque.append((node.right, curr_sum - node.right.val))
            if node.left:
                deque.append((node.left, curr_sum - node.left.val))
        return False
