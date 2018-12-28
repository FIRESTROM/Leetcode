class Solution(object):
    def longestValidParentheses(self, s):
        """
        :type s: str
        :rtype: int
        """
        result = 0
        dp = [0] * len(s)
        for i in range(1, len(s)):
            if s[i] == ")":
                if s[i - 1] == "(":
                    if i >= 2:
                        dp[i] = dp[i - 2]
                    dp[i] += 2
                elif i - dp[i - 1] > 0 and s[i - dp[i - 1] - 1] == "(":
                    if i - dp[i - 1] >= 2:
                        dp[i] = dp[i - dp[i - 1] - 2]
                    dp[i] += dp[i - 1] + 2
                result = max(result, dp[i])
        return result

# Another Solution Using Stack

class Solution(object):
    def longestValidParentheses(self, s):
        """
        :type s: str
        :rtype: int
        """
        result = 0
        stack = [0]
        for i in s:
            if i == "(":
                stack.append(0)
            else:
                if len(stack) > 1:
                    val = stack.pop()
                    stack[-1] += val + 2
                    result = max(result, stack[-1])
                else:
                    stack = [0]
        return result
