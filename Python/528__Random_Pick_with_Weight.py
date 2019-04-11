class Solution(object):

    def __init__(self, w):
        """
        :type w: List[int]
        """
        import random
        self.array = []
        self.total = sum(w)
        print(w)
        for i, num in enumerate(w):
            self.array.append(num if i == 0 else self.array[-1]+num)
        print(self.array)

    def pickIndex(self):
        """
        :rtype: int
        """
        i, j = 0, len(self.array)-1
        rand_num = random.randint(1,self.total)
        while i <= j:
            mid = (i+j)/2
            if self.array[mid] < rand_num:
                i = mid + 1
            else:
                j = mid - 1
        return i



# Your Solution object will be instantiated and called as such:
# obj = Solution(w)
# param_1 = obj.pickIndex()
