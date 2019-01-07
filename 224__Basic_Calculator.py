class Solution(object):
    def calculate(self, s):
        """
        :type s: str
        :rtype: int
        """
        for ch in ['+', '-', '(', ')']:
            s = s.replace(ch, ' ' + ch + ' ')

        sign = 1
        stack = [0]
        for each in s.split():
            if each in ['+', '-']:
                sign = [1, -1][each == '-']
            elif each == '(':
                stack.extend([sign, 0])
                sign = 1
            elif each == ')':
                value = stack.pop() * stack.pop()
                stack[-1] += value
            else:
                stack[-1] += sign * int(each)
        return stack[-1]
