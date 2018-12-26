# Definition for an interval.
# class Interval(object):
#     def __init__(self, s=0, e=0):
#         self.start = s
#         self.end = e

class Solution(object):
    def insert(self, intervals, newInterval):
        """
        :type intervals: List[Interval]
        :type newInterval: Interval
        :rtype: List[Interval]
        """
        if len(intervals) == 0:
            return [newInterval]

        result = []
        count = -1
        for i in range(len(intervals)):
            if intervals[i].end < newInterval.start:
                count += 1
                result.append(intervals[i])
            else:
                break
        if count == len(intervals) - 1:
            result.append(newInterval)
            return result

        i, j = count + 1, count + 1

        # Not overlap with intervals[i]
        if intervals[i].start > newInterval.end:
            result.append(newInterval)
            if intervals[i:]:
                result.extend(intervals[i:])
        else:
            while j < len(intervals) and intervals[j].start <= newInterval.end:
                j += 1
            j -= 1 # Last overlap
            start = min(intervals[i].start, newInterval.start)
            end = max(intervals[j].end, newInterval.end)
            result.append(Interval(start, end))

            if j + 1 < len(intervals) and intervals[j + 1:]:
                result.extend(intervals[j + 1:])
        return result

   
