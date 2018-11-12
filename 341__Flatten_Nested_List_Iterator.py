# """
# This is the interface that allows for creating nested lists.
# You should not implement it, or speculate about its implementation
# """
#class NestedInteger(object):
#    def isInteger(self):
#        """
#        @return True if this NestedInteger holds a single integer, rather than a nested list.
#        :rtype bool
#        """
#
#    def getInteger(self):
#        """
#        @return the single integer that this NestedInteger holds, if it holds a single integer
#        Return None if this NestedInteger holds a nested list
#        :rtype int
#        """
#
#    def getList(self):
#        """
#        @return the nested list that this NestedInteger holds, if it holds a nested list
#        Return None if this NestedInteger holds a single integer
#        :rtype List[NestedInteger]
#        """

class NestedIterator(object):

    def __init__(self, nestedList):
        """
        Initialize your data structure here.
        :type nestedList: List[NestedInteger]
        """
        self.list = self.flatten(nestedList, [])
        self.index = 0

    def flatten(self, nested_list, res):
        for item in nested_list:
            if item.isInteger():
                res.append(item.getInteger())
            else:
                self.flatten(item.getList(), res)
        return res


    def next(self):
        """
        :rtype: int
        """
        val = self.list[self.index]
        self.index += 1
        return val


    def hasNext(self):
        """
        :rtype: bool
        """
        return self.index < len(self.list)


# Your NestedIterator object will be instantiated and called as such:
# i, v = NestedIterator(nestedList), []
# while i.hasNext(): v.append(i.next())


## Solution using yeild

class NestedIterator(object):

    def __init__(self, nestedList):
        # This function will return a generator which have all integers
        # coming out as the order in the nestedlist
        def gen(nestedList):
            for x in nestedList:
                if x.isInteger():
                    yield x.getInteger()
                else:
                    for y in gen(x.getList()):
                        yield y
        self.gen = gen(nestedList)

    def next(self):
        return self.value

    def hasNext(self):
        try:
            self.value = next(self.gen)
            return True
        except StopIteration:
            return False
