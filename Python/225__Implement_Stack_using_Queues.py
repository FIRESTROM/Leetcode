class MyStack(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.data = []


    def push(self, x):
        """
        Push element x onto stack.
        :type x: int
        :rtype: void
        """
        self.data = [x] + self.data


    def pop(self):
        """
        Removes the element on top of the stack and returns that element.
        :rtype: int
        """
        x = self.data[0]
        self.data = self.data[1:]
        return x


    def top(self):
        """
        Get the top element.
        :rtype: int
        """
        return self.data[0]


    def empty(self):
        """
        Returns whether the stack is empty.
        :rtype: bool
        """
        return len(self.data) == 0


# Your MyStack object will be instantiated and called as such:
# obj = MyStack()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.top()
# param_4 = obj.empty()
