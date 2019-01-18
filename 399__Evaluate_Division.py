class Solution(object):
    def calcEquation(self, equations, values, queries):
        """
        :type equations: List[List[str]]
        :type values: List[float]
        :type queries: List[List[str]]
        :rtype: List[float]
        """
        #  weighted edge, union find
        def find(a):
            if a not in parent:
                parent[a] = (a, 1.0)

            elif parent[a][0] != a:
                a_, val = find(parent[a][0])
                parent[a] = (a_, parent[a][1] * val)

            return parent[a]

        parent = collections.defaultdict(list)

        for i in range(len(equations)):
            a, b = equations[i]
            val = values[i]

            a_, diva_ = find(a)
            b_, divb_ = find(b)

            parent[b_] = (a_, diva_ / divb_ * val)

        result = []
        for a, b in queries:
            if a not in parent or b not in parent:
                result.append(-1.0)
                continue

            a_, diva_ = find(a)
            b_, divb_ = find(b)

            if a_ != b_:
                result.append(-1.0)
            else:
                result.append(divb_ / diva_)

        return result
