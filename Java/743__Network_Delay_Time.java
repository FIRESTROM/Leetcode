class Solution {
    public int networkDelayTime(int[][] times, int N, int K) {
        Map<Integer, List<int[]>> graph = new HashMap();
        for (int[] time: times) {
            if (!graph.containsKey(time[0]))
                graph.put(time[0], new ArrayList<int[]>());
            graph.get(time[0]).add(new int[]{time[1], time[2]});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, K});
        Map<Integer, Integer> dist_map = new HashMap<>();
        while (!pq.isEmpty()) {
            int[] info = pq.poll();
            int dist = info[0], node = info[1];
            if (dist_map.containsKey(node)) continue;
            dist_map.put(node, dist);
            if (graph.containsKey(node))
                for (int[] edge : graph.get(node)) {
                    int neighbor = edge[0], dist_2 = edge[1];
                    if (!dist_map.containsKey(neighbor))
                        pq.offer(new int[]{dist + dist_2, neighbor});
                }
        }
        if (dist_map.size() != N) return -1;
        int result = 0;
        for (int val : dist_map.values())
            result = Math.max(result, val);
        return result;

    }
}
