class Solution {

    int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    class Point {
        int r;
        int c;
        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return -1;
        int m = grid.length, n = grid[0].length;
        int buildings = 0;
        int[][] dist_sum = new int[m][n];
        int[][] access = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 1) continue;
                int level = 0;
                buildings++;
                Queue<Point> queue = new LinkedList<>();
                boolean[][] visited = new boolean[m][n];
                queue.offer(new Point(i, j));
                while (!queue.isEmpty()) {
                    int queue_size = queue.size();
                    for (int k = 0; k < queue_size; k++) {
                        Point point = queue.poll();
                        if (visited[point.r][point.c]) continue;
                        if (grid[point.r][point.c] == 0) {
                            dist_sum[point.r][point.c] += level;
                            access[point.r][point.c]++;
                            visited[point.r][point.c] = true;
                        }
                        if (point.c + 1 < n && grid[point.r][point.c + 1] == 0 && !visited[point.r][point.c + 1])
                            queue.offer(new Point(point.r, point.c + 1));
                        if (point.c - 1 >= 0 && grid[point.r][point.c - 1] == 0 && !visited[point.r][point.c - 1])
                            queue.offer(new Point(point.r, point.c - 1));
                        if (point.r + 1 < m && grid[point.r + 1][point.c] == 0 && !visited[point.r + 1][point.c])
                            queue.offer(new Point(point.r + 1, point.c));
                        if (point.r - 1 >= 0 && grid[point.r - 1][point.c] == 0 && !visited[point.r - 1][point.c])
                            queue.offer(new Point(point.r - 1, point.c));
                    }
                    level++;
                }
            }
        }
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0 || access[i][j] != buildings)
                    continue;
                result = Math.min(result, dist_sum[i][j]);
            }
        }

        return result == Integer.MAX_VALUE ? -1 : result;

    }
}
