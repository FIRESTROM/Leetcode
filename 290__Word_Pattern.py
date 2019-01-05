class Solution(object):
    def wordPattern(self, pattern, str):
        """
        :type pattern: str
        :type str: str
        :rtype: bool
        """
        dic_pattern_str = {}
        dic_str_pattern = {}
        s = str.split()
        if len(s) != len(pattern):
            return False
        for i, char in enumerate(pattern):
            if s[i] in dic_str_pattern:
                if dic_str_pattern[s[i]] != char:
                    return False
            else:
                dic_str_pattern[s[i]] = char
            if char in dic_pattern_str:
                if dic_pattern_str[char] != s[i]:
                    return False
            else:
                dic_pattern_str[char] = s[i]
        return True
