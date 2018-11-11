# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def lowestCommonAncestor(self, root, p, q):
        """
        :type root: TreeNode
        :type p: TreeNode
        :type q: TreeNode
        :rtype: TreeNode
        """
        if root == p or root == q:
            return root
        leftnode, rightnode = None, None
        if root.left:
            # Return some node if the "root" is p or q
            leftnode = self.lowestCommonAncestor(root.left, p, q)
        if root.right:
            # Same as above
            rightnode = self.lowestCommonAncestor(root.right, p, q)

        # Means we find either p or q from one side and another from the other
        # side --> return node
        if leftnode and rightnode:
            return root
        # One of the side find nothing, means that both p and q are in one side,
        # and the ancestor is at the place of the leftnode / rightnode.
        else:
            return leftnode or rightnode
