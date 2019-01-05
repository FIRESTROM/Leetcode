class Solution(object):
    def isReflected(self, points):
        """
        :type points: List[List[int]]
        :rtype: bool
        """
        max_val, min_val = float("-inf"), float("inf")
        dic = {}
        for p in points:
            max_val = max(max_val, p[0])
            min_val = min(min_val, p[0])
            dic[str(p[0]) + ":" + str(p[1])] = 1

        mid_val = min_val + max_val
        for p in points:
            temp_str = str(mid_val - p[0]) + ":" + str(p[1])
            if temp_str not in dic:
                return False

        return True
