class Solution(object):
    def findOrder(self, numCourses, prerequisites):
        """
        :type numCourses: int
        :type prerequisites: List[List[int]]
        :rtype: List[int]
        """
        def helper(i):
            visited[i] = 1
            if i in graph:
                for j in graph[i]:
                    if visited[j] == 0:
                        if not helper(j):
                            return False
                    elif visited[j] == 1:
                        return False
            visited[i] = 2
            stack.insert(0, i)
            return True

        visited = [0] * numCourses
        graph = {}
        stack = []
        for pair in prerequisites:
            if pair[1] in graph:
                graph[pair[1]].add(pair[0])
            else:
                graph[pair[1]] = set([pair[0]])

        for i in range(numCourses):
            if visited[i] == 0:
                if not helper(i):
                    return []
        return stack
