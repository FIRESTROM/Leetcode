class Solution {

    class Pair {
        int val;
        int x, y;
        Pair(int val, int x, int y) {
            this.val = val;
            this.x = x;
            this.y = y;
        }
    }

    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length == 0 || heightMap[0].length == 0) {
            return 0;
        }
        int m = heightMap.length, n = heightMap[0].length;
        PriorityQueue<Pair> pq = new PriorityQueue<>(new PairComparator());
        boolean[][] done = new boolean[m][n];
        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};
        for (int i = 0; i < m; i++) {
            pq.offer(new Pair(heightMap[i][0], i, 0));
            pq.offer(new Pair(heightMap[i][n - 1], i, n - 1));
            done[i][0] = true;
            done[i][n - 1] = true;
        }
        for (int j = 0; j < n; j++) {
            pq.offer(new Pair(heightMap[0][j], 0, j));
            pq.offer(new Pair(heightMap[m - 1][j], m - 1, j));
            done[0][j] = true;
            done[m - 1][j] = true;
        }
        int sum = 0;
        while (!pq.isEmpty()) {
            Pair pair = pq.poll();
            int x = pair.x, y = pair.y;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (0 <= nx && nx < m && 0 <= ny && ny < n && !done[nx][ny]) {
                    done[nx][ny] = true;
                    pq.offer(new Pair(Math.max(heightMap[nx][ny], pair.val), nx, ny));
                    sum += Math.max(0, pair.val - heightMap[nx][ny]);
                }
            }
        }
        return sum;
    }

    private class PairComparator implements Comparator<Pair> {
        public int compare(Pair a, Pair b) {
            return a.val - b.val;
        }
    }

}
