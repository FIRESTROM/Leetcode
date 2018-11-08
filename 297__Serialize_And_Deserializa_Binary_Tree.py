# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Codec:

    def serialize(self, root):
        """Encodes a tree to a single string.

        :type root: TreeNode
        :rtype: str
        """

        def bfs(root, string):
            if root is None:
                string += 'None,'
            else:
                string += str(root.val) + ','
                string = bfs(root.left, string)
                string = bfs(root.right, string)
            return string

        return bfs(root, "")



    def deserialize(self, data):
        """Decodes your encoded data to tree.

        :type data: str
        :rtype: TreeNode
        """
        def bfs(data):
            if data[0] == "None":
                data.pop(0)
                return None
            root = TreeNode(data[0])
            data.pop(0)
            root.left = bfs(data)
            root.right = bfs(data)
            return root

        data = data.split(",")
        root = bfs(data)
        return root


### Here is another solution that is faster using deque


from collections import deque

class Codec:

    def serialize(self, root):

        self.result = []
        self.bfs(root)
        return " ".join(self.result)

    def bfs(self, root):
        nodes = deque()
        nodes.append(root)

        while(nodes):
            node = nodes.popleft()
            if node is None:
                self.result.append("None")
                continue
            self.result.append(str(node.val))
            nodes.append(node.left)
            nodes.append(node.right)

    def deserialize(self, data):

        if not data:
            return None

        self.deserialize = deque(data.split())
        self.nodes = deque()
        root_val = self.deserialize.popleft()
        if root_val == "None":
            return None
        root = TreeNode(root_val)
        self.nodes.append(root)
        self.bfs(root)
        return root

    def bfs(self, node):
        while self.nodes:
            node = self.nodes.popleft()
            if node == "None":
                continue
            left = self.deserialize.popleft()
            right = self.deserialize.popleft()
            leftNode, rightNode = "None", "None"
            if left != "None":
                leftNode = TreeNode(left)
                node.left = leftNode
                self.nodes.append(leftNode)
            if right != "None":
                rightNode = TreeNode(right)
                node.right = rightNode
                self.nodes.append(rightNode)

# Your Codec object will be instantiated and called as such:
# codec = Codec()
# codec.deserialize(codec.serialize(root))
