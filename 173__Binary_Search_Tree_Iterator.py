# Definition for a  binary tree node
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class BSTIterator(object):
    def __init__(self, root):
        """
        :type root: TreeNode
        """
        self.list = []
        self.addlist(root)
        self.len = len(self.list)
        
    def addlist(self, root):
        if root is None:
            return
        self.addlist(root.left)
        self.list += [root.val]
        self.addlist(root.right)

    def hasNext(self):
        """
        :rtype: bool
        """
        if self.len != 0:
            return True
        return False

    def next(self):
        """
        :rtype: int
        """
        val = self.list[0]
        self.list = self.list[1:]
        self.len -= 1
        return val


# Your BSTIterator will be called like this:
# i, v = BSTIterator(root), []
# while i.hasNext(): v.append(i.next())




## Faster solution!!

class BSTIterator(object):
    def __init__(self, root):
        """
        :type root: TreeNode
        """
        self.root = root
        # Keep all the left nodes from the root
        self.stack = []
        while root:
            self.stack.append(root)
            root = root.left


    def hasNext(self):
        """
        :rtype: bool
        """
        return not self.stack == []


    def next(self):
        """
        :rtype: int
        """
        top = self.stack.pop()
        # Check right subtree
        right = top.right
        # Keep all the left nodes from the subtree
        while right:
            self.stack.append(right)
            right = right.left

        return top.val
