# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def pathSum(self, root, sum):
        """
        :type root: TreeNode
        :type sum: int
        :rtype: List[List[int]]
        """
        def helper(root, val, curr_path):
            if root is None:
                return
            path = curr_path + [root.val]
            if root.left is None and root.right is None:
                if root.val == val:
                    result.append(path)
                return
            helper(root.left, val - root.val, path)
            helper(root.right, val - root.val, path)
        result = []
        helper(root, sum, [])
        return result


    
