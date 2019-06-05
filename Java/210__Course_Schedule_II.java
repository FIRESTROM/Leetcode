class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        boolean is_possible = true;
        Map<Integer, List<Integer>> adj_list = new HashMap<>();
        int[] degree = new int[numCourses];
        int[] result = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            int dest = prerequisites[i][0], src = prerequisites[i][1];
            List<Integer> lst = adj_list.getOrDefault(src, new ArrayList<Integer>());
            lst.add(dest);
            adj_list.put(src, lst);
            degree[dest]++;
        }
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i++)
            if (degree[i] == 0)
                queue.add(i);
        int i = 0;
        while (!queue.isEmpty()) {
            int node = queue.remove();
            result[i++] = node;
            if (adj_list.containsKey(node))
                for (Integer neighbor : adj_list.get(node)) {
                    degree[neighbor]--;
                    if (degree[neighbor] == 0)
                        queue.add(neighbor);
                }
        }
        if (i == numCourses)
            return result;
        return new int[0];

    }
}
