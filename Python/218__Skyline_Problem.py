class Solution:
    # @param {integer[][]} buildings
    # @return {integer[][]}
    def getSkyline(self, buildings):

        if buildings == []:
            return []
        if len(buildings) == 1:
            return [[buildings[0][0], buildings[0][2]], [buildings[0][1], 0]]
        mid = (len(buildings) - 1) / 2
        left = self.getSkyline(buildings[0 : mid + 1])
        right = self.getSkyline(buildings[mid + 1:])
        return self.merge(left, right)


    def merge(self,left,right):
        i, j = 0, 0
        result = []
        h1, h2 = None, None
        while i < len(left) and j < len(right):
            if left[i][0] < right[j][0]:
                h1 = left[i][1]
                new = [left[i][0], max(h1, h2)]
                if result == [] or result[-1][1] != new[1]:
                    result.append(new)
                i += 1
            elif left[i][0] > right[j][0]:
                h2 = right[j][1]
                new = [right[j][0], max(h1, h2)]
                if result == [] or result[-1][1] != new[1]:
                    result.append(new)
                j += 1
            else:
                h1 = left[i][1]
                h2 = right[j][1]
                new = [right[j][0], max(h1, h2)]
                if result == [] or result[-1][1] != new[1]:
                    result.append([right[j][0], max(h1, h2)])
                i += 1
                j += 1
        while i < len(left):
            if result == [] or result[-1][1] != left[i][1]:
                result.append(left[i][:])
            i += 1
        while j < len(right):
            if result == [] or result[-1][1] != right[j][1]:
                result.append(right[j][:])
            j += 1

        return result


## Another Solution

from heapq import heappush, heappop
class Solution(object):
    def getSkyline(self, buildings):
        # add start-building events
        # also add end-building events(acts as buildings with 0 height)
        # and sort the events in left -> right order
        events = [(L, -H, R) for L, R, H in buildings]
        events += list({(R, 0, 0) for _, R, _ in buildings})
        events.sort()

        # res: result, [x, height]
        # live: heap, [-height, ending position]
        res = [[0, 0]]
        live = [(0, float("inf"))]
        for pos, negH, R in events:
            # 1, pop buildings that are already ended
            # 2, if it's the start-building event, make the building alive
            # 3, if previous keypoint height != current highest height, edit the result
            while live[0][1] <= pos: heappop(live)
            if negH: heappush(live, (negH, R))
            if res[-1][1] != -live[0][0]:
                res += [ [pos, -live[0][0]] ]
        return res[1:]
