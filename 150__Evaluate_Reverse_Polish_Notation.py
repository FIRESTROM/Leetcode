class Solution(object):
    def evalRPN(self, tokens):
        """
        :type tokens: List[str]
        :rtype: int
        """
        stack = []
        for token in tokens:
            if token not in "+-*/":
                stack.append(int(token))
            else:
                op2 = stack.pop()
                op1 = stack.pop()
                if token == '+':
                    stack.append(op1 + op2)
                elif token == '-':
                    stack.append(op1 - op2)
                elif token == '*':
                    stack.append(op1 * op2)
                else:
                    tmp = op1 / op2
                    if tmp >= 0:
                        stack.append(op1//op2)
                    else:
                        tmp = abs(op1) // abs(op2)
                        stack.append(-tmp)
        return stack[0]
