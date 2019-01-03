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
            return

        def layer(nodes):
            new_nodes = []
            for i in range(len(nodes)):
                if nodes[i].left is not None:
                    new_nodes.append(nodes[i].left)
                if nodes[i].right is not None:
                    new_nodes.append(nodes[i].right)
                if i != len(nodes) - 1:
                    nodes[i].next = nodes[i + 1]
                else:
                    nodes[i].next = None
            if new_nodes == []:
                return
            else:
                layer(new_nodes)

        layer([root])
