class TwoSum(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.dic = {}

    def add(self, number):
        """
        Add the number to an internal data structure..
        :type number: int
        :rtype: void
        """
        self.dic[number] = self.dic.get(number, 0) + 1


    def find(self, value):
        """
        Find if there exists any pair of numbers which sum is equal to the value.
        :type value: int
        :rtype: bool
        """
        for i in self.dic:
            if value - i in self.dic:
                if i * 2 == value and self.dic[i] < 2:
                    pass
                else:
                    return True
        return False



# Your TwoSum object will be instantiated and called as such:
# obj = TwoSum()
# obj.add(number)
# param_2 = obj.find(value)
