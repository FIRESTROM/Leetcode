from heapq import heappush, heappop, heapreplace, heapify

class MedianFinder(object):

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.maxHeap = []
        self.minHeap = []


    def addNum(self, num):
        """
        :type num: int
        :rtype: void
        """
        heappush(self.maxHeap, -num)
        heappush(self.minHeap, -heappop(self.maxHeap))
        if len(self.minHeap) > len(self.maxHeap):
            heappush(self.maxHeap, -heappop(self.minHeap))


    def findMedian(self):
        """
        :rtype: float
        """
        if len(self.maxHeap) > len(self.minHeap):
            return float(-self.maxHeap[0])

        return ((-self.maxHeap[0] + self.minHeap[0] + 0.00 )/2)




# Your MedianFinder object will be instantiated and called as such:
# obj = MedianFinder()
# obj.addNum(num)
# param_2 = obj.findMedian()
