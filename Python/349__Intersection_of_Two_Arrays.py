class Solution(object):
    def intersection(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: List[int]
        """
        dic = dict()
        result = []
        for i in range(len(nums1)) :
            if nums1[i] not in dic :
                dic[nums1[i]] = 1
        for i in range(len(nums2)) :
            if nums2[i] in dic and nums2[i] not in result :
                result += [nums2[i]]
        return result
