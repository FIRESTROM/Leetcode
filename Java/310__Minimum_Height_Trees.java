class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> result = new ArrayList<>();
        if (edges.length == 0) {
            result.add(0);
            return result;
        }
        int[] indegree = new int[n];
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) map.put(i, new ArrayList<>());
        for (int i = 0; i < edges.length; i++) {
            indegree[edges[i][0]]++;
            indegree[edges[i][1]]++;
            map.get(edges[i][0]).add(edges[i][1]);
            map.get(edges[i][1]).add(edges[i][0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++)
            if (indegree[i] == 1)
                queue.offer(i);
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            count += size;
            for (int i = 0; i < size; i++) {
                Integer id = queue.poll();
                indegree[id]--;
                if (count == n) result.add(id);
                for (Integer adjId : map.get(id)) {
                    if (indegree[adjId] != 0) {
                        indegree[adjId]--;
                        if (indegree[adjId] == 1)
                            queue.offer(adjId);
                    }
                }
            }
        }
        return result;
    }
}
