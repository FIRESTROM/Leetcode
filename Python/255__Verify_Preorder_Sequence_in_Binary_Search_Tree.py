class Solution(object):
    def verifyPreorder(self, preorder):
        """
        :type preorder: List[int]
        :rtype: bool
        """
        stack = []
        low = float("-inf")
        for x in preorder:
            if x < low:
                return False
            while stack and stack[-1] < x:
                low = stack.pop()
            stack.append(x)
        return True

# More Straight forward Solution

class Solution(object):
    def is_preorder(self, preorder, lo, hi):
        if lo >= hi:
            return True
        increasing, j = False, hi + 1
        for i in range(lo + 1, hi + 1):
            if not increasing and preorder[i] > preorder[lo]:
                increasing, j = True, i
            if increasing and preorder[i] < preorder[lo]:
                return False
        if increasing == False:
            return self.is_preorder(preorder, lo + 1, j - 1)
        else:
            return self.is_preorder(preorder, lo + 1, j - 1) and self.is_preorder(preorder, j, hi)

    def verifyPreorder(self, preorder):
        """
        :type preorder: List[int]
        :rtype: bool
        """
        return self.is_preorder(preorder, 0, len(preorder) - 1)
