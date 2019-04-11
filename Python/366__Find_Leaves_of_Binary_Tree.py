# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def findLeaves(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        result = []
        visited = set()
        while root and not root in visited:
            leaves = []
            self.dfs(root, leaves, visited)
            result.append(leaves)
        return result

    def dfs(self, root, leaves, visited):
        if not root:
            return
        if root.left in visited:
            root.left = None
        if root.right in visited:
            root.right = None
        if not root.left and not root.right:
            leaves.append(root.val)
            visited.add(root)
            return
        self.dfs(root.left, leaves, visited)
        self.dfs(root.right, leaves, visited)

# Faster Solution

class Solution(object):
    def findLeaves(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        if not root:
            return []
        dic = {}
        self.run(root, dic)
        result = []
        for height in dic:
            result += [dic[height]]
        return result

    def run(self, node, dic):
        if not node:
            return 0

        left = self.run(node.left, dic)
        right = self.run(node.right, dic)

        height = max(left, right)

        dic[height] = dic[height] + [node.val] if height in dic else [node.val]

        return height + 1
