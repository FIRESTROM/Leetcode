# Definition for binary tree with next pointer.
# class TreeLinkNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
#         self.next = None

class Solution:
    # @param root, a tree link node
    # @return nothing
    def connect(self, root):

        if root is None:
            return None

        cur_level = []
        cur_level.append(root)

        while cur_level:
            next_level = []
            for i in range(len(cur_level)):
                cur_node = cur_level[i]
                if i+1 < len(cur_level):
                    cur_node.next = cur_level[i+1]
                else:
                    cur_node.next = None
                if cur_node.left: next_level.append(cur_node.left)
                if cur_node.right: next_level.append(cur_node.right)
            cur_level = next_level
