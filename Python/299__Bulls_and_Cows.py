class Solution(object):
    def getHint(self, secret, guess):
        """
        :type secret: str
        :type guess: str
        :rtype: str
        """
        num1, num2 = 0, 0
        dic_s, dic_g = {}, {}
        for i in range(len(secret)):
            if secret[i] == guess[i]:
                num1 += 1
            else:
                dic_s[secret[i]] = dic_s.get(secret[i], 0) + 1
                dic_g[guess[i]] = dic_g.get(guess[i], 0) + 1

        for key, value in dic_s.items():
            if dic_g.get(key):
                num2 += min(dic_g.get(key), value)

        return str(num1) + "A" + str(num2) + "B"x
