# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def levelOrderBottom(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        if root is None:
            return []
        result = []
        def layer(nodes):
            current_val = []
            new_nodes = []
            for node in nodes:
                if node is None:
                    continue
                else:
                    current_val.append(node.val)
                    new_nodes.append(node.left)
                    new_nodes.append(node.right)
            if current_val == []:
                return
            else:
                result.append(current_val)
                layer(new_nodes)

        layer([root])

        return result[::-1]

# Or Use DFS Solution

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def levelOrderBottom(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        def dfs(root):
            if root:
                stack = [(root, 0)]
                res = []
                while stack:
                    node, level = stack.pop()
                    if node:
                        if len(res) < level + 1:
                            res.insert(0, [])
                        res[-level - 1].insert(0, node.val)
                        stack.append((node.left, level + 1))
                        stack.append((node.right, level + 1))
                return res
            return []

        return dfs(root)
