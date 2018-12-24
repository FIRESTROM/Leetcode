# Binary Search Tree Solution
class Node:
    def __init__(self, val):
        self.val = val
        self.left = None
        self.right = None
        self.count = 1
        self.left_tree_size = 0


class Solution(object):
    def countSmaller(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        root = Node(float('inf'))
        result = []

        for i in range(len(nums)-1, -1, -1):
            root, count = self.insert(nums[i], root)
            result.append(count)

        return result[::-1]


    def insert(self, val, node):
        if not node:
            node = Node(val)
            return node, 0

        if val == node.val:
            node.count += 1
            return node, node.left_tree_size

        if val < node.val:
            node.left_tree_size += 1
            node.left, count = self.insert(val, node.left)
            return node, count

        node.right, count = self.insert(val, node.right)

        return node, node.count + node.left_tree_size + count



# Binary Index Tree Solution


class Solution(object):
    def countSmaller(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        if not nums or not len(nums): return []

        rank = {num: i+1 for i, num in enumerate(sorted(nums)) }
        N = len(nums)
        res = []
        BIT = [0] * (N+1)

        def update(i):
            while i <= N:
                BIT[i] += 1
                i += i & -i

        def query(i):
            sum_ = 0
            while i > 0:
                sum_ += BIT[i]
                i -= i & -i
            return sum_

        for num in nums[::-1]:
            res.append(query(rank[num] - 1))
            update(rank[num])

        return res[::-1]
