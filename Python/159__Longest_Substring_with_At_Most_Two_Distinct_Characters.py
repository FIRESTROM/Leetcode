class Solution(object):
    def lengthOfLongestSubstringTwoDistinct(self, s):
        """
        :type s: str
        :rtype: int
        """
        if len(s) <= 2:
            return len(s)
        result = 2
        n = len(s)
        i, j = 0, 1
        dic = {s[0] : 1}
        while j < n:
            if s[j] not in dic:
                if len(dic) < 2:
                    dic[s[j]] = 1
                    j += 1
                    result = max(result, j - i)
                else:
                    while i < j:
                        dic[s[i]] -= 1
                        i += 1
                        if dic[s[i - 1]] == 0:
                            del dic[s[i - 1]]
                            break
            else:
                dic[s[j]] += 1
                j += 1
                result = max(result, j - i)

        return result
