class Solution(object):
    def canCompleteCircuit(self, gas, cost):
        """
        :type gas: List[int]
        :type cost: List[int]
        :rtype: int
        """
        dp = [gas[0] - cost[0]]
        for i in range(1, len(gas)):
            dp.append(dp[-1] + gas[i] - cost[i])
        if dp[-1] < 0:
            return -1
        minval, result = dp[0], 0
        for i in range(len(dp)):
            if minval > dp[i]:
                minval = dp[i]
                result = i
        return (result + 1) % len(gas)
