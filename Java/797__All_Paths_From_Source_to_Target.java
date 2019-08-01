class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        return helper(graph, 0);
    }

    private List<List<Integer>> helper(int[][] graph, int node) {
        int N = graph.length;
        List<List<Integer>> result = new ArrayList();
        if (node == N - 1) {
            List<Integer> path = new LinkedList<>();
            path.add(N - 1);
            result.add(path);
            return result;
        }

        for (int nei: graph[node]) {
            for (List<Integer> path: helper(graph, nei)) {
                path.add(0, node);
                result.add(path);
            }
        }
        return result;
    }
}
