class Solution(object):
    def findRepeatedDnaSequences(self, s):
        """
        :type s: str
        :rtype: List[str]
        """
        dic = collections.defaultdict(int)
        for i in range(10, len(s) + 1):
            dic[s[i - 10 : i]] += 1
        return [key for key in dic.keys() if dic[key] > 1]
