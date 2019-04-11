# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def verticalOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        if not root:
            return []
        record = collections.defaultdict(list)
        queue, result, min_i, max_i = [(0, root)], [], float("inf"), float("-inf")
        while queue:
            newq = []
            for i, node in queue:
                if node:
                    min_i = min(min_i, i)
                    max_i = max(max_i, i)
                    record[i].append(node.val)
                    newq.append((i - 1, node.left))
                    newq.append((i + 1, node.right))
            queue = newq
        for i in range(min_i, max_i + 1):
            result.append(record[i])
        return result

# More Simple Solution

class Solution(object):
    def verticalOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """

        idx_dict = collections.defaultdict(list)
        queue = [(root, 0)]
        for node, i in queue:
            if node:
                idx_dict[i].append(node.val)
                queue += (node.left, i - 1), (node.right, i + 1)

        return [idx_dict[idx] for idx in sorted(idx_dict.keys())]
