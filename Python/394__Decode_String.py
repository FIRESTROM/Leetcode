class Solution(object):
    def decodeString(self, s):
        """
        :type s: str
        :rtype: str
        """
        stack = []
        n = 0
        for char in s:
            if char.isdigit():
                n = n * 10 + int(char)
            elif char == "[":
                stack.append(str(n))
                n = 0
            elif char == "]":
                tmp = ""
                while stack and stack[-1].isalpha():
                    tmp = stack.pop() + tmp
                if stack:
                    num = stack.pop()
                stack.append(int(num) * tmp)
            else:
                stack.append(char)

        return "".join(stack)
