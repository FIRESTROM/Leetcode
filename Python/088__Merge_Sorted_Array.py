class Solution(object):
    def merge(self, nums1, m, nums2, n):
        """
        :type nums1: List[int]
        :type m: int
        :type nums2: List[int]
        :type n: int
        :rtype: void Do not return anything, modify nums1 in-place instead.
        """
        for i in range(0,n):
            index = m+i
            nums1[index] = nums2[i]

        nums1.sort()


## Another Solution

class Solution(object):
    def merge(self, nums1, m, nums2, n):
        """
        :type nums1: List[int]
        :type m: int
        :type nums2: List[int]
        :type n: int
        :rtype: void Do not return anything, modify nums1 in-place instead.
        """
        if len(nums1) == 0 or len(nums2) == 0:
            return

        i = m - 1
        j = n - 1
        point = m + n - 1

        while i >= 0 and j >= 0:
            if nums1[i] >= nums2[j]:
                nums1[point] = nums1[i]
                i -= 1
                point -= 1
            else:
                nums1[point] = nums2[j]
                j -= 1
                point -= 1

        while j >= 0:
            nums1[point] = nums2[j]
            j -= 1
            pt -= 1
