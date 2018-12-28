class RandomizedCollection(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.dic = {}
        self.index_val = {}
        self.index = 0

    def insert(self, val):
        """
        Inserts a value to the collection. Returns true if the collection did not already contain the specified element.
        :type val: int
        :rtype: bool
        """
        flag = not val in self.dic
        if flag:
            self.dic[val] = set()
        self.dic[val].add(self.index)
        self.index_val[self.index] = val
        self.index += 1
        return flag




    def remove(self, val):
        """
        Removes a value from the collection. Returns true if the collection contained the specified element.
        :type val: int
        :rtype: bool
        """
        if val not in self.dic:
            return False

        val_index = self.dic[val].pop()
        if not self.dic[val]:
            self.dic.pop(val)

        last_val = self.index_val.pop(self.index - 1)

        if val_index != self.index - 1:
            self.dic[last_val].remove(self.index - 1)
            self.dic[last_val].add(val_index)
            self.index_val[val_index] = last_val
        self.index -= 1

        return True


    def getRandom(self):
        """
        Get a random element from the collection.
        :rtype: int
        """
        return self.index_val[random.randint(0, self.index - 1)]







# Your RandomizedCollection object will be instantiated and called as such:
# obj = RandomizedCollection()
# param_1 = obj.insert(val)
# param_2 = obj.remove(val)
# param_3 = obj.getRandom()
