# Definition for an interval.
# class Interval(object):
#     def __init__(self, s=0, e=0):
#         self.start = s
#         self.end = e

class Solution(object):
    def minMeetingRooms(self, intervals):
        """
        :type intervals: List[Interval]
        :rtype: int
        """
        intervals = sorted(intervals, key = lambda x : x.start)
        rooms = []
        for pair in intervals:
            if len(rooms) == 0:
                rooms = [pair.end]
                continue
            min_end = min(rooms)
            if min_end <= pair.start:
                rooms[rooms.index(min_end)] = pair.end
            else:
                rooms += [pair.end]
        return len(rooms)


        
