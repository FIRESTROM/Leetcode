class Solution {

    char[][] check;
    int m;
    int n;

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        this.check = grid;
        this.m = grid.length;
        this.n = grid[0].length;
        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (check[i][j] == '1') {
                    result++;
                    helper(i, j);
                }
            }
        }
        return result;
    }

    private void helper(int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n)
            return;
        if (check[i][j] == '1') {
            check[i][j] = '0';
            helper(i + 1, j);
            helper(i - 1, j);
            helper(i, j + 1);
            helper(i, j - 1);
        }
    }
}
