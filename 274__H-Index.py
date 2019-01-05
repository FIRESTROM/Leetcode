class Solution(object):
    def hIndex(self, citations):
        """
        :type citations: List[int]
        :rtype: int
        """
        citations.sort()
        for idx in range(len(citations)):
            if idx >= citations[idx]:
                return idx
        return len(citations)
