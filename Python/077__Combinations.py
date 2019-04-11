class Solution(object):
    def combine(self, n, k):
        """
        :type n: int
        :type k: int
        :rtype: List[List[int]]
        """

        def helper(tlist, start, end):
            if len(tlist) == k:
                result.append(tlist)
                return
            for i in range(start, end + 1):
                tlist.append(i)
                helper(tlist, i + 1, end)
                tlist.pop()

        result = []
        helper([], 1, n)
        return result
