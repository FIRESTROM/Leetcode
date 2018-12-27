class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        if len(prices) <= 1:
            return 0

        # O(n) counting from left, find the max gain up to each day (not ending at each day)
        left = [0] * len(prices)
        curmin = prices[0]
        for i in range(1, len(prices)):
            curmin = min(curmin, prices[i])
            left[i] = max(prices[i] - curmin, left[i - 1])

        # O(n) counting from right
        right = [0] * len(prices)
        curmax = prices[-1]
        for i in range(len(prices) - 2, -1, -1):
            curmax = max(curmax, prices[i])
            right[i] = max(curmax - prices[i], right[i + 1])

        # O(n)
        result = 0
        for i in range(len(prices)):
            result = max(result, left[i] + right[i])
        return result
