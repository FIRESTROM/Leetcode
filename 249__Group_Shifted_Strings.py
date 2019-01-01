class Solution(object):
    def groupStrings(self, strings):
        """
        :type strings: List[str]
        :rtype: List[List[str]]
        """
        dic = collections.defaultdict(list)
        for word in strings:
            string = ""
            for c in word:
                string += str((ord(c) - ord(word[0]) + 26) % 26) + " "
            dic[string].append(word)

        result = []
        for v in dic.values():
            result.append(v)

        return result
