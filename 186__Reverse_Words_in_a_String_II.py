class Solution(object):
    def reverseWords(self, str):
        """
        :type str: List[str]
        :rtype: void Do not return anything, modify str in-place instead.
        """
        def reverse(start, end):
            while start < end:
                str[start], str[end] = str[end], str[start]
                start += 1
                end -= 1

        reverse(0, len(str) - 1)

        index, left = 0, 0
        while index < len(str):
            if str[index] == " ":
                reverse(left, index - 1)
                left = index + 1
            elif index == len(str) - 1:
                reverse(left, index)
            index += 1
