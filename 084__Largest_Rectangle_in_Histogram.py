# Divide & Conquer Solution

class Solution(object):
    def largestRectangleArea(self, heights):
        """
        :type heights: List[int]
        :rtype: int
        """
        def divide_conquer(heights, start, end):
            if start > end:
                return 0
            min_i = start
            for i in range(start, end + 1):
                if heights[min_i] > heights[i]:
                    min_i = i
            return max([heights[min_i] * (end - start + 1), divide_conquer(heights, start, min_i - 1), divide_conquer(heights, min_i + 1, end)])

        return divide_conquer(heights, 0, len(heights) - 1)

# Stack Solution

class Solution(object):
    def largestRectangleArea(self, heights):
        """
        :type heights: List[int]
        :rtype: int
        """

        stack = []
        stack.append(-1)
        maxarea = 0;
        for i in range(len(heights)):
            while stack[-1] != -1 and heights[stack[-1]] >= heights[i]:
                maxarea = max(maxarea, heights[stack.pop()] * (i - stack[-1] - 1))
            stack.append(i)
        while stack[-1] != -1:
            maxarea = max(maxarea, heights[stack.pop()] * (len(heights) - stack[-1] -1))

        return maxarea
