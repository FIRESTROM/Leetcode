class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int val = bfs(grid, i, j);
                    if (val > max) {
                        max = val;
                    }
                }
            }
        }
        return max;
    }

    private int bfs(int[][] grid, int i, int j) {
        int m = grid.length, n = grid[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != 1) {
            return 0;
        }
        int result;
        grid[i][j] = 2;
        result = 1 + bfs(grid, i - 1, j) +  bfs(grid, i + 1, j) + bfs(grid, i, j - 1) + bfs(grid, i, j + 1);
        return result;
    }



}
