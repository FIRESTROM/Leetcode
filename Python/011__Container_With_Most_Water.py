class Solution(object):
    def maxArea(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        start, end = 0, len(height) - 1
        result = 0

        while start < end:
            result = max(result, min(height[start], height[end]) * (end - start))
            if height[start] < height[end]:
                start += 1
            else:
                end -= 1
        return result

# Optimize Solution

class Solution(object):
    def maxArea(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        result = 0
        start, end = 0, len(height) - 1
        while start < end :
            if height[start] < height[end]:
                area = height[start] * (end - start)
                if area > result:
                    result = area
                start += 1
                while height[start] <= height[start - 1] and start + 1 < end :
                    start += 1
            else:
                area = height[end] * (end - start)
                if area > result:
                    result = area
                end -= 1
                while height[end] <= height[end + 1] and start + 1 < end:
                    end -= 1
        return result
