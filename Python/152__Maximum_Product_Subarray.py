class Solution(object):
    def maxProduct(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """

        max_i = [i for i in nums]
        min_i = [i for i in nums]
        n = len(nums)

        for i in range(1, n):
            max_i[i] = max(max_i[i], max_i[i-1] * max_i[i], min_i[i-1] * max_i[i])
            min_i[i] = min(min_i[i], max_i[i-1] * min_i[i], min_i[i-1] * min_i[i])
        return max(max_i)

# Another solution (more readable)

class Solution(object):
    def maxProduct(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """

        n = len(nums)

        if n == 0:
            return None
        if n == 1:
            return nums[0]

        max_product = [nums[0]] + [1] * (n - 1)
        min_product = [nums[0]] + [1] * (n - 1)

        for i in range(1, n):
            if nums[i] >= 0:
                if max_product[i - 1] <= 0:
                    max_product[i] = nums[i]
                else:
                    max_product[i] = max_product[i-1] * nums[i]

                if min_product[i - 1] <= 0:
                    min_product[i] = nums[i] * min_product[i - 1]
                else:
                    min_product[i] = nums[i]
            else:
                if min_product[i - 1] <= 0:
                    max_product[i] = min_product[i - 1] * nums[i]
                else:
                    max_product[i] = nums[i]

                if max_product[i - 1] > 0:
                    min_product[i] = max_product[i-1] * nums[i]
                else:
                    min_product[i] = nums[i]

        return max(max_product)
