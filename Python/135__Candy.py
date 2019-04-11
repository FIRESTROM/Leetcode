class Solution(object):
    def candy(self, ratings):
        """
        :type ratings: List[int]
        :rtype: int
        """
        values = [1] * len(ratings)

        for idx in range(len(ratings) - 1, -1, -1):
            prev = idx - 1 if idx > 0 else 0
            if ratings[prev] > ratings[idx] and values[prev] <= values[idx]:
                values[prev] = values[idx] + 1

        for idx in range(len(ratings)):
            nxt = idx + 1
            if nxt < len(ratings) and ratings[nxt] > ratings[idx] and values[nxt] <= values[idx]:
                values[nxt] = values[idx] + 1

        return sum(values)
