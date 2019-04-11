class Solution(object):
    def removeDuplicateLetters(self, s):
        """
        :type s: str
        :rtype: str
        """
        for char in sorted(set(s)):
            suffix = s[s.index(char):]
            if set(suffix) == set(s):
                return char + self.removeDuplicateLetters(suffix.replace(char, ""))
        return ""

# Another Solution Using Stack

class Solution(object):
    def removeDuplicateLetters(self, s):
        # count the occurence of letters
        count = {}
        for i in s:
            if count.has_key(i): count[i] += 1
            else: count[i] = 1

        # use stack to keep the order
        stack = []
        used = {}
        for i in s:
            used[i] = False

        for i in s:
            count[i] -= 1
            if not used[i]:

                while len(stack) > 0:
                    top = stack[-1]
                    if ord(i) < ord(top): # current letter less than top letter
                        if count[top] >= 1: # more top letter( left
                            j = stack.pop()
                            used[j] = False
                        else: # no more top letter left
                            break

                    else: # current letter larger than top letter
                        break

                stack.append(i)
                used[i] = True

        return "".join(stack)
