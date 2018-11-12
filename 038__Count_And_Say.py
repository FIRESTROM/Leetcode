class Solution(object):
    def countAndSay(self, n):
        """
        :type n: int
        :rtype: str
        """
        def recursive(n):
            result = ""
            count = 1
            if len(n) == 1:
                return "1" + n
            for i in range(1, len(n)):
                if n[i] == n[i - 1]:
                    count += 1
                else:
                    result += str(count) + n[i - 1]
                    count = 1
            result += str(count) + n[-1]
            return result

        result = "1"
        while int(n) - 1 :
            print(result)
            result = recursive(result)
            n -= 1
        return str(result)
