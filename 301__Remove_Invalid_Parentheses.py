class Solution:  # https://leetcode.com/problems/remove-invalid-parentheses/
    def removeInvalidParentheses(self, s):
        rmL = rmR = 0
        for c in s:
            if c == '(':
                rmL += 1
            elif c == ')' :
                if rmL > 0:
                    rmL -= 1
                else:
                    rmR += 1

        self.results = set()
        self.dfs(s, 0, "", rmL, rmR, 0)
        return list(self.results)

    def dfs(self, s, index, temp, left, right, half):
        if index == len(s) and left == 0 and right == 0 and half == 0:
            self.results.add(temp)
            return
        if index == len(s) or left < 0 or right < 0 or half < 0:
            return

        if s[index] == '(':
            self.dfs(s, index+1, temp+s[index], left, right, half+1) # use left
            self.dfs(s, index+1, temp, left-1, right, half) # remove left

        elif s[index] == ')':
            self.dfs(s, index+1, temp+s[index], left, right, half-1) # use right
            self.dfs(s, index+1, temp, left, right-1, half) #remove right

        else:
            self.dfs(s, index+1, temp+s[index], left, right, half) # skip if neither left nor right
