class Solution(object):
    def maxNumber(self, nums1, nums2, k):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :type k: int
        :rtype: List[int]
        """
        result = []
        for i in range(0, k + 1):
            if i <= len(nums1) and k - i <= len(nums2):
                sort1 = self.findmax(nums1, i)
                sort2 = self.findmax(nums2, k - i)
                merged = self.merge(sort1, sort2)
                if self.larger(merged, result):
                    result = merged
        return result

    def findmax(self, num, k):
        queue = []
        for i in range(0, len(num)):
            while len(queue) > 0 and num[i] > queue[-1] and len(queue) + len(num) - i > k:
                queue.pop()
            if len(queue) < k:
                queue.append(num[i])
        return queue

    def merge(self, sort1, sort2):
        i, j = 0, 0
        result = []
        while i < len(sort1) and j < len(sort2):
            if self.larger(sort1[i:], sort2[j:]):
                result.append(sort1[i])
                i += 1
            else:
                result.append(sort2[j])
                j += 1
        if i == len(sort1):
            result += sort2[j:]
        else:
            result += sort1[i:]
        return result

    def larger(self, list1, list2):
        for i in range(0, min(len(list1), len(list2))):
            if list1[i] < list2[i]:
                return False
            elif list1[i] > list2[i]:
                return True
        if len(list1) < len(list2):
            return False
        else:
            return True
