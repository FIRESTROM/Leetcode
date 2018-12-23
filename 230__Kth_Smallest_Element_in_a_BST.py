# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def kthSmallest(self, root, k):
        """
        :type root: TreeNode
        :type k: int
        :rtype: int
        """
        stack = []
        def helper(root):
            if root is None:
                return
            helper(root.left)
            stack.append(root.val)
            helper(root.right)
        helper(root)
        return stack[k - 1]

# Another solution (Faster)


# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def kthSmallest(self, root, k):
        """
        :type root: TreeNode
        :type k: int
        :rtype: int
        """
        stack = []
        node = root
        # Add all left node
        while node:
            stack.append(node)
            node = node.left

        while stack != []:
            node = stack.pop()
            k -= 1 # Smallest till now
            if k == 0:
                return node.val
            node = node.right
            while node:
                stack.append(node)
                node = node.left
