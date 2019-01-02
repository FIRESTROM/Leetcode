# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):

    def inorder(self, root, val_list, node_list):
        if root:
            self.inorder(root.left, val_list, node_list)
            val_list.append(root.val);
            node_list.append(root)
            self.inorder(root.right, val_list, node_list)

    def recoverTree(self, root):
        """
        :type root: TreeNode
        :rtype: void Do not return anything, modify root in-place instead.
        """
        val_list = []
        node_list = []
        self.inorder(root, val_list, node_list)
        val_list.sort()
        for i,v in enumerate(val_list):
            node_list[i].val = v
