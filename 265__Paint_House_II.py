class Solution(object):
    def minCostII(self, costs):
        """
        :type costs: List[List[int]]
        :rtype: int
        """
        if not len(costs) or not len(costs[0]):
            return 0
        firstcost, secondcost = float("inf"), float("inf")
        house_num, color_num = len(costs), len(costs[0])

        for j in range(color_num):
            if costs[0][j] < firstcost:
                firstcost, secondcost = costs[0][j], firstcost
            elif firstcost <= costs[0][j] < secondcost:
                secondcost = costs[0][j]

        for i in range(1, house_num):
            temp_first, temp_second = float("inf"), float("inf")
            for j in range(color_num):
                if costs[i - 1][j] != firstcost:
                    costs[i][j] = firstcost + costs[i][j]
                else:
                    costs[i][j] = secondcost + costs[i][j]
                if costs[i][j] < temp_first:
                    temp_first, temp_second = costs[i][j], temp_first
                elif temp_first <= costs[i][j] < temp_second:
                    temp_second = costs[i][j]
            firstcost, secondcost = temp_first, temp_second

        return firstcost
