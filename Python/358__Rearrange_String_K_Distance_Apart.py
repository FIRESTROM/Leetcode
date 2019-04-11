class Solution(object):
    def rearrangeString(self, s, k):
        """
        :type s: str
        :type k: int
        :rtype: str
        """
        if k == 0:
            return s
        heap = [(-freq, char) for (char, freq) in collections.Counter(s).items()]
        heapq.heapify(heap)
        res = []
        while len(res) < len(s):
            queue = []
            for _ in xrange(k):
                if len(res) == len(s):
                    return "".join(res)
                if not heap:
                    return ""
                freq, char = heapq.heappop(heap)
                res.append(char)
                if freq < -1:
                    queue.append((freq + 1, char))
            while queue:
                heapq.heappush(heap, queue.pop())
        return "".join(res)

# Another Solution
from heapq import heappush, heappop
from collections import deque
class Solution(object):
    def rearrangeString(self, s, k):
        """
        :type s: str
        :type k: int
        :rtype: str
        """
        dic = {}
        count = {}
        for c in s:
            dic[c] = -k
            if c in count:
                count[c] += 1
            else:
                count[c] = 1

        hq = []
        for c in count:
            heappush(hq, (-count[c], c))

        dq = deque()
        result = []
        while dq or hq:
            if dq and dic[dq[0][1]] + k <= len(result):
                heappush(hq, dq.popleft())
            if not hq:
                return ""
            else:
                freq, c = heappop(hq)
                dic[c] = len(result)
                result.append(c)
                if freq < -1:
                    dq.append((freq + 1, c))

        return "".join(result)


# A Cooler Solution

class Solution(object):
    def rearrangeString(self, s, k):
        """
        :type s: str
        :type k: int
        :rtype: str
        """
        if not string:
            return ""

        count = collections.defaultdict(int)
        for char in s:
            count[char] += 1
        # sort the letters according to the frequency
        stack = sorted(list(count.items()), key=lambda t: t[1])

        char, count = stack.pop()  # get most frequent character
        lst = [[char] for _ in range(count)]

        # take care of the letters with same highest freq
        while stack and stack[-1][1] == count:
            char, _ = stack.pop()
            for l in lst:
                l.append(char)

        # all the characters left
        res = "".join(char * count for char, count in stack)
        # padding
        for i, r in enumerate(res):
            lst[i % (len(lst) - 1)].append(r)

        for l in lst[:-1]:
            if len(l) < k:
                return ""

        return "".join("".join(l) for l in lst)
