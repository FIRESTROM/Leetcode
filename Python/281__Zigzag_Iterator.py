class ZigzagIterator(object):

    def __init__(self, v1, v2):
        """
        Initialize your data structure here.
        :type v1: List[int]
        :type v2: List[int]
        """
        self.data = []
        self.index = 0
        for i in range(min(len(v1), len(v2))):
            self.data += [v1[i], v2[i]]
        if len(v1) < len(v2):
            self.data += v2[len(v1):]
        else:
            self.data += v1[len(v2):]


    def next(self):
        """
        :rtype: int
        """
        self.index += 1
        return self.data[self.index - 1]

    def hasNext(self):
        """
        :rtype: bool
        """
        return self.index < len(self.data)


# Your ZigzagIterator object will be instantiated and called as such:
# i, v = ZigzagIterator(v1, v2), []
# while i.hasNext(): v.append(i.next())
