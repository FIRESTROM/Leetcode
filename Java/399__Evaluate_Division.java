class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<String>> graph = new HashMap<>();
        Map<String, Double> weight = new HashMap<>();
        int x = 0;
        for (List<String> equation : equations) {
            graph.putIfAbsent(equation.get(0), new ArrayList<>());
            graph.putIfAbsent(equation.get(1), new ArrayList<>());
            graph.get(equation.get(0)).add(equation.get(1));
            graph.get(equation.get(1)).add(equation.get(0));
            weight.put(equation.get(0) + equation.get(1), values[x]);
            weight.put(equation.get(1) + equation.get(0), 1 / values[x]);
            weight.put(equation.get(0) + equation.get(0), 1.0);
            weight.put(equation.get(1) + equation.get(1), 1.0);
            x++;
        }
        List<Double> result_arr = new ArrayList<>();
        for (List<String> query : queries) {
            int cur_size = result_arr.size();
            dfs(graph, weight, query.get(0), query.get(1), 1, result_arr, new HashSet<>());
            if (result_arr.size() == cur_size)
                result_arr.add(-1.0);
        }
        double[] result = new double[result_arr.size()];
        int i = 0;
        for (double val : result_arr)
            result[i++] = val;
        return result;
    }

    private void dfs(Map<String, List<String>> graph, Map<String,Double> weight, String src, String dst, double cwt, List<Double> result, Set<String> visited){
        if (visited.contains(src))
            return;
        if (src.equals(dst) && weight.containsKey(src + src)) {
            result.add(cwt);
            return;
        }
        visited.add(src);
        if (graph.get(src) != null)
            for (String nei : graph.get(src))
                if (weight.get(src + nei) != null)
                    dfs(graph, weight, nei, dst, cwt * weight.get(src + nei), result, visited);
    }
}
