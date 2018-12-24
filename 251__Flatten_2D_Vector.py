class Vector2D(object):

    def __init__(self, vec2d):
        """
        Initialize your data structure here.
        :type vec2d: List[List[int]]
        """
        self.list = []
        for lst in vec2d:
            self.list += lst
        self.length = len(self.list)
        self.index = -1

    def next(self):
        """
        :rtype: int
        """
        self.index += 1
        return self.list[self.index]

    def hasNext(self):
        """
        :rtype: bool
        """
        return self.index + 1 < self.length

# Your Vector2D object will be instantiated and called as such:
# i, v = Vector2D(vec2d), []
# while i.hasNext(): v.append(i.next())
