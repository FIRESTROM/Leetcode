class MovingAverage(object):

    def __init__(self, size):
        """
        Initialize your data structure here.
        :type size: int
        """
        self.data = []
        self.size = size


    def next(self, val):
        """
        :type val: int
        :rtype: float
        """
        if len(self.data) < self.size:
            self.data += [val]
            return sum(self.data) / float(len(self.data))
        else:
            self.data = self.data[1:]
            self.data += [val]
            return sum(self.data) / float(len(self.data))



# Your MovingAverage object will be instantiated and called as such:
# obj = MovingAverage(size)
# param_1 = obj.next(val)

# A Faster Solution
class MovingAverage(object):

    def __init__(self, size):
        """
        Initialize your data structure here.
        :type size: int
        """
        self.size = size
        self.vals = []
        self.count = 0.0
        self.ptr = 0

    def next(self, val):
        """
        :type val: int
        :rtype: float
        """
        self.vals.append(float(val))
        self.count += val

        if len(self.vals) > self.size:
            self.count -= self.vals[self.ptr]
            self.ptr += 1
            return self.count / self.size

        return self.count / len(self.vals)
