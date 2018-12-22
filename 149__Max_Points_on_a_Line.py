# Definition for a point.
# class Point(object):
#     def __init__(self, a=0, b=0):
#         self.x = a
#         self.y = b

class Solution(object):


    def gcd(self, a, b):
        if b == 0:
            return a
        else:
            return self.gcd(b, a % b)

    def maxPoints(self, points):
        """
        :type points: List[Point]
        :rtype: int
        """
        if len(points) <= 2:
            return len(points)
        
        result = 0
        for i in range(len(points)):
            dic = {"90" : 1}
            overlap, curmax = 0, 0
            for j in range(i + 1, len(points)):
                dx, dy = points[j].x - points[i].x, points[j].y - points[i].y
                if dx == 0 and dy == 0:
                    overlap += 1
                    continue
                if dx == 0:
                    angle = "90"
                else:
                    temp = self.gcd(dx, dy)
                    angle = (dy / temp, dx / temp)
                if angle not in dic:
                    dic[angle] = 1
                dic[angle] += 1

            result = max(result, max(dic.values()) + overlap)

        return result
