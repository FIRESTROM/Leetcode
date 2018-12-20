class Solution(object):
    def longestCommonPrefix(self, strs):
        """
        :type strs: List[str]
        :rtype: str
        """
        result = ""
        index = 0
        while result not in strs:
            tempset = set(str[index] for str in strs)
            if len(tempset) == 1:
                result += strs[0][index]
                index += 1
            else:
                break;
        return result

# Use Horizontal scanning

class Solution(object):
    def longestCommonPrefix(self, strs):
        """
        :type strs: List[str]
        :rtype: str
        """
        if len(strs) == 0 :
            return ""
        result = strs[0]
        for i in range(1, len(strs)) :
            while strs[i].find(result) != 0:
                result = result[0 : len(result) - 1]
                if result == "":
                    return ""
        return result
