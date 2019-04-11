class Solution(object):
    def wordBreak(self, s, wordDict):
        """
        :type s: str
        :type wordDict: List[str]
        :rtype: List[str]
        """

        def helper(s, dic):

            if s in dic:
                return dic[s]
            if len(s) == 0:
                return []

            result = []
            for word in wordDict:
                if not s.startswith(word):
                    continue
                if len(word) == len(s):
                    result.append(word)
                else:
                    rest = helper(s[len(word):], dic)
                    for lst in rest:
                        result.append(word + " " + lst)
            dic[s] = result

            return result




        return helper(s, {})


       
