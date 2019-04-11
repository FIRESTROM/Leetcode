class Solution(object):
    def anagramMappings(self, A, B):
        """
        :type A: List[int]
        :type B: List[int]
        :rtype: List[int]
        """
        D = {x: i for i, x in enumerate(B)}
        return [D[x] for x in A]
