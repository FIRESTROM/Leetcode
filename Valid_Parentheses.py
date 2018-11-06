class Solution(object):
    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """
        stack = []
        dict = {"]": "[", "}": "{", ")": "("}
        for i in s:
            if i in dict.values():
                stack.append(i)
            elif i in dict.keys():
                if stack == [] or dict[i] != stack.pop():
                    return False
            else:
                return False
        return stack == []
