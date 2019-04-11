class Solution(object):
    def largestNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: str
        """
        comp = lambda a, b : 1 if a + b > b + a else -1 if a + b < b + a else 0
        nums = map(str,nums)
        nums.sort(cmp = comp, reverse = True)
        return str(int("".join(nums)))

#  we define a function that compares two string (a,b) . we consider a bigger than b if a+b>b+a
#  for example : (a="2",b="11") a is bigger than b because "211" >"112"

#  convert all elements of the list from int to string

#  sort the list descendingly using the comparing function we defined
#  for example sorting this list ["2","11","13"] using the function defined in step 1 would produce ["2","13","11"]

#  we concatatenate the list "21311"
