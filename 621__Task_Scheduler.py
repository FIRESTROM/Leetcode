class Solution(object):
    def leastInterval(self, tasks, n):
        """
        :type tasks: List[str]
        :type n: int
        :rtype: int
        """
        dic = dict()
        for tast in tasks:
            if tast in dic:
                dic[tast] += 1
            else:
                dic[tast] = 1
        max_value = max(dic.values())

        ## Above code can be replaced by :
        ##     dic = collections.Counter(tasks)
        ##     max_value = max(d.values())
        num = 0
        for tast in dic:
            if dic[tast] == max_value:
                num += 1
        length = len(tasks)
        return max(length, ((n + 1) * (max_value - 1) + num))


## Above is a pure math solution. We will add a solution using heap.

from heapq import heappush, heappop
from collections import Counter
class Solution:
    def leastInterval(self, tasks, n):
        """
        :type tasks: List[str]
        :type n: int
        :rtype: int
        """
        result, heap = 0, []
        for k, v in Counter(tasks).items():
            heappush(h, (-1*v, k))
        while h:
            i, temp = 0, []
            while i <= n:
                result += 1
                if h:
                    x, y = heappop(h)
                    if x != -1:
                        temp.append((x + 1, y))
                if not h and not temp:
                    break
                else:
                    i += 1
            for item in temp:
                heappush(h, item)
        return result
