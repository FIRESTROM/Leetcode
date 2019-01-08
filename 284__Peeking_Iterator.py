# Below is the interface for Iterator, which is already defined for you.
#
# class Iterator(object):
#     def __init__(self, nums):
#         """
#         Initializes an iterator object to the beginning of a list.
#         :type nums: List[int]
#         """
#
#     def hasNext(self):
#         """
#         Returns true if the iteration has more elements.
#         :rtype: bool
#         """
#
#     def next(self):
#         """
#         Returns the next element in the iteration.
#         :rtype: int
#         """

class PeekingIterator(object):
    def __init__(self, iterator):
        """
        Initialize your data structure here.
        :type iterator: Iterator
        """
        self.iterator = iterator
        self.queue = collections.deque()


    def peek(self):
        """
        Returns the next element in the iteration without advancing the iterator.
        :rtype: int
        """
        if len(self.q) != 0:
            elem = self.q.popleft()
            self.queue.appendleft(elem)
            return elem
        else:
            elem = self.iterator.next()
            self.queue.append(elem)
            return elem

    def next(self):
        """
        :rtype: int
        """
        if len(self.queue) != 0:
            elem = self.queue.popleft()
            return elem
        else:
            return self.iterator.next()

    def hasNext(self):
        """
        :rtype: bool
        """
        return (not len(self.queue) == 0) or self.iterator.hasNext()




# Your PeekingIterator object will be instantiated and called as such:
# iter = PeekingIterator(Iterator(nums))
# while iter.hasNext():
#     val = iter.peek()   # Get the next element but not advance the iterator.
#     iter.next()         # Should return the same value as [val].
