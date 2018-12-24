class Solution(object):
    def lengthOfLongestSubstringKDistinct(self, s, k):
        """
        :type s: str
        :type k: int
        :rtype: int
        """
        if s == "":
            return 0
        if k >= len(s):
            return len(s)
        if k == 0:
            return 0
        start, end = 0, 0
        result = 0
        dic = {}
        dic[s[0]] = 1

        while end < len(s):

            while len(dic) <= k and end < len(s) - 1:
                if len(dic) != k:
                    end += 1
                    if s[end] in dic:
                        dic[s[end]] += 1
                    else:
                        dic[s[end]] = 1
                else:
                    if s[end + 1] in dic:
                        end += 1
                        dic[s[end]] += 1
                    else:
                        break;
            result = max(result, end - start + 1)
            if end == len(s) - 1:
                break
            while len(dic) >= k:
                if dic[s[start]] == 1:
                    del dic[s[start]]
                else:
                    dic[s[start]] -= 1
                start += 1
        return result


# The solution above can be optimized to :

class Solution(object):
    def lengthOfLongestSubstringKDistinct(self, s, k):
        """
        :type s: str
        :type k: int
        :rtype: int
        """
        d = {}
        low, ret = 0, 0
        for i, c in enumerate(s):
            d[c] = i
            if len(d) > k:
                low = min(d.values())
                del d[s[low]]
                low += 1
            ret = max(i - low + 1, ret)
        return ret
