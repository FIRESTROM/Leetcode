# Definition for an interval.
# class Interval(object):
#     def __init__(self, s=0, e=0):
#         self.start = s
#         self.end = e

class Solution(object):
    def merge(self, intervals):
        """
        :type intervals: List[Interval]
        :rtype: List[Interval]
        """
        result = []
        intervals = sorted(intervals, key = lambda x : x.start)
        for i in range(len(intervals)):
            if len(result) == 0:
                result = [intervals[i]]
                continue
            if result[-1].end >= intervals[i].start:
                result[-1].end = max(intervals[i].end, result[-1].end)
            else:
                result += [intervals[i]]
        return result
