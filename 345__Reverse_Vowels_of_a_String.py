class Solution(object):
    def reverseVowels(self, s):
        """
        :type s: str
        :rtype: str
        """
        vowels = ("a", "e", "i", "o", "u", "A", "E", "I", "O", "U")
        i, j = 0, len(s) - 1
        lst = [c for c in s]

        while i < j:
            while  i < j  and lst[i] not in vowels:
                i += 1
            while  i < j and lst[j] not in vowels:
                j -= 1
            lst[i], lst[j] = lst[j], lst[i]
            i += 1
            j -= 1

        return "".join(lst)
