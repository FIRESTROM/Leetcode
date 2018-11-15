class Solution(object):
    def findMedianSortedArrays(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: float
        """
        len1, len2 = len(nums1), len(nums2)
        totallen = len1 + len2

        if len1 == 1 and len2 == 0:
            return nums1[0]
        if len1 == 0 and len2 == 1:
            return nums2[0]

        index1, index2 = 0, 0
        for i in range(totallen / 2 - 1):
            if index1 == len1:
                index2 += 1
            elif index2 == len2:
                index1 += 1
            else:
                if nums1[index1] <= nums2[index2]:
                    index1 += 1
                else:
                    index2 += 1
        result = []
        for i in range(2):
            if index1 == len1:
                result += [nums2[index2]]
                index2 += 1
            elif index2 == len2:
                result += [nums1[index1]]
                index1 += 1
            else:
                if nums1[index1] <= nums2[index2]:
                    result += [nums1[index1]]
                    index1 += 1
                else:
                    result += [nums2[index2]]
                    index2 += 1
        if totallen % 2 == 0:
            return (result[0] + result[1]) / 2.0
        else:
            return result[1]
