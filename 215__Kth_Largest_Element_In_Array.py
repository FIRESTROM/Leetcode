## This is a solution using Min_Heap. The heapq.heapqpop will pop out the smallest
## value, and reorder the heap. heapq.heappush will alse push the value to the
## right place in the heap. We will store k largest value in the list, and the
## value on the top is the smallest. which is the kth largest value


import heapq

class Solution(object):
    def findKthLargest(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        min_heap = [-float("inf")] * k
        heapq.heapify(min_heap)
        for num in nums:
            if num > min_heap[0]:
                heapq.heappop(min_heap)
                heapq.heappush(min_heap, num)
        return min_heap[0]

## Also we can use Max_Heap to do this. There is no Max_Heap data structure in
## python, but we can get change every element to its negative. Then pop out
## k - 1 numbers, then the number on the top of heap is the result we want.

import heapq

class Solution(object):
    def findKthLargest(self, nums, k):
        nums = [-num for num in nums]
        heapq.heapify(nums)
        result = float('inf')
        for _ in range(k):
            result = heapq.heappop(nums)
        return -result
