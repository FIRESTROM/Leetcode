class Solution(object):
    def hIndex(self, citations):
        """
        :type citations: List[int]
        :rtype: int
        """
        n = len(citations)
        if n == 0:
            return 0
        low, high = 1, len(citations)
        while low <= high:
            mid = (low + high) / 2
            if citations[n - mid] == mid:
                if mid == n or citations[n - mid] != citations[n - mid - 1]:
                    return mid
                else:
                    low = mid + 1
            elif citations[n - mid] > mid:
                low = mid + 1
            else:
                high = mid - 1
        return high
