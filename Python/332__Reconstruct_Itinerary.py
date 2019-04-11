class Solution(object):
    def findItinerary(self, tickets):
        """
        :type tickets: List[List[str]]
        :rtype: List[str]
        """
        dic = {}
        for ticket in tickets:
            if ticket[0] not in dic:
                dic[ticket[0]] = [ticket[1]]
            else:
                dic[ticket[0]].append(ticket[1])

        for ticket in dic:
            dic[ticket].sort()

        result = ["JFK"]
        end = []
        while dic:
            if result[-1] not in dic:
                end.append(result[-1])
                result.pop()
                continue
            fr, to = result[-1], dic[result[-1]].pop(0)
            result.append(to)
            if len(dic[fr]) == 0:
                dic.pop(fr)

        if end:
            result += end[::-1]

        return result

# Using DFS Solution

class Solution(object):
    def findItinerary(self, tickets):
        """
        :type tickets: List[List[str]]
        :rtype: List[str]
        """
        if not tickets:
            return []
        graph = collections.defaultdict(list)
        for start, end in tickets:
            graph[start].append(end)
        for start in graph:
            dic[start].sort()

        result = ["JFK"]
        count = 0
        numtickets = len(tickets)
        return self.dfs(result, count, numtickets, graph, "JFK")

    def dfs(self, result, count, total, graph, node):
        if count == total:
            return result
        else:
            next_addresses = graph[node]
            for i in range(len(next_addresses)):
                next_address = next_addresses.pop(i)
                result.append(next_address)
                route = self.dfs(result, count + 1, total, graph, next_address)
                if route:
                    return route
                result.pop()
                next_addresses.insert(i, next_address)
