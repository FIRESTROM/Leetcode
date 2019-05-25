class Solution {
    class State {
        int cover, head;
        State (int c, int h) {
            cover = c;
            head = h;
        }
    }
    public int shortestPathLength(int[][] graph) {
        int len = graph.length;
        Queue<State> queue = new LinkedList();
        // dp[cover_list][head]
        int[][] dp = new int[1 << len][len];
        for (int[] row: dp)
            Arrays.fill(row, len * len);

        for (int x = 0; x < len; x++) {
            queue.offer(new State(1 << x, x));
            dp[1 << x][x] = 0;
        }

        while (!queue.isEmpty()) {
            State node = queue.poll();
            int d = dp[node.cover][node.head];
            if (node.cover == (1 << len) - 1) // All covered
                return d; // BFS, so it must be smallest

            for (int child: graph[node.head]) {
                int cover2 = node.cover | (1 << child); // cover this child
                if (d + 1 < dp[cover2][child]) {
                    dp[cover2][child] = d + 1;
                    queue.offer(new State(cover2, child));
                }
            }
        }

        throw null;
    }
}
