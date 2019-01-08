class Solution(object):
    def canWin(self, s):
        """
        :type s: str
        :rtype: bool
        """
        cache = {}
        return self.helper([ch for ch in s], cache)

    def helper(self, s, cache):
        cache_key = "".join(s)
        if cache_key in cache:
            return cache[cache_key]
        for i in range(len(s)-1):
            if s[i] == s[i+1] and s[i] == "+":
                s[i] = s[i+1] = "-"
                next_result = self.helper(s, cache)
                s[i] = s[i+1] = "+"
                if next_result == False:
                    cache[cache_key] = True
                    return True
        cache[cache_key] = False
        return cache[cache_key]

# The above is the solution using memorization of this:
class Solution(object):
    def canWin(self, s):
        """
        :type s: str
        :rtype: bool
        """
        for i in range(len(s) - 1):
            if s[i] == s[i + 1] == "+" and not self.canWin(s[:i] + "--" + s[i + 2:]):
                return True
        return False


# DFS Solution
class Solution:
    def canWin(self, s):
        """
        :type s: str
        :rtype: bool
        """
        choices = {i for i in range(1, len(s)) if s[i] == s[i - 1] == "+"}
        def dfs(arr, moves, turn):
            if not moves:
                return turn == 1
            elif turn:
                return all(dfs(arr + [m], moves - {m - 1, m, m + 1}, 1 - turn) for m in moves)
            else:
                return any(dfs(arr + [m], moves - {m - 1, m, m + 1}, 1 - turn) for m in moves)
        return not dfs([], choices, 1)
