class HitCounter(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.data = []
        self.start = 0


    def hit(self, timestamp):
        """
        Record a hit.
        @param timestamp - The current timestamp (in seconds granularity).
        :type timestamp: int
        :rtype: void
        """
        self.data.append(timestamp)


    def getHits(self, timestamp):
        """
        Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity).
        :type timestamp: int
        :rtype: int
        """
        while self.start < len(self.data) and timestamp - self.data[self.start] >= 300:
            self.start += 1
        if self.start == len(self.data):
            return 0
        return len(self.data) - self.start




# Your HitCounter object will be instantiated and called as such:
# obj = HitCounter()
# obj.hit(timestamp)
# param_2 = obj.getHits(timestamp)
