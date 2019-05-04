class Solution {
    public int islandPerimeter(int[][] grid) {
        int num = 0, edge_inside = 0;
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    num += 1;
                    if (i - 1 >= 0 && grid[i - 1][j] == 1) {
                        edge_inside += 1;
                    }
                    if (i + 1 < m && grid[i + 1][j] == 1) {
                        edge_inside += 1;
                    }
                    if (j - 1 >= 0 && grid[i][j - 1] == 1) {
                        edge_inside += 1;
                    }
                    if (j + 1 < n && grid[i][j + 1] == 1) {
                        edge_inside += 1;
                    }
                }
            }
        }
        return num * 4 - edge_inside;
    }
}
