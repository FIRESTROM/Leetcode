# Definition for a undirected graph node
# class UndirectedGraphNode:
#     def __init__(self, x):
#         self.label = x
#         self.neighbors = []

class Solution:
    # @param node, a undirected graph node
    # @return a undirected graph node
    def cloneGraph(self, node):

        if node is None:
            return None

        newNodes = {}

        def dfs(node):
            if node.label in newNodes:
                return newNodes[node.label]
            else:
                temp_node = UndirectedGraphNode(node.label)
                newNodes[node.label] = temp_node
                for n in node.neighbors:
                    temp_node.neighbors.append(dfs(n))
                return temp_node

        return dfs(node)
