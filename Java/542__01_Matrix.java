class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) queue.offer(new int[]{i,j});
                else matrix[i][j] = Integer.MAX_VALUE;
            }
        }
        int[][] directions = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        while (!queue.isEmpty()) {
            int[] coor = queue.poll();
            for (int i = 0; i < directions.length; i++) {
                int dx = coor[0] + directions[i][0];
                int dy = coor[1] + directions[i][1];
                if (dx >= 0 && dx < m && dy >= 0 && dy < n && matrix[dx][dy] > matrix[coor[0]][coor[1]] + 1) {
                    matrix[dx][dy] = matrix[coor[0]][coor[1]] + 1;
                    queue.offer(new int[]{dx, dy});
                }
            }
        }
        return matrix;
    }
}
