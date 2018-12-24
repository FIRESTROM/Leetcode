class Solution(object):
    def topKFrequent(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: List[int]
        """
        if len(nums) == 0:
            return []
        dic = {}
        for i in nums:
            if i in dic:
                dic[i] += 1
            else:
                dic[i] = 1

        dic = sorted(dic.items(), key=lambda x : x[1], reverse=True)
        result = []
        for i in range(k):
            result.append(dic[i][0])

        return result


# Using MinHeap
import heapq
class Solution(object):
    def topKFrequent(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: List[int]
        """
        if len(nums) == 0:
            return []
        dic = {}
        for i in nums:
            if i in dic:
                dic[i] += 1
            else:
                dic[i] = 1

        # build min heap
        freq_list = [(val * -1, key) for key, val in dic.items()]
        heapq.heapify(freq_list)
        
        # get top k freq element
        result = []
        for i in range(k):
            result.append(heapq.heappop(freq_list)[1])

        return result
