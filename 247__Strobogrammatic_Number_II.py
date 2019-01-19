class Solution(object):
    def findStrobogrammatic(self, n):
        """
        :type n: int
        :rtype: List[str]
        """
        dic = {"0": "0", "1":"1", "6":"9", "8":"8", "9":"6"}
        dic_mid = {"0": "0", "1":"1", "8":"8"}
        first_half = n / 2
        self.result = []
        def helper(count, first_half, second_half):
            if count > n:
                return
            if count == n:
                self.result += [first_half + second_half]
                return
            if count + 1 == n:
                self.result += [first_half + char + second_half for char in dic_mid]
                return
            for char in dic:
                if char == "0" and len(first_half) == 0:
                    continue
                helper(count + 2, first_half + char, dic[char] + second_half)
        helper(0, "", "")
        return self.result
