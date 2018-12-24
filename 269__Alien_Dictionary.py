class Solution(object):
    def alienOrder(self, words):
        """
        :type words: List[str]
        :rtype: str
        """
        def order(word1, word2):
            if len(word1) == 0 or len(word2) == 0:
                return "", ""
            if word1[0] != word2[0]:
                return word1[0], word2[0]
            return order(word1[1:], word2[1:])

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

        visited = {}
        graph = {}
        stack = []

        for i in range(len(words)):
            for j in range(len(words[i])):
                if words[i][j] not in visited:
                    visited[words[i][j]] = 0
            if i != 0:
                x, y = order(words[i - 1], words[i])
                if len(x) != 0 and len(y) != 0:
                    if x in graph:
                        graph[x].add(y)
                    else:
                        graph[x] = set(y)

        for i in visited:
            if visited[i] == 0:
                if not helper(i):
                    return ""
        return "".join(stack)


# A similar but faster solution. Using a faster way to generate topological order.

class Solution:
    def alienOrder(self, words):
        """
        :type words: List[str]
        :rtype: str
        """
        def getEdge(word1, word2):
            if not word1 or not word2:
                return "", ""
            if word1[0] != word2[0]:
                return word1[0], word2[0]
            return getEdge(word1[1:], word2[1:])

        graph = collections.defaultdict(set)
        visited = collections.defaultdict(int)
        for i, word in enumerate(words):
            for char in word:
                if char not in visited:
                    visited[char] = 0
            if i > 0:
                x, y = getEdge(words[i - 1], word)
                if x and y:
                    if y in graph[x]:
                        continue
                    visited[y] += 1
                    graph[x].add(y)

        point_to_nothing = [char for char in visited if visited[char] == 0]
        result = []
        while point_to_nothing:
            s = point_to_nothing.pop()
            result.append(s)
            for char in graph[s]:
                visited[char] -= 1
                if visited[char] == 0:
                    point_to_nothing.append(char)

        if len(result) < len(visited):
            return ""
        return "".join(result)
