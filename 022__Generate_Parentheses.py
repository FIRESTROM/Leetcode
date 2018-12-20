class Solution(object):
    def generateParenthesis(self, n):
        """
        :type n: int
        :rtype: List[str]
        """
        def addOne(list):
            temp = []
            for lst in list:
                for i in range(len(lst)):
                    cur = lst[:i] + "(" + lst[i:]
                    for j in range(i + 1, len(cur)):
                        current = cur[:j] + ")" + cur[j:]
                        if current not in temp:
                            temp.append(current)
            return temp
        result = ["()"]
        for i in range(n - 1):
            result = addOne(result)
        return result


# Backtracking

class Solution(object):
    def generateParenthesis(self, n):
        """
        :type n: int
        :rtype: List[str]
        """
        ans = []
        def backtrack(S = '', left = 0, right = 0):
            if len(S) == 2 * N:
                ans.append(S)
                return
            if left < N:
                backtrack(S+'(', left+1, right)
            if right < left:
                backtrack(S+')', left, right+1)

        backtrack()
        return ans
