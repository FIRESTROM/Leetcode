class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        if len(prices) == 0:
            return 0
        min_price = prices[0]
        max_profit = -1
        for i in range(len(prices)):
            if max_profit < prices[i] - min_price:
                max_profit = prices[i] - min_price
            if min_price > prices[i]:
                min_price = prices[i]
        return max_profit
                
