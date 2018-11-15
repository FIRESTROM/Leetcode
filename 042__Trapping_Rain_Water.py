class Solution(object):
    def trap(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        if len(height) == 0 or len(height) == 1:
            return 0

        left_index = 0
        right_index = len(height) - 1
        left_min, right_min = 0, 0
        count = 0
        while left_index <= right_index:
            left_height, right_height = height[left_index], height[right_index]

            if left_height == right_height:
                count += (right_index - left_index + 1) * (left_height - left_min)
                left_min, right_min = left_height, right_height
                while height[left_index] <= left_height and left_index <= right_index:
                    left_index += 1
                    if left_index > right_index:
                        break

                while height[right_index] <= right_height and left_index <= right_index:
                    right_index -= 1

            elif left_height < right_height:
                count += (right_index - left_index + 1) * (left_height - left_min)
                left_min, right_min = left_height, left_height
                while height[left_index] <= left_height and left_index <= right_index:
                    left_index += 1
                    if left_index > right_index:
                        break
            else:
                count += (right_index - left_index + 1) * (right_height - right_min)
                left_min, right_min = right_height, right_height
                while height[right_index] <= right_height and left_index <= right_index:
                    right_index -= 1
                    if left_index > right_index:
                        break

        return count - sum(height)



## Here is another smarter solution using Two Pointers

class Solution(object):
    def trap(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        left, right = 0, len(height) - 1
        left_max, right_max = 0, 0
        result = 0
        while left < right:
            if height[left] < height[right]:
                if height[left] > left_max:
                    left_max = height[left]
                else:
                    result += (left_max - height[left])
                left += 1
            else:
                if height[right] > right_max:
                    right_max = height[right]
                else:
                    result += (right_max - height[right])
                right -= 1

        return result
