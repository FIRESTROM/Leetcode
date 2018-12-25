class RandomizedSet(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.data = {}
        self.index = 0
        self.list = []


    def insert(self, val):
        """
        Inserts a value to the set. Returns true if the set did not already contain the specified element.
        :type val: int
        :rtype: bool
        """
        if val not in self.data:
            self.data[val] = self.index
            self.list.append(val)
            self.index += 1
            return True
        return False


    def remove(self, val):
        """
        Removes a value from the set. Returns true if the set contained the specified element.
        :type val: int
        :rtype: bool
        """
        if val in self.data:
            last, index = self.list[-1], self.data[val]
            self.list[index] = last
            self.data[last] = index
            self.list.pop()
            del self.data[val]
            self.index -= 1
            return True
        return False


    def getRandom(self):
        """
        Get a random element from the set.
        :rtype: int
        """
        return random.choice(self.list)



# Your RandomizedSet object will be instantiated and called as such:
# obj = RandomizedSet()
# param_1 = obj.insert(val)
# param_2 = obj.remove(val)
# param_3 = obj.getRandom()
