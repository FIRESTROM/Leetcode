class Solution(object):
    def intersect(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: List[int]
        """
        dic = {}
        for i in nums1:
            if i in dic:
                dic[i] += 1
            else:
                dic[i] = 1
        result = []
        for i in nums2:
            if i in dic and dic[i] != 0:
                result.append(i)
                dic[i] -= 1
        return result
        
