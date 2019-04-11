# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def rightSideView(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        if root is None:
            return []

        def helper(nodes):
            self.result += [nodes[-1].val]
            new_nodes = []
            for node in nodes:
                if node.left is not None:
                    new_nodes.append(node.left)
                if node.right is not None:
                    new_nodes.append(node.right)
            if new_nodes:
                helper(new_nodes)

        self.result = []
        helper([root])
        return self.result
