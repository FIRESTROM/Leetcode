class Solution(object):
    def groupAnagrams(self, strs):
        """
        :type strs: List[str]
        :rtype: List[List[str]]
        """
        dic = dict()
        for str in strs:
            temp = ''.join(sorted(str))
            if not temp in dic:
                dic[temp] = [str]
            else:
                dic[temp].append(str)

        result = []
        for key in dic.keys():
            result.append(dic[key])
        return result
