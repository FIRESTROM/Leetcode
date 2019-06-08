class Solution {
    public List<int[]> pacificAtlantic(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0)
            return new ArrayList<>();
        int m = matrix.length, n = matrix[0].length;
        boolean[][] canReachPacific = new boolean[m][n];
        boolean[][] canReachAtlantic = new boolean[m][n];

        for (int i = 0; i < n; i++)
            dfs(matrix, canReachPacific, 0, i);
        for (int j = 0; j < m; j++)
            dfs(matrix, canReachPacific, j, 0);
        for (int i = 0; i < m; i++)
            dfs(matrix, canReachAtlantic, i, n - 1);
        for (int j = 0; j < n; j++)
            dfs(matrix, canReachAtlantic, m - 1, j);

        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (canReachPacific[i][j] && canReachAtlantic[i][j])
                    result.add(new int[]{i, j});

        return result;
    }

    private void dfs(int[][] matrix, boolean[][] canReach, int row, int col) {
        if (row < 0 || col < 0 || row >= matrix.length || col >= matrix[0].length)
            return;
        canReach[row][col] = true;
        if (row + 1 < matrix.length && matrix[row][col] <= matrix[row + 1][col] && canReach[row + 1][col] == false)
            dfs(matrix, canReach, row + 1, col);
        if (row - 1 >= 0 && matrix[row][col] <= matrix[row -1][col] && canReach[row -1][col] == false)
            dfs(matrix, canReach, row - 1, col);
        if (col + 1 < matrix[0].length && matrix[row][col] <= matrix[row][col + 1] && canReach[row][col + 1] == false)
            dfs(matrix, canReach, row, col + 1);
        if (col - 1 >= 0 && matrix[row][col] <= matrix[row][col - 1] && canReach[row][col - 1] == false)
            dfs(matrix, canReach, row, col - 1);
    }
}
