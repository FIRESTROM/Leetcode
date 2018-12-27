class Solution(object):
    def twoSum(self, numbers, target):
        """
        :type numbers: List[int]
        :type target: int
        :rtype: List[int]
        """
        left, right = 0, len(numbers) - 1
        while left < right:
            val = numbers[left] + numbers[right]
            if val == target:
                return [left + 1, right + 1]
            elif val < target:
                left += 1
            else:
                right -= 1
        return [-1, -1]

# Another smart solution using dic

class Solution(object):
    def twoSum(self, numbers, target):
        """
        :type numbers: List[int]
        :type target: int
        :rtype: List[int]
        """
        dic, result = {},[]
        for i, num in enumerate(numbers):
            if num in dic:
                res.append(dic[num] + 1)
                res.append(i + 1)

            dic[target - num] = i
        return result
