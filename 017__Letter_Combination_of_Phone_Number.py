class Solution(object):
    def letterCombinations(self, digits):
        """
        :type digits: str
        :rtype: List[str]
        """
        result = [""]
        letters = {"2": "abc", "3": "def", "4": "ghi", "5": "jkl", "6": "mno", "7": "pqrs", "8": "tuv", "9": "wxyz"}
        for digit in digits:
            result = [combination + l for l in letters[digit] for combination in result]
        return result if len(result) > 1 else []
